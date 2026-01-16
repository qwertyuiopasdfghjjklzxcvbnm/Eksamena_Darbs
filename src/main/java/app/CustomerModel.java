package app;

import java.util.UUID;

import enums.UserRole;

public class CustomerModel extends UserModel {
    public String shippingAddress;

    public CustomerModel(String username, String email, String address) {
        super(username, email, UserRole.CUSTOMER, UUID.randomUUID());
        this.shippingAddress = address;
    }
}