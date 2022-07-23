package com.example.t2009m1spring.seeder;

import com.example.t2009m1spring.entity.Category;
import com.example.t2009m1spring.repository.CategoryRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ApplicationSeeder implements CommandLineRunner {
    @Autowired
    CategorySeeder categorySeeder;
    private boolean needSeeder;
    @Override
    public void run(String... args) throws Exception {
        if (needSeeder) {
            categorySeeder.generate();
        }
    }
}
