package eis.edi.api.eisportal.common;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration("${PROJECT_HOME}/external_application.properties")
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties("eisportal.spring.datasource")
    public DataSourceProperties mssqlDataSourceProperties()
    {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource mssqlDataSource()
    {
        return mssqlDataSourceProperties()
        .initializeDataSourceBuilder()
        .build();
    }

    @Bean
    public JdbcTemplate mssqlJdbcTemplate(@Qualifier("mssqlDataSource") DataSource datasource)
    {
        return new JdbcTemplate(datasource);
    }

}
