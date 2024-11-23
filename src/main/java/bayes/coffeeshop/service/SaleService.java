/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bayes.coffeeshop.service;

import bayes.coffeeshop.dto.SaleDto;
import java.util.List;

/**
 *
 * @author KiwiG
 */
public interface SaleService {
    void registerSale();
    SaleDto getSaleById(Long saleId);
    List<SaleDto> getSaleAll();
    double obtenerVentaDiaria();
}
