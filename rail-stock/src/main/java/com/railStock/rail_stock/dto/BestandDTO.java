package com.railStock.rail_stock.dto;


import com.railStock.rail_stock.entity.Lagerplatz;
import com.railStock.rail_stock.entity.Lok;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class BestandDTO {
    private Long id;
    private LokDTO lok;
    private LagerplatzDTO lagerplatz;
    private int menge;

    public BestandDTO(Long id, LokDTO lok, LagerplatzDTO lagerplatz, int menge){
        this.id = id;
        this.lok = lok;
        this.lagerplatz = lagerplatz;
        this.menge = menge;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LokDTO getLok() {
        return lok;
    }

    public void setLok(LokDTO lok) {
        this.lok = lok;
    }

    public LagerplatzDTO getLagerplatz() {
        return lagerplatz;
    }

    public void setLagerplatz(LagerplatzDTO lagerplatz) {
        this.lagerplatz = lagerplatz;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }


}
