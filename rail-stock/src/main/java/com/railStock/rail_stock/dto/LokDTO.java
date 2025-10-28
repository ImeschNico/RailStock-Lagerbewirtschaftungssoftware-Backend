package com.railStock.rail_stock.dto;


import com.railStock.rail_stock.entity.Lok;
import jakarta.persistence.Column;

/**
 * Datenübertragungsobjekt (DTO) für Lokomotiven.
 * <p>
 * Dieses Objekt wird verwendet, um Lokomotivdaten zwischen Backend und Frontend zu übertragen.
 * Es enthält alle relevanten Informationen einer Lok, wie Artikelnummer, Bezeichnung, Typ,
 * Modell, Stromart, Spurweite, Epoche, Betriebsart sowie Herstellerinformationen.
 * </p>
 *
 * <p>
 * Typischerweise in Endpunkten wie {@code GET /api/loks/filter} zurückgegeben.
 * </p>
 *
 * @author Nico Imesch
 * @version 1.0
 */
public class LokDTO {

    /**
     * Eindeutige ID der Lok.
     */
    private final Long id;

    /**
     * Artikelnummer der Lokomotive.
     */
    private final String artNumber;

    /**
     * Bezeichnung der Lok.
     */
    private final String bezeichnung;

    /**
     * Typ der Lok (z. B. E-Lok, Diesellok).
     */
    private final String typ;

    /**
     * Modell oder Baureihe der Lok.
     */
    private final  String modell;

    /**
     * Stromart (z. B. AC, DC, Digital).
     */
    private final String stromart;

    /**
     * Spurweite (z. B. H0, N).
     */
    private final String spur;

    /**
     * Epoche der Lok (z. B. III, IV).
     */
    private final String epoche;

    /**
     * Betriebsart (z. B. Analog, Digital).
     */
    private final String betriebsart;

    /**
     * ID des Herstellers.
     */
    private final Long herstellerId;

    /**
     * Name des Herstellers.
     */
    private final String herstellerName;

    /**
     * Konstruktor zur Initialisierung aller Felder eines {@link LokDTO}.
     *
     * @param id             eindeutige ID der Lok
     * @param artNumber      Artikelnummer
     * @param bezeichnung    Bezeichnung der Lok
     * @param typ            Typ der Lok
     * @param modell         Modell oder Baureihe
     * @param stromart       Stromart
     * @param spur           Spurweite
     * @param epoche         Epoche
     * @param betriebsart    Betriebsart
     * @param herstellerId   ID des Herstellers
     * @param herstellerName Name des Herstellers
     */
    public LokDTO(Long id, String artNumber, String bezeichnung, String typ, String modell, String stromart, String spur, String epoche,
                  String betriebsart, Long herstellerId, String herstellerName) {
        this.id = id;
        this.artNumber = artNumber;
        this.bezeichnung = bezeichnung;
        this.typ = typ;
        this.modell = modell;
        this.stromart = stromart;
        this.spur = spur;
        this.epoche = epoche;
        this.betriebsart = betriebsart;
        this.herstellerId = herstellerId;
        this.herstellerName = herstellerName;
    }

    public Long getId() {
        return id;
    }

    public String getArtNumber() {
        return artNumber;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public String getTyp() {
        return typ;
    }

    public String getModell() {
        return modell;
    }

    public String getStromart() {
        return stromart;
    }

    public String getSpur() {
        return spur;
    }

    public String getEpoche() {
        return epoche;
    }

    public String getBetriebsart() {
        return betriebsart;
    }

    public Long getHerstellerId() {
        return herstellerId;
    }

    public String getHerstellerName() {
        return herstellerName;
    }
}
