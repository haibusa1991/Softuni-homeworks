package exam.service.impl;

import com.google.gson.Gson;
import exam.dto.laptop.LaptopImportDto;
import exam.model.Laptop;
import exam.repository.LaptopRepository;
import exam.repository.ShopRepository;
import exam.service.LaptopService;
import exam.util.Filenames;
import exam.util.LaptopShopFileReader;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class LaptopServiceImpl implements LaptopService {
    private final LaptopRepository laptopRepository;
    private final ShopRepository shopRepository;
    private final Gson gson;
    private final ModelMapper mapper;

    public LaptopServiceImpl(LaptopRepository laptopRepository, ShopRepository shopRepository, Gson gson, ModelMapper mapper) {
        this.laptopRepository = laptopRepository;
        this.shopRepository = shopRepository;
        this.gson = gson;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        return this.laptopRepository.count() > 0;
    }

    @Override
    public String readLaptopsFileContent() {
        return LaptopShopFileReader.readFile(Filenames.LAPTOPS_FILE);
    }

    @Override
    public String importLaptops() {
        LaptopImportDto[] ImportDtos = gson.fromJson(readLaptopsFileContent(), LaptopImportDto[].class);

        List<String> results = new ArrayList<>();
        for (LaptopImportDto dto : ImportDtos) {
            Laptop laptop = mapper.map(dto, Laptop.class);
            laptop.setShop(this.shopRepository.getShopByName(dto.getShop().getName()));

            try {
                this.laptopRepository.save(laptop);
                results.add(String.format("Successfully imported Laptop %s - %.2f - %d - %d",
                        laptop.getMacAddress(),
                        laptop.getCpuSpeed(),
                        laptop.getRam(),
                        laptop.getStorage()));
            } catch (Exception e) {
                results.add("Invalid Laptop");
            }
        }
        return String.join(System.lineSeparator(), results);
    }

    @Override
    @Transactional
    public String exportBestLaptops() {
        List<String> results = new ArrayList<>();

        for (Laptop laptop : this.laptopRepository.getBestLaptops()) {
            results.add(String.format("""
                            Laptop - %s
                            *Cpu speed - %.2f
                            **Ram - %d
                            ***Storage - %d
                            ****Price - %.2f
                            #Shop name - %s
                            ##Town - %s
                            """,
                    laptop.getMacAddress(),
                    laptop.getCpuSpeed(),
                    laptop.getRam(),
                    laptop.getStorage(),
                    laptop.getPrice(),
                    laptop.getShop().getName(),
                    laptop.getShop().getTown().getName()));
        }

        return String.join(System.lineSeparator(), results);
    }
}
