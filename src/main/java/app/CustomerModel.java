package app;

import java.util.UUID;

import enums.UserRole;

public class CustomerModel extends UserModel {
    public String shippingAddress;

    public CustomerModel(String username, String email, String address) {
        // Generates a random ID and sets role to CUSTOMER
        super(username, email, UserRole.CUSTOMER, UUID.randomUUID());
        this.shippingAddress = address;
    }
}