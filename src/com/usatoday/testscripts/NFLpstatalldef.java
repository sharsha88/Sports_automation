package com.usatoday.testscripts;

import junit.framework.TestCase;

import org.junit.Test;

import com.usatoday.frameworkengine.Testexecutor;

public class NFLpstatalldef extends TestCase
{
	@Test
	public void testNFLpstatalldef()
	{
		try
		{
		System.out.println("inside testNFLpstatalldef test try block");
		Testexecutor executor = new Testexecutor();
		executor.executeTest(this.getClass().getSimpleName());
		}
		catch (Exception e)
		{
			System.out.println("inside testNFLpstatalldef test catch block");
			System.out.println(e);
		}
	}
}
