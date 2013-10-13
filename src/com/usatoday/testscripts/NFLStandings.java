package com.usatoday.testscripts;

import junit.framework.TestCase;

import org.junit.Test;

import com.usatoday.frameworkengine.Testexecutor;

public class NFLStandings extends TestCase
{
	@Test
	public void testNFLStandings()
	{
		try
		{
		System.out.println("inside testNFLStandings test try block");
		Testexecutor executor = new Testexecutor();
		executor.executeTest(this.getClass().getSimpleName());
		}
		catch (Exception e)
		{
			System.out.println("inside testNFLStandings test catch block");
			System.out.println(e);
		}
	}

}
