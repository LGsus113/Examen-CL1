package pe.edu.i202221123.cl1_jpa_data_Medina_Lazaro.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class CountryLanguajeId implements Serializable {
    private String countryCode;
    private String language;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryLanguajeId that = (CountryLanguajeId) o;
        return countryCode.equals(that.countryCode) && language.equals(that.language);
    }

    @Override
    public int hashCode() {
        return 31 * countryCode.hashCode() + language.hashCode();
    }
}
