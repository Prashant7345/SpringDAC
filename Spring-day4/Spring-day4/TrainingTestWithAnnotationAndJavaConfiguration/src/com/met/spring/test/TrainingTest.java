package com.met.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.met.config.TrainingConfiguration;
import com.met.model.JavaTrainer;
import com.met.model.Workshop;

public class TrainingTest {

	public static void main(String[] args) {
		
		/*ApplicationContext context = new ClassPathXmlApplicationContext("training.xml");*/
		
		
		ApplicationContext context = new AnnotationConfigApplicationContext(TrainingConfiguration.class);
		
		/*Trainer trainer = context.getBean(Trainer.class);
		System.out.println(trainer);
		trainer.train();
		
		TrainingCompany trainingCompany = (TrainingCompany) context.getBean("metSolutions");
		//trainingCompany.conductTraining();
		*/
		
		/*Trainer trainer = context.getBean("javaTrainer1", Trainer.class);
		System.out.println(trainer);
		trainer.train();*/
		
		JavaTrainer trainer = context.getBean("javaTrainer1", JavaTrainer.class);
		System.out.println("Java Trainer class name :: " + trainer.getClass());
		trainer.train();
		
		
		
		
		Workshop trainingWorkshop = context.getBean("trainingWorkshop", Workshop.class);
		trainingWorkshop.conductWorkshop();
		
	}
	
}
