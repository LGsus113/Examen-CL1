package pe.edu.i202221123.cl1_jpa_data_Medina_Lazaro.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.i202221123.cl1_jpa_data_Medina_Lazaro.entity.Country;

public interface CountryRepository extends CrudRepository<Country, String> {
}
