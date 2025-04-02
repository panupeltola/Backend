package kevat25.dronepaivakirja.domain;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Lentopaikka {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long lentopaikkaId;
    private String nimi, kaupunki;
    private double northing, easting;
    public Lentopaikka() {
    }

    

    public Lentopaikka(String nimi, String kaupunki, double northing, double easting) {
        this.nimi = nimi;
        this.kaupunki = kaupunki;
        this.northing = northing;
        this.easting = easting;


    
    
        
    }

    @OneToMany(mappedBy = "lentopaikka", cascade = CascadeType.ALL) 
    List<Lento> lennot;

    public List<Lento> getLennot() {
        return lennot;
    }



    public void setLennot(List<Lento> lennot) {
        this.lennot = lennot;
    }



    public Long getLentopaikkaId() {
        return lentopaikkaId;
    }
    public void setLentopaikkaId(Long lentopaikkaId) {
        this.lentopaikkaId = lentopaikkaId;
    }
    public String getNimi() {
        return nimi;
    }
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
    public String getKaupunki() {
        return kaupunki;
    }
    public void setKaupunki(String kaupunki) {
        this.kaupunki = kaupunki;
    }
    public double getNorthing() {
        return northing;
    }
    public void setNorthing(double northing) {
        this.northing = northing;
    }
    public double getEasting() {
        return easting;
    }
    public void setEasting(double easting) {
        this.easting = easting;
    }
    @Override
    public String toString() {
        return "Lentopaikat [lentopaikkaId=" + lentopaikkaId + ", nimi=" + nimi + ", kaupunki=" + kaupunki
                + ", northing=" + northing + ", easting=" + easting + "]";
    }

    
   

    


    
}
