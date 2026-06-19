package com.deliveryslotbookingapi.admin.user.dto;

import com.deliveryslotbookingapi.user.Status;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AdminUserUpdateRequest {
    @NotBlank
    private Status status;
}
