package com.railStock.rail_stock.mapper;


import com.railStock.rail_stock.dto.LagerplatzDTO;
import com.railStock.rail_stock.entity.Lagerplatz;

import java.util.List;
import java.util.stream.Collectors;

public class LagerplatzMapper {

    public static LagerplatzDTO toDTO(Lagerplatz entity) {

        if (entity == null) {
            return null;
        }

        return new LagerplatzDTO(
                entity.getId(),
                entity.getRegal(),
                entity.getTablar()
        );

    }

    public LagerplatzMapper(){}

    public static Lagerplatz toEntity(LagerplatzDTO dto) {
        if (dto == null) {
            return null;
        }

        Lagerplatz lagerplatz = new Lagerplatz(
                dto.getRegal(),
                dto.getTablar()
        );
        lagerplatz.setId(dto.getId());
        return lagerplatz;
    }

    public static List<LagerplatzDTO> toDTOList(List<Lagerplatz> lagerplaetze) {
        return lagerplaetze.stream().map(lp -> new LagerplatzDTO(lp.getId(), lp.getRegal(), lp.getTablar())).collect(Collectors.toList());
    }
}
