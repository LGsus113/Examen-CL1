package pe.edu.i202221123.Crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202221123.Entity.City;
import pe.edu.i202221123.Entity.Country;

import java.util.List;
import java.util.stream.Collectors;

public class JPAFind {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        Country country = em.find(Country.class, "PER");

        if (country != null) {
            List<City> cities = country.getCities().stream().filter(city -> city.getPopulation() > 700000).collect(Collectors.toList());

            System.out.println("Ciudades peruanas con poblacion > 700k");

            for (City city : cities) {
                System.out.println(city.getName());
            }
        } else {
            System.out.println("El pais con codigo PER no fue encontrado");
        }

        em.close();
        emf.close();
    }
}
