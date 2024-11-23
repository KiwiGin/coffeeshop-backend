/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bayes.coffeeshop.controller;

import bayes.coffeeshop.dto.OrderDto;
import bayes.coffeeshop.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author KiwiG
 */
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/orden")
public class OrderController {
    private OrderService orderService;
    
     @PostMapping
    public ResponseEntity<OrderDto> createProduct(@RequestBody OrderDto orderDto){
        OrderDto saveOrder = orderService.registerOrder(orderDto);
        return new ResponseEntity<>(saveOrder, HttpStatus.CREATED);
    }
}
