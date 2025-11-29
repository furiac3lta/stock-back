package com.marcedev.stock.controller;

import com.marcedev.stock.dto.StockMovementDto;
import com.marcedev.stock.service.StockMovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/branches/history")
@RequiredArgsConstructor
public class BranchHistoryController {

    private final StockMovementService service;

    /**
     * Devuelve el historial de movimientos de TODA la sucursal.
     *
     * Ejemplo:
     * GET /branches/history/2
     */
    @GetMapping("/{branchId}")
    public List<StockMovementDto> historyByBranch(@PathVariable Long branchId) {
        return service.historyByBranch(branchId);
    }
}
