package com.marcedev.stock.service.impl;

import com.marcedev.stock.dto.AuthRequestDto;
import com.marcedev.stock.dto.AuthResponseDto;
import com.marcedev.stock.entity.User;
import com.marcedev.stock.repository.UserRepository;
import com.marcedev.stock.security.JwtService;
import com.marcedev.stock.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    @Override
    public AuthResponseDto login(AuthRequestDto dto) {

        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getUsername(),
                        dto.getPassword()
                )
        );

        User user = userRepository.findByUsername(dto.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        String token = jwtService.generateToken(user);

        AuthResponseDto response = new AuthResponseDto();
        response.setToken(token);
        response.setUsername(user.getUsername());
        response.setRoles(user.getRoles().stream().map(r -> r.getName()).toList());

        return response;
    }
}
