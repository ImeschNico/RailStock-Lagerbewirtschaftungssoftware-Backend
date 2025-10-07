package com.railStock.rail_stock.service;


import com.railStock.rail_stock.dto.LokDTO;
import com.railStock.rail_stock.entity.Lok;
import com.railStock.rail_stock.mapper.LokMapper;
import com.railStock.rail_stock.repository.LagerplatzRepository;
import com.railStock.rail_stock.repository.LokRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LokService {

    private final LokRepository lokRepository;

    public LokService(LokRepository lokRepository) {
        this.lokRepository = lokRepository;

    }

    public List<LokDTO> filterLoks(
            String artNumber,
            String bezeichnung,
            String typ,
            String modell,
            String stromart,
            String spur,
            String epoche,
            String betriebsart,
            Long herstellerId
    ){
        List<Lok> loks = lokRepository.findAll();

        return loks.stream()
                .filter(l -> artNumber == null || l.getArtNumber().equalsIgnoreCase(artNumber))
                .filter(l -> bezeichnung == null || l.getBezeichnung().equalsIgnoreCase(bezeichnung))
                .filter(l -> typ == null || l.getTyp().equalsIgnoreCase(typ))
                .filter(l -> modell == null || l.getModell().equalsIgnoreCase(modell))
                .filter(l -> stromart == null|| l.getStromart().equalsIgnoreCase(stromart))
                .filter(l -> spur == null || l.getSpur().equalsIgnoreCase(spur))
                .filter(l -> epoche == null || l.getEpoche().equalsIgnoreCase(epoche))
                .filter(l -> betriebsart == null || l.getBetriebsart().equalsIgnoreCase(betriebsart))
                .filter(l -> herstellerId == null || l.getHersteller().equals(herstellerId))
                .map(LokMapper::toDTO)
                .collect(Collectors.toList());
    }
}
