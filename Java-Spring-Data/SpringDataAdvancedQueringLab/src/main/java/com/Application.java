package com;

import com.entities.Size;
import com.services.PrintService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Application implements CommandLineRunner {
    private final PrintService printService;

    public Application(PrintService printService) {
        this.printService = printService;
    }

    @Override
    public void run(String... args) throws Exception {
//        System.out.println(printService.getTask1(Size.MEDIUM));
//        System.out.println(printService.getTask2(Size.MEDIUM, 10L));
//        System.out.println(printService.getTask3(BigDecimal.valueOf(5)));
//        System.out.println(printService.getTask4("M"));
//        System.out.println(printService.getTask5("Lavender", "Herbs", "Apple"));
//        System.out.println(printService.getTask6(BigDecimal.valueOf(8.5)));
//        System.out.println(printService.getTask7("Berry", "Mineral-Collagen"));
//        System.out.println(printService.getTask8(2));
//        System.out.println(printService.getTask9("Nettle"));
//        System.out.println(printService.getTask10(45.5));
        System.out.println(printService.getTask11(50, "Berry", "Lavender", "Apple"));

    }
}

