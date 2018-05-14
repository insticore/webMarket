package com.insticore.studApp.repository;

import com.insticore.studApp.model.Product;
import com.insticore.studApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
