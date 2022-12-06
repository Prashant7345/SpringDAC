package com.met.model;

public class Stage {

	private static int count = 0;
	
	private static Stage stage = null;
	
	private Stage(){
		
		System.out.println("Stage Object created with id: " + ++count);
		
	}

	public static Stage getStage(){
		
		if(stage == null) stage = new Stage();
		
		return stage;
		
	}
	
}
