package com.deliveryslotbookingapi.admin.slot.mapper;

import com.deliveryslotbookingapi.admin.slot.dto.AdminSlotRequest;
import com.deliveryslotbookingapi.admin.slot.dto.AdminSlotResponse;
import com.deliveryslotbookingapi.slot.Slot;


public class AdminSlotMapper {
    public static Slot toEntity(AdminSlotRequest req){
        Slot slot = new Slot();

        slot.setDeliveryDate(req.getDeliveryDate());
        slot.setStartTime(req.getStartTime());
        slot.setEndTime(req.getEndTime());
        slot.setCapacity(req.getCapacity());
        slot.setStatus(req.getStatus());

        return slot;
    }

    public static AdminSlotResponse toAdminSlotResponse(Slot slot){
        return AdminSlotResponse.builder()
                .id(slot.getId())
                .deliveryDate(slot.getDeliveryDate())
                .startTime(slot.getStartTime())
                .endTime(slot.getEndTime())
                .capacity(slot.getCapacity())
                .bookedCount(slot.getBookedCount())
                .status(slot.getStatus())
                .createdAt(slot.getCreatedAt())
                .updatedAt(slot.getUpdatedAt())
                .build();
    }
}
