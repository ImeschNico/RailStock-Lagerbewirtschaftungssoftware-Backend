package com.railStock.rail_stock.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "lok")
public class Lok {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String artNumber;

    @Column(nullable = false, length = 1000)
    private String bezeichnung;

    @Column(nullable = false, length = 100)
    private String typ;

    @Column(nullable = false, length = 100)
    private String modell;

    @Column(nullable = false, length = 30)
    private String stromart;

    @Column(nullable = false, length = 10)
    private String spur;

    @Column(nullable = false, length = 10)
    private String epoche;

    @Column(nullable = false, length = 20)
    private String betriebsart;


    //----Beziehung zu Hersteller ----
    @ManyToOne
    @JoinColumn(name = "hersteller_id", nullable = false)
    private Hersteller hersteller;


    //----Konstruktoren----
    public Lok() {}

    public Lok(String artNumber, String bezeichnung, String typ, String modell, String stromart, String spur, String epoche, String betriebsart) {
        this.artNumber = artNumber;
        this.bezeichnung = bezeichnung;
        this.typ = typ;
        this.modell = modell;
        this.stromart = stromart;
        this.spur = spur;
        this.epoche = epoche;
        this.betriebsart = betriebsart;
    }


    //----Getter & Setter -----
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Hersteller getHersteller() {
        return hersteller;
    }

    public void setHersteller(Hersteller hersteller) {
        this.hersteller = hersteller;
    }
}
