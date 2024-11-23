/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bayes.coffeeshop.mapper;

import bayes.coffeeshop.dto.SaleDto;
import bayes.coffeeshop.model.Sale;

/**
 *
 * @author KiwiG
 */
public class SaleMapper {
    public static SaleDto mapToSaleDto(Sale sale){
        return new SaleDto(
                sale.getIdVenta(),
                sale.getMonto()
        );
    }
    
    public static Sale mapToSale(SaleDto saleDto){
        return new Sale(
                saleDto.getIdVenta(),
                saleDto.getMonto()
        );
    }
}
