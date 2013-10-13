package com.usatoday.testscripts;

import junit.framework.TestCase;

import org.junit.Test;

import com.usatoday.frameworkengine.Testexecutor;

public class NFLrecap extends TestCase
{
	@Test
	public void testNFLrecap()
	{
		try
		{
		System.out.println("inside testNFLrecap test try block");
		Testexecutor executor = new Testexecutor();
		executor.executeTest(this.getClass().getSimpleName());
		}
		catch (Exception e)
		{
			System.out.println("inside testNFLrecap test catch block");
			System.out.println(e);
		}
	}
}
