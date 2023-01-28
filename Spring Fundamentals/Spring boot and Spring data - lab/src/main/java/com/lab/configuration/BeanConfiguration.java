package com.lab.configuration;

import com.google.gson.*;
import com.lab.models.entities.Brand;
import com.lab.models.entities.Model;
import com.lab.models.entities.dto.BrandDto;
import com.lab.models.entities.dto.ModelDto;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Type;
import java.time.LocalDateTime;

@Configuration
public class BeanConfiguration {



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

        return mapper;

    }
}
