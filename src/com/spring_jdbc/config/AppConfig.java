package com.spring_jdbc.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages= {"com.spring_jdbc"})
public class AppConfig {

	@Bean
	public JdbcTemplate jdbc() {
		JdbcTemplate jdbc = new JdbcTemplate(getDataSource());
		
		return jdbc;
	}
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/spring_jdbc");
		dataSource.setUsername("root");
		dataSource.setPassword("Admin");
		return dataSource;
	}
}
