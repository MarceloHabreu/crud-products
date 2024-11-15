package tech.project.crudProducts.domain.category;

import jakarta.validation.constraints.NotBlank;

public record CategoryRequestDTO(
        @NotBlank
        String name) {
}
