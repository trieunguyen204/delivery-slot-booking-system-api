package com.deliveryslotbookingapi.auth.service;

import com.deliveryslotbookingapi.config.JwtService;
import com.deliveryslotbookingapi.user.User;
import com.deliveryslotbookingapi.user.UserRepository;
import com.deliveryslotbookingapi.auth.dto.LoginRequest;
import com.deliveryslotbookingapi.auth.dto.LoginResponse;
import com.deliveryslotbookingapi.auth.dto.RegisterRequest;
import com.deliveryslotbookingapi.auth.dto.RegisterResponse;
import com.deliveryslotbookingapi.auth.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public RegisterResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email đã tồn tại");
        }

        if (userRepository.existsByPhone(request.getPhone())) {
            throw new RuntimeException("Số điện thoại đã tồn tại");
        }

        User user = UserMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        User savedUser = userRepository.save(user);

        return UserMapper.toRegisterResponse(savedUser);
    }

    public LoginResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Email hoặc mật khẩu không đúng"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Email hoặc mật khẩu không đúng");
        }

        String token = jwtService.generateToken(user);

        return UserMapper.toLoginResponse(user, token);
    }
}