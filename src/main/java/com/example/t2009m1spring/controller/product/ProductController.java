package com.example.t2009m1spring.controller.product;

import com.example.t2009m1spring.entity.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private static List<Product> products = new ArrayList<>();
    @RequestMapping(method = RequestMethod.POST)
    public Product save(@RequestBody Product product) {
        products.add(product);
        return product;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> findAll() {
        return products;
    }

    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public Product findById(@RequestParam int id) {
        int index = -1;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                index = i;
            }
        }
        if (index == -1) {
            return null;
        }
        return products.get(index);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public Product update(@RequestParam int id, @RequestBody Product product) {
        int index = -1;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                index = i;
            }
        }
        if (index == -1) {
            return null;
        }
        products.get(index).setName(product.getName());
        products.get(index).setDescription(product.getDescription());
        products.get(index).setSlug(product.getSlug());
        products.get(index).setThumbnail(product.getThumbnail());
        products.get(index).setStatus(product.getStatus());
        return products.get(index);
    }
    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public Product delete(@RequestParam int id) {
        int index = -1;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                index = i;
            }
        }
        if (index == -1) {
            return null;
        }
        products.remove(index);
        return null;
    }
}
