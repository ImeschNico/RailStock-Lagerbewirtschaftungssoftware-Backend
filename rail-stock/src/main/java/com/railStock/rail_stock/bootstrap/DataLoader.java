package com.railStock.rail_stock.bootstrap;


import com.railStock.rail_stock.entity.Hersteller;
import com.railStock.rail_stock.entity.Lok;
import com.railStock.rail_stock.repository.HerstellerRepository;
import com.railStock.rail_stock.repository.LokRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
public class DataLoader implements CommandLineRunner {

    private final HerstellerRepository herstellerRepository;
    private final LokRepository lokRepository;

    public DataLoader(HerstellerRepository herstellerRepository, LokRepository lokRepository) {
        this.herstellerRepository = herstellerRepository;
        this.lokRepository = lokRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //Nur laden wenn die Tabelle leer ist
        if (herstellerRepository.count() == 0) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(
                    getClass().getResourceAsStream("/data/hersteller.csv")
            ))){
                String line;
                br.readLine(); //Kopfzeile überspringen
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(";");
                    if (parts.length >= 2){
                        Hersteller hersteller = new Hersteller();
                        hersteller.setName(parts[1].trim());
                        herstellerRepository.save(hersteller);
                    }
                }
            }
        }
        if (lokRepository.count() == 0) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(
                    getClass().getResourceAsStream("/data/lokDaten.csv")
            ))){
                String line;
                br.readLine();
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(";");
                    if (parts.length >= 9){
                        Lok lok = new Lok();
                        lok.setArtNumber(parts[0].trim());
                        lok.setBezeichnung(parts[1].trim());
                        lok.setTyp(parts[2].trim());
                        lok.setModell(parts[3].trim());
                        lok.setStromart(parts[4].trim());
                        lok.setSpur(parts[5].trim());
                        lok.setEpoche(parts[6].trim());
                        lok.setBetriebsart(parts[7].trim());



                        lokRepository.save(lok);
                    }
                }
            }
        }
    }
}
