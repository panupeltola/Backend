package kevat25.dronepaivakirja.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Lento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    

    private String lentaja, aika, pvm;
    
    @ManyToOne
    @JoinColumn(name= "lentopaikkaId")
    private Lentopaikka lentopaikka;

    private double lampoTila;

    public Lento() {
    }

    



    public Lento(String lentaja, String aika, String pvm, Lentopaikka lentopaikka, double lampoTila) {
        this.lentaja = lentaja;
        this.aika = aika;
        this.pvm = pvm;
        this.lentopaikka = lentopaikka;
        this.lampoTila = lampoTila;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAika() {
        return aika;
    }

    public void setAika(String aika) {
        this.aika = aika;
    }

    public Lentopaikka getLentopaikka() {
        return lentopaikka;
    }

    public void setLentopaikka(Lentopaikka lentopaikka) {
        this.lentopaikka = lentopaikka;
    }

    public double getLampoTila() {
        return lampoTila;
    }

    public void setLampoTila(double lampoTila) {
        this.lampoTila = lampoTila;
    }

    public String getPvm() {
        return pvm;
    }



    public void setPvm(String pvm) {
        this.pvm = pvm;
    }



    public String getLentaja() {
        return lentaja;
    }

    public void setLentaja(String lentaja) {
        this.lentaja = lentaja;
    }



    @Override
    public String toString() {
        return "Lento [id=" + id + ", lentaja=" + lentaja + ", aika=" + aika + ", lentopaikka=" + lentopaikka
                + ", lampoTila=" + lampoTila + "]";
    }

    
   
     

    

}
