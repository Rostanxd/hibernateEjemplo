package es.makigas.hibernate.modelo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Rostan on 18/09/2016.
 */

@Entity
@Table(name="DIRECCION")
public class Direccion implements Serializable{

    @Id
    @Column(name="idDireccion")
    private Long id;

    @Column(name="direccion")
    private String direccion;

    @Column(name="localidad")
    private String localidad;

    @Column(name="provincia")
    private String provincia;

    @Column(name="pais")
    private String pais;

    //  Mapped indica que es OneToOne en inversa, el due;o de la relacion es empleado
    //  y para ello se indica cual es el objeto mas no el nombre de la columna.
    @OneToOne(mappedBy = "direccion", fetch = FetchType.LAZY)   //  Fetch Lazy, no se obtienen estos datos mientras no se haga el get del atributo. Es lo contrario a EAGER
    private Empleado empleado;

    public Direccion(){

    }

    public Direccion(Long id, String direccion, String localidad, String provincia, String pais) {
        this.id = id;
        this.direccion = direccion;
        this.localidad = localidad;
        this.provincia = provincia;
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "id=" + getId() +
                ", direccion='" + getDireccion() + '\'' +
                ", localidad='" + getLocalidad() + '\'' +
                ", provincia='" + getProvincia() + '\'' +
                ", pais='" + getPais() + '\'' +
                ", empleado='" + empleado.getCodigo() +"'" +
                '}';
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
