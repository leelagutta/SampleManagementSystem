package com.dhanya.service.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.dhanya.service.repository.CustomerRepository;
import com.dhanya.service.repository.CustomerRepositoryImpl;

@Configuration
public class TestBeansConfig {

	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL)
				.addScript("classpath:db/dbSchema.sql")
				.addScript("classpath:db/testData.sql").build();
	}

	@Bean
	@Autowired
	public CustomerRepository customerRepository() {
		CustomerRepository repository = new CustomerRepositoryImpl(dataSource());
		return repository;
	}
}
