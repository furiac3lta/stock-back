package com.marcedev.stock.controller;

import com.marcedev.stock.dto.StockMovementDto;
import com.marcedev.stock.dto.StockTransferRequest;
import com.marcedev.stock.service.StockMovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock/transfer")
@RequiredArgsConstructor
public class StockTransferController {

    private final StockMovementService movementService;

    /**
     * POST /stock/transfer
     * Body:
     * {
     *   "sourceBranchId": 1,
     *   "targetBranchId": 2,
     *   "productId": 5,
     *   "quantity": 10,
     *   "description": "Paso harina a sucursal 2",
     *   "user": "admin"
     * }
     */
    @PostMapping
    public StockMovementDto transfer(@RequestBody StockTransferRequest req) {
        return movementService.transfer(req);
    }
}
