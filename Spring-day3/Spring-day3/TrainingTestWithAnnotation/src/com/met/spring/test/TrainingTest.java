package com.met.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.met.model.Trainer;
import com.met.model.TrainingCompany;
import com.met.model.Workshop;

public class TrainingTest {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("training.xml");
		
		/*Trainer trainer = context.getBean(Trainer.class);
		System.out.println(trainer);
		trainer.train();
		
		TrainingCompany trainingCompany = (TrainingCompany) context.getBean("metSolutions");
		//trainingCompany.conductTraining();
		*/
		Workshop trainingWorkshop = context.getBean("trainingWorkshop", Workshop.class);
		trainingWorkshop.conductWorkshop();
		
	}
	
}
