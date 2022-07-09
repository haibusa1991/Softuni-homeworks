package softuni.exam.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import softuni.exam.models.dto.offer.ImportOfferDto;
import softuni.exam.models.entity.Offer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public Gson getGson() {
        return new GsonBuilder().create();
    }

    @Bean
    public ModelMapper getMapper() {
        ModelMapper mapper = new ModelMapper();

        Converter<String, LocalDate> converter = context -> {
//                28/12/2005
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.parse(context.getSource(), formatter);
        };

        mapper.createTypeMap(ImportOfferDto.class, Offer.class)
                .addMappings(e -> e.using(converter).map(ImportOfferDto::getPublishDate, Offer::setPublishDate));

        return mapper;
    }

}
