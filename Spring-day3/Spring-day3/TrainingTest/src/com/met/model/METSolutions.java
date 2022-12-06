package com.met.model;

import java.sql.SQLException;

import javax.sql.DataSource;

public class METSolutions implements TrainingCompany {

	private Trainer trainer;
	
	/*private DataSource dataSource;*/
	
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
/*		System.out.println("DataSOurce :: " + dataSource);
		try {
			dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/		trainer.train();

	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "METSolutions is a Training company";
	}

}
