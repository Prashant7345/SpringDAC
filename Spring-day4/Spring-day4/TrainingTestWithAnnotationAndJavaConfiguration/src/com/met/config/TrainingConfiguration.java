package com.met.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.annotation.Scope;

import com.met.model.DotNetTrainer;
import com.met.model.JavaTrainer;
import com.met.model.Trainer;

/*<beans  - > @Configuration*/

/*<context:component-scan base-package="com.met.*"></context:component-scan>    ->>    @ComponentScan*/


@Configuration
@ComponentScan(basePackages="com.met.*")
@PropertySource("classpath:app.properties")

public class TrainingConfiguration {

	/*<bean id="javaTrainer1" class="com.met.model.JavaTrainer" >
		<constructor-arg name="name" value="Ram"></constructor-arg>
		<constructor-arg name="subjects">
			<list>
				<value>OOPS</value>
				<value>JDBC</value>
				<value>COLLECTIONS</value>
			</list>
		</constructor-arg>
	</bean>*/
	
	/*<bean     ->    @Bean*/
	/*by default name of function is bean id . here it is "javaTrainer"*/
	
	
	@Value("${trainer1.name}")
	private String trainer1Name;
	
	@Value("#{${trainer1.subjects}}")
	private List<String> trainer1Subjects;
	
	@Bean("javaTrainer1")
	public Trainer javaTrainer(){
		
		/*List<String> subjects = new ArrayList<String>(3);
		subjects.add("OOPS");
		subjects.add("JDBC");
		subjects.add("COLLECTIONS");
		
		Trainer trainer = new JavaTrainer("Ram", subjects);*/
		
		Trainer trainer = new JavaTrainer(trainer1Name, trainer1Subjects);
		
		return trainer;
		
	}
	
	@Value("${trainer2.name}")
	private String trainer2Name;
	
	@Value("#{${trainer2.subjects}}")
	private List<String> trainer2Subjects;
		
	@Bean
	/*@Scope("prototype")
	@Lazy
	@Primary*/
	public Trainer javaTrainer2(){
		Trainer trainer = new JavaTrainer(trainer2Name, trainer2Subjects);
		
		return trainer;
		
	}
	
	
	@Value("${dotNetTrainer1.name:Jack}")
	private String dotNetTrainerName;
	
	@Value("#{${dotNetTrainer1.subjects}}")
	private List<String> dotNetTrainerSubjects;
	
	@Bean
	public Trainer dotNetTrainer(){
		
		Trainer dotNetTrainer = new DotNetTrainer(dotNetTrainerName, dotNetTrainerSubjects);
		
		return dotNetTrainer;
		
	}
	
}













