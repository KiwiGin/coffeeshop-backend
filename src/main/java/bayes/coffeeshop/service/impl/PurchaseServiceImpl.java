/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bayes.coffeeshop.service.impl;

import bayes.coffeeshop.dto.PurchaseDto;
import bayes.coffeeshop.exception.ResourceNotFoundException;
import bayes.coffeeshop.mapper.PurchaseMapper;
import bayes.coffeeshop.model.ProductTrend;
import bayes.coffeeshop.repository.PurchaseRepository;
import bayes.coffeeshop.service.PurchaseService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import bayes.coffeeshop.model.Purchase;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 *
 * @author KiwiG
 */
@Service
@AllArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {

    private PurchaseRepository purchaseRepository;

    @Override
    public PurchaseDto registerPurchase(PurchaseDto purchaseDto) {
        Purchase purchase = PurchaseMapper.mapToPurchase(purchaseDto);
        Purchase purchaseSaved = purchaseRepository.save(purchase);
        return PurchaseMapper.mapToPurchaseDto(purchaseSaved);
    }

    @Override
    public PurchaseDto getPurchaseById(Long purchaseId) {
        Purchase purchase = purchaseRepository.findById(purchaseId)
                .orElseThrow(() -> new ResourceNotFoundException("No hay"));
        return PurchaseMapper.mapToPurchaseDto(purchase);
    }

    @Override
    public List<PurchaseDto> getPurchaseAll() {
        List<Purchase> purchaseList = purchaseRepository.findAll();
        return purchaseList.stream().map((purchase) -> PurchaseMapper.mapToPurchaseDto(purchase)).collect(Collectors.toList());
    }

    @Override
    public List<ProductTrend> getProductoTrend() {
        List<Object[]> result = purchaseRepository.findMostPurchasedProducts();

        // Si no hay productos vendidos, retornamos una lista vacía o un mensaje especial
        if (result.isEmpty()) {
            return List.of(new ProductTrend("No hay productos comprados", 0L));
        }

        List<ProductTrend> trends = new ArrayList<>();

        // Recorrer los resultados y mapearlos a una lista de ProductTrend
        for (Object[] mayorComprado : result) {
            String productName = (String) mayorComprado[0];
            Long cantidadVendida = (Long) mayorComprado[1];
            trends.add(new ProductTrend(productName, cantidadVendida));
        }

        return trends;
    }

}
