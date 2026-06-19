package com.deliveryslotbookingapi.admin.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminUserResponse {
    private Long id;
    private String fullName;
    private String phone;
    private String email;
    private String role;
    private String status;
}
