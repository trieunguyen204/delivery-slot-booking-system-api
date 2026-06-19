package com.deliveryslotbookingapi.admin.slot.dto;

import com.deliveryslotbookingapi.slot.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminSlotResponse {
    private Long id;
    private LocalDate deliveryDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private Long capacity;
    private Long bookedCount;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
