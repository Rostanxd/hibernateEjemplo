package es.makigas.hibernate.modelo;

import javax.persistence.*;

/**
 * Created by Rostan on 19/09/2016.
 */

@Entity
@Table(name = "LIBROS")
public class Libro {

    @Id
    @Column(name = "idLibro")
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAutor")   //  Aqui se define el nombre de la columan que hace de FK hacia el autor.
    private Autor autor;

    public Libro() {}   //  Constructor vacio para hibernate

    public Libro(Long id, String titulo, Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor=" + autor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Libro libro = (Libro) o;

        if (!id.equals(libro.id)) return false;
        if (!titulo.equals(libro.titulo)) return false;
        return autor.equals(libro.autor);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + titulo.hashCode();
        result = 31 * result + autor.hashCode();
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Autor getAutor() {
        return autor;
    }
}
