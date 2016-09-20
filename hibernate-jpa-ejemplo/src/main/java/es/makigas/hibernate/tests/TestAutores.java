package es.makigas.hibernate.tests;

import es.makigas.hibernate.modelo.Autor;
import es.makigas.hibernate.modelo.Libro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by Rostan on 19/09/2016.
 */
public class TestAutores {

    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public static void main(String[] args){
        crearDatos();
        imprimirDatos();
    }

    public static void crearDatos(){
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Autor autor1 = new Autor(1L, "Pablo Perez","Española");
        Autor autor2 = new Autor(2L, "Elena Gomez","Mexicana");
        Autor autor3 = new Autor(3L, "Miguel Lopez","Chilena");

        em.persist(autor1);
        em.persist(autor2);
        em.persist(autor3);

        em.persist(new Libro(1L,"Programar en Java es Facil",autor2));
        em.persist(new Libro(2L,"Como vestirse con estilo",autor3));
        em.persist(new Libro(3L,"Como cocinar sin quemar la cocina",autor1));
        em.persist(new Libro(4L,"Programar en Cobol es divertido",autor2));
        em.persist(new Libro(5L,"Programar en Cobol no es divertido",autor2));


        em.getTransaction().commit();
        em.close();
    }

    public static void imprimirDatos(){
        EntityManager em = emf.createEntityManager();
        Autor autor = em.find(Autor.class, 2L);
        System.out.println(autor);

        List<Libro> libros = autor.getListLibros();
        for (Libro libro : libros){
            System.out.println("*" + libro.toString());
        }


        em.close();
    }


}
