package kevat25.dronepaivakirja.domain;

import jakarta.persistence.*;


@Entity
public class Kayttaja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id", nullable = false, updatable = false)
    private long id;
    
    @Column(name ="henkilonimi", nullable = false, unique = true)
    private String henkilonimi;

    @Column(name ="username", nullable = false, unique = true)
    private String username;

    @Column(name="salasana", nullable = false)
    private String salasanaHash;

    @Column(name="role", nullable = false)
    private String role;

    public Kayttaja() {
    }

    public Kayttaja(String henkilonimi, String kayttajanimi, String salasanaHash, String role) {
        this.henkilonimi = henkilonimi;
        this.username = kayttajanimi;
        this.salasanaHash = salasanaHash;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHenkilonimi() {
        return henkilonimi;
    }

    public void setHenkilonimi(String henkilonimi) {
        this.henkilonimi = henkilonimi;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSalasanaHash() {
        return salasanaHash;
    }

    public void setSalasanaHash(String salasanaHash) {
        this.salasanaHash = salasanaHash;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Kayttaja [id=" + id + ", henkilonimi=" + henkilonimi + ", username=" + username + ", salasanaHash="
                + salasanaHash + ", role=" + role + "]";
    }

   
    

    



}
