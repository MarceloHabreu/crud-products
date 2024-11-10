package tech.project.crudProducts.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.project.crudProducts.domain.product.Product;
import tech.project.crudProducts.domain.product.ProductRequestDTO;
import tech.project.crudProducts.services.ProductService;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody ProductRequestDTO product){
        var productId = productService.createProduct(product);

        return ResponseEntity.created(URI.create("/product/" + productId.toString())).build();
    }

    @GetMapping
    public ResponseEntity<List<Product>> listProducts() {
        var products = productService.listProducts();

        return ResponseEntity.ok(products);
    }
}
