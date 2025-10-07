package com.railStock.rail_stock.service;


import com.railStock.rail_stock.dto.LagerplatzDTO;
import com.railStock.rail_stock.entity.Lagerplatz;
import com.railStock.rail_stock.mapper.LagerplatzMapper;
import com.railStock.rail_stock.repository.LagerplatzRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LagerplatzService {

    private final LagerplatzRepository lagerplatzRepository;

    public LagerplatzService(LagerplatzRepository lagerplatzRepository) {
        this.lagerplatzRepository = lagerplatzRepository;
    }

    public List<Lagerplatz> findByFilter(String regal, String tablar) {
        return lagerplatzRepository.findByFilter(regal, tablar);
    }

    public Lagerplatz create(LagerplatzDTO dto) {
        return lagerplatzRepository.findByRegalAndTablarIgnoreCase(dto.getRegal(), dto.getTablar())
                .orElseGet(() -> {
                    Lagerplatz neu = LagerplatzMapper.toEntity(dto);
                    return lagerplatzRepository.save(neu);
                });
    }
}
