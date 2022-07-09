package JsonEx.services.queryService;

import JsonEx.entities.Mapper;
import JsonEx.entities.category.CategoryRepository;
import JsonEx.entities.product.ProductCountDto;
import JsonEx.entities.product.ProductPriceDto;
import JsonEx.entities.product.ProductRepository;
import JsonEx.entities.product.SellingProductDto;
import JsonEx.entities.user.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class QueryServiceImpl implements QueryService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public QueryServiceImpl(ProductRepository productRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Set<SellingProductDto> getSellingProductsInRange(BigDecimal from, BigDecimal to) {
        return productRepository.getSellingProductsInRange(from, to);
    }

    @Transactional
    @Override
    public List<SellerDto> getAllSales() {
        Set<User> allSales = this.userRepository.getAllSales();
        return allSales.stream()
                .map(e -> Mapper.getInstance().getMapper().map(e, SellerDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductCountDto> getCategoriesByProductCount() {
        return this.categoryRepository.getProductCount();
    }


    @Transactional
    @Override
    public UsersProductsCountDto getUserProducts() {
        Set<User> userCountSales = this.userRepository.getUserCountSales();


        List<UserProductDto> userProductDtos = userCountSales.stream()
                .map(e -> Mapper.getInstance().getMapper().map(e, UserProductDto.class))
                .collect(Collectors.toList());

        return new UsersProductsCountDto(userProductDtos.size(), new HashSet<>(userProductDtos));
    }


}