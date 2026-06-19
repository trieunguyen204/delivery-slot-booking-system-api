package com.deliveryslotbookingapi.auth.mapper;

import com.deliveryslotbookingapi.user.Role;
import com.deliveryslotbookingapi.user.Status;
import com.deliveryslotbookingapi.user.User;
import com.deliveryslotbookingapi.auth.dto.LoginResponse;
import com.deliveryslotbookingapi.auth.dto.RegisterRequest;
import com.deliveryslotbookingapi.auth.dto.RegisterResponse;

public class UserMapper {

    public static User toUser(RegisterRequest request) {
        User user = new User();

        user.setFullName(request.getFullName());
        user.setPhone(request.getPhone());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(Role.USER);
        user.setStatus(Status.ACTIVE);

        return user;
    }

    public static RegisterResponse toRegisterResponse(User user) {
        return RegisterResponse.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .phone(user.getPhone())
                .email(user.getEmail())
                .role(user.getRole().name())
                .status(user.getStatus().name())
                .build();
    }

    public static LoginResponse toLoginResponse(User user, String token) {
        return LoginResponse.builder()
                .token(token)
                .id(user.getId())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .role(user.getRole().name())
                .status(user.getStatus().name())
                .build();
    }
}