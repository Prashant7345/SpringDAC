package com.met.model;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*<bean id="trainingWorkshop" class="com.met.model.TrainingWorkshop" autowire="constructor">
	
</bean>*/
	
/*<bean id="trainingWorkshop" class="com.met.model.TrainingWorkshop"     -> @Component  */
/*autowire="constructor"   ->  on 1 constructor @Autowired*/


@Component				//<bean id="trainingWorkshop" class="com.met.model.TrainingWorkshop"  
public class TrainingWorkshop implements Workshop {

	private TrainingCompany trainingCompany;
	
	public TrainingWorkshop() {
		super();
		System.out.println("TrainingWorkshop default constructor invoked");
	}

	@Autowired
	public TrainingWorkshop(TrainingCompany trainingCompany) {
		super();
		this.trainingCompany = trainingCompany;
		System.out.println("TrainingWorkshop Parameterized constructor invoked");
	}
	
/*	public TrainingWorkshop(TrainingCompany trainingCompany, DataSource ds) {
		super();
		this.trainingCompany = trainingCompany;
		System.out.println("TrainingWorkshop Parameterized constructor invoked with DataSource");
	}*/

	public TrainingCompany getTrainingCompany() {
		return trainingCompany;
	}

	public void setTrainingCompany(TrainingCompany trainingCompany) {
		this.trainingCompany = trainingCompany;
	}

	@Override
	public void conductWorkshop() {
		System.out.println("TrainingWorkshop :: conductWorkshop");
		trainingCompany.conductTraining();

	}

}
