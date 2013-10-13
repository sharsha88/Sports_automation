package com.usatoday.testscripts;

import junit.framework.TestCase;

import org.junit.Test;

import com.usatoday.frameworkengine.Testexecutor;

public class NHLScoreCards extends TestCase
{
	@Test
	public void testNHLScoreCards()
	{
		try
		{
			System.out.println("inside testNHLScoreCards test try block");
			Testexecutor executor = new Testexecutor();
			executor.executeTest(this.getClass().getSimpleName());
		}
		catch (Exception e)
		{
			System.out.println("inside testNHLScoreCards test catch block");
			System.out.println(e);
		}
	}
}
