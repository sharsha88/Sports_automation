package com.usatoday.testscripts;

import junit.framework.TestCase;

import org.junit.Test;

import com.usatoday.frameworkengine.Testexecutor;

public class NFLSchedules extends TestCase
{
	@Test
	public void testNFLSchedules()
	{
		try
		{
			System.out.println("inside testNFLSchedules test try block");
			Testexecutor executor = new Testexecutor();
			executor.executeTest(this.getClass().getSimpleName());
		}
		catch (Exception e)
		{
			System.out.println("inside testNFLSchedules test catch block");
			System.out.println(e);
		}
	}

}
