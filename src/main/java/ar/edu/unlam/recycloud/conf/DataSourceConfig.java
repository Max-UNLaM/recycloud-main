package ar.edu.unlam.recycloud.conf;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import static ar.edu.unlam.recycloud.conf.ConfigConstants.*;

@Configuration
@EnableTransactionManagement
public class DataSourceConfig {

    private static final String DEFAULT_ENV = LOCAL;
    private static final String DEFAULT_SQL_HOST = "localhost:3306";
    private final Environment environment;

    DataSourceConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean(name = "database")
    public HikariDataSource dataSource() {
        if (environment.getProperty(ENVIRONMENT_KEY, DEFAULT_ENV).equals(TEST)) {
            return getTestDataSource();
        } else {
            return getProdDataSource();
        }
    }

    private HikariDataSource getProdDataSource() {
        String host = environment.getProperty(SQL_HOST_KEY, DEFAULT_SQL_HOST);
        String db = environment.getProperty(SQL_DATABASE_KEY);
        String username = environment.getProperty(SQL_USER_KEY);
        String password = environment.getProperty(SQL_PASSWORD_KEY);

        return DataSourceBuilder.create().type(HikariDataSource.class)
                .username(username)
                .password(password)
                .url("jdbc:mysql://" + host + "/" + db + "?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false")
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }

    private HikariDataSource getTestDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class)
                .username("sa")
                .password("sa")
                .url("jdbc:h2:mem:testdb")
                .driverClassName("org.h2.Driver")
                .build();
    }

}
