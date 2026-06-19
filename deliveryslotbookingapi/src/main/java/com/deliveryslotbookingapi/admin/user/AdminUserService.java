package com.deliveryslotbookingapi.admin.user;

import com.deliveryslotbookingapi.admin.user.dto.AdminUserResponse;
import com.deliveryslotbookingapi.admin.user.mapper.AdminUserMapper;
import com.deliveryslotbookingapi.user.Status;
import com.deliveryslotbookingapi.user.User;
import com.deliveryslotbookingapi.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminUserService {

    private final UserRepository userRepository;

    // xem chi tiết user
    public AdminUserResponse getUser(Long id){
        if (id==null){ // khong can bat loi id khong phai so
            throw new RuntimeException("Id khong hop le");
        }

        User user = userRepository.findById(id).orElseThrow(
                ()->new RuntimeException("Khong tim thay user co id = "+id)
        );

        return AdminUserMapper.toAdminUserResponse(user);
    }
    //xem danh sách user
    public List<AdminUserResponse> getUsers(){
        List<User> users = userRepository.findAll();

        List<AdminUserResponse> adminUserResponses = users.stream()
                .map(user -> AdminUserMapper.toAdminUserResponse(user))
                .toList();

        return adminUserResponses;
    }
    // Khóa user user
    public AdminUserResponse changeUserStatus(Long id,
                                              Status status){
        User user = userRepository.findById(id)
                .orElseThrow(
                        ()-> new RuntimeException("Khong tim thay user co id = "+id)
                );
        String newStatus = status.toString().toUpperCase();
        user.setStatus(Status.valueOf(newStatus));

        userRepository.save(user);

        return AdminUserMapper.toAdminUserResponse(user);
    }

    // xóa user
    public void deleteUser(Long id){
        userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Khong tim thay user co id ="+id));

        userRepository.deleteById(id);
    }

}
