package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.niit")
public class DBConfig {

public DataSource getH2DataSource()
{	
		DriverManagerDataSource drivermanager = new DriverManagerDataSource();
		drivermanager.setDriverClassName("org.h2.Driver");
		drivermanager.setUrl(" jdbc:h2:tcp://localhost/~/project1");
		drivermanager.setUsername("ab");
		drivermanager.setPassword("99");
		return drivermanager;
}

@Bean(name="sessionFactory")
public SessionFactory getSessionFactory()
{
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.put("hibernate.show_sql", "true");
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		
		LocalSessionFactoryBuilder locsessionbuilder = new LocalSessionFactoryBuilder(getH2DataSource());
		locsessionbuilder.addProperties(hibernateProperties);
		locsessionbuilder.addAnnotatedClass(Category.class);
		locsessionbuilder.addAnnotatedClass(Product.class);
		locsessionbuilder.addAnnotatedClass(Supplier.class);
		
		SessionFactory sessionFactory = locsessionbuilder.buildSessionFactory();
		System.out.println("Session Factory Object created");
		return sessionFactory;
		
}

@Bean
public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
{
	HibernateTransactionManager hibernatetransmanager = new HibernateTransactionManager(sessionFactory);
	return hibernatetransmanager;
}

}
