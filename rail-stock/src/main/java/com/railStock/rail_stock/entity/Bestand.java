package com.railStock.rail_stock.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "bestand")
public class Bestand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lok_id", nullable = false)
    private Lok lok;

    @ManyToOne
    @JoinColumn(name = "lagerplatz_id", nullable = false)
    private Lagerplatz lagerplatz;

    @Column(nullable = false)
    private int menge;


    //----Konstruktoren ----
    public Bestand() {}

    public Bestand(Lok lok, Lagerplatz lagerplatz, int menge) {
        this.lok = lok;
        this.lagerplatz = lagerplatz;
        this.menge = menge;

    }


    //----Getter & Setter ----

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Lok getLok() {
        return lok;
    }

    public void setLok(Lok lok) {
        this.lok = lok;
    }

    public Lagerplatz getLagerplatz() {
        return lagerplatz;
    }

    public void setLagerplatz(Lagerplatz lagerplatz) {
        this.lagerplatz = lagerplatz;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }
}
