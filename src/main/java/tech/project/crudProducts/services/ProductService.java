package tech.project.crudProducts.services;

import org.springframework.stereotype.Service;
import tech.project.crudProducts.domain.product.Product;
import tech.project.crudProducts.domain.product.ProductRequestDTO;
import tech.project.crudProducts.repositories.ProductRepository;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private ProductRepository productRepository;
    // Constructor
    ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public UUID createProduct(ProductRequestDTO createProductDTO){
        // DTO -> ENTITY
        if (createProductDTO == null) {
            throw new IllegalArgumentException("Product data is missing");
        }
        var entity = new Product(
                UUID.randomUUID(),
                createProductDTO.name(),
                createProductDTO.description(),
                createProductDTO.price(),
                null,            // created_by (defina o usuário conforme necessário)
                null,            // category (defina a categoria conforme necessário)
                Instant.now(),   // created_at
                Instant.now()    // updated_at
        );
        var savedEntity = productRepository.save(entity);
        return savedEntity.getId();
    }

    public List<Product> listProducts() {
        return (List<Product>) productRepository.findAll();
    }
}
