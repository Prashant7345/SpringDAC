package com.met.model;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/*<bean id="metSolutions" class="com.met.model.METSolutions" autowire="byType">
	
	</bean>*/


/*<bean id="metSolutions" class="com.met.model.METSolutions"  -> @Component*/
/*autowire="byType"     -> @AUtowired on property*/

@Component("metSolutions")						//METSolutions -> mETSolutions -> METSolutions
public class METSolutions implements TrainingCompany {

	/*@Autowired
	@Qualifier("javaTrainer2")
	private Trainer trainer;
	
	@Autowired(required=false)
	private DataSource dataSource;
	
	public METSolutions(){
		System.out.println("METSolutions default constructor invoked");
	}
	
	public METSolutions(Trainer trainer) {
		
		this.trainer = trainer;
		System.out.println("METSolutions Parameterized constructor invoked");
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	@Override
	public void conductTraining() {
		System.out.println("METSolutions :: conductTraining");
		System.out.println("DataSOurce :: " + dataSource);
		try {
			dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		trainer.train();

	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "METSolutions is a Training company";
	}
*/
	
	@Autowired
	//@Qualifier("javaTrainer2")
	private List<Trainer> trainers;
	
	/*@Autowired(required=false)
	private DataSource dataSource;*/
	
	public METSolutions(){
		System.out.println("METSolutions default constructor invoked");
	}
	
	public METSolutions(List<Trainer> trainers) {
		
		this.trainers = trainers;
		System.out.println("METSolutions Parameterized constructor invoked");
	}

	

	public List<Trainer> getTrainers() {
		return trainers;
	}

	public void setTrainers(List<Trainer> trainers) {
		this.trainers = trainers;
	}

	@Override
	public void conductTraining() {
		System.out.println("METSolutions :: conductTraining");

		
		for(Trainer trainer : trainers){
			trainer.train();
		}

	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "METSolutions is a Training company";
	}

	
	
	
}
