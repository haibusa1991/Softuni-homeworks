package cardealer.services;

import cardealer.dto.supplier.ExportSupplierSimpleJsonDto;
import cardealer.dto.supplier.ImportSupplierJsonDto;
import cardealer.entities.Supplier;
import cardealer.repositories.SupplierRepository;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static cardealer.util.Filepaths.*;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    private final Gson gson;
    private final ModelMapper mapper;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, Gson gson, ModelMapper mapper) {
        this.supplierRepository = supplierRepository;
        this.gson = gson;
        this.mapper = mapper;
    }

    @Override
    public void importSuppliers() throws IOException {
        String json = String.join(System.lineSeparator(), Files.readAllLines(Path.of(JSON_IMPORT_SUPPLIERS)));

        List<Supplier> suppliers = Arrays.stream(gson.fromJson(json, ImportSupplierJsonDto[].class))
                .map(e -> mapper.map(e, Supplier.class))
                .collect(Collectors.toList());

        supplierRepository.saveAll(suppliers);
    }

    @Transactional
    @Override
    public void exportLocalSuppliers() throws IOException {
        List<Supplier> suppliers = this.supplierRepository.getSupplierByUsesImportedParts(false);

        List<ExportSupplierSimpleJsonDto> dtos = suppliers.stream()
                .map(e -> {
                    int size = e.getSuppliedParts().size();
                    ExportSupplierSimpleJsonDto dto = mapper.map(e, ExportSupplierSimpleJsonDto.class);
                    dto.setPartsCount(size);
                    return dto;
                })
                .collect(Collectors.toList());


        FileOutputStream fos = new FileOutputStream(JSON_EXPORT_QUERY_3);
        fos.write(gson.toJson(dtos).getBytes());
        fos.close();

    }
}
