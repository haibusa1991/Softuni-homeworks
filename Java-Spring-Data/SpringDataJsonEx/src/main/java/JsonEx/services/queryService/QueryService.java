package JsonEx.services.queryService;

import JsonEx.entities.product.ProductCountDto;
import JsonEx.entities.product.SellingProductDto;
import JsonEx.entities.user.SellerDto;
import JsonEx.entities.user.UsersProductsCountDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface QueryService {
    Set<SellingProductDto> getSellingProductsInRange(BigDecimal from, BigDecimal to);

    List<SellerDto> getAllSales();

    List<ProductCountDto> getCategoriesByProductCount();

    UsersProductsCountDto getUserProducts();
}
