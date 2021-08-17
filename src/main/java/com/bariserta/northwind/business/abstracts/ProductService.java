package com.bariserta.northwind.business.abstracts;

import com.bariserta.northwind.core.utilites.results.DataResult;
import com.bariserta.northwind.core.utilites.results.Result;
import com.bariserta.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();

    DataResult<List<Product>> getAll(int pageNo, int pageSize);

    DataResult<List<Product>> getAllSortedByProductName();

    Result add(Product product);

    DataResult<Product> getByProductName(String productName);

    DataResult<Product> getByProductNameAndCategoryCategoryId(String productName, int categoryId);

    DataResult<List<Product>> getByProductNameOrCategoryCategoryId(String productName, int categoryId);

    DataResult<List<Product>> getByCategoryCategoryIdIn(List<Integer> categories);

    DataResult<List<Product>> getByProductNameContains(String productName);

    DataResult<List<Product>> getByProductNameStartsWith(String productName);

    DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);
}
