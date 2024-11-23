/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bayes.coffeeshop.mapper;

import bayes.coffeeshop.dto.PurchaseDto;
import bayes.coffeeshop.model.Purchase;

/**
 *
 * @author KiwiG
 */
public class PurchaseMapper {
    public static PurchaseDto mapToPurchaseDto(Purchase purchase) {
        return new PurchaseDto(
                purchase.getIdPurchase(),
                purchase.getOrder().getIdOrder(), // ID de la orden
                purchase.getProduct().getId(),    // ID del producto
                purchase.getProduct().getName(),  // Nombre del producto
                purchase.getCosto(),
                purchase.getOrder().getDate().toString() // Fecha de la orden en formato String
        );
    }

    public static Purchase mapToPurchase(PurchaseDto purchaseDto) {
        Purchase purchase = new Purchase();
        purchase.setIdPurchase(purchaseDto.getIdPurchase());
        purchase.setCosto(purchaseDto.getCosto());

        return purchase;
    }
}
