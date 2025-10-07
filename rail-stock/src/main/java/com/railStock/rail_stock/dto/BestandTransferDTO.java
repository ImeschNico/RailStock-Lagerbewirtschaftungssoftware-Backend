package com.railStock.rail_stock.dto;




public class BestandTransferDTO {
    private String artNumber;
    private String vonRegal;
    private String vonTablar;
    private String zuRegal;
    private String zuTablar;
    private int menge;

    public BestandTransferDTO(String artNumber, String vonRegal, String vonTablar, String zuRegal, String zuTablar , int menge) {
        this.artNumber = artNumber;
        this.vonRegal = vonRegal;
        this.vonTablar = vonTablar;
        this.zuRegal = zuRegal;
        this.zuTablar = zuTablar;
        this.menge = menge;

    }

    public String getArtNumber() {
        return artNumber;
    }

    public void setArtNumber(String artNumber) {
        this.artNumber = artNumber;
    }

    public String getVonRegal() {
        return vonRegal;
    }

    public void setVonRegal(String vonRegal) {
        this.vonRegal = vonRegal;
    }

    public String getVonTablar() {
        return vonTablar;
    }

    public void setVonTablar(String vonTablar) {
        this.vonTablar = vonTablar;
    }

    public String getZuRegal() {
        return zuRegal;
    }

    public void setZuRegal(String zuRegal) {
        this.zuRegal = zuRegal;
    }

    public String getZuTablar() {
        return zuTablar;
    }

    public void setZuTablar(String zuTablar) {
        this.zuTablar = zuTablar;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }
}
