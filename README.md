# RailStock-Lagerbewirtschaftungssoftware-Backend

**RailStock Backend** ist der serverseitige Teil der RailStock-Lagerverwaltungssoftware zur Organisation und Verwaltung von Modelleisenbahnbeständen.  
Das Backend basiert auf **Spring Boot** und stellt eine RESTful API bereit, über die das Frontend Daten zu Lokomotiven, Lagerplätzen und Beständen abrufen und verwalten kann.

---

## Technologien

- **Java 21**
- – moderne, stabile Laufzeitumgebung mit langfristigem Support (LTS)
- **Spring Boot 3.5.6**
- – Framework für den schnellen Aufbau von Microservices und REST-APIs
- **Spring Web**
- – für die Bereitstellung der REST-Endpunkte
- **Spring Data JPA (Hibernate)**
- – zur einfachen Datenbankanbindung mit automatischer Objekt-Relationaler Abbildung
- **H2 Database (lokal, persistent)**
- – gewählt, um eine **einfach einsetzbare Lösung** zu bieten.  
  Dadurch kann das Backend als **fertiges JAR** ausgeliefert und z. B. per USB-Stick an den Bekannten weitergegeben werden.  
  Er kann das Projekt **direkt lokal ausführen und damit arbeiten**, ohne Docker, Git oder eine separate Datenbank installieren zu müssen.  
  Die Daten werden **persistent gespeichert**, sodass sie beim Neustart erhalten bleiben.  
  Später ist ein Wechsel auf MySQL oder PostgreSQL problemlos möglich, falls eine produktive Umgebung eingerichtet wird.
   Die **persistente Speicherung** wird über H2s Dateimodus realisiert:  
  ```properties
  spring.datasource.url=jdbc:h2:file:./railstockdb
  spring.datasource.driver-class-name=org.h2.Driver
  spring.datasource.username=sa
  spring.datasource.password=
  spring.jpa.hibernate.ddl-auto=update
  ```
- **Springdoc OpenAPI (Swagger UI)**
- – automatische Generierung der API-Dokumentation
- **JUnit 5 & MockMVC (Testing)**
- – für automatisierte Unit- und Integrationstests
- **Maven**
- – als Build- und Dependency-Management-Tool

---
