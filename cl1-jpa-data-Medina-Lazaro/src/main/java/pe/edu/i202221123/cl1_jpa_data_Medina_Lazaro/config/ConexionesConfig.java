package pe.edu.i202221123.cl1_jpa_data_Medina_Lazaro.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConexionesConfig {
    @Value("${DB_SAKILA_URL}")
    private String dbSakilaUrl;

    @Value("${DB_SAKILA_USER}")
    private String dbSakilaUser;

    @Value("${DB_SAKILA_PASS}")
    private String dbSakilaPass;

    @Value("${DB_SAKILA_DRIVER}")
    private String dbSakilaDriver;

    @Bean
    public HikariDataSource hikariDataSource() {
        HikariConfig hc = new HikariConfig();

        hc.setJdbcUrl(dbSakilaUrl);
        hc.setUsername(dbSakilaUser);
        hc.setPassword(dbSakilaPass);
        hc.setDriverClassName(dbSakilaDriver);

        hc.setMaximumPoolSize(30);
        hc.setMinimumIdle(4);
        hc.setIdleTimeout(240000);
        hc.setConnectionTimeout(45000);

        System.out.println("###### HikariCP initialized ######");
        return new HikariDataSource(hc);
    }
}
