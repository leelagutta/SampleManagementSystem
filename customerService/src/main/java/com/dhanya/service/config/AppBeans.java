package com.dhanya.service.config;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.dhanya.service.repository.CustomerRepository;
import com.dhanya.service.repository.CustomerRepositoryImpl;

/**
 *	Common application beans that shared during runtime. 
 * 
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.dhanya.*" })
@PropertySource("classpath:/common.properties")
public class AppBeans extends WebMvcConfigurerAdapter {
	
	@Autowired
	private Environment env;

	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	

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