package com.bariserta.northwind.business.abstracts;

import com.bariserta.northwind.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
}
