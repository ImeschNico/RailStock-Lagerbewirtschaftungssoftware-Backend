package com.railStock.rail_stock.controller;


import com.railStock.rail_stock.dto.LagerplatzDTO;
import com.railStock.rail_stock.entity.Lagerplatz;
import com.railStock.rail_stock.mapper.LagerplatzMapper;
import com.railStock.rail_stock.service.LagerplatzService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lagerplatz")
public class LagerplatzController {

    private final LagerplatzService lagerplatzService;

    public LagerplatzController(LagerplatzService lagerplatzService) {
        this.lagerplatzService = lagerplatzService;
    }

    @GetMapping("/filter")
    public List<LagerplatzDTO> getLagerplaetze(
            @RequestParam(required = false) String regal,
            @RequestParam(required = false) String tablar
    ){
        List<Lagerplatz> lagerplaetze = lagerplatzService.findByFilter(regal, tablar);
        return LagerplatzMapper.toDTOList(lagerplaetze);
    }

    @PostMapping("/erstellen")
    public LagerplatzDTO erstellenLagerplatz(@RequestBody LagerplatzDTO dto){
        Lagerplatz lp = lagerplatzService.create(dto);
        return LagerplatzMapper.toDTO(lp);
    }
}
