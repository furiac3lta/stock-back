package com.marcedev.stock.service;

import com.marcedev.stock.dto.AuthRequestDto;
import com.marcedev.stock.dto.AuthResponseDto;

public interface AuthService {

    AuthResponseDto login(AuthRequestDto dto);
}
