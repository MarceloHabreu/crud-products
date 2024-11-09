package tech.project.crudProducts.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.project.crudProducts.domain.product.Product;
import tech.project.crudProducts.domain.product.ProductRequestDTO;
import tech.project.crudProducts.service.ProductService;

import java.net.URI;

@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductRequestDTO product){
        var productId = productService.createProduct(product);

        return ResponseEntity.created(URI.create("/products/" + productId.toString())).build();
    }
}
