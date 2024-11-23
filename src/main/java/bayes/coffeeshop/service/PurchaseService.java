/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bayes.coffeeshop.service;

import bayes.coffeeshop.dto.PurchaseDto;
import bayes.coffeeshop.model.ProductTrend;
import java.util.List;

/**
 *
 * @author KiwiG
 */
public interface PurchaseService {
    PurchaseDto registerPurchase(PurchaseDto purchaseDto);
    PurchaseDto getPurchaseById(Long purchaseId);
    List<PurchaseDto> getPurchaseAll();
    List<ProductTrend> getProductoTrend();
}
