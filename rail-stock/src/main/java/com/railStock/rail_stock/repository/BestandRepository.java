package com.railStock.rail_stock.repository;

import com.railStock.rail_stock.entity.Bestand;
import com.railStock.rail_stock.entity.Lagerplatz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface BestandRepository extends JpaRepository<Bestand, Long> {

    List<Bestand> findByLok_ArtNumber(String artNumber);


    List<Bestand> findByLagerplatz_RegalAndLagerplatz_Tablar(String regal, String tablar);

    @Query("SELECT b FROM Bestand b WHERE TRIM(LOWER(b.lok.artNumber)) = :artNumber " +
            "AND LOWER(b.lagerplatz.regal) = LOWER(:regal) " +
            "AND LOWER(b.lagerplatz.tablar) = LOWER(:tablar)")
    Optional<Bestand> findByLokAndLagerplatz(@Param("artNumber") String artNumber,
                                             @Param("regal") String regal,
                                             @Param("tablar") String tablar);

}
