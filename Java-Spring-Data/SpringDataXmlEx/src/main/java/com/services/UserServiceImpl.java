package com.services;

import com.entities.product.ExportProductNamePriceDto;
import com.entities.product.ExportProductNamePriceListDto;
import com.entities.product.Product;
import com.entities.user.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private ModelMapper mapper;

    private final String QUERY_TWO_FILE = "src/main/resources/export/query2.xml";
    private final String QUERY_FOUR_FILE = "src/main/resources/export/query4.xml";

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

        this.mapper = new ModelMapper();
    }

    @Override
    @Transactional
    public void exportSuccessfullySoldProducts() throws JAXBException, IOException {
        List<ExportUserWithSoldProductsDto> usersWithSoldProducts = this.userRepository.
                getUsersWithSoldProducts()
                .stream()
                .map(this::filterUnsoldItems)
                .map(e -> this.mapper.map(e, ExportUserWithSoldProductsDto.class))
                .collect(Collectors.toList());

        ExportUserListWithSoldProductsDto list = new ExportUserListWithSoldProductsDto(usersWithSoldProducts);

        JAXBContext context = JAXBContext.newInstance(ExportUserListWithSoldProductsDto.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(list, new FileWriter(QUERY_TWO_FILE));
    }

    @Override
    @Transactional
    public void exportUsersAndSoldItems() throws JAXBException, IOException {

        List<ExportUserListWithProductNamePriceDto> usersWithSoldProducts = this.userRepository.getUsersWithSoldProducts()
                .stream()
                .map(this::filterUnsoldItems)
                .map(this::convertToUserDto)
                .collect(Collectors.toList());

        ExportUsersWithSalesDto dto = new ExportUsersWithSalesDto(usersWithSoldProducts.size(),usersWithSoldProducts);

        JAXBContext context = JAXBContext.newInstance(ExportUsersWithSalesDto.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);

        marshaller.marshal(dto,new FileWriter(QUERY_FOUR_FILE));
    }

    private ExportUserListWithProductNamePriceDto convertToUserDto(User user) {
        ExportUserListWithProductNamePriceDto retval = new ExportUserListWithProductNamePriceDto();
        retval.setFirstName(user.getFirstName());
        retval.setLastName(user.getLastName());
        retval.setAge(user.getAge());

        List<ExportProductNamePriceDto> productNamePriceDtos = user
                .getListedProducts()
                .stream()
                .map(e -> mapper.map(e, ExportProductNamePriceDto.class))
                .collect(Collectors.toList());

        ExportProductNamePriceListDto exportProductNamePriceListDto =
                new ExportProductNamePriceListDto(productNamePriceDtos.size(), productNamePriceDtos);

        retval.setSoldProducts(exportProductNamePriceListDto);

        return retval;
    }

    private User filterUnsoldItems(User user) {

        List<Product> soldProducts = new ArrayList<>(user.getListedProducts()).stream()
                .filter(e -> e.getBuyer() != null)
                .collect(Collectors.toList());
        user.setListedProducts(new HashSet<>(soldProducts));

        return user;
    }
}
