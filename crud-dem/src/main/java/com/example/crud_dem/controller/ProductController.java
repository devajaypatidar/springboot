package com.example.crud_dem.controller;

import com.example.crud_dem.model.Product;
import com.example.crud_dem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProdcuts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        Optional<Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok).orElseGet( ()-> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        System.out.println("Posting Data");
        return productService.saveProduct(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable Long id, @RequestBody Product productDetails){
        Optional<Product> productOptional = productService.getProductById(id);
        if(!productOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }

        Product product = productOptional.get();
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());

        Product updateproduct = productService.saveProduct(product);
        return ResponseEntity.ok(updateproduct);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        Optional<Product> productOptional = productService.getProductById(id);
        if(productOptional.isPresent()){
            productService.deleteProduct(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
