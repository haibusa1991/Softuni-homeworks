package com.services;

import com.entities.category.Category;
import com.entities.category.CategoryRepository;
import com.entities.category.ImportCategoryListDto;
import com.entities.product.ImportProductListDto;
import com.entities.product.Product;
import com.entities.product.ProductRepository;
import com.entities.user.User;
import com.entities.user.ImportUserListDto;
import com.entities.user.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SeedServiceImpl implements SeedService {
    private final String USER_FILE_PATH = "src/main/resources/users.xml";
    private final String CATEGORIES_FILE_PATH = "src/main/resources/categories.xml";
    private final String PRODUCTS_FILE_PATH = "src/main/resources/products.xml";

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final ModelMapper mapper;

    @Autowired
    public SeedServiceImpl(UserRepository userRepository, CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;

        this.mapper = new ModelMapper();
    }


    @Override
    public void seedUsers() throws JAXBException, FileNotFoundException {
        FileReader fileReader = new FileReader(USER_FILE_PATH);

        JAXBContext context = JAXBContext.newInstance(ImportUserListDto.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        ImportUserListDto userListDto = (ImportUserListDto) unmarshaller.unmarshal(fileReader);

        List<User> users = userListDto.getUsers()
                .stream()
                .map(e -> mapper.map(e, User.class))
                .collect(Collectors.toList());

        this.userRepository.saveAll(users);

    }

    @Override
    public void seedCategories() throws FileNotFoundException, JAXBException {
        FileReader fileReader = new FileReader(CATEGORIES_FILE_PATH);

        JAXBContext context = JAXBContext.newInstance(ImportCategoryListDto.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        ImportCategoryListDto importCategoryListDto = (ImportCategoryListDto) unmarshaller.unmarshal(fileReader);

        List<Category> categories = importCategoryListDto.getCategories()
                .stream()
                .map(e -> mapper.map(e, Category.class))
                .collect(Collectors.toList());

        this.categoryRepository.saveAll(categories);

    }

    @Override
    public void seedProducts() throws FileNotFoundException, JAXBException {
        FileReader fileReader = new FileReader(PRODUCTS_FILE_PATH);

        JAXBContext context = JAXBContext.newInstance(ImportProductListDto.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        ImportProductListDto importProductListDto = (ImportProductListDto) unmarshaller.unmarshal(fileReader);

        List<Product> products = importProductListDto.getProductDtos()
                .stream()
                .map(e -> mapper.map(e, Product.class))
                .map(this::setRandomSeller)
                .map(this::setRandomBuyer)
                .map(this::setRandomCategories)
                .collect(Collectors.toList());

        this.productRepository.saveAll(products);

    }

    @Override
    public void seedAll() throws JAXBException, FileNotFoundException {
        seedUsers();
        seedCategories();
        seedProducts();
    }

    private Product setRandomCategories(Product product) {
        Random r = new Random();
        int categoriesCount = (int) this.categoryRepository.count();
        int categoriesToAdd = Math.max((r.nextInt(categoriesCount) + 1) / 2, 1);

        Set<Category> categories = new HashSet<>();
        while (categories.size() < categoriesToAdd) {
            categories.add(this.categoryRepository.getCategoryById(r.nextInt(categoriesCount) + 1));
        }

        product.setCategories(categories);
        return product;
    }

    private Product setRandomSeller(Product product) {
        product.setSeller(getRandomUser());
        return product;
    }

    private Product setRandomBuyer(Product product) {
        int r = new Random().nextInt(100) + 1;

        if (r <= 30) {
            return product;
        }

        product.setBuyer(getRandomUser());
        return product;
    }

    private User getRandomUser() {
        Random r = new Random();
        int userId = r.nextInt((int) this.userRepository.count()) + 1;
        return this.userRepository.getUserById(userId);
    }
}
