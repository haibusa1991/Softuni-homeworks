package cardealer;

import cardealer.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Application implements CommandLineRunner {
    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private final SaleService saleService;

    @Autowired
    public Application(SupplierService supplierService, PartService partService, CarService carService, CustomerService customerService, SaleService saleService) {
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
    }

    @Override
    public void run(String... args) throws Exception {
//        supplierService.importSuppliers();
//        partService.importParts();
//        carService.importCars();
//        customerService.importCustomers();
//        saleService.seedSales();

//        customerService.exportCustomersOrdered();
//        carService.exportToyota();
//        supplierService.exportLocalSuppliers();
//        carService.exportCarsWithParts();
//        customerService.exportAllCustomers();
        saleService.exportAllSales();

    }
}
