/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bayes.coffeeshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author KiwiG
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseDto {
    private Long idPurchase;        // ID de la compra
    private Long idOrder;           // ID de la orden (FK)
    private Long idProduct;         // ID del producto (FK)
    private String productName;     // Nombre del producto (opcional, si lo necesitas)
    private double costo;           // Costo de la compra
    private String orderDate;       // Fecha de la orden (opcional, en formato String)
}
