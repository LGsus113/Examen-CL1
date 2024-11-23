package pe.edu.i202221123.cl1_jpa_data_Medina_Lazaro.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConexionesConfig {
    @Value("${DB_WORLD_URL}")
    private String dbWorldUrl;

    @Value("${DB_WORLD_USER}")
    private String dbWorldUser;

    @Value("${DB_WORLD_PASS}")
    private String dbWorldPass;

    @Value("${DB_WORLD_DRIVER}")
    private String dbWorldDriver;

    @Bean
    public HikariDataSource hikariDataSource() {
        HikariConfig hc = new HikariConfig();

        hc.setJdbcUrl(dbWorldUrl);
        hc.setUsername(dbWorldUser);
        hc.setPassword(dbWorldPass);
        hc.setDriverClassName(dbWorldDriver);

        hc.setMaximumPoolSize(30);
        hc.setMinimumIdle(4);
        hc.setIdleTimeout(240000);
        hc.setConnectionTimeout(45000);

        System.out.println("###### HikariCP initialized ######");
        return new HikariDataSource(hc);
    }
}
