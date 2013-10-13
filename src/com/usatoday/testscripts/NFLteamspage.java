package com.usatoday.testscripts;

import junit.framework.TestCase;

import org.junit.Test;

import com.usatoday.frameworkengine.Testexecutor;

public class NFLteamspage extends TestCase
{
	@Test
	public void testNFLteamspage()
	{
		try
		{
		System.out.println("inside testNFLteamspage test try block");
		Testexecutor executor = new Testexecutor();
		executor.executeTest(this.getClass().getSimpleName());
		}
		catch (Exception e)
		{
			System.out.println("inside testNFLteamspage test catch block");
			System.out.println(e);
		}
	}
}
