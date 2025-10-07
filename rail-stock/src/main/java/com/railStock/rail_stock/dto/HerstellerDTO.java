package com.railStock.rail_stock.dto;



public class HerstellerDTO {

    private final Long id;

    private final String name;


    public HerstellerDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
