package guru.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String vorName;
    private String nachName;

    @ManyToMany(mappedBy = "autoren")
    private Set<Buch> buecher=new HashSet<>();

    public Autor() {
    }

    public Autor(String vorName, String nachName) {
        this.vorName = vorName;
        this.nachName = nachName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVorName() {
        return vorName;
    }

    public void setVorName(String vorName) {
        this.vorName = vorName;
    }

    public String getNachName() {
        return nachName;
    }

    public void setNachName(String nachName) {
        this.nachName = nachName;
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
        Autor autor = (Autor) o;
        return id == autor.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", vorName='" + vorName + '\'' +
                ", nachName='" + nachName + '\'' +
                ", buecher=" + buecher +
                '}';
    }
}
