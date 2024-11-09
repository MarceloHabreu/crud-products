package tech.project.crudProducts.domain.product;

import java.util.UUID;

public record ProductResponseDTO(UUID id, String name, String description, double price) {
    public ProductResponseDTO(Product product){
        this(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }
}
