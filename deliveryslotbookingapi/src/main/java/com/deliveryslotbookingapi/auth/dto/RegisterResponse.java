package com.deliveryslotbookingapi.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterResponse {
    private Long id;
    private String fullName;
    private String phone;
    private String email;
    private String role;
    private String status;
}