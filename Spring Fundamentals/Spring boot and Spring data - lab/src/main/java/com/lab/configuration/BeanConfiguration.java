package com.lab.configuration;

import com.google.gson.Gson;
import com.lab.models.entities.Brand;
import com.lab.models.entities.dto.BrandDto;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class BeanConfiguration {

    @Bean
    public Gson getGson() {
        return new Gson();
    }

    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper mapper = new ModelMapper();

        Converter<String, LocalDateTime> localDateTimeConverter = context -> LocalDateTime.parse(context.getSource());

        mapper.createTypeMap(BrandDto.class, Brand.class)
                .addMappings(m -> m.using(localDateTimeConverter).map(BrandDto::getCreated, Brand::setCreated))
                .addMappings(m -> m.using(localDateTimeConverter).map(BrandDto::getModified, Brand::setModified));

        return mapper;

    }
}
