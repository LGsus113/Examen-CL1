package pe.edu.i202221123.Crud;

import jakarta.persistence.*;
import org.hibernate.internal.build.AllowSysOut;
import pe.edu.i202221123.Entity.Country;

public class JPARemove {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        Country country = em.find(Country.class, "IMN");

        em.getTransaction();
        em.remove(country);
        em.getTransaction().commit();
    }
}
