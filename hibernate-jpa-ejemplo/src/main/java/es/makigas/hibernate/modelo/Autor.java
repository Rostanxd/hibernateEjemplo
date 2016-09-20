package es.makigas.hibernate.modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rostan on 19/09/2016.
 */

@Entity
@Table(name = "AUTORES")
public class Autor implements Serializable{

    @Id
    @Column(name = "idAutor")
    private Long Id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "nacionalidad")
    private String nacionalidad;

    //  Mappedby, especifica cual es el campo de la clase libro, que define que autor esta asociado con el this.autor (idAutor)
    //  Cascade, hace referencia a la forma en que se almacena en las dos tablas en la bse de datos.
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Libro> listLibros = new ArrayList<>();

    public Autor() {}   //  Constructor vacio para hibernate.

    public Autor(Long id, String nombre, String nacionalidad) {
        Id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "Id=" + Id +
                ", nombre='" + nombre + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                '}';
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setListLibros(List<Libro> listLibros) {
        this.listLibros = listLibros;
    }

    public List<Libro> getListLibros() {
        return listLibros;
    }
}
