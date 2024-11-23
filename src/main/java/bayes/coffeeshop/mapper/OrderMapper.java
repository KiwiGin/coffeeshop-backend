/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bayes.coffeeshop.mapper;

import bayes.coffeeshop.dto.OrderDto;
import bayes.coffeeshop.model.Order;

/**
 *
 * @author KiwiG
 */
public class OrderMapper {
    public static OrderDto mapToOrderDto(Order order) {
        return new OrderDto(
                order.getIdOrder(),
                order.getQuantity(),
                order.getDate()
        );
    }

    public static Order mapToOrder(OrderDto orderDto) {
        return new Order(
                orderDto.getIdOrder(),
                orderDto.getQuantity(),
                orderDto.getDate()
        );
    }
}
