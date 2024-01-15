package com.love2shop.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.love2shop.ecommerce.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
