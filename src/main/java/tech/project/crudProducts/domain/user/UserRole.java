package tech.project.crudProducts.domain.user;

public enum UserRole {

    ADMIN("admin"),

    USER("user");

    private String role;

    // constructor
    UserRole(String role) {
        this.role = role;
    }

    // method get
    public String getRole() {
        return role;
    }
}
