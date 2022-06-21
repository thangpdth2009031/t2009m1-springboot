package com.example.t2009m1spring.controller.product;

import com.example.t2009m1spring.entity.Product;
import com.example.t2009m1spring.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@CrossOrigin("http://localhost:63343")
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    ProductService productService;
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return ResponseEntity.ok(productService.save(product));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        Optional<Product> product = productService.findById(id);
        if (!product.isPresent()){
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(product.get());
    }

    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public ResponseEntity<Product> update(@PathVariable int id, @RequestBody Product product) {
        Optional<Product> productId = productService.findById(id);
        if (!productId.isPresent()){
            ResponseEntity.badRequest().build();
        }
        Product exitsProduct = productId.get();
        exitsProduct.setName(product.getName());
        exitsProduct.setThumbnail(product.getThumbnail());
        exitsProduct.setDescription(product.getDescription());
        exitsProduct.setSlug(product.getSlug());
        exitsProduct.setStatus(product.getStatus());
        return ResponseEntity.ok(productService.save(exitsProduct));
    }
    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Optional<Product> product = productService.findById(id);
        if (!product.isPresent()){
            ResponseEntity.badRequest().build();
        }
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
