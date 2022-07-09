package com.services;

import com.entities.Ingredient;
import com.entities.Shampoo;
import com.entities.Size;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Set;


public interface QueryService {
    List<Shampoo> geShampooBySizeOrderedByIdAsc(Size size);

    List<Shampoo> getShampooBySizeOrIdOrderByPriceAsc(Size medium, Long labelId);

    List<Shampoo> getShampooByPriceOrderByPriceDesc(BigDecimal price);

    List<Ingredient> getIngredientsStaringWith(String startsWith);

    Collection<Ingredient> getAllIngredientsByName(String[] names);

    long countShampooWithPriceLessThan(BigDecimal price);

    Set<String> getAllBrandNamesContainingIngredients(String... ingredientNames);

    Set<String>  getAllBrandNamesWithIngredientCountLessThan(int ingredientCount);

    int deleteIngredientByName(String name);

    int increaseIngredientPriceBy(double percentage);

    int increaseIngredientPriceBy(double percentage,String... ingredientNames);
}
