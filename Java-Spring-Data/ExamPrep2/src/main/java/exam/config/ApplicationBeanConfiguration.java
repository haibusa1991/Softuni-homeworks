package exam.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.xml.bind.v2.runtime.JAXBContextImpl;
import exam.dto.customer.CustomerImportDto;
import exam.model.Customer;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
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
    public ModelMapper mapper() {
        ModelMapper mapper = new ModelMapper();

        Converter<String, LocalDate> converter = context -> {
//                "26/07/2020"
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.parse(context.getSource(), formatter);
        };


        mapper.createTypeMap(CustomerImportDto.class, Customer.class)
                .addMappings(e -> e.using(converter).map(CustomerImportDto::getRegisteredOn, Customer::setRegistrationDate));

        return mapper;
    }

    public static <T> Unmarshaller getUnmarshaller(Class<T> clazz) {
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            return context.createUnmarshaller();
        } catch (Exception e) {
            return null;
        }
    }
}
