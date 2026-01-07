package app;

import java.time.LocalDate;
import java.util.UUID;

import enums.UserRole;

public class EmployeeModel extends UserModel {
    public LocalDate hiredDate;

    public EmployeeModel(String username, String email) {
        super(username, email, UserRole.MANAGER, UUID.randomUUID());
        this.hiredDate = LocalDate.now();
    }
}