package com.bariserta.northwind.business.concretes;

import com.bariserta.northwind.business.abstracts.ProductService;
import com.bariserta.northwind.core.utilites.results.DataResult;
import com.bariserta.northwind.core.utilites.results.Result;
import com.bariserta.northwind.core.utilites.results.SuccessDataResult;
import com.bariserta.northwind.core.utilites.results.SuccessResult;
import com.bariserta.northwind.dataAccess.abstracts.ProductDao;
import com.bariserta.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
                "Data listed."
        );
    }

    @Override
    public Result add(Product product) {
        productDao.save(product);
        return new SuccessResult("Product added.");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<Product>(
                productDao.getByProductName(productName),
                "Data listed."
        );
    }

    @Override
    public DataResult<Product> getByProductNameAndCategoryCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<Product>(
                productDao.getByProductNameAndCategoryCategoryId(productName,categoryId),
                "Data listed."
        );
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategoryCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(
                productDao.getByProductNameOrCategoryCategoryId(productName,categoryId),
                "Data listed."
        );
    }

    @Override
    public DataResult<List<Product>> getByCategoryCategoryIdIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>(
                productDao.getByCategoryCategoryIdIn(categories),
                "Data listed."
        );
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>(
                productDao.getByProductNameContains(productName),
                "Data listed."
        );
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>(
                productDao.getByProductNameStartsWith(productName),
                "Data listed."
        );
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(
                productDao.getByNameAndCategory(productName,categoryId),
                "Data listed."
        );
    }


    @Override
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo - 1 ,pageSize);

        return new SuccessDataResult<List<Product>>(
                productDao.findAll(pageable).getContent(),
                "Data listed."
        );
    }

    @Override
    public DataResult<List<Product>> getAllSortedByProductName() {
        Sort sort = Sort.by(Sort.Direction.DESC,"productName");
        return new SuccessDataResult<List<Product>>(
                productDao.findAll(sort),
                "Data listed."
        );
    }
}
