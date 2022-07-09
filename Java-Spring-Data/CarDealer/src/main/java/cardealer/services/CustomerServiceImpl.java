package cardealer.services;

import cardealer.dto.sales.ExportSaleJsonDto;
import cardealer.dto.customer.ExportCustomerOrderedJsonDto;
import cardealer.dto.customer.ExportTotalSalesJsonDto;
import cardealer.dto.customer.ImportCustomerJsonDto;
import cardealer.entities.Customer;
import cardealer.entities.Part;
import cardealer.entities.Sale;
import cardealer.repositories.CustomerRepository;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

import static cardealer.util.Filepaths.*;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final Gson gson;
    private final ModelMapper mapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, Gson gson, ModelMapper mapper) {
        this.customerRepository = customerRepository;
        this.gson = gson;
        this.mapper = mapper;
    }


    @Override
    public void importCustomers() throws IOException {
        String json = String.join(System.lineSeparator(), Files.readAllLines(Path.of(JSON_IMPORT_CUSTOMERS)));

        List<Customer> customers = Arrays.stream(gson.fromJson(json, ImportCustomerJsonDto[].class))
                .map(e -> mapper.map(e, Customer.class))
                .collect(Collectors.toList());

        this.customerRepository.saveAll(customers);
    }

    @Override
    @Transactional
    public void exportCustomersOrdered() throws IOException {
        List<Customer> customers = this.customerRepository
                .getCustomerByIdGreaterThanOrderByBirthDateAscIsYoungDriverDesc(0);

        //eeew.
        List<ExportCustomerOrderedJsonDto> dtos = customers.stream()
                .map(e -> {
                    ExportCustomerOrderedJsonDto dto = mapper.map(e, ExportCustomerOrderedJsonDto.class);
                    Set<ExportSaleJsonDto> salesDto = e.getSales()
                            .stream()
                            .map(e2 -> {
                                double carPrice = e2.getCar()
                                        .getParts()
                                        .stream()
                                        .map(Part::getPrice)
                                        .map(BigDecimal::doubleValue)
                                        .mapToDouble(e3 -> e3)
                                        .sum();

                                double salePrice = carPrice * e2.getDiscountPercentage().getDiscountMultiplier();

                                ExportSaleJsonDto sale = mapper.map(e2, ExportSaleJsonDto.class);

                                sale.setCarPrice(BigDecimal.valueOf(carPrice));
                                sale.setSalePrice(BigDecimal.valueOf(salePrice));
                                return sale;
                            })
                            .collect(Collectors.toSet());


                    dto.setSales(salesDto);
                    return dto;
                })
                .collect(Collectors.toList());

        FileOutputStream fos = new FileOutputStream(JSON_EXPORT_QUERY_1);
        fos.write(gson.toJson(dtos).getBytes());
        fos.close();
    }

    @Override
    @Transactional
    public void exportAllCustomers() throws IOException {
        List<ExportTotalSalesJsonDto> dtos = this.customerRepository.getAllCustomersWithSales()
                .stream()
                .map(e -> {
                    ExportTotalSalesJsonDto dto = new ExportTotalSalesJsonDto();
                    dto.setFullName(e.getName());
                    dto.setBoughtCars(e.getSales().size());


                    List<BigDecimal> carPrices = new ArrayList<>();

                    Set<Sale> sales = e.getSales();

                    for (Sale sale : sales) {
                        Set<Part> parts = sale.getCar().getParts();
                        List<BigDecimal> carPrice = parts.stream()
                                .map(Part::getPrice)
                                .collect(Collectors.toList());

                        carPrices.addAll(carPrice);
                    }

                    for (BigDecimal carPrice : carPrices) {
                        dto.setSpentMoney(dto.getSpentMoney().add(carPrice));
                    }

                    return dto;
                })
                .collect(Collectors.toList());

        FileOutputStream fos = new FileOutputStream(JSON_EXPORT_QUERY_5);
        fos.write(gson.toJson(dtos).getBytes());
        fos.close();
    }

}
