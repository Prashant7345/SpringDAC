package com.met.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.met.model.Employee;

@Configuration
@EnableTransactionManagement     //<tx:annotation-driven transaction-manager="hibernateTransactionManager"/>
@EnableWebMvc					 //<mvc:annotation-driven />
@ComponentScan(basePackages="com.met.*")	//<context:component-scan base-package="com.met.*"></context:component-scan>
public class MVCConfig {

	/*<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="prefix">
			<value>/WEB-INF/pages/</value>
		</property>
		<property name="suffix">
			<value>.jsp</value>
		</property>
	</bean>*/
	
	@Bean
	public ViewResolver viewResolver(){
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
		
	}
	
	/*<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<property name="driverClassName" value="oracle.jdbc.OracleDriver" />
		<property name="url" value="jdbc:oracle:thin:@localhost:1521:XE" />
		<property name="username" value="system" />
		<property name="password" value="admin123" />
	</bean>*/
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("system");
		dataSource.setPassword("admin123");
		
		return dataSource;
	}
	
	/*<bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
		<property name="dataSource" ref="dataSource"></property>
	</bean>*/
	
	@Bean
	public JdbcTemplate jdbcTemplate(){
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		
		return jdbcTemplate;
	}
	
	
	/*<bean id="sessionFactoryBean" class="org.springframework.orm.hibernate4.LocalSessionFactoryBean">
	<property name="dataSource" ref="dataSource"></property>
    	<property name="annotatedClasses">
    		<list>
    			<value>com.met.model.Employee</value>
    			<!-- <value>com.met.model.Account</value> -->
    		</list>
    	</property>
    	<property name="hibernateProperties">
    		<props>
    			<prop key="hibernate.dialect">org.hibernate.dialect.Oracle10gDialect</prop>
    			<prop key="hibernate.show_sql">true</prop>
    		</props>
    	</property>
 	</bean>*/
	
	@Bean
	public LocalSessionFactoryBean localSessionFactoryBean(){
		
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setAnnotatedClasses(Employee.class);
		
		sessionFactoryBean.setHibernateProperties(properties());
		
		return sessionFactoryBean;
		
	}
	
	@Bean
	public Properties properties(){
		
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		properties.setProperty("hibernate.show_sql", "true");
		
		return properties;
	}
	
	/*
	 <bean id="hibernateTransactionManager" class="org.springframework.orm.hibernate4.HibernateTransactionManager">
		<property name="sessionFactory" ref="sessionFactoryBean"></property>
	 </bean>*/
	
	@Bean
	public HibernateTransactionManager htm(SessionFactory sf){
		
		HibernateTransactionManager htm = new HibernateTransactionManager();
		htm.setSessionFactory(sf);
		
		return htm;
		
	}
	
	
	
}
