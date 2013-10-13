package com.usatoday.testscripts;

import junit.framework.TestCase;

import org.junit.Test;

import com.usatoday.frameworkengine.Testexecutor;

public class SportsFrontModules extends TestCase
{
	@Test
	public void testSportsFrontModules()
	{
		try
		{
		System.out.println("inside SportsFrontModules test try block");
		Testexecutor executor = new Testexecutor();
		executor.executeTest(this.getClass().getSimpleName());
		}
		catch (Exception e)
		{
			System.out.println("inside SportsFrontModules test catch block");
			System.out.println(e);
		}
	}

}
