package com.railStock.rail_stock.dto;



public class BestandFormDTO {

    private String artNumber;
    private String regal;
    private String tablar;
    private int menge;

    public BestandFormDTO() {
        this.artNumber = "";
        this.regal = "";
        this.tablar = "";
        this.menge = 0;

    }

    public String getArtNumber() {
        return artNumber;
    }

    public void setArtNumber(String artNumber) {
        this.artNumber = artNumber;
    }

    public String getRegal() {
        return regal;
    }

    public void setRegal(String regal) {
        this.regal = regal;
    }

    public String getTablar() {
        return tablar;
    }

    public void setTablar(String tablar) {
        this.tablar = tablar;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }
}
