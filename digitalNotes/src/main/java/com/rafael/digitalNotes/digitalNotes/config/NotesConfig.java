
package com.rafael.digitalNotes.digitalNotes.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@PropertySource("classpath:application.properties")
public class NotesConfig implements WebMvcConfigurer {
    public final Environment environment;

    @Autowired
    public NotesConfig(Environment environment) {
        this.environment = environment;
    }
    
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(this.environment.getProperty("driver"));
        dataSource.setUrl(this.environment.getProperty("url"));
        dataSource.setUsername(this.environment.getProperty("username_value"));
        dataSource.setPassword(this.environment.getProperty("password"));

        return dataSource;
    }
    
    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
    
    
}
