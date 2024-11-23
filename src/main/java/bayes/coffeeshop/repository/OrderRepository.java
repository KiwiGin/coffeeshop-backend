/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bayes.coffeeshop.repository;

import bayes.coffeeshop.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author KiwiG
 */
public interface OrderRepository extends JpaRepository<Order, Long>{
    
}
