package io.github.cafeteru.webflux.config;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

@Configuration
@Slf4j
public class DBConfig extends AbstractR2dbcConfiguration {
    @Value("${spring.r2dbc.url}")
    private String dbUrl;

    @Override
    public ConnectionFactory connectionFactory() {
        return ConnectionFactories.get(dbUrl);
    }

    @Bean
    public ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
        var initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory);
        CompositeDatabasePopulator populator  = new CompositeDatabasePopulator();
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator(new ClassPathResource("sql/createTable.sql"));
        populator.addPopulators(resourceDatabasePopulator);
        initializer.setDatabasePopulator(populator);
        return initializer;
    }
}
