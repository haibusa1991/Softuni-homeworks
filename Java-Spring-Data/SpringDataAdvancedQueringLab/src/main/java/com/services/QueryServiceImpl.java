package com.services;


import com.entities.Ingredient;
import com.entities.Shampoo;
import com.entities.Size;
import com.repositories.IngredientRepository;
import com.repositories.ShampooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Service
public class QueryServiceImpl implements QueryService {
    private final ShampooRepository shampooRepository;
    private final IngredientRepository ingredientRepository;

    @Autowired
    public QueryServiceImpl(
            ShampooRepository shampooRepository,
            IngredientRepository ingredientRepository) {

        this.shampooRepository = shampooRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Shampoo> geShampooBySizeOrderedByIdAsc(Size size) {
        return this.shampooRepository.findAllBySizeOrderById(size);
    }

    @Override
    public List<Shampoo> getShampooBySizeOrIdOrderByPriceAsc(Size size, Long labelId) {
        return this.shampooRepository.findAllBySizeOrLabel_IdOrderByPriceAsc(size, labelId);
    }

    @Override
    public List<Shampoo> getShampooByPriceOrderByPriceDesc(BigDecimal price) {
        return this.shampooRepository.findAllByPriceGreaterThanOrderByPriceDesc(price);
    }

    @Override
    public List<Ingredient> getIngredientsStaringWith(String startsWith) {
        return this.ingredientRepository.findAllByNameStartingWith(startsWith);
    }

    @Override
    public Collection<Ingredient> getAllIngredientsByName(String[] names) {
        return this.ingredientRepository.findAllByNameIn(List.of(names));
    }

    @Override
    public long countShampooWithPriceLessThan(BigDecimal price) {
        return this.shampooRepository.countByPriceLessThan(price);
    }

    @Override
    public Set<String> getAllBrandNamesContainingIngredients(String... ingredientNames) {
        return this.shampooRepository.findAllBrandNamesContainingIngredients(Set.of(ingredientNames));
    }

    @Override
    public Set<String> getAllBrandNamesWithIngredientCountLessThan(int ingredientCount) {
        return this.shampooRepository.getAllShampoosWithIngredientsLessThan(ingredientCount);
    }

    @Override
    public int deleteIngredientByName(String name) {
        return this.ingredientRepository.deleteIngredientByName(name);
    }

    @Override
    public int increaseIngredientPriceBy(double percentage) {

        return this.ingredientRepository.increaseIngredientPriceBy(BigDecimal.valueOf(percentage / 100 + 1));
    }

    @Override
    public int increaseIngredientPriceBy(double percentage, String... ingredientNames) {
        return this.ingredientRepository.increaseIngredientPriceBy(BigDecimal.valueOf(percentage / 100 + 1), Set.of(ingredientNames));
    }
}
