package com.usatoday.testscripts;

import junit.framework.TestCase;

import org.junit.Test;

import com.usatoday.frameworkengine.Testexecutor;


public class NHLHeader extends TestCase
{
	@Test
	public void testNHLHeader()
	{
		try
		{
			System.out.println("inside testNHLHeader test try block");
			Testexecutor executor = new Testexecutor();
			executor.executeTest(this.getClass().getSimpleName());
		}
		catch (Exception e)
		{
			System.out.println("inside testNHLHeader test catch block");
			System.out.println(e);
		}
	}

}
