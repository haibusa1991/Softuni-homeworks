package com.lab;

import com.google.gson.*;
import com.lab.models.RegistrationForm;
import com.lab.models.entities.Brand;
import com.lab.models.entities.Model;
import com.lab.models.entities.Offer;
import com.lab.models.entities.User;
import com.lab.models.entities.dto.BrandDto;
import com.lab.models.entities.dto.ModelDto;
import com.lab.models.entities.dto.OfferDto;
import com.lab.models.entities.dto.UserDto;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;

@Configuration
public class Beans {


    @Bean
    public Gson getGson() {
        GsonBuilder gson = new GsonBuilder();
//        gson.registerTypeAdapter(Model.class,new LocalDateTimeSerializer());

        return gson.create();
    }

    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper mapper = new ModelMapper();

        Converter<String, LocalDateTime> localDateTimeConverter = context -> LocalDateTime.parse(context.getSource());

        mapper.createTypeMap(BrandDto.class, Brand.class)
                .addMappings(m -> m.using(localDateTimeConverter).map(BrandDto::getCreated, Brand::setCreated))
                .addMappings(m -> m.using(localDateTimeConverter).map(BrandDto::getModified, Brand::setModified));

        mapper.createTypeMap(ModelDto.class, Model.class)
                .addMappings(m -> m.using(localDateTimeConverter).map(ModelDto::getCreated, Model::setCreated))
                .addMappings(m -> m.using(localDateTimeConverter).map(ModelDto::getModified, Model::setModified));

        mapper.createTypeMap(UserDto.class, User.class)
                .addMappings(m -> m.using(localDateTimeConverter).map(UserDto::getCreated, User::setCreated))
                .addMappings(m -> m.using(localDateTimeConverter).map(UserDto::getModified, User::setModified));

        mapper.createTypeMap(OfferDto.class, Offer.class)
                .addMappings(m -> m.using(localDateTimeConverter).map(OfferDto::getCreated, Offer::setCreated))
                .addMappings(m -> m.using(localDateTimeConverter).map(OfferDto::getModified, Offer::setModified));

        return mapper;
    }

    @Bean
    public RegistrationForm getRegistrationForm() {
        return new RegistrationForm();
    }
}
