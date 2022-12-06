package com.met.model;

public class TrainingWorkshop implements Workshop {

	private TrainingCompany trainingCompany;
	
	public TrainingWorkshop() {
		super();
		System.out.println("TrainingWorkshop default constructor invoked");
	}

	public TrainingWorkshop(TrainingCompany trainingCompany) {
		super();
		this.trainingCompany = trainingCompany;
		System.out.println("TrainingWorkshop Parameterized constructor invoked");
	}

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
