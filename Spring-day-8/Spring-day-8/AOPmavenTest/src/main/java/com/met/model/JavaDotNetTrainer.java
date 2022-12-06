package com.met.model;

import java.util.List;
import java.util.Random;

public class JavaDotNetTrainer {

		private String name;
		private List<String> subjects;
		
		public JavaDotNetTrainer() {
			System.out.println("JavaDotNetTrainer default constructor invoked...");
		}

		public JavaDotNetTrainer(String name, List<String> subjects) {
			super();
			this.name = name;
			this.subjects = subjects;
			System.out.println("JavaDotNetTrainer Param constructor invoked...");
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<String> getSubjects() {
			return subjects;
		}

		public void setSubjects(List<String> subjects) {
			this.subjects = subjects;
		}

		public void train() {
			
			/*System.out.println("Participants are taking seats");							//Before Training
			System.out.println("Participants are switching off phones");*/
			
			/*Random rnd = new Random();
			int nextValue = rnd.nextInt(10);
			
			if(nextValue < 5){
				throw new RuntimeException("Training was failure");
			}
			*/
			
			System.out.println("JavaDotNetTrainer :: train");
			System.out.println(name + " is training on JavaDotNet subjects " + subjects);			//Business logic

			
			/*System.out.println("Training completed");		*/								//After TRaining
			
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return name + " is a JavaDotNetTrainer";
		}
		
	}

