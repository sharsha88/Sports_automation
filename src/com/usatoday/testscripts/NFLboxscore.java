package com.usatoday.testscripts;

import junit.framework.TestCase;

import org.junit.Test;

import com.usatoday.frameworkengine.Testexecutor;

public class NFLboxscore extends TestCase
{
	@Test
	public void testNFLboxscore()
	{
		try
		{
		System.out.println("inside testNFLboxscore test try block");
		Testexecutor executor = new Testexecutor();
		executor.executeTest(this.getClass().getSimpleName());
		}
		catch (Exception e)
		{
			System.out.println("inside testNFLboxscore test catch block");
			System.out.println(e);
		}
	}
}
