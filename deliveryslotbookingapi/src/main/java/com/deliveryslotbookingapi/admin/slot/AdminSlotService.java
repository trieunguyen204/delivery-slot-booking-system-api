package com.deliveryslotbookingapi.admin.slot;

import com.deliveryslotbookingapi.admin.slot.dto.AdminSlotResponse;
import com.deliveryslotbookingapi.admin.slot.mapper.AdminSlotMapper;
import com.deliveryslotbookingapi.slot.Slot;
import com.deliveryslotbookingapi.slot.SlotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminSlotService {
    private final SlotRepository slotRepository;

    // xem chi tiet slot
    public AdminSlotResponse getSlot(Long id){
        Slot slot = slotRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Khong tim thay slot co id = "+id));

        return AdminSlotMapper.toAdminSlotResponse(slot);
    }

    // xem ds slot
    public List<AdminSlotResponse> getSlots(){
        List<Slot> slots =
    }
}
