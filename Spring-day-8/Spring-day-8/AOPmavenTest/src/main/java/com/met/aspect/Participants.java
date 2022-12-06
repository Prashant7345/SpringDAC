package com.met.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component

@Aspect
@EnableAspectJAutoProxy
public class Participants {

	@Pointcut("execution(* *.train(..))")				//execution -> Method Execution
	public void training(){}							// 1 -> any return type
														//2 -> Any Classname
														// .. -> o, 1....n arguements
	/*@Before("training()")
	public void swiftchOffPhones(){
		System.out.println("Participants are Joining zoom");
	}
	
	@Before("training()")
	public void takeSeats(){											//Before JDBC connection
		System.out.println("Participants are taking seats");
	}
	
	@AfterReturning("training()")													//commit code
	public void trainingSuccess(){
		System.out.println("Training completed successfully.........");
	}
	
	
	@AfterThrowing("training()")
	public void trainingFailure(){													//exception handling code
		System.out.println("Training was failure...........");
	}
	
	
	
	@After("training()")
	public void trainingCompleted(){									//Finally block
		System.out.println("Training completed");	
	}*/
	
	
	//@Around -> @Before + @AfterReturning + @AFterThrowing + @After
	
	
	@Around("training()")
	public void aroundTraining(ProceedingJoinPoint pjp){
		
		try{
			System.out.println("Participants are Joining zoom");			//@Before
			System.out.println("Participants are taking seats");
			
			pjp.proceed();														//actual business logic
			
			System.out.println("Training completed successfully.........");		//@AFterReturning
			
		}catch(Throwable t){
			System.out.println("Training was failure...........");				//@AfterThrowing
		}finally {
			System.out.println("Training completed");							//@After
		}
		
		
	}
	
	
}










