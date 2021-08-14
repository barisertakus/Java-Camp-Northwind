package com.bariserta.northwind.business.concretes;

import com.bariserta.northwind.business.abstracts.ProductService;
import com.bariserta.northwind.core.utilites.results.DataResult;
import com.bariserta.northwind.core.utilites.results.Result;
import com.bariserta.northwind.core.utilites.results.SuccessDataResult;
import com.bariserta.northwind.core.utilites.results.SuccessResult;
import com.bariserta.northwind.dataAccess.abstracts.ProductDao;
import com.bariserta.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<List<Product>>(
                productDao.findAll(),
                "Data listed"
        );
    }

    @Override
    public Result add(Product product) {
        productDao.save(product);
        return new SuccessResult("Product added.");
    }
}
