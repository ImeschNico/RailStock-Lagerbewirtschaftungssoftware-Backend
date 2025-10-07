package com.railStock.rail_stock.repository;

import com.railStock.rail_stock.entity.Lagerplatz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface LagerplatzRepository extends JpaRepository<Lagerplatz, Long> {

    List<Lagerplatz> findByRegalIgnoreCase(String regal);

    @Query("SELECT l FROM Lagerplatz l WHERE TRIM(LOWER(l.tablar)) = LOWER(:tablar)")
    List<Lagerplatz> findByTablarIgnoreCaseTrim(@Param("tablar") String tablar);

    Optional<Lagerplatz> findByRegalAndTablarIgnoreCase(String regal, String tablar);

    // NEU: flexible Filter-Methode
    @Query("SELECT l FROM Lagerplatz l " +
            "WHERE (:regal IS NULL OR LOWER(l.regal) = LOWER(:regal)) " +
            "AND (:tablar IS NULL OR LOWER(l.tablar) = LOWER(:tablar))")
    List<Lagerplatz> findByFilter(@Param("regal") String regal, @Param("tablar") String tablar);
}