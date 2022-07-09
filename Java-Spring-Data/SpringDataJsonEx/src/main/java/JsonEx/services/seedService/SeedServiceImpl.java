package JsonEx.services.seedService;

import JsonEx.entities.Mapper;
import JsonEx.entities.category.Category;
import JsonEx.entities.category.CategoryRegistrationDto;
import JsonEx.entities.category.CategoryRepository;
import JsonEx.entities.product.Product;
import JsonEx.entities.product.ProductRegistrationDto;
import JsonEx.entities.product.ProductRepository;
import JsonEx.entities.user.User;
import JsonEx.entities.user.UserRegistrationDto;
import JsonEx.entities.user.UserRepository;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SeedServiceImpl implements SeedService {
    private final Gson gson;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public SeedServiceImpl(UserRepository userRepository, CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.gson = new Gson();
    }

    @Override
    public void seedUsers() throws FileNotFoundException {
        FileReader fileReader = new FileReader("src/main/resources/productsShop/users.json");

        List<User> users = Arrays.stream(gson.fromJson(fileReader, UserRegistrationDto[].class))
                .map(e -> Mapper.getInstance().getMapper().map(e, User.class))
                .collect(Collectors.toList());

        userRepository.saveAll(users);
    }

    @Override
    public void seedCategories() throws FileNotFoundException {
        FileReader fileReader = new FileReader("src/main/resources/productsShop/categories.json");

        List<Category> categories = Arrays.stream(gson.fromJson(fileReader, CategoryRegistrationDto[].class))
                .map(e -> Mapper.getInstance().getMapper().map(e, Category.class))
                .collect(Collectors.toList());

        categoryRepository.saveAll(categories);
    }

    @Override
    public void seedProducts() throws FileNotFoundException {
        FileReader fileReader = new FileReader("src/main/resources/productsShop/products.json");

        List<Product> products = Arrays.stream(gson.fromJson(fileReader, ProductRegistrationDto[].class))
                .map(e -> Mapper.getInstance().getMapper().map(e, Product.class))
                .map(this::setRandomSeller)
                .map(this::setRandomBuyer)
                .map(this::setRandomCategories)
                .collect(Collectors.toList());

        productRepository.saveAll(products);
    }

    private Product setRandomSeller(Product p) {
        p.setSeller(getRandomUser());
        return p;
    }

    private Product setRandomBuyer(Product p) {

        if (new Random().nextInt(10) + 1 < 4) {
            return p;
        }

        p.setBuyer(getRandomUser());
        return p;
    }

    private Product setRandomCategories(Product p) {
        Random r = new Random();

        long categoryCount = r.nextLong(categoryRepository.count()) + 1;
        Set<Category> categories = new HashSet<>();

        while (categories.size() < categoryCount) {
            categories.add(categoryRepository.getCategoryById(r.nextInt((int) categoryRepository.count()) + 1));
        }

        p.setCategories(categories);
        return p;
    }

    private User getRandomUser() {
        Random r = new Random();

        User user = null;
        while (user == null) {
            user = this.userRepository.getUserById(r.nextInt((int) userRepository.count()) + 1);
        }

        return user;
    }

    @Override
    public void seedAll() throws FileNotFoundException {
        this.seedUsers();
        this.seedCategories();
        this.seedProducts();
    }

}
