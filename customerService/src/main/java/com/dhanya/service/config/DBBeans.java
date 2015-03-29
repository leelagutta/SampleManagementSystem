package com.dhanya.service.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.dhanya.service.repository.CustomerRepository;
import com.dhanya.service.repository.CustomerRepositoryImpl;

/**
 * Provide Database beans to the web application during runtime. Beans are sharable across the application.
 * @author Leela Gutta
 */
@Configuration
@PropertySource("classpath:/common.properties")
public class DBBeans {
	
	@Autowired
	private Environment env;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(
				env.getProperty("dataSource.url"), env.getProperty("dataSource.user"), env.getProperty("dataSource.password"));
		dataSource.setDriverClassName(env.getProperty("dataSource.driverClass"));
		return dataSource;
	}

	@Bean
	public CustomerRepository customerRepository() {
		CustomerRepository repository = new CustomerRepositoryImpl(dataSource());
		return repository;
	}
}