package pe.edu.i202221123.cl1_jpa_data_Medina_Lazaro.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "countrylanguage")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CountryLanguage {
    @EmbeddedId
    private CountryLanguajeId id; // Clave primaria compuesta

    @ManyToOne
    @JoinColumn(name = "CountryCode", referencedColumnName = "Code", insertable = false, updatable = false)
    private Country country; // Relación bidireccional con la entidad Country

    @Column(name = "IsOfficial")
    private String isOfficial;

    @Column(name = "Percentage")
    private Double percentage;
}
