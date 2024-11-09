/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bayes.coffeeshop.service.impl;

import bayes.coffeeshop.dto.ProductDto;
import bayes.coffeeshop.exception.ResourceNotFoundException;
import bayes.coffeeshop.mapper.ProductMapper;
import bayes.coffeeshop.model.Product;
import bayes.coffeeshop.repository.ProductRepository;
import bayes.coffeeshop.service.ProductService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author KiwiG
 */
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Product product =  ProductMapper.mapToProduct(productDto);
        Product savedProduct = productRepository.save(product);
        return ProductMapper.mapToProductDto(savedProduct);
    }

    @Override
    public ProductDto getProductById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(()->new ResourceNotFoundException("No existe producto con ese id: "+productId));
        return ProductMapper.mapToProductDto(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map((product)-> ProductMapper.mapToProductDto(product))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProductById(Long productId, ProductDto updatedProduct) {
        Product product = productRepository.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Producto no existe con este id: "+productId));
        product.setName(updatedProduct.getName());
        product.setPrice(updatedProduct.getPrice());
        product.setCategory(updatedProduct.getCategory());
        product.setImgUrl(updatedProduct.getImgUrl());
        
        Product updatedProductObj=productRepository.save(product);
        return ProductMapper.mapToProductDto(updatedProductObj);
    }

    @Override
    public void deleteProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(()->new ResourceNotFoundException("No existe producto con ese id: "+productId));
        productRepository.deleteById(productId);
    }
    
}
