package com.bariserta.northwind.dataAccess.abstracts;

import com.bariserta.northwind.entities.concretes.Product;
import com.bariserta.northwind.entities.dtos.ProductWithCategoryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {
    Product getByProductName(String productName);

    Product getByProductNameAndCategoryCategoryId(String productName, int categoryId);

    List<Product> getByProductNameOrCategoryCategoryId(String productName, int categoryId);

    List<Product> getByCategoryCategoryIdIn(List<Integer> categories);

    List<Product> getByProductNameContains(String productName);

    List<Product> getByProductNameStartsWith(String productName);

    @Query("FROM Product WHERE productName =:productName and category.categoryId=:categoryId")
    List<Product> getByNameAndCategory(String productName, int categoryId);

    @Query("select new com.bariserta.northwind.entities.dtos.ProductWithCategoryDTO" +
            "(p.id, p.productName, c.categoryName) " +
            "from Category c inner join c.products p")
    List<ProductWithCategoryDTO> getProductWithCategoryDetails();
}
