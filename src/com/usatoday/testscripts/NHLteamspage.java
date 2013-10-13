package com.usatoday.testscripts;

import junit.framework.TestCase;

import org.junit.Test;

import com.usatoday.frameworkengine.Testexecutor;

public class NHLteamspage extends TestCase
{
	@Test
	public void testNHLteamspage()
	{
		try
		{
		System.out.println("inside testNHLteamspage test try block");
		Testexecutor executor = new Testexecutor();
		executor.executeTest(this.getClass().getSimpleName());
		}
		catch (Exception e)
		{
			System.out.println("inside testNHLteamspage test catch block");
			System.out.println(e);
		}
	}
}
