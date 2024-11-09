package tech.project.crudProducts.domain.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record ProductRequestDTO(
        @NotBlank
        String name,

        @NotBlank
        String description,

        @Positive
        double price
) {
}
