package guru.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Verlag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String adresse;
    private String plz;
    private String stadt;

    @OneToMany
    @JoinColumn(name="verlag_id")
    private Set<Buch> buecher=new HashSet<>();

    public Verlag() {
    }

    public Verlag(String name, String adresse, String plz, String stadt) {
        this.name = name;
        this.adresse = adresse;
        this.plz = plz;
        this.stadt = stadt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getStadt() {
        return stadt;
    }

    public void setStadt(String stadt) {
        this.stadt = stadt;
    }

    public Set<Buch> getBuecher() {
        return buecher;
    }

    public void setBuecher(Set<Buch> buecher) {
        this.buecher = buecher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Verlag verlag = (Verlag) o;
        return id == verlag.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Verlag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adresse='" + adresse + '\'' +
                ", plz='" + plz + '\'' +
                ", stadt='" + stadt + '\'' +
                ", buecher=" + buecher +
                '}';
    }
}
