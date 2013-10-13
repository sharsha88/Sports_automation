package com.usatoday.testscripts;

import junit.framework.TestCase;

import org.junit.Test;

import com.usatoday.frameworkengine.Testexecutor;

public class NHLStandings extends TestCase
{
	@Test
	public void testNHLStandings()
	{
		try
		{
		System.out.println("inside testNHLStandings test try block");
		Testexecutor executor = new Testexecutor();
		executor.executeTest(this.getClass().getSimpleName());
		}
		catch (Exception e)
		{
			System.out.println("inside testNHLStandings test catch block");
			System.out.println(e);
		}
	}
}
