package br.com.geodeveloper.getDepartament.controller;

import br.com.geodeveloper.getDepartament.entities.Departament;
import br.com.geodeveloper.getDepartament.entities.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @GetMapping
    public List<Product> getObjects() {
        Departament d1 = new Departament(1L, "Rock");
        Departament d2 = new Departament(2L, "Pop");
//        d1.setId(1L);
//        d1.setName("Rock");

        Product p1 = new Product(1L, "Civil War - Guns N' Roses", 2.99, d1);
        Product p2 = new Product(2L, "Time - Pink Floyd", 3.59, d1);
        Product p3 = new Product(3L, "Triller - Michael Jackson", 1.79, d2);

        List<Product> list = Arrays.asList(p1, p2, p3);

        return list;
    }
}
