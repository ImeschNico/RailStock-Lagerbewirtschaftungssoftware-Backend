package com.railStock.rail_stock.dto;


import com.railStock.rail_stock.entity.Lok;
import jakarta.persistence.Column;

public class LokDTO {

    private final Long id;

    private final String artNumber;

    private final String bezeichnung;

    private final String typ;

    private final  String modell;

    private final String stromart;

    private final String spur;

    private final String epoche;

    private final String betriebsart;

    private final Long herstellerId;

    private final String herstellerName;

    public LokDTO(Long id, String artNumber, String bezeichnung, String typ, String modell, String stromart, String spur, String epoche,
                  String betriebsart, Long herstellerId, String herstellerName) {
        this.id = id;
        this.artNumber = artNumber;
        this.bezeichnung = bezeichnung;
        this.typ = typ;
        this.modell = modell;
        this.stromart = stromart;
        this.spur = spur;
        this.epoche = epoche;
        this.betriebsart = betriebsart;
        this.herstellerId = herstellerId;
        this.herstellerName = herstellerName;
    }

    public Long getId() {
        return id;
    }

    public String getArtNumber() {
        return artNumber;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public String getTyp() {
        return typ;
    }

    public String getModell() {
        return modell;
    }

    public String getStromart() {
        return stromart;
    }

    public String getSpur() {
        return spur;
    }

    public String getEpoche() {
        return epoche;
    }

    public String getBetriebsart() {
        return betriebsart;
    }

    public Long getHerstellerId() {
        return herstellerId;
    }

    public String getHerstellerName() {
        return herstellerName;
    }
}
