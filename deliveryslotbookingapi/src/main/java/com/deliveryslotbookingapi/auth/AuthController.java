package com.deliveryslotbookingapi.auth;

import com.deliveryslotbookingapi.auth.dto.LoginRequest;
import com.deliveryslotbookingapi.auth.dto.LoginResponse;
import com.deliveryslotbookingapi.auth.dto.RegisterRequest;
import com.deliveryslotbookingapi.auth.dto.RegisterResponse;
import com.deliveryslotbookingapi.auth.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService userService;

    @PostMapping("/register")
    public RegisterResponse register(@Valid @RequestBody RegisterRequest request) {
        return userService.register(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest request) {
        return userService.login(request);
    }
}