package com.services;

import com.entities.category.ExportCategoryStatisticsDto;
import com.entities.category.ExportCategoryStatisticsListDto;
import com.entities.product.ExportProductDto;
import com.entities.product.ExportProductDtoList;
import com.entities.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final String QUERY_ONE_FILE = "src/main/resources/export/query1.xml";

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void exportCurrentlyListedProductsInRange(BigDecimal from, BigDecimal to) throws JAXBException, IOException {
        List<ExportProductDto> products = this.productRepository.getProductDtosInRange(from, to);

        ExportProductDtoList exportProductDtoList = new ExportProductDtoList();
        exportProductDtoList.setProductDtos(products);

        JAXBContext context = JAXBContext.newInstance(ExportProductDtoList.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(exportProductDtoList, new FileWriter(QUERY_ONE_FILE));
    }
}
