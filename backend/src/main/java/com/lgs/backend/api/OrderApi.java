package com.lgs.backend.api;

import com.lgs.backend.model.Order;
import com.lgs.backend.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/orders", produces = "application/json;charset=utf-8")
public class OrderApi {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderApi.class);

    private OrderService orderService;
    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping
    public List<Order> getOrderAll() {
        LOGGER.info("查询全部信息");
        return orderService.getOrderAll();
    }
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Integer id) {
        return orderService.getOrderById(id);
    }
    @PostMapping
    public ResponseEntity<Map<String, Object>> addOrder(@RequestBody Order order) {
        boolean success = orderService.addOrder(order);
        return ResponseEntity.ok(Map.of("success", success));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteOrder(@PathVariable Integer id) {
        boolean success = orderService.deleteOrder(id);
        return ResponseEntity.ok(Map.of("success", success));
    }
    @PutMapping
    public ResponseEntity<Map<String, Object>> updateOrder(@RequestBody Order order) {
        boolean success = orderService.updateOrder(order);
        return ResponseEntity.ok(Map.of("success", success));
    }
}
