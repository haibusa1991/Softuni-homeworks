package com.services;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.math.BigDecimal;

public interface ProductService {
    void exportCurrentlyListedProductsInRange(BigDecimal from, BigDecimal to) throws JAXBException, IOException;

}
