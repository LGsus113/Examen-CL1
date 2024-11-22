package pe.edu.i202221123.cl1_jpa_data_Medina_Lazaro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.i202221123.cl1_jpa_data_Medina_Lazaro.repository.CountryRepository;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Cl1JpaDataMedinaLazaroApplication implements CommandLineRunner {
	@Autowired
	CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(Cl1JpaDataMedinaLazaroApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Implementación del código aquí
		System.out.println("Aplicación Spring Boot iniciada correctamente.");

		String countryCodeArg = "ARG";
		String countryCodePer = "PER";

		countryRepository.findById(countryCodeArg).ifPresentOrElse(
				country -> {
					System.out.println("Lenguajes de Argentina (ARG):");
					country.getCountryLanguages().forEach(language ->
							System.out.println(language.getId().getLanguage()));
				},
				() -> {
					System.out.println("No se encontraron lenguajes para Argentina. Mostrando lenguajes de Perú (PER):");
					countryRepository.findById(countryCodePer).ifPresent(country -> {
						country.getCountryLanguages().forEach(languaje ->
								System.out.println(languaje.getId().getLanguage()));
					});
				}
		);

		/*
		List<String> CountryCodesToDelete = Arrays.asList("COL", "ARG");
		countryRepository.deleteAllById(CountryCodesToDelete);
		System.out.println("Eliminados son: " + CountryCodesToDelete);
		* */

		/*
		String countryCodeArg = "ARG";
		String countryCodePer = "PER";

		countryRepository.findById(countryCodeArg).ifPresentOrElse(
				country -> {
					System.out.println("Lenguajes de Argentina (ARG):");
					country.getCountryLanguages().forEach(language ->
							System.out.println(language.getId().getLanguage())
					);
				},
				() -> {
					System.out.println("No se encontraron lenguajes para Argentina. Mostrando lenguajes de Perú (PER):");
					countryRepository.findById(countryCodePer).ifPresent(country -> {
						country.getCountryLanguages().forEach(language ->
								System.out.println(language.getId().getLanguage())
						);
					});
				}
		);

		// Eliminar países: COL y ARG
		List<String> countryCodesToDelete = Arrays.asList("COL", "ARG");
		countryRepository.deleteAllById(countryCodesToDelete);
		System.out.println("Países eliminados: " + countryCodesToDelete);

		// Repetir consulta para activar flujo alternativo
		countryRepository.findById(countryCodeArg).ifPresentOrElse(
				country -> {
					System.out.println("Lenguajes de Argentina (ARG):");
					country.getCountryLanguages().forEach(language ->
							System.out.println(language.getId().getLanguage())
					);
				},
				() -> {
					System.out.println("No se encontraron lenguajes para Argentina. Mostrando lenguajes de Perú (PER):");
					countryRepository.findById(countryCodePer).ifPresent(country -> {
						country.getCountryLanguages().forEach(language ->
								System.out.println(language.getId().getLanguage())
						);
					});
				}
		);

		* */
	}

}
