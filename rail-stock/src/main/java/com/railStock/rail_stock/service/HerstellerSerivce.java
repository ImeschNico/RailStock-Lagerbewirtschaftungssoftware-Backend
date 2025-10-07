package com.railStock.rail_stock.service;


import com.railStock.rail_stock.entity.Hersteller;
import com.railStock.rail_stock.repository.HerstellerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HerstellerSerivce {

    private final HerstellerRepository herstellerRepository;

    public HerstellerSerivce(HerstellerRepository herstellerRepository) {
        this.herstellerRepository = herstellerRepository;
    }

    public Hersteller findHerstellerByName(String name) {
        return herstellerRepository.findByName(name);
    }
}
