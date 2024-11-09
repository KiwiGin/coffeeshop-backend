/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bayes.coffeeshop.mapper;

import bayes.coffeeshop.dto.ProductDto;
import bayes.coffeeshop.model.Product;

/**
 *
 * @author KiwiG
 */
public class ProductMapper {
    public static ProductDto mapToProductDto(Product product){
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getCategory(),
                product.getImgUrl()
        );
    }
    
    public static Product mapToProduct(ProductDto productDto){
        return new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getPrice(),
                productDto.getCategory(),
                productDto.getImgUrl()
        );
    }
    
}
