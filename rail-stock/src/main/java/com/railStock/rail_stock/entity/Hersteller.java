package com.railStock.rail_stock.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "hersteller")
public class Hersteller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    /**
     * Konstruktoren für JPA
     */
    public Hersteller() {}

    /**
     *
     * @param name
     */
    public Hersteller(String name) {
        this.name = name;
    }


    //---Getter und Setter ----
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
