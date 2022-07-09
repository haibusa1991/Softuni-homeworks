package com.services;

import com.entites.Category;
import com.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
public class CategoriesServiceImpl implements CategoriesService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoriesServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Set<Category> getRandomCategories() {
        int categoriesCount = (int) categoryRepository.count();

        int requiredCategoriesCount = new Random().nextInt(categoriesCount) + 1;

        Set<Category> categories = new HashSet<>();
        while (categories.size() < requiredCategoriesCount) {
            Integer randomId = new Random().nextInt(categoriesCount)+1;
            Category randomCategory = categoryRepository.findCategoryById(randomId);

            categories.add(randomCategory);
        }

        return categories;
    }
}
