package com.tactfactory.monprojetsb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tactfactory.monprojetsb.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
