package com.railStock.rail_stock.controller;


import com.railStock.rail_stock.dto.LokDTO;
import com.railStock.rail_stock.entity.Lok;
import com.railStock.rail_stock.service.LokService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loks")
public class LokController {

    private final LokService lokService;

    public LokController(LokService lokService) {
        this.lokService = lokService;
    }

    @GetMapping("/filter")
    public List<LokDTO> filterLoks(
            @RequestParam(required = false) String artNumber,
            @RequestParam(required = false) String bezeichnung,
            @RequestParam(required = false) String typ,
            @RequestParam(required = false) String modell,
            @RequestParam(required = false) String stromart,
            @RequestParam(required = false) String spur,
            @RequestParam(required = false) String epoche,
            @RequestParam(required = false) String betriebsart,
            @RequestParam(required = false) Long herstellerId
    ){
        return lokService.filterLoks(artNumber, bezeichnung, typ, modell, stromart, spur, epoche, betriebsart, herstellerId);
    }
}
