/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bayes.coffeeshop.service;

import bayes.coffeeshop.dto.ProductDto;
import java.util.List;

/**
 *
 * @author KiwiG
 */
public interface ProductService {
    ProductDto createProduct(ProductDto productDto);
    ProductDto getProductById(Long productId);
    List<ProductDto> getAllProducts();
    ProductDto updateProductById(Long productId, ProductDto updatedProduct);
    
    void deleteProduct(Long productId);
}
