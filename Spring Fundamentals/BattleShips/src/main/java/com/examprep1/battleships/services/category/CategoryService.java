package com.examprep1.battleships.services.category;

import com.examprep1.battleships.entities.Category;

public interface CategoryService {

    String[] getAllShipCategories();

    Category getCategory(String categoryName);
}
