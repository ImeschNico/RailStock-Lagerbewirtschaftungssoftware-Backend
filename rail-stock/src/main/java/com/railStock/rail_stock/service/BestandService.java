package com.railStock.rail_stock.service;


import com.railStock.rail_stock.dto.BestandDTO;
import com.railStock.rail_stock.dto.BestandFormDTO;
import com.railStock.rail_stock.dto.GesamtBestandDTO;
import com.railStock.rail_stock.entity.Bestand;
import com.railStock.rail_stock.entity.Lagerplatz;
import com.railStock.rail_stock.entity.Lok;
import com.railStock.rail_stock.mapper.BestandMapper;
import com.railStock.rail_stock.repository.BestandRepository;
import com.railStock.rail_stock.repository.LagerplatzRepository;
import com.railStock.rail_stock.repository.LokRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BestandService {

    private final BestandRepository bestandRepository;
    private final LagerplatzRepository lagerplatzRepository;
    private final LokRepository lokRepository;

    public BestandService(BestandRepository betsandRepository, LagerplatzRepository lagerplatzRepository, LokRepository lokRepository) {
        this.bestandRepository = betsandRepository;
        this.lagerplatzRepository = lagerplatzRepository;
        this.lokRepository = lokRepository;
    }

    public List<Bestand> findAll() {
        return bestandRepository.findAll();
    }

    public List<Bestand> findByArtNumber(String artNumber) {
        return bestandRepository.findByLok_ArtNumber(artNumber);
    }

    public Bestand updateBestand(BestandFormDTO form) {

        // Werte aus DTO
        String lokArtNumber = form.getArtNumber();
        String regal = form.getRegal();
        String tablar = form.getTablar();
        int menge = form.getMenge();

        // Lagerplatz prüfen
        Lagerplatz lagerplatz = lagerplatzRepository
                .findByRegalAndTablarIgnoreCase(regal, tablar)
                .orElseThrow(() -> new RuntimeException("Lagerplatz nicht gefunden"));

        // Bestand suchen
        Bestand bestand = bestandRepository
                .findByLokAndLagerplatz(lokArtNumber, regal, tablar)
                .orElseGet(() -> {
                    Lok lok = lokRepository.findByArtNumber(lokArtNumber)
                            .orElseThrow(() -> new RuntimeException("Lok nicht gefunden"));

                    Bestand neu = new Bestand();
                    neu.setLok(lok);
                    neu.setLagerplatz(lagerplatz);
                    neu.setMenge(0);
                    return bestandRepository.save(neu);
                });

        // Menge aktualisieren
        bestand.setMenge(bestand.getMenge()+menge);
        return bestandRepository.save(bestand);
    }

    public List<Bestand> findByLagerplatz(String regal, String tablar) {
        return bestandRepository.findByLagerplatz_RegalAndLagerplatz_Tablar(regal, tablar);
    }

    public List<GesamtBestandDTO> getGesamtBestand() {
        return bestandRepository.findAll().stream().collect(Collectors.groupingBy(b -> b.getLok().getArtNumber(),
                Collectors.summingInt(Bestand:: getMenge)
        ))
                .entrySet().stream().map(e -> new GesamtBestandDTO(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }


    @Transactional
    public Bestand transferBestand(String artNumber, String vonRegal, String vonTablar, String zuRegal, String zuTablar, int menge) {


        Lagerplatz vonLp = lagerplatzRepository.findByRegalAndTablarIgnoreCase(vonRegal, vonTablar)
                .orElseThrow(() -> new RuntimeException("Lagerplatz nicht gefunden"));

        Lagerplatz zuLp = lagerplatzRepository.findByRegalAndTablarIgnoreCase(zuRegal, zuTablar)
                .orElseGet(() -> {
                    Lagerplatz lp = new Lagerplatz();
                    lp.setRegal(zuRegal);
                    lp.setTablar(zuTablar);
                    return lagerplatzRepository.save(lp);
        });

        Lok lok = lokRepository.findByArtNumber(artNumber).orElseThrow(() -> new RuntimeException("Lok nicht gefunden"));

        Bestand vonBestand = bestandRepository.findByLokAndLagerplatz(artNumber, vonRegal, vonTablar)
                .orElseThrow(() -> new RuntimeException("Bestand nicht gefunden"));

        if (vonBestand.getMenge() < menge){
            throw new RuntimeException("Nicht genug Bestand zum transferieren");
        }

        int neuMengeQuelle = vonBestand.getMenge()- menge;
        if (neuMengeQuelle == 0){
            bestandRepository.delete(vonBestand);
        }else {
            vonBestand.setMenge(neuMengeQuelle);
            bestandRepository.save(vonBestand);
        }

        Bestand zuBestand = bestandRepository.findByLokAndLagerplatz(artNumber,zuRegal,zuTablar)
                .orElseGet(() -> {
                    Bestand neu = new Bestand();
                    neu.setLok(lok);
                    neu.setLagerplatz(zuLp);
                    neu.setMenge(0);
                    return neu;
                });

        zuBestand.setMenge(zuBestand.getMenge()+menge);
        return bestandRepository.save(zuBestand);
    }

}
