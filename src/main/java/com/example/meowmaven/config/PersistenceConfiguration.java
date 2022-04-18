package com.example.meowmaven.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfiguration {
    // A datasource BEAN
    @Bean // aka @Component
    public DataSource dataSource() {
        DataSourceBuilder<?> builder = DataSourceBuilder.create();
        builder.url("jdbc:postgresql://localhost@5432/meowmaven");
        System.out.println("Datasource BEAN!!!!");
        return builder.build();
    }
}
