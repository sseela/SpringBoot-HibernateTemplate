package com.example.HibernateTemplate;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@org.springframework.context.annotation.Configuration
@EnableJpaRepositories(basePackages= {"com.example.HibernateTemplate"})
@EnableTransactionManagement
public class Configuration {
	
	@ConfigurationProperties(value="spring.datasource")
	@Bean
	public DataSource createDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(value="sessionFactory")
	public LocalSessionFactoryBean buildSessionFactory(DataSource datasource) {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
		
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		sf.setDataSource(datasource);
		sf.setHibernateProperties(hibernateProperties);
		sf.setPackagesToScan(new String[] {"com.example.HibernateTemplate"});
		
		return sf;
	}
	
	@Bean
	public HibernateTransactionManager buildTxMan(@Qualifier(value="sessionFactory") SessionFactory sf) {
		return new HibernateTransactionManager(sf);
	}
	
	
	//If we want to use HibernateTemplate, then we have to add this extra configuration
	
	@Bean
	public HibernateTemplate getHibernateTemplate(@Qualifier(value="sessionFactory") SessionFactory sf) {
		return new HibernateTemplate(sf);
	}
	
}
