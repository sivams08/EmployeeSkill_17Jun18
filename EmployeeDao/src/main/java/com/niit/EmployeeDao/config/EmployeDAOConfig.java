package com.niit.EmployeeDao.config;



import java.util.Properties;

import javax.sql.DataSource;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages="com.niit")
@EnableTransactionManagement
public class EmployeDAOConfig {

	
	@Bean(name="dataSource")
	public DataSource dataSource() {
		
		DriverManagerDataSource datasourceObj = new DriverManagerDataSource();
		datasourceObj.setDriverClassName("org.h2.Driver");
		datasourceObj.setUrl("jdbc:h2:tcp://localhost/~/test");
		datasourceObj.setUsername("sa");
		datasourceObj.setPassword("");
		return datasourceObj;
				
	}
	
	public Properties getHibernateProperties() {
		
		Properties propertiesObj = new Properties();
		propertiesObj.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		propertiesObj.setProperty("hibernate.show_sql", "true");
		propertiesObj.setProperty("hibernate.hbm2ddl.auto", "update");		
		return propertiesObj;
	}
	
	@Autowired
	@Bean(name="sessionFact")
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
	
		LocalSessionFactoryBean sessionFacctoryObj = new LocalSessionFactoryBean();
		sessionFacctoryObj.setDataSource(dataSource);
		sessionFacctoryObj.setHibernateProperties(getHibernateProperties());
		sessionFacctoryObj.setPackagesToScan("com.niit");
		return sessionFacctoryObj;
	}
	
	@Bean(name="transactionManager")
	@Autowired
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFact) {
		
		HibernateTransactionManager hibernateTransObj = new HibernateTransactionManager();
		hibernateTransObj.setSessionFactory(sessionFact);
		return hibernateTransObj;
	}
	

}
