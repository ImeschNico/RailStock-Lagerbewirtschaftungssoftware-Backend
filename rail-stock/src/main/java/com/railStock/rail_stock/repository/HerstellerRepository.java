package com.railStock.rail_stock.repository;


import com.railStock.rail_stock.entity.Hersteller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HerstellerRepository extends JpaRepository<Hersteller, Long> {

    Hersteller findByName(String name);
}
