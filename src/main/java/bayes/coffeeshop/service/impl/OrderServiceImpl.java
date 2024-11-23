/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bayes.coffeeshop.service.impl;

import bayes.coffeeshop.dto.OrderDto;
import bayes.coffeeshop.exception.ResourceNotFoundException;
import bayes.coffeeshop.mapper.OrderMapper;
import bayes.coffeeshop.repository.OrderRepository;
import bayes.coffeeshop.service.OrderService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import bayes.coffeeshop.model.Order;
import bayes.coffeeshop.repository.PurchaseRepository;
import java.util.stream.Collectors;

/**
 *
 * @author KiwiG
 */
@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService{
    private OrderRepository orderRepository;
    private PurchaseRepository purchaseReposi;

    @Override
    public OrderDto registerOrder(OrderDto orderDto) {
        Order order = OrderMapper.mapToOrder(orderDto);
        Order orderSaved = orderRepository.save(order);
        purchaseReposi.insertPurchasesFromOrder();
        return OrderMapper.mapToOrderDto(orderSaved);
    }

    @Override
    public OrderDto getOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(()->new ResourceNotFoundException("No existe orden con ese id: "+orderId));
        return OrderMapper.mapToOrderDto(order);
    }

    @Override
    public List<OrderDto> getOrderAll() {
        List<Order> listaOrden = orderRepository.findAll();
        return listaOrden.stream().map((order)->OrderMapper.mapToOrderDto(order)).collect(Collectors.toList());
    }
    
}
