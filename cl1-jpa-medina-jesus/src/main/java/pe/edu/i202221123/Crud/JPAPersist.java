package pe.edu.i202221123.Crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import pe.edu.i202221123.Entity.City;
import pe.edu.i202221123.Entity.Country;
import pe.edu.i202221123.Entity.CountryLanguage;
import pe.edu.i202221123.Entity.CountryLanguageId;

public class JPAPersist {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();

            // Crear el país imaginario
            Country country = new Country();
            country.setCode("IMN");
            country.setName("Imaginary Nation");
            country.setContinent("Imaginary Continent");
            country.setRegion("Unknown");
            country.setSurfaceArea(100000.00);
            country.setIndependYear(2020);
            country.setPopulation(1000000);
            country.setLifeExpectancy(75.0);
            country.setGnp(50000.00);
            country.setLocalName("Imaginary");
            country.setGovernmentForm("Democracy");
            country.setHeadOfState("John Doe");
            country.setCapital(1);
            country.setCode2("IM");

            // Crear las ciudades
            City city1 = new City();
            city1.setName("City One");
            city1.setDistrict("District A");
            city1.setPopulation(300000);
            city1.setCountry(country);

            City city2 = new City();
            city2.setName("City Two");
            city2.setDistrict("District B");
            city2.setPopulation(200000);
            city2.setCountry(country);

            City city3 = new City();
            city3.setName("City Three");
            city3.setDistrict("District C");
            city3.setPopulation(100000);
            city3.setCountry(country);

            // Crear los lenguajes nativos
            CountryLanguage language1 = new CountryLanguage();
            CountryLanguageId languageId1 = new CountryLanguageId();
            languageId1.setCountryCode("IMN");
            languageId1.setLanguage("Imaginary Language 1");
            language1.setId(languageId1);
            language1.setIsOfficial("T");
            language1.setPercentage(100.0);
            language1.setCountry(country);

            CountryLanguage language2 = new CountryLanguage();
            CountryLanguageId languageId2 = new CountryLanguageId();
            languageId2.setCountryCode("IMN");
            languageId2.setLanguage("Imaginary Language 2");
            language2.setId(languageId2);
            language2.setIsOfficial("F");
            language2.setPercentage(50.0);
            language2.setCountry(country);

            // Persistir el país, ciudades y lenguajes
            em.persist(country);
            em.persist(city1);
            em.persist(city2);
            em.persist(city3);
            em.persist(language1);
            em.persist(language2);

            // Commit de la transacción
            et.commit();
        } catch (RuntimeException e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
            emf.close();
        }
    }
}
