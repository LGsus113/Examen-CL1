package pe.edu.i202221123.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "city")
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

    public City() {}

    public City(Integer id, String name, Country country, String district, Integer population) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.district = district;
        this.population = population;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country +
                ", district='" + district + '\'' +
                ", population=" + population +
                '}';
    }
}