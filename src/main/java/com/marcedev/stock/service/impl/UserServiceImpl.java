package com.marcedev.stock.service.impl;

import com.marcedev.stock.entity.Role;
import com.marcedev.stock.entity.User;
import com.marcedev.stock.repository.RoleRepository;
import com.marcedev.stock.repository.UserRepository;
import com.marcedev.stock.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;

    @Override
    public User register(User user) {

        if (userRepository.existsByUsername(user.getUsername()))
            throw new RuntimeException("El usuario ya existe");

        Role role = roleRepository.findByName("USER")
                .orElseThrow(() -> new RuntimeException("Role USER no encontrado"));

        user.setPassword(encoder.encode(user.getPassword()));
        user.setRoles(Set.of(role));

        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

}
