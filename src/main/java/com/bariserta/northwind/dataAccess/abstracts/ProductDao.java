package com.bariserta.northwind.dataAccess.abstracts;

import com.bariserta.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product,Integer> {

}
