package com.railStock.rail_stock.dto;



public class LagerplatzDTO {

    private final Long id;

    private final String regal;

    private final String tablar;


    public LagerplatzDTO(Long id, String regal, String tablar) {
        this.id = id;
        this.regal = regal;
        this.tablar = tablar;
    }

    public String getTablar() {
        return tablar;
    }

    public String getRegal() {
        return regal;
    }

    public Long getId() {
        return id;
    }
}
