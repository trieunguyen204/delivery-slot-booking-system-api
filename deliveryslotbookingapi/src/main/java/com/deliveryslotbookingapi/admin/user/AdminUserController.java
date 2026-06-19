package com.deliveryslotbookingapi.admin.user;

import com.deliveryslotbookingapi.admin.user.dto.AdminUserResponse;
import com.deliveryslotbookingapi.admin.user.dto.AdminUserUpdateRequest;
import com.deliveryslotbookingapi.user.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/user")
@RequiredArgsConstructor
public class AdminUserController {
    private final AdminUserService adminUserService;

    // xem chi tiet user
    @GetMapping("/{id}")
    public AdminUserResponse getUser(@PathVariable Long id){
        return adminUserService.getUser(id);
    }

    // xem danh sach user
    @GetMapping
    public List<AdminUserResponse> getUsers(){
        return adminUserService.getUsers();
    }

    // update
    @PostMapping("/{id}")
    public AdminUserResponse updateUser(@PathVariable Long id,
                                        @RequestBody AdminUserUpdateRequest request){
        return adminUserService.changeUserStatus(id,request.getStatus());
    }

    //delete
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        adminUserService.deleteUser(id);
    }
}
