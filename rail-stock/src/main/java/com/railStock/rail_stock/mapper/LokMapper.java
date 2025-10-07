package com.railStock.rail_stock.mapper;


import com.railStock.rail_stock.dto.LokDTO;
import com.railStock.rail_stock.entity.Hersteller;
import com.railStock.rail_stock.entity.Lok;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class LokMapper {

    public static LokDTO toDTO(Lok entity) {
        if (entity == null) {
            return null;
        }
        return new LokDTO(
                entity.getId(),
                entity.getArtNumber(),
                entity.getBezeichnung(),
                entity.getTyp(),
                entity.getModell(),
                entity.getStromart(),
                entity.getSpur(),
                entity.getEpoche(),
                entity.getBetriebsart(),
                entity.getHersteller() != null ? entity.getHersteller().getId() : null,
                entity.getHersteller() != null ? entity.getHersteller().getName() : null

        );
    }

    public LokMapper() {
    }

    public static Lok toEntity(LokDTO dto) {
        if (dto == null) {
            return null;
        }
        Lok lok = new Lok(
                dto.getArtNumber(),
                dto.getBezeichnung(),
                dto.getTyp(),
                dto.getModell(),
                dto.getStromart(),
                dto.getSpur(),
                dto.getEpoche(),
                dto.getBetriebsart()
        );
        lok.setId(dto.getId());

        if (dto.getHerstellerId() != null || dto.getHerstellerName() != null) {
            Hersteller hersteller = new Hersteller();
            hersteller.setId(dto.getHerstellerId());
            hersteller.setName(dto.getHerstellerName());
            lok.setHersteller(hersteller);
        }
        return lok;
    }

}
