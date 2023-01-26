package com.lab.components;

import com.google.gson.Gson;
import com.lab.models.entities.Brand;
import com.lab.models.entities.dto.BrandDto;
import com.lab.repositories.BrandRepository;
import com.lab.utils.FileUtils;
import com.lab.utils.Filepaths;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class DataInitializer implements CommandLineRunner {
    private final BrandRepository brandRepository;
    private final Gson gson;
    private final ModelMapper mapper;

    @Autowired
    public DataInitializer(BrandRepository brandRepository,
                           Gson gson,
                           ModelMapper mapper) {
        this.brandRepository = brandRepository;
        this.gson = gson;
        this.mapper = mapper;
    }

    @Override
    public void run(String... args) throws Exception {

        ArrayList<Brand> carBrand = getBrands();
        this.brandRepository.saveAll(carBrand);
        this.brandRepository.flush();
    }

    public ArrayList<Brand> getBrands() throws IOException {
        String json = FileUtils.readFileFromDisk(Filepaths.BRANDS_FILE_PATH);
        BrandDto[] brandDtos = gson.fromJson(json, BrandDto[].class);

        ArrayList<Brand> brands = new ArrayList<>();
        for (BrandDto brand : brandDtos) {
            brands.add(this.mapper.map(brand, Brand.class));
        }
        return brands;
    }
}
