package com.bariserta.northwind.business.abstracts;

import com.bariserta.northwind.core.utilites.results.DataResult;
import com.bariserta.northwind.core.utilites.results.Result;
import com.bariserta.northwind.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();
    Result add(Product product);
}
