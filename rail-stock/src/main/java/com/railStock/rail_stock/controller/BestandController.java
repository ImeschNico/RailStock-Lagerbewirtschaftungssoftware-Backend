package com.railStock.rail_stock.controller;


import com.railStock.rail_stock.dto.BestandDTO;
import com.railStock.rail_stock.dto.BestandFormDTO;
import com.railStock.rail_stock.dto.BestandTransferDTO;
import com.railStock.rail_stock.dto.GesamtBestandDTO;
import com.railStock.rail_stock.entity.Bestand;
import com.railStock.rail_stock.entity.Lok;
import com.railStock.rail_stock.mapper.BestandMapper;
import com.railStock.rail_stock.service.BestandService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/bestand")
public class BestandController {

    private final BestandService bestandService;

    public BestandController(BestandService bestandService) {
        this.bestandService = bestandService;
    }

    @GetMapping("/lok/{artNumber}")
    public List<BestandDTO> getBestand(@PathVariable String artNumber) {
        return bestandService.findByArtNumberIncludingEmpty(artNumber);
    }

    @PutMapping("/updateBestand")
    public BestandDTO updateBestand(@RequestBody BestandFormDTO form) {
        Bestand updated = bestandService.updateBestand(form);
        return BestandMapper.toDTO(updated);
    }

    @GetMapping("/alleBestaende")
    public List<GesamtBestandDTO> getGesamtBestand() {
        return bestandService.getGesamtBestand();
    }

    @GetMapping("/lagerplatz")
    public List<BestandDTO> getAllBestand(@PathVariable String regal, String tablar) {
        return bestandService.findByLagerplatz(regal, tablar).stream().map(BestandMapper::toDTO).collect(Collectors.toList());
    }

    @PutMapping("/transferBestand")
    public BestandDTO transferBestand(@RequestBody BestandTransferDTO form) {
        Bestand transferred = bestandService.transferBestand(
                form.getArtNumber(),
                form.getVonRegal(),
                form.getVonTablar(),
                form.getZuRegal(),
                form.getZuTablar(),
                form.getMenge()
        );
        return BestandMapper.toDTO(transferred);
    }

}
