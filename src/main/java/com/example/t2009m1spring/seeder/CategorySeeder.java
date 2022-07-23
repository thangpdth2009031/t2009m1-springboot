package com.example.t2009m1spring.seeder;

import com.example.t2009m1spring.entity.Category;
import com.example.t2009m1spring.repository.CategoryRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CategorySeeder {
    @Autowired
    CategoryRepository categoryRepository;
    public static ArrayList<Category> categories;
    public void generate() {
        Faker faker = new Faker();

        categories = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Category category = Category.builder()
                    .name(faker.name().name())
                    .build();
            categories.add(category);
        }
        categoryRepository.saveAll(categories);
    }

}
