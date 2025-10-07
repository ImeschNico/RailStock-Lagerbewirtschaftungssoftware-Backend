package com.railStock.rail_stock.dto;

public class GesamtBestandDTO{
    private String artNumber;
    private int gesamtMenge;

    public GesamtBestandDTO(String artNumber, int gesamtMenge) {
        this.artNumber = artNumber;
        this.gesamtMenge = gesamtMenge;

    }

    public String getArtNumber() {
        return artNumber;
    }

    public void setArtNumber(String artNumber) {
        this.artNumber = artNumber;
    }

    public int getMenge() {
        return gesamtMenge;
    }

    public void setMenge(int menge) {
        this.gesamtMenge = gesamtMenge;
    }
}
