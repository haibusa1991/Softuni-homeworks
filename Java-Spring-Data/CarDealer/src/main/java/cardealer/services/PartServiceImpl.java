package cardealer.services;

import cardealer.dto.part.ImportPartJsonDto;
import cardealer.entities.Part;
import cardealer.entities.Supplier;
import cardealer.repositories.PartRepository;
import cardealer.repositories.SupplierRepository;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static cardealer.util.Filepaths.*;

@Service
public class PartServiceImpl implements PartService {
    private final PartRepository partRepository;
    private final SupplierRepository supplierRepository;
    private final Gson gson;
    private final ModelMapper mapper;

    @Autowired
    public PartServiceImpl(PartRepository partRepository, SupplierRepository supplierRepository, Gson gson, ModelMapper mapper) {
        this.partRepository = partRepository;
        this.supplierRepository = supplierRepository;
        this.gson = gson;
        this.mapper = mapper;
    }

    @Override
    public void importParts() throws IOException {
        String json = String.join(System.lineSeparator(), Files.readAllLines(Path.of(JSON_IMPORT_PARTS)));

        List<Part> collect = Arrays.stream(gson.fromJson(json, ImportPartJsonDto[].class))
                .map(e -> mapper.map(e, Part.class))
                .map(this::setRandomSupplier)
                .collect(Collectors.toList());

        this.partRepository.saveAll(collect);
    }

    private Part setRandomSupplier(Part part) {
        int supplierId = new Random().nextInt((int) this.supplierRepository.count()) + 1;
        Supplier s = this.supplierRepository.getById(supplierId);

        part.setSupplier(s);

        return part;
    }
}
