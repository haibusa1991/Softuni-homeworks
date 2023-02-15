package com.examprep1.battleships.services.category;

import com.examprep1.battleships.entities.Category;
import com.examprep1.battleships.enumeration.ShipCategory;
import com.examprep1.battleships.repositories.CategoryRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostConstruct
    public void initShipCategories() {
        if (this.categoryRepository.count() == 0) {
            List<Category> categories = Arrays.stream(ShipCategory.values()).map(Category::new).toList();
            this.categoryRepository.saveAll(categories);
        }
    }

    @Override
    public String[] getAllShipCategories() {
        return this.categoryRepository.findAll()
                .stream()
                .map(Category::getName)
                .map(Enum::name)
                .toArray(String[]::new);
    }

    @Override
    public Category getCategory(String categoryName){
        return this.categoryRepository.findCategoryByName(ShipCategory.valueOf(categoryName));
    }
}
