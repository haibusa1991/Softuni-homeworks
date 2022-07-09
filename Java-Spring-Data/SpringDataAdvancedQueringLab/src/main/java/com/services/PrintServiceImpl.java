package com.services;

import com.entities.Ingredient;
import com.entities.Size;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.stream.Collectors;

@Service
public class PrintServiceImpl implements PrintService {
    private final QueryService queryService;

    public PrintServiceImpl(QueryService queryService) {
        this.queryService = queryService;
    }

    @Override
    public String getTask1(Size size) {
        return queryService.geShampooBySizeOrderedByIdAsc(Size.MEDIUM)
                .stream()
                .map(e -> String.format("%s %s %.2f lv.",
                        e.getBrand(),
                        e.getSize().name(),
                        e.getPrice()))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public String getTask2(Size medium, Long labelId) {
        return queryService.getShampooBySizeOrIdOrderByPriceAsc(medium, labelId)
                .stream()
                .map(e -> String.format("%s %s %.2f lv.",
                        e.getBrand(),
                        e.getSize().name(),
                        e.getPrice()))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public String getTask3(BigDecimal price) {
        return queryService.getShampooByPriceOrderByPriceDesc(price)
                .stream()
                .map(e -> String.format("%s %s %.2f lv.",
                        e.getBrand(),
                        e.getSize().name(),
                        e.getPrice()))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public String getTask4(String startsWith) {
        return queryService.getIngredientsStaringWith(startsWith)
                .stream()
                .map(Ingredient::getName)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public String getTask5(String... names) {
        return queryService.getAllIngredientsByName(names)
                .stream()
                .map(Ingredient::getName)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public Long getTask6(BigDecimal price) {
        return queryService.countShampooWithPriceLessThan(price);
    }

    @Override
    public String getTask7(String... ingredients) {
        return queryService.getAllBrandNamesContainingIngredients(ingredients)
                .stream()
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public String getTask8(int ingredientsCount) {
        return queryService.getAllBrandNamesWithIngredientCountLessThan(ingredientsCount)
                .stream()
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public String getTask9(String ingredientName) {
        return String.format("%d ingredients were deleted", queryService.deleteIngredientByName(ingredientName));
    }

    @Override
    public String getTask10(double percentage) {
        return String.format("The price of %d ingredients were increased by %.2f percent",
                queryService.increaseIngredientPriceBy(percentage),
                percentage);
    }

    @Override
    public String getTask11(double percentage, String... ingredientNames) {
        return String.format("The price of the following %d ingredients was increased by %.2f percent:%n%s",
                queryService.increaseIngredientPriceBy(percentage, ingredientNames),
                percentage,
                String.join(System.lineSeparator(), ingredientNames));
    }
}
