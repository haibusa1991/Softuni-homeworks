package com;

import com.services.CategoryService;
import com.services.ProductService;
import com.services.SeedService;
import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Application implements CommandLineRunner {
    private final SeedService seedService;
    private final ProductService productService;
    private final UserService userService;
    private final CategoryService categoryService;

    @Autowired
    public Application(SeedService seedService, ProductService productService, UserService userService, CategoryService categoryService) {
        this.seedService = seedService;
        this.productService = productService;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
//        seedService.seedAll();
//        productService.exportCurrentlyListedProductsInRange(BigDecimal.valueOf(500), BigDecimal.valueOf(1000));
//        userService.exportSuccessfullySoldProducts();
//        categoryService.exportCategoryInfo();
        userService.exportUsersAndSoldItems();

    }
}
