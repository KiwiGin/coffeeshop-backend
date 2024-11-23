/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bayes.coffeeshop.service.impl;

import bayes.coffeeshop.dto.SaleDto;
import bayes.coffeeshop.exception.ResourceNotFoundException;
import bayes.coffeeshop.mapper.SaleMapper;
import bayes.coffeeshop.repository.SaleRepository;
import bayes.coffeeshop.service.SaleService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import bayes.coffeeshop.model.Sale;
import java.util.stream.Collectors;
/**
 *
 * @author KiwiG
 */
@Service
@AllArgsConstructor
public class SaleServiceImpl implements SaleService{
    private SaleRepository saleRepository;

    @Override
    public void registerSale() {
        saleRepository.insertarVentaDiaria();
        
    }

    @Override
    public SaleDto getSaleById(Long saleId) {
        Sale sale = saleRepository.findById(saleId)
                .orElseThrow(()->new ResourceNotFoundException("No se ha encontrado venta con ese id"));
        return SaleMapper.mapToSaleDto(sale);
    }

    @Override
    public List<SaleDto> getSaleAll() {
        List<Sale> listSales= saleRepository.findAll();
        return listSales.stream().map((sale)->SaleMapper.mapToSaleDto(sale)).collect(Collectors.toList());
    }

    @Override
    public double obtenerVentaDiaria() {
        List<Object[]> result = saleRepository.obtenerVentaDiaria();
        if(result.isEmpty()){
            return 0;
        }
        Object[] mayorComprado = result.get(0);
        double ventadiaria = (Double) mayorComprado[0];
        
        return ventadiaria;
    }
    
}
