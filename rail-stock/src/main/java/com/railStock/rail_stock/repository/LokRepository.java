package com.railStock.rail_stock.repository;

import com.railStock.rail_stock.entity.Lok;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface LokRepository extends JpaRepository<Lok, Long> {

    Optional<Lok> findByArtNumber(String artNumber);
    List<Lok> findByBezeichnung(String bezeichnung);
    List<Lok> findByTyp(String typ);
    List<Lok> findByModell(String modell);
    List<Lok> findByStromart(String stromart);
    List<Lok> findBySpur(String spur);
    List<Lok> findByEpoche(String epoche);
    List<Lok> findByBetriebsart(String betriebsart);
    List<Lok> findByHersteller_Id(Long herstellerId);
}
