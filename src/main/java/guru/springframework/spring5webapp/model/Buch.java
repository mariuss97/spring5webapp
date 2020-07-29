package guru.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Buch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String titel;
    private String isbn;

    @ManyToOne
    private Verlag verlag;

    @ManyToMany
    @JoinTable(name = "autor_buch", joinColumns = @JoinColumn(name="buch_id"),
    inverseJoinColumns = @JoinColumn(name="autor_id"))
    private Set<Autor> autoren=new HashSet<>();

    public Buch() {
    }


    public Buch(String titel, String isbn) {
        this.titel = titel;
        this.isbn = isbn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<Autor> getAutoren() {
        return autoren;
    }

    public void setAutoren(Set<Autor> autoren) {
        this.autoren = autoren;
    }

    public Verlag getVerlag() {
        return verlag;
    }

    public void setVerlag(Verlag verlag) {
        this.verlag = verlag;
    }
}
