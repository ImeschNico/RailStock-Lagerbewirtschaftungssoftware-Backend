package com.railStock.rail_stock.mapper;


import com.railStock.rail_stock.dto.BestandDTO;
import com.railStock.rail_stock.entity.Bestand;

public class BestandMapper {

    public static BestandDTO toDTO(Bestand entity) {
        if (entity == null) {
            return null;
        }

        return new BestandDTO(
                entity.getId(),
                entity.getLok() != null ? LokMapper.toDTO(entity.getLok()) : null,
                entity.getLagerplatz() != null ? LagerplatzMapper.toDTO(entity.getLagerplatz()) : null,
                entity.getMenge()

        );
    }

    public BestandMapper(){}

    public static Bestand toEntity(BestandDTO dto) {
        if (dto == null) {
            return null;
        }

        Bestand bestand = new Bestand(
                dto.getLok() != null ? LokMapper.toEntity(dto.getLok()) : null,
                dto.getLagerplatz() != null ? LagerplatzMapper.toEntity(dto.getLagerplatz()) : null,
                dto.getMenge()
        );
        bestand.setId(dto.getId());
        return bestand;


    }
}
