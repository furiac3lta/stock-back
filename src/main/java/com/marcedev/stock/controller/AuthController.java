package com.marcedev.stock.controller;

import com.marcedev.stock.dto.AuthRequestDto;
import com.marcedev.stock.dto.AuthResponseDto;
import com.marcedev.stock.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public AuthResponseDto login(@RequestBody AuthRequestDto dto) {
        return authService.login(dto);
    }
}
