package com.services;

import com.entities.category.CategoryRepository;
import com.entities.category.ExportCategoryStatisticsDto;
import com.entities.category.ExportCategoryStatisticsListDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final String QUERY_THREE_FILE = "src/main/resources/export/query3.xml";

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Transactional
    @Override
    public void exportCategoryInfo() throws JAXBException, IOException {
        List<ExportCategoryStatisticsDto> categoryStatistics = this.categoryRepository.getCategoryStatistics()
                .stream()
                .sorted(Comparator.comparing(ExportCategoryStatisticsDto::getCount).reversed())
                .collect(Collectors.toList());

        ExportCategoryStatisticsListDto exportDto = new ExportCategoryStatisticsListDto(categoryStatistics);

        JAXBContext context = JAXBContext.newInstance(ExportCategoryStatisticsListDto.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(exportDto, new FileWriter(QUERY_THREE_FILE));
    }
}
