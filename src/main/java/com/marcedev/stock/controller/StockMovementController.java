package com.marcedev.stock.controller;

import com.marcedev.stock.dto.StockMovementDto;
import com.marcedev.stock.dto.StockTransferRequest;
import com.marcedev.stock.service.StockMovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
@RequiredArgsConstructor
public class StockMovementController {

    private final StockMovementService service;

    @GetMapping("/all")
    public List<StockMovementDto> all() {
        return service.findAll();
    }

    @GetMapping("/{productId}/history")
    public List<StockMovementDto> history(@PathVariable Long productId) {
        return service.history(productId);
    }

    @PostMapping("/{productId}/move")
    public StockMovementDto move(
            @PathVariable Long productId,
            @RequestParam Integer quantity,
            @RequestParam String type,
            @RequestParam(required = false) String description,
            @RequestParam String user
    ) {
        return service.move(productId, quantity, type, description, user);
    }
}
