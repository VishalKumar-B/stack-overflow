package com.example.gatewaycsrf;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class SampleController {
    private final List<String> productList;

    public SampleController() {
        this.productList = new ArrayList<>();
        productList.add("keyboard");
        productList.add("mouse");
    }


    @GetMapping
    public ResponseEntity<?> getProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productList);
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody String product) {
        if(productList.contains(product)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(String.format("product %s already exists", product));
        }
        productList.add(product);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }
}
