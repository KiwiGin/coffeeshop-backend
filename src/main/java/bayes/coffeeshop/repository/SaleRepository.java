/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bayes.coffeeshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import bayes.coffeeshop.model.Sale;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author KiwiG
 */
public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Modifying
@Transactional
@Query(value = "INSERT INTO sale (monto) " +
               "SELECT SUM(p.costo) AS monto " +
               "FROM purchase p", 
       nativeQuery = true)
void insertarVentaDiaria();


    @Query("SELECT s.monto FROM Sale s ORDER BY s.monto DESC")
List<Object[]> obtenerVentaDiaria();
}
