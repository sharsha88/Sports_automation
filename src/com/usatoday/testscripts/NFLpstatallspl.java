package com.usatoday.testscripts;

import junit.framework.TestCase;

import org.junit.Test;

import com.usatoday.frameworkengine.Testexecutor;

public class NFLpstatallspl extends TestCase
{
	@Test
	public void testNFLpstatallspl()
	{
		try
		{
		System.out.println("inside testNFLpstatallspl test try block");
		Testexecutor executor = new Testexecutor();
		executor.executeTest(this.getClass().getSimpleName());
		}
		catch (Exception e)
		{
			System.out.println("inside testNFLpstatallspl test catch block");
			System.out.println(e);
		}
	}
}
