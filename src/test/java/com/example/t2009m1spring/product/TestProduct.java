package com.example.t2009m1spring.product;

import com.example.t2009m1spring.controller.product.ProductController;
import com.example.t2009m1spring.entity.Product;
import com.example.t2009m1spring.repository.ProductRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class TestProduct {
    MockMvc mockMvc;
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    ProductController productController;

    @Test
    public void paging() {
        int page = 1;
        int limit = 10;
        Page<Product> pageProduct = productRepository.findAll(
                PageRequest.of(
                        page - 1,
                        limit,
                        Sort.by(Sort.Direction.DESC, "name")));
        System.out.println("Total elements: " + pageProduct.getTotalElements());
        System.out.println("Total pages:" + pageProduct.getTotalPages());
        System.out.println("Current pages: " + pageProduct.getNumber());
        System.out.println("Current limit: " + pageProduct.getSize());
        List<Product> list = pageProduct.getContent();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());

        }
    }
    @Before
    public void preTest(){
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(productController)
                .build();
    }
    @Test
    public void requestBodyTest() {
       try {
           when(productController.findAll()).thenReturn((ResponseEntity<List<Product>>) productRepository.findAll());
           mockMvc
                   .perform(get("/api/v1/products")
                           .content(String.valueOf(new Product()))
                           .contentType("application/json"))
                   .andDo(MockMvcResultHandlers.print())
                   .andExpect(status().isOk());

       }catch (Exception e) {
           System.out.println("Exception: " + e.getMessage());
       }
    }
}
