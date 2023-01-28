package com.lab.components;

import com.google.gson.Gson;
import com.lab.models.entities.Brand;
import com.lab.models.entities.Model;
import com.lab.models.entities.UserRole;
import com.lab.models.entities.dto.BrandDto;
import com.lab.models.entities.dto.ModelDto;
import com.lab.models.entities.dto.UserRoleDto;
import com.lab.models.enumeration.Roles;
import com.lab.repositories.BrandRepository;
import com.lab.repositories.ModelRepository;
import com.lab.repositories.UserRolesRepository;
import com.lab.utils.FileUtils;
import com.lab.utils.Filepaths;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {
    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;
    private final UserRolesRepository userRolesRepository;
    private final Gson gson;
    private final ModelMapper mapper;

    @Autowired
    public DataInitializer(BrandRepository brandRepository,
                           ModelRepository modelRepository,
                           UserRolesRepository userRolesRepository,
                           Gson gson,
                           ModelMapper mapper) {
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
        this.userRolesRepository = userRolesRepository;
        this.gson = gson;
        this.mapper = mapper;
    }

    @Override
    public void run(String... args) throws Exception {
//        importBrands();
//        importModels();
        importRoles();
    }

    private void importBrands() throws IOException {
        String json = FileUtils.readFileFromDisk(Filepaths.BRANDS_FILE_PATH);
        BrandDto[] brandDtos = gson.fromJson(json, BrandDto[].class);

        ArrayList<Brand> brands = new ArrayList<>();
        for (BrandDto brand : brandDtos) {
            brands.add(this.mapper.map(brand, Brand.class));
        }
        this.brandRepository.saveAll(brands);
        this.brandRepository.flush();
    }

    private void importModels() throws IOException {
        String json = FileUtils.readFileFromDisk(Filepaths.MODELS_FILE_PATH);
        ModelDto[] modelDtos = gson.fromJson(json, ModelDto[].class);

        for (ModelDto modelDto : modelDtos) {
            Model currentModel = this.mapper.map(modelDto, Model.class);
            currentModel.setBrand(this.brandRepository.getBrandByName(modelDto.getBrand()));
            this.modelRepository.save(currentModel);
        }
        this.modelRepository.flush();
    }

    private void importRoles() throws IOException {
        String json = FileUtils.readFileFromDisk(Filepaths.USER_ROLES_FILE_PATH);

        UserRoleDto[] userRoleDtos = gson.fromJson(json, UserRoleDto[].class);

        //todo refactor to use model mapper
        for (UserRoleDto userRoleDto : userRoleDtos) {
            UserRole role = new UserRole();
            Roles currentRole = Roles.valueOf(userRoleDto.getUserRole().toUpperCase());
            role.setUserRole(currentRole);
            this.userRolesRepository.save(role);
        }
    }

}
