package com.deliveryslotbookingapi.admin.slot.dto;

import com.deliveryslotbookingapi.slot.Status;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class AdminSlotRequest {
    @NotNull(message = "Ngay giao hang khong duoc de trong")
    @FutureOrPresent(message = "Ngay giao hang khong duoc la ngay trong qua khu")
    private LocalDate deliveryDate;

    @NotNull(message = "Gio bat dau khong duoc de trong")
    private LocalTime startTime;

    @NotNull(message = "Gio ket thuc khong duoc de trong")
    private LocalTime endTime;

    @NotNull(message = "Suc chua khong duoc de trong")
    @Min(value = 1,message = "Suc chua phai lon hon 0")
    private Long capacity;

    @NotNull(message = "Status khong duoc de trong")
    private Status status;
}
