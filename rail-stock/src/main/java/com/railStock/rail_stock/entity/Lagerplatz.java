package com.railStock.rail_stock.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "lagerplatz")
public class Lagerplatz {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 7)
    private String regal;

    @Column(nullable = false, length = 7)
    private String tablar;


    //----Konstruktoren ----
    public Lagerplatz() {}

    public Lagerplatz(String regal, String tablar) {
        this.regal = regal;
        this.tablar = tablar; }


//----Getter & Setter ----
    public Long getId()
    { return id; }

    public void setId(Long id)
    { this.id = id; }

    public String getRegal()
    { return regal; }

    public void setRegal(String regal)
    { this.regal = regal; }

    public String getTablar()
    { return tablar; }

    public void setTablar(String tablar)
    { this.tablar = tablar; }
}