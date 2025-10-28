package com.railStock.rail_stock.service;


import com.railStock.rail_stock.entity.Hersteller;
import com.railStock.rail_stock.repository.HerstellerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service-Klasse für Operationen auf {@link Hersteller}-Entities.
 * <p>
 * Bietet Methoden zum Abrufen von Herstellern aus der Datenbank.
 * </p>
 *
 * Autor: Nico Imesch
 * Version: 1.0
 */
@Service
public class HerstellerSerivce {

    private final HerstellerRepository herstellerRepository;

    /**
     * Konstruktor für die Dependency Injection.
     *
     * @param herstellerRepository Repository für Hersteller
     */
    public HerstellerSerivce(HerstellerRepository herstellerRepository) {
        this.herstellerRepository = herstellerRepository;
    }

    /**
     * Findet einen Hersteller anhand des Namens.
     *
     * @param name Name des Herstellers
     * @return Gefundener Hersteller oder null, falls nicht vorhanden
     */
    public Hersteller findHerstellerByName(String name) {
        return herstellerRepository.findByName(name);
    }
}
