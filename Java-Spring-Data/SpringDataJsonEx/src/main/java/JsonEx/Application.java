package JsonEx;

import JsonEx.services.queryService.QueryService;
import JsonEx.services.seedService.SeedService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Application implements CommandLineRunner {
    private final SeedService seedService;
    private final QueryService queryService;
    private final Gson gson;


    public Application(SeedService seedService, QueryService queryService) {
        this.seedService = seedService;
        this.queryService = queryService;
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public void run(String... args) throws Exception {
//        seedService.seedAll();
//        System.out.println(query1());
//        System.out.println(query2());
//        System.out.println(query3());
        System.out.println(query4());
    }

    private String query1() {
        return gson.toJson(queryService.getSellingProductsInRange(BigDecimal.valueOf(500), BigDecimal.valueOf(1000)));
    }

    private String query2() {
        return gson.toJson(this.queryService.getAllSales());
    }

    private String query3() {
        return gson.toJson(queryService.getCategoriesByProductCount());
    }

    private String query4() {
        return gson.toJson(queryService.getUserProducts());
    }
}
