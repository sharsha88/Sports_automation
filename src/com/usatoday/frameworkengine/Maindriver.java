package com.usatoday.frameworkengine;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

import org.openqa.selenium.WebDriver;

import com.usatoday.Libraries.Configurations;
import com.usatoday.Libraries.ExcelLibrary;
import com.usatoday.Libraries.Reports;
import com.usatoday.Libraries.ProjectSpecificComponents;

public class Maindriver
{
	public static WebDriver driver;
	public static String scrptNm;
	public static Configurations config ;
	public static String testpath;
	public static String rspath;
	public static String Sports;
	public static String finalrp;
	
	public static void main(String[] args) throws Exception
	{
		ProjectSpecificComponents pjs = new ProjectSpecificComponents();
		try
		{
			pjs.modularsetup();
		}
		catch (Exception e)
		{
			e.printStackTrace(); 
		}
		Thread.sleep(1000);
		Reports report = new Reports();
		try
		{
		report.CreateFinalReport();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		ExcelLibrary exl = new ExcelLibrary();
		finalrp = exl.getExcelData(System.getProperty("user.dir")+"\\Modular.xlsx", "FinalReport", 1, 1);
		int rows = exl.getRowCount(System.getProperty("user.dir")+"\\Modular.xlsx", "Sports");
		for(int i=1; i<=rows;i++)
		{   
			String exestatus = exl.getExcelData(System.getProperty("user.dir")+"\\Modular.xlsx", "Sports", i, 2);
			Sports = exl.getExcelData(System.getProperty("user.dir")+"\\Modular.xlsx", "Sports", i, 1);
			Reports.failcntr=0;
			Reports.passcntr=0;
			Reports.slno=1;
			if(exestatus.equalsIgnoreCase("yes"))
			{
				System.out.println("Executing "+Sports+ "Test Cases");
				testpath = exl.getExcelData(System.getProperty("user.dir")+"\\Modular.xlsx", "Sports", i, 3);
				rspath = exl.getExcelData(System.getProperty("user.dir")+"\\Modular.xlsx", "Sports", i, 4);
				
				try
				{
				Maindriver.Start();
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				if(Reports.failcntr > 0)
				{
					System.out.println(Reports.failcntr);
					try
					{
					report.writeFail(Sports, "FAIL");
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
					
				}
				if(Reports.failcntr == 0)
				{
					System.out.println(Reports.passcntr);
					try
					{
					report.writePass(Sports, "PASS");
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
				}
			}
		}
		
		pjs.openhtml(finalrp);
	}	
	
		public static void Start() throws ClassNotFoundException
		{
			config = new Configurations();
			ProjectSpecificComponents prjspec = new ProjectSpecificComponents();
			try
			{
				prjspec.VerifyTestEnv(config.Browser, config.Environment, config.Url);
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			driver = ProjectSpecificComponents.webdriver;
			
			try{
				System.out.println("inside Try");
				Reports report = new Reports(Maindriver.scrptNm);
				report.createSummaryFile();
			}
			catch(Exception e){
				System.out.println("inside exception");
				System.out.println(e);
			}
			
			TestRunner.run(Maindriver.suiteToRun());
			driver.quit();
		}
		public static Test suiteToRun() throws ClassNotFoundException
		{
			TestSuite suite = new TestSuite();
			ExcelLibrary lib=new ExcelLibrary();
			config = new Configurations();
			
			int numOfScenarios = lib.getRowCount(config.Testpath, "Scenarios");
			for(int j=1;j<=numOfScenarios;j++)
			{
				String execStatus = lib.getExcelData(config.Testpath, "Scenarios", j, 1);
				if(execStatus.equalsIgnoreCase("yes"))
				{
					System.out.println("inside exe status:");
					scrptNm = lib.getExcelData(config.Testpath, "Scenarios", j, 0);	
					Class scriptName = Class.forName("com.usatoday.testscripts."+scrptNm);
					System.out.println(scriptName);
					suite.addTestSuite(scriptName);
					System.out.println("going out exe status:");
				}
			}		
			
			return suite;
		}

//		Thread.sleep(1000);
//		driver.quit();
		
//		driver.findElement(By.xpath(xpathExpression))
		
}
	
