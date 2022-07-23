package com.example.t2009m1spring.repository;

import com.example.t2009m1spring.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
