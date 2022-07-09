package exam.service.impl;

import com.google.gson.Gson;
import exam.dto.customer.CustomerImportDto;
import exam.model.Customer;
import exam.repository.CustomerRepository;
import exam.repository.TownRepository;
import exam.service.CustomerService;
import exam.util.Filenames;
import exam.util.LaptopShopFileReader;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final TownRepository townRepository;
    private final Gson gson;
    private final ModelMapper mapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, TownRepository townRepository, Gson gson, ModelMapper mapper) {
        this.customerRepository = customerRepository;
        this.townRepository = townRepository;
        this.gson = gson;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        return this.customerRepository.count() > 0;
    }

    @Override
    public String readCustomersFileContent() {
        return LaptopShopFileReader.readFile(Filenames.CUSTOMERS_FILE);
    }

    @Override
    public String importCustomers(){
        CustomerImportDto[] customerImportDtos = gson.fromJson(readCustomersFileContent(), CustomerImportDto[].class);

        List<String> results = new ArrayList<>();
        for (CustomerImportDto dto : customerImportDtos) {
            Customer customer = mapper.map(dto, Customer.class);
            customer.setTown(townRepository.getTownByName(dto.getTown().getName()));

            try {
                this.customerRepository.save(customer);
                results.add(String.format("Successfully imported Customer %s %s - %s",
                        customer.getFirstName(),
                        customer.getLastName(),
                        customer.getEmail()));
            } catch (Exception e) {
                results.add("Invalid Customer");
            }

        }
        return String.join(System.lineSeparator(), results);
    }
}
