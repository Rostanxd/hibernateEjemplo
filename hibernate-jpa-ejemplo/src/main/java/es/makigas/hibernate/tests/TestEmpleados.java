package es.makigas.hibernate.tests;

import es.makigas.hibernate.modelo.Direccion;
import es.makigas.hibernate.modelo.Empleado;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by Rostan on 17/09/2016.
 */
public class TestEmpleados {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public  static void main(String[] args){
        /* Crear el gestor de persistencia (EM)*/
        /*
        EntityManager manager = emf.createEntityManager();
        manager = emf.createEntityManager();

        insertInicial();

        manager.getTransaction().begin();
        Empleado e = manager.find(Empleado.class, 10L);
        e.setNombre("David");
        e.setApellidos("Lopez");
        //  Se usa para poder usar una entidad que fue cerrada por el manager.close() y que funcione en su actualizacion,
        e = manager.merge(e);   //  es decir una entidad que no esta en modo manager. Se suele confundir con el Update.
        manager.getTransaction().commit();

        imprimirTodo();
        manager.close();    //  Se cierra el manager, se debe hacer esto para evitar que el beign tran, bloquee por mucho la tabla.
        */

        /*
        // Codigo para hace una consulta de empleados a la base.
        List<Empleado> empleados = (List<Empleado>) manager.createQuery("From Empleado").getResultList();
        System.out.println("En esta base de datos hay "+ empleados.size()+ " empleados.");
        */

        /*
        EntityManager man = emf.createEntityManager();
        Empleado e = new Empleado(10L, "Perez", "Pepito", LocalDate.of(1979,6,10));
        man.getTransaction().begin();
        man.persist(e);
        man.getTransaction().commit();
        man.close();

        imprimirTodo();

        man = emf.createEntityManager();
        man.getTransaction().begin();
        e.setNombre("Dani");
        e = man.merge(e);   //  obtiene la entidad que no esta gestinoada (managed) a gestionada y con ello se pueden hacer los updates
        man.remove(e);  //  remueve la entidad del sistema.
        man.getTransaction().commit();
        man.close();

        imprimirTodo();
        */

        /*
        //  Guardando en dos tablas por separado, forma facil.
        EntityManager man = emf.createEntityManager();
        Direccion d = new Direccion(15L,"Calle falsa 123", "Springfield", "Springfiel", "EEUU");
        Empleado e = new Empleado(10L, "Perez", "Pepito", LocalDate.of(1979,6,10));
        e.setDireccion(d);
        man.getTransaction().begin();
        man.persist(d);
        man.persist(e);
        man.getTransaction().commit();
        man.close();

        imprimirTodo();
        */

        EntityManager man = emf.createEntityManager();
        Empleado e = new Empleado(10L, "Perez", "Pepito", LocalDate.of(1979,6,10));
        e.setDireccion(new Direccion(15L,"Calle falsa 123", "Springfield", "Springfiel", "EEUU"));
        man.getTransaction().begin();
        man.persist(e);
        man.getTransaction().commit();
        man.close();

        imprimirTodo();
    }

    private static void insertInicial() {
        EntityManager man = emf.createEntityManager();
        Empleado e = new Empleado(10L, "Perez", "Pepito", LocalDate.of(1979,6,10));
        //  Para hacer update
        //  e.setApellidos("Lopez");
        man.getTransaction().begin();
        man.persist(e);
        man.getTransaction().commit();
        man.close();
    }

    //  Evitar quejas.
    @SuppressWarnings("unchecked")
    private static void imprimirTodo(){
        EntityManager man = emf.createEntityManager();
        List<Empleado> emps = (List<Empleado>) man.createQuery("From Empleado").getResultList();
        System.out.println("En esta base de datos hay "+ emps.size()+ " empleados.");
        for (Empleado emp : emps){
            System.out.println(emp.toString());
        }
        man.close();
    }
}
