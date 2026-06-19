package com.deliveryslotbookingapi.admin.user.mapper;

import com.deliveryslotbookingapi.admin.user.dto.AdminUserResponse;
import com.deliveryslotbookingapi.user.Status;
import com.deliveryslotbookingapi.user.User;

public class AdminUserMapper {
    public static AdminUserResponse toAdminUserResponse(User user){
        return AdminUserResponse.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .phone(user.getPhone())
                .email(user.getEmail())
                .role(user.getRole().name())
                .status(user.getStatus().name())
                .build();
    }

}
