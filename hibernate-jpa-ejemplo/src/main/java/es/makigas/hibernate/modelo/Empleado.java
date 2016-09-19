package es.makigas.hibernate.modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by Rostan on 16/09/2016.
 */

@Entity
@Table(name = "Empleado")
public class Empleado implements Serializable{

    @Id
    @Column(name = "codEmpleado")
    private Long codigo;

    @Column(name = "apellido")
    private String apellidos;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fecNacimiento")
    private LocalDate fechanacimiento;

    @OneToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "idDireccion")
    private Direccion direccion;

    //  Constructor vacio obligado en Hibernate
    public Empleado(){

    }

    public Empleado(Long codigo, String apellidos, String nombre, LocalDate fechanacimiento) {
        this.setCodigo(codigo);
        this.setApellidos(apellidos);
        this.setNombre(nombre);
        this.setFechanacimiento(fechanacimiento);
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "codigo=" + codigo +
                ", apellidos='" + apellidos + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechanacimiento=" + fechanacimiento +
                ", direccion=" + direccion +
                '}';
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(LocalDate fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }


}
