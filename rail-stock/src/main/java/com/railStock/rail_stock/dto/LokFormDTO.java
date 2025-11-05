package com.railStock.rail_stock.dto;

public class LokFormDTO {
    private String artNumber;
    private String bezeichnung;
    private String typ;
    private String modell;
    private String stromart;
    private String spur;
    private String epoche;
    private String betriebsart;
    private String herstellerName;

    public String getArtNumber() {
        return artNumber;
    }

    public void setArtNumber(String artNumber) {
        this.artNumber = artNumber;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public String getStromart() {
        return stromart;
    }

    public void setStromart(String stromart) {
        this.stromart = stromart;
    }

    public String getSpur() {
        return spur;
    }

    public void setSpur(String spur) {
        this.spur = spur;
    }

    public String getEpoche() {
        return epoche;
    }

    public void setEpoche(String epoche) {
        this.epoche = epoche;
    }

    public String getBetriebsart() {
        return betriebsart;
    }

    public void setBetriebsart(String betriebsart) {
        this.betriebsart = betriebsart;
    }

    public String getHerstellerName() {
        return herstellerName;
    }

    public void setHerstellerName(String herstellerName) {
        this.herstellerName = herstellerName;
    }
}
