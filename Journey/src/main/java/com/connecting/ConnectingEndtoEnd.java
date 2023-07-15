package com.connecting;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com")
@PropertySource("classpath:spring.properties")
public class ConnectingEndtoEnd {

	@Bean
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver irvr=new InternalResourceViewResolver();
		irvr.setPrefix("/WEB-INF/views/");
		irvr.setSuffix(".jsp");
		return irvr;
	}
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dmds=new DriverManagerDataSource();
		dmds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dmds.setUrl("jdbc:mysql://localhost:3306/babu");
		dmds.setUsername("root");
		dmds.setPassword("root");
		return dmds;
		
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate template=new JdbcTemplate(getDataSource());
		
		
		return template;
	}

}
