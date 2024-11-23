/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bayes.coffeeshop.model;

/**
 *
 * @author KiwiG
 */
public class ProductTrend {
    private String name;
    private Long cantidadVendida;

    public ProductTrend(String name, Long cantidadVendida) {
        this.name = name;
        this.cantidadVendida = cantidadVendida;
    }

    // Getters y setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(Long cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }
}
