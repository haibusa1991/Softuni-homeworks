package cardealer.util;

import cardealer.dto.car.ExportCarJsonDto;
import cardealer.dto.car.ImportCarJsonDto;
import cardealer.dto.customer.ExportCustomerOrderedJsonDto;
import cardealer.dto.customer.ImportCustomerJsonDto;
import cardealer.dto.supplier.ImportSupplierJsonDto;
import cardealer.entities.*;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class Config {

    @Bean
    @Primary
    public Gson getGson() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    @Bean(name = "skipCarId")
    public Gson getGsonNoCarId() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .setExclusionStrategies(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes f) {
                        return f.getDeclaringClass() == ExportCarJsonDto.class && f.getName().equals("id");
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> clazz) {
                        return false;
                    }
                })
                .create();
    }

    @Bean
    @Primary
    public ModelMapper getModelMapper() {
        ModelMapper mapper = new ModelMapper();


        mapper.createTypeMap(ImportSupplierJsonDto.class, Supplier.class)
                .addMapping(ImportSupplierJsonDto::isImporter, Supplier::setUsesImportedParts);

        mapper.createTypeMap(ImportCarJsonDto.class, Car.class)
                .addMapping(ImportCarJsonDto::getTravelledDistance, Car::setTraveledDistance);

        Converter<String, LocalDate> stringToLocalDate = context -> {
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(context.getSource().split("T")[0], timeFormatter);
        };

        mapper.createTypeMap(ImportCustomerJsonDto.class, Customer.class)
                .addMappings(e -> e.using(stringToLocalDate).map(ImportCustomerJsonDto::getBirthDate, Customer::setBirthDate));

        Converter<LocalDate, String> LocalDateToString = context -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
            return LocalDateTime.of(context.getSource(), LocalTime.of(0, 0, 0)).format(formatter);
        };

        mapper.createTypeMap(Customer.class, ExportCustomerOrderedJsonDto.class)
                .addMappings(e -> e.using(LocalDateToString)
                        .map(Customer::getBirthDate, ExportCustomerOrderedJsonDto::setBirthDate));


        return mapper;
    }

}
