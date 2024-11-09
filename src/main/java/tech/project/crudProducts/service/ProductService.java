package tech.project.crudProducts.service;

import org.springframework.stereotype.Service;
import tech.project.crudProducts.domain.product.Product;
import tech.project.crudProducts.domain.product.ProductRequestDTO;
import tech.project.crudProducts.repository.ProductRepository;

import java.time.Instant;
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
        var entity = new Product(
                UUID.randomUUID(),
                createProductDTO.name(),
                createProductDTO.description(),
                createProductDTO.price(),
                Instant.now(),
                null
        );
        var savedEntity = productRepository.save(entity);
        return savedEntity.getId();
    }
}
