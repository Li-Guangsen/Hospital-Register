package com.lgs.backend.controller;

import com.lgs.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/client/order")
public class OrderController {
    private OrderService orderService;
    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping("/close/{id}")
    public ResponseEntity<Map<String, Object>> closeOrder(@PathVariable Integer id) {
        boolean success = orderService.closeOrder(id);
        return ResponseEntity.ok(Map.of("success", success));
    }
}
