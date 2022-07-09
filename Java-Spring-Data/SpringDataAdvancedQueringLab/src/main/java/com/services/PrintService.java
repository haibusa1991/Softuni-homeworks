package com.services;

import com.entities.Size;

import java.math.BigDecimal;

public interface PrintService {

    String getTask1(Size size);

    String getTask2(Size medium, Long labelId);

    String getTask3(BigDecimal price);

    String getTask4(String startsWith);

    String getTask5(String... names);

    Long getTask6(BigDecimal price);

    String getTask7(String... ingredients);

    String getTask8(int ingredientsCount);

    String getTask9(String ingredientName);

    String getTask10(double percentage);

    String getTask11(double percentage, String... ingredientNames);
}
