package cardealer.services;

import cardealer.dto.sales.ExportSaleWithCustomerJsonDto;
import cardealer.entities.*;
import cardealer.repositories.CarRepository;
import cardealer.repositories.CustomerRepository;
import cardealer.repositories.SaleRepository;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static cardealer.util.Filepaths.*;

@Service
public class SaleServiceImpl implements SaleService {
    private final SaleRepository saleRepository;
    private final CustomerRepository customerRepository;
    private final CarRepository carRepository;
    private final ModelMapper mapper;
    private final Gson gson;

    private int SALES_COUNT = 150;

    public SaleServiceImpl(SaleRepository saleRepository,
                           CustomerRepository customerRepository,
                           CarRepository carRepository,
                           ModelMapper mapper,
                           @Qualifier("skipCarId") Gson gson) {
        this.saleRepository = saleRepository;
        this.customerRepository = customerRepository;
        this.carRepository = carRepository;
        this.mapper = mapper;
        this.gson = gson;
    }

    @Override
    public void seedSales() {
        for (int i = 0; i < SALES_COUNT; i++) {
            if (SALES_COUNT > this.carRepository.count()) {
                break;
            }

            Customer customer = getRandomCustomer();
            Car car = getRandomCar();
            Discount discount = getRandomDiscount();

            Sale s = new Sale(car, customer, discount);
            try {
                this.saleRepository.save(s);
            } catch (Exception e) {
                SALES_COUNT++;
            }
        }

    }

    private Customer getRandomCustomer() {
        return this.customerRepository.getById(new Random().nextInt((int) this.customerRepository.count()) + 1);
    }

    private Car getRandomCar() {
        return this.carRepository.getById(new Random().nextInt((int) this.carRepository.count()) + 1);
    }

    private Discount getRandomDiscount() {
        return Discount.values()[new Random().nextInt(Discount.values().length)];
    }


    @Override
    @Transactional
    public void exportAllSales() throws IOException {
        List<Sale> allSales = saleRepository.getAllSales();

        List<ExportSaleWithCustomerJsonDto> dtos = allSales.stream()
                .map(e -> {
                    ExportSaleWithCustomerJsonDto dto = this.mapper.map(e, ExportSaleWithCustomerJsonDto.class);

                    List<BigDecimal> partPrices = new ArrayList<>();
                    e.getCar().getParts().stream().map(Part::getPrice).forEach(partPrices::add);

                    BigDecimal finalPrice = BigDecimal.ZERO;
                    for (BigDecimal partPrice : partPrices) {
                        finalPrice = finalPrice.add(partPrice);
                    }

                    dto.setPrice(finalPrice);
                    BigDecimal discount = BigDecimal.valueOf(dto.getDiscount());
                    dto.setPriceWithDiscount(finalPrice.multiply(discount));

                    return dto;
                })
                .collect(Collectors.toList());

        FileOutputStream fos = new FileOutputStream(JSON_EXPORT_QUERY_6);
        fos.write(gson.toJson(dtos).getBytes());
        fos.close();
    }

}

