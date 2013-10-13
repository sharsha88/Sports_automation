package com.usatoday.testscripts;

import junit.framework.TestCase;

import org.junit.Test;

import com.usatoday.frameworkengine.Testexecutor;

public class NFLpstatAFCspl extends TestCase
{
	@Test
	public void testNFLpstatAFCspl()
	{
		try
		{
		System.out.println("inside testNFLpstatAFCspl test try block");
		Testexecutor executor = new Testexecutor();
		executor.executeTest(this.getClass().getSimpleName());
		}
		catch (Exception e)
		{
			System.out.println("inside testNFLpstatAFCspl test catch block");
			System.out.println(e);
		}
	}
}
