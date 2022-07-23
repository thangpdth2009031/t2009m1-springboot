package com.example.t2009m1spring.repository;

import com.example.t2009m1spring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByNameContains(String name);
    List<Product> findAllByNameContainsOrPriceLessThanEqualAndStatusEquals(String name, double price, int status);
    @Query(value = "select *from  products p where p.name like :name", nativeQuery = true)
    List<Product> search(@Param("name") String name);

}
