package com.example.football.config;

import com.example.football.models.dto.player.PlayerImportDto;
import com.example.football.models.entity.Player;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public Gson getGson() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    @Bean
    public ModelMapper getMapper() {
        ModelMapper mapper = new ModelMapper();

        Converter<String, LocalDate> converter = context -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.parse(context.getSource(), formatter);
        };

        mapper.createTypeMap(PlayerImportDto.class, Player.class)
                .addMappings(e -> e.using(converter).map(PlayerImportDto::getBirthDate, Player::setBirthDate));

        return mapper;
    }


    public static <T> Unmarshaller getUnmarshaller(Class<T> c) {

        try {
            JAXBContext context = JAXBContext.newInstance(c);
            return context.createUnmarshaller();
        } catch (JAXBException e) {
            return null;
        }

    }
}
