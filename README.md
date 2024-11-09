# CRUD de Produtos com Autenticação

## Descrição

Este é um projeto de API RESTful desenvolvido com Spring Boot para a criação, leitura, atualização e exclusão (CRUD) de produtos. A aplicação implementa autenticação de usuários e diferentes permissões para `admin` e `user`:
- Usuários podem ver produtos, listar todos e buscar por categoria.
- Administradores podem adicionar, atualizar e remover produtos.

## Tecnologias

- **Java 17** 
- **Spring Boot**
- **Spring Security** (para autenticação e controle de permissões)
- **Spring Data JPA** (para interações com o banco de dados)
- **MySQL** ( banco de dados relacional)
- **Maven** para gerenciamento de dependências

## Diagrama de Relacionamento

```mermaid
erDiagram
    USERS {
        UUID id PK
        VARCHAR username
        VARCHAR email "unique"
        VARCHAR password
        VARCHAR role
        TIMESTAMP created_at
    }
    
    CATEGORIES {
        UUID id PK
        VARCHAR name "unique"
    }
    
    PRODUCTS {
        UUID id PK
        VARCHAR title
        TEXT description
        DOUBLE price
        TIMESTAMP created_at
        TIMESTAMP updated_at
        UUID created_by FK
        UUID category_id FK
    }

    USERS ||--o{ PRODUCTS : "criou"
    CATEGORIES ||--o{ PRODUCTS : "contém"
