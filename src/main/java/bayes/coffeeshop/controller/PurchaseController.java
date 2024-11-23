/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bayes.coffeeshop.controller;

import bayes.coffeeshop.model.ProductTrend;
import bayes.coffeeshop.service.PurchaseService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author KiwiG
 */
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {
    private PurchaseService purchaseService;
    
    @GetMapping
    public ResponseEntity<List<ProductTrend>> getProductoTrend() {
        List<ProductTrend> trends = purchaseService.getProductoTrend();
        return ResponseEntity.ok(trends);
    }
}
