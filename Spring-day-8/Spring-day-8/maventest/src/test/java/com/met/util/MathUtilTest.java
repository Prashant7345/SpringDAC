package com.met.util;

import org.junit.Assert;
import org.junit.Test;

public class MathUtilTest {

	MathUtil mathUtil = new MathUtil();
	
	@Test
	public void testAdd(){
		
		long actualResult = mathUtil.add(10, 20);
		
		long businessExpectedOutput = 30;
		
		Assert.assertEquals(businessExpectedOutput, actualResult);
		
		
	}
	
}
