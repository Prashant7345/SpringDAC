package com.met.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.met.model.Trainer;

public class TrainingTest {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("training.xml");
		
		Trainer trainer = context.getBean(Trainer.class);
		System.out.println(trainer);
		trainer.train();
		
		
		
	}
	
}
