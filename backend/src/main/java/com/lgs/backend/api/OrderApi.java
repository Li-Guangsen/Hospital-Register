package com.lgs.backend.api;

import com.github.pagehelper.PageInfo;
import com.lgs.backend.model.Order;
import com.lgs.backend.model.OrderSearchBean;
import com.lgs.backend.model.OrderSearchCount;
import com.lgs.backend.service.OrderService;
import com.lgs.backend.utils.PaginateInfo;
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
    public Map<String,Object> getOrderAll(@RequestParam(defaultValue = "1") Integer pageNo,
                                          @RequestParam(defaultValue = "1000") Integer pageSize,
                                          OrderSearchBean order) {
        LOGGER.info("查询全部预约信息");
        PaginateInfo paginateInfo = new PaginateInfo(pageNo,pageSize);
        List<Order> orders = orderService.getOrderAll(paginateInfo,order);
        PageInfo<Order> pageInfo = new PageInfo<>(orders);
        Map<String,Object> map = Map.of("pageNo",pageInfo.getPageNum(),"pageSize",pageInfo.getPageSize(),"total",pageInfo.getTotal());
        return Map.of("success",true,"rows", orders,"pi",map);
    }
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Integer id) {
        return orderService.getOrderById(id);
    }
    @GetMapping("/count")
    public int getOrderCount() {
        return orderService.getOrderCount();
    }
    @GetMapping("/doctorCount")
    public  Map<String,Object> getDoctorOrderCount() {
        List<OrderSearchCount> orderSearchCounts = orderService.getDoctorOrderCount();
        return Map.of("success",true,"data",orderSearchCounts);
    }
    @GetMapping("/subjectCount")
    public  Map<String,Object> getSubjectOrderCount() {
        List<OrderSearchCount> orderSearchCounts = orderService.getSubjectOrderCount();
        return Map.of("success",true,"data",orderSearchCounts);
    }
    @GetMapping("/workDateCount")
    public  Map<String,Object> getWorkDateOrderCount() {
        List<Integer> workDateOrderCounts = orderService.getWorkDateOrderCount();
        return Map.of("success",true,"data",workDateOrderCounts);
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
    @PutMapping("/status")
    public ResponseEntity<Map<String, Object>> updateOrderStatus(@RequestBody Order order) {
        boolean success = orderService.updateStatus(order);
        return ResponseEntity.ok(Map.of("success", success));
    }
}
