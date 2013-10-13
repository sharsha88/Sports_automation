package com.usatoday.testscripts;

import junit.framework.TestCase;

import org.junit.Test;

import com.usatoday.frameworkengine.Testexecutor;

public class NHLrecap extends TestCase
{
	@Test
	public void testNHLrecap()
	{
		try
		{
		System.out.println("inside testNHLrecap test try block");
		Testexecutor executor = new Testexecutor();
		executor.executeTest(this.getClass().getSimpleName());
		}
		catch (Exception e)
		{
			System.out.println("inside testNHLrecap test catch block");
			System.out.println(e);
		}
	}
}
