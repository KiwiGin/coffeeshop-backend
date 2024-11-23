/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bayes.coffeeshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import bayes.coffeeshop.model.Purchase;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author KiwiG
 */
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    @Query("SELECT p.name, SUM(o.quantity) AS cantidad_vendida "
            + "FROM Product p "
            + "JOIN Purchase c ON p.id = c.product.id "
            + "JOIN Order o ON c.order.id = o.id "
            + "GROUP BY p.id, p.name "
            + "ORDER BY cantidad_vendida DESC")
    List<Object[]> findMostPurchasedProducts();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO purchase (id_order, id_product, costo) "
            + "SELECT o.id_order AS id_order, "
            + "       p.id AS id_product, "
            + "       SUM(p.price * o.quantity) AS costo "
            + "FROM orders o "
            + "JOIN purchase pur ON pur.id_order = o.id_order "
            + "JOIN product p ON p.id = pur.id_product "
            + "WHERE NOT EXISTS ("
            + "    SELECT 1 "
            + "    FROM purchase c "
            + "    WHERE c.id_order = o.id_order AND c.id_product = p.id "
            + ") "
            + "GROUP BY o.id_order, p.id;",
            nativeQuery = true)
    void insertPurchasesFromOrder();

}
