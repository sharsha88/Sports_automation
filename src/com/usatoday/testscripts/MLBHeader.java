package com.usatoday.testscripts;

import junit.framework.TestCase;

import org.junit.Test;

import com.usatoday.frameworkengine.Testexecutor;

public class MLBHeader extends TestCase
{
	@Test
	public void testMLBHeader()
	{
		try
		{
		System.out.println("inside testNFLHeader test try block");
		Testexecutor executor = new Testexecutor();
		executor.executeTest(this.getClass().getSimpleName());
		}
		catch (Exception e)
		{
			System.out.println("inside testMLBHeader test catch block");
			System.out.println(e);
		}
	}

}


