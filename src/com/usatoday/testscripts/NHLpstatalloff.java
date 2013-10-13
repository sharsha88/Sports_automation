package com.usatoday.testscripts;

import junit.framework.TestCase;

import org.junit.Test;

import com.usatoday.frameworkengine.Testexecutor;

public class NHLpstatalloff extends TestCase
{
	@Test
	public void testNHLpstatalloff()
	{
		try
		{
		System.out.println("inside testNHLpstatalloff test try block");
		Testexecutor executor = new Testexecutor();
		executor.executeTest(this.getClass().getSimpleName());
		}
		catch (Exception e)
		{
			System.out.println("inside testNHLpstatalloff test catch block");
			System.out.println(e);
		}
	}
}
