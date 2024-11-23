/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bayes.coffeeshop.controller;

import bayes.coffeeshop.service.SaleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author KiwiG
 */
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/sale")
public class SaleController {
    
    private SaleService saleService;
   
    @GetMapping
    public ResponseEntity<Double> obtenerVentaDiaria(){
        double ventadiaria = saleService.obtenerVentaDiaria();
        return ResponseEntity.ok(ventadiaria);
    }
    
    @PostMapping
    public ResponseEntity<?> registerSale(){
        saleService.registerSale();
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
