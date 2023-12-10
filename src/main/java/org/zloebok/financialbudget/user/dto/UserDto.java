package org.zloebok.financialbudget.user.dto;

import lombok.Data;
import org.zloebok.financialbudget.user.entity.Role;

import java.util.UUID;

@Data
public class UserDto{
    UUID id;
    String username;
    String password;
    String email;
    Role role;
}