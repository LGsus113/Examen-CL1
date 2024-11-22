package pe.edu.i202221123.cl1_jpa_data_Medina_Lazaro.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "city")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremento para la clave primaria
    @Column(name = "ID")
    private Integer id; // Clave primaria

    @Column(name = "Name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "CountryCode", referencedColumnName = "Code")
    private Country country; // Relación bidireccional con la entidad Country

    @Column(name = "District")
    private String district;

    @Column(name = "Population")
    private Integer population;
}
