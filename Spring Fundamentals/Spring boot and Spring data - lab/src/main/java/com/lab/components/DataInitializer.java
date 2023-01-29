package com.lab.components;

import com.google.gson.Gson;
import com.lab.models.entities.Brand;
import com.lab.models.entities.Model;
import com.lab.models.entities.User;
import com.lab.models.entities.UserRole;
import com.lab.models.entities.dto.BrandDto;
import com.lab.models.entities.dto.ModelDto;
import com.lab.models.entities.dto.UserDto;
import com.lab.models.entities.dto.UserRoleDto;
import com.lab.models.enumeration.Roles;
import com.lab.repositories.BrandRepository;
import com.lab.repositories.ModelRepository;
import com.lab.repositories.UserRepository;
import com.lab.repositories.UserRoleRepository;
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
    private final ModelRepository modelRepository;
    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;
    private final Gson gson;
    private final ModelMapper mapper;

    @Autowired
    public DataInitializer(BrandRepository brandRepository,
                           ModelRepository modelRepository,
                           UserRoleRepository userRoleRepository,
                           UserRepository userRepository,
                           Gson gson,
                           ModelMapper mapper) {
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
        this.gson = gson;
        this.mapper = mapper;
    }

    @Override
    public void run(String... args) throws Exception {
        importBrands();
        importModels();
        importRoles();
        importUsers();
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
    }

    private void importRoles() throws IOException {
        String json = FileUtils.readFileFromDisk(Filepaths.USER_ROLES_FILE_PATH);
        UserRoleDto[] userRoleDtos = gson.fromJson(json, UserRoleDto[].class);

        for (UserRoleDto userRoleDto : userRoleDtos) {
            UserRole role = this.mapper.map(userRoleDto, UserRole.class);
            this.userRoleRepository.save(role);
        }
    }

    private void importUsers() throws IOException {
        String json = FileUtils.readFileFromDisk(Filepaths.USERS_FILE_PATH);
        UserDto[] userDtos = gson.fromJson(json, UserDto[].class);
        for (UserDto userDto : userDtos) {
            User user = this.mapper.map(userDto, User.class);
            user.setRole(this.userRoleRepository.getUserRoleByRole(Roles.valueOf(userDto.getRole())));
            this.userRepository.save(user);
        }
    }

}
