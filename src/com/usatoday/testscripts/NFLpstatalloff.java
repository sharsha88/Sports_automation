package com.usatoday.testscripts;

import junit.framework.TestCase;

import org.junit.Test;

import com.usatoday.frameworkengine.Testexecutor;

public class NFLpstatalloff extends TestCase
{
	@Test
	public void testNFLpstatalloff()
	{
		try
		{
		System.out.println("inside testNFLpstatalloff test try block");
		Testexecutor executor = new Testexecutor();
		executor.executeTest(this.getClass().getSimpleName());
		}
		catch (Exception e)
		{
			System.out.println("inside testNFLpstatalloff test catch block");
			System.out.println(e);
		}
	}
}
