/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bayes.coffeeshop.service;

import bayes.coffeeshop.dto.OrderDto;
import java.util.List;
import bayes.coffeeshop.model.Order;

/**
 *
 * @author KiwiG
 */
public interface OrderService {
    OrderDto registerOrder(OrderDto orderDto);
    OrderDto getOrderById(Long orderId);
    List<OrderDto> getOrderAll();
}
