package com.usatoday.Libraries;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.usatoday.frameworkengine.Maindriver;


public class Reports {
	public static String pth="";
	public int failcounter;
	public static int slno;
	public String scriptname;
	public static WebDriver drv1;
	public String Snapshotpath;
    public static int screencapcounter=1;
    public static int passcntr;
	public static int failcntr;
	public static int fslno=1;

	//Creating a Result Summary html Log file

	public Reports(String scrptname) 
	{
		drv1 = Maindriver.driver;
		this.scriptname=scrptname;
		
		try
		{
			this.failcounter=0;
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	public Reports() 
	{
//		passcntr = 0;
//		failcntr = 0;
	}

//********************************************************************************************************************
//Generic function name :createSummaryFile
//Description : To Create test automation summary file.
//********************************************************************************************************************

	public void createSummaryFile() throws IOException
	{
		try
		{
			System.out.println("Inside create summary Try block");

			Configurations config = new Configurations();
			String sfile=config.ResultPath; 
			System.out.println(sfile);
			Calendar c = new GregorianCalendar();
			String currtime=c.getTime().toString();
				
			
			String Browser =config.Browser;
			String Url=config.Url;
			String Os=config.Os;
			String BrowserVersion=config.BrowserVersion;
			String Env = config.Environment;
			String sport = config.sports;
			System.out.println(Url);
			BufferedWriter bw1 = new BufferedWriter(new FileWriter(sfile+"/"+sport+"_Summary.html"));

			bw1.write("<html>");
			bw1.write("<head>");
			bw1.write("<title>"+sport+" Test Results</title>");
			bw1.write("</head><body>");
	//		bw1.write("<table style=font-family:calibri  Align=center><tr><td width=200><img src=Usatoday_logo.jpg/></td><td width=500><B>Selenium Hybrid Automation Framework Implementation</B></td></tr></table>");
			bw1.write("<table style=font-family:arial border =1 cellspacing=1 frame=Vsides bgcolor=#CC9999 Align=Center>");
			bw1.write("<tr><th width=775>"+sport+" TestCases Execution Summary Report</th></tr>");
			bw1.write("</table>");
			bw1.write("<table style=font-family:calibri border =1 cellspacing=1 frame=Vsides bgcolor=6699FF Align=Center>");
			bw1.write("<tr><td  width=500 ><B>Execution Started Time</B></td><td width=270><B>" +currtime+ "</B></td></tr>");
			bw1.write("<tr><td  width=500 ><B>Application URL </B></td><td width=270><B>"+Url+"</B></td></tr>");
			bw1.write("<tr><td  width=500 ><B>Environment </B></td><td width=270><B>"+Env+"</B></td></tr>");
			bw1.write("<tr><td  width=500 ><B>Browser </B></td><td width=270><B>"+Browser+"</B></td></tr>");
			bw1.write("<tr><td  width=500 ><B>Browser Version </B></td><td width=270><B>"+BrowserVersion+"</B></td></tr>");
			bw1.write("<tr><td  width=500 ><B>Operating System </B></td><td width=270><B>"+Os+"</B></td></tr>");
			bw1.write("<tr><td  width=500 ><B>Automation Tool</B></td><td width=270><B>Selenium</B></td></tr></table><br/>");
			bw1.write("<table style=font-family:calibri border =2 cellspacing=1 frame=Vsides bgcolor=#E8E8E8 Align=Center><tr><td Align=Center width=50><B>SL NO</B></td><td Align=center width=632><B>TestScript Name</B></td><td width=80 Align=center><B>Result</B></td></tr>");
			bw1.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}


//********************************************************************************************************************
//Generic function name :writePassSummary
//Description : Writing Pass Message to the html log file
//********************************************************************************************************************
	
	public void writePassSummary(String scriptname, String status) throws IOException
	{
		try
		{
			Configurations config = new Configurations();
			String rpath = config.ResultPath;
			String sport = config.sports;
			BufferedWriter bw1 = new BufferedWriter(new FileWriter(rpath+"/"+sport+"_Summary.html",true));
			bw1.write("<tr><td Align=center>"+slno+"</td><td><a href="+scriptname+".html>"+scriptname+"</a></td><td bgcolor=#00FF00 Align=center>"+status+"</td></tr>");
			slno++;
			passcntr++;
			bw1.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}


//********************************************************************************************************************
//Generic function name :writeFailSummary
//Description : Writing Fail Message to the html log file
//********************************************************************************************************************
	
	public void writeFailSummary(String scriptname, String status) throws IOException
	{
		try
		{
			Configurations config = new Configurations();
			String rpath = config.ResultPath;
			System.out.println(rpath);
			String sport = config.sports;
			BufferedWriter bw1 = new BufferedWriter(new FileWriter(rpath+"/"+sport+"_Summary.html",true));
			bw1.write("<tr><td Align=center>"+slno+"</td><td><a href="+scriptname+".html>"+scriptname+"</a></td><td bgcolor=#FF0000 Align=center>"+status+"</td></tr>");
			slno++;
			failcntr++;
			bw1.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
//********************************************************************************************************************
//Generic function name :createLogFile
//Description : Creating Html Log File for the test script
//********************************************************************************************************************

	    public void createLogFile() throws IOException{
	            try{
	            Configurations config = new Configurations();
	            String rpath = config.ResultPath;
	            System.out.println(rpath);
	            Calendar c = new GregorianCalendar();
	            String currtime=c.getTime().toString();
	            BufferedWriter bw1 = new BufferedWriter(new FileWriter(rpath+"/"+scriptname+".html"));
	            bw1.write("<html><head><title>"+scriptname+"</title></head><body><table style=font-family:calibri border =1 cellspacing=1 frame=Vsides  bgcolor=6699FF Align=Center><tr><td><B>Test Case Name</B></td><td><B>"+scriptname+"</B></td></tr>");
	            bw1.write("<tr><td width=500 ><B>Execution Start Time</B></td><td width=270><B>"+currtime+"</B></td></tr></table><br/>");
	            bw1.write("<table style=font-family:calibri border =1 cellspacing=1 frame=Vsides bgcolor=#E8E8E8 Align=Center><tr><td Align=center><B>Step Description</B></td><td Align=center><B>Result</B></td></tr>");
	            bw1.close();
	            }
	            catch(Exception e){
	            System.out.println(e);
	            }
	    }
//********************************************************************************************************************
//Generic function name :writePassLog
//Description : Writing Pass message to the HTML log file
//********************************************************************************************************************

	    public void writePassLog(String desc) throws IOException{
	            try{
	            Configurations config = new Configurations();
	            String rpath = config.ResultPath;
	            BufferedWriter bw1 = new BufferedWriter(new FileWriter(rpath+"/"+scriptname+".html",true));
	            bw1.write("<tr><td width=690>"+desc+"</td><td width=80 bgcolor=#00FF00 Align=center >PASS</td></tr>");
	            bw1.close();
	            }
	            catch(Exception e){
	            System.out.println(e);
	            }
	    }

//********************************************************************************************************************
//Generic function name :writeFailLog
//Description : Writing Fail message to the HTML log file
//********************************************************************************************************************

	    public void writeFailLog(String desc) throws Exception{
	            try{
	            Configurations config = new Configurations();
	            String rpath = config.ResultPath;
	            System.out.println(rpath);
	            Capturescreenshot(scriptname);
	            BufferedWriter bw1 = new BufferedWriter(new FileWriter(rpath+"/"+scriptname+".html",true));
	            bw1.write("<tr><td width=690><a href="+Snapshotpath+">"+desc+"</a></td><td width=80 bgcolor=#FF0000 Align=center >FAIL</td></tr>");
	            bw1.close();
	            this.failcounter++;
	            }
	            catch(Exception e){
	            System.out.println(e);
	            }
	    }
	    
//********************************************************************************************************************
//Generic function name :Capturescreenshot
//Description : Capture the screen shot and store in the Result folder
//********************************************************************************************************************

	    public void Capturescreenshot(String scriptname)throws Exception
	    {
	    	//Random rn=new Random();
	    	//int rnum=rn.nextInt(1000);
	    	//Date dt = new Date();
	    	//String timestamp=dt.toString().replace(":","_");

	    	Configurations config = new Configurations();
	    	String rpath = config.ResultPath;
	    	try 
	    	{
	    		File srcFile = ((TakesScreenshot)drv1).getScreenshotAs(OutputType.FILE);
	    		//Once we have the screenshot in our file 'srcFile' you can use all FileUtils methods like
	    		Snapshotpath = rpath+scriptname+screencapcounter+".png";
	    		srcFile.renameTo( new File(Snapshotpath));
	    	} 
	    	catch (Exception e) 
	    	{
	    		e.printStackTrace();
	    	}
	    	screencapcounter++;

	    }
	    
//********************************************************************************************************************
//Generic function name :CreateFinalReport
//Description : To Create Final Text Execution Report
//********************************************************************************************************************	    
	    public void CreateFinalReport() throws IOException
		{
			try
			{
				System.out.println("Inside Final Text Execution Report");

				Configurations config = new Configurations();
				Thread.sleep(1000);
				String Ffile=config.FinalReportPath; 
				
				System.out.println(Ffile);
				Calendar c = new GregorianCalendar();
				String currtime=c.getTime().toString();
					
				
				String Browser =config.Browser;
				String Url=config.Url;
				String Os=config.Os;
				String BrowserVersion=config.BrowserVersion;
				String Env = config.Environment;
				System.out.println(Url);
				
				BufferedWriter bw1 = new BufferedWriter(new FileWriter(Ffile+"/Test_Automation_Report.html"));
				bw1.write("<html>");
				bw1.write("<head>");
				bw1.write("<title>Result Summary</title>");
				bw1.write("</head><body>");
				//bw1.write("<table style=font-family:calibri  Align=center><tr><td width=200><img src=./Logo/marlabslogo.jpg/></td><td width=500><B>Selenium Hybrid Automation Framework Implementation</B></td></tr></table>");
				bw1.write("<table style=font-family:arial border =1 cellspacing=1 frame=Vsides bgcolor=#CC9999 Align=Center>");
				bw1.write("<tr><th width=775>USA TODAY - Automation Test Execution Summary Report</th></tr>");
				bw1.write("</table>");
				bw1.write("<table style=font-family:calibri border =1 cellspacing=1 frame=Vsides bgcolor=6699FF Align=Center>");
				bw1.write("<tr><td  width=500 ><B>Execution Started Time</B></td><td width=270><B>" +currtime+ "</B></td></tr>");
				bw1.write("<tr><td  width=500 ><B>Application URL </B></td><td width=270><B>"+Url+"</B></td></tr>");
				bw1.write("<tr><td  width=500 ><B>Environment </B></td><td width=270><B>"+Env+"</B></td></tr>");
				bw1.write("<tr><td  width=500 ><B>Browser </B></td><td width=270><B>"+Browser+"</B></td></tr>");
				bw1.write("<tr><td  width=500 ><B>Browser Version </B></td><td width=270><B>"+BrowserVersion+"</B></td></tr>");
				bw1.write("<tr><td  width=500 ><B>Operating System </B></td><td width=270><B>"+Os+"</B></td></tr>");
				bw1.write("<tr><td  width=500 ><B>Automation Tool</B></td><td width=270><B>Selenium</B></td></tr></table><br/>");
				bw1.write("<table style=font-family:calibri border =2 cellspacing=1 frame=Vsides bgcolor=#E8E8E8 Align=Center><tr><td Align=Center width=55><B>SL NO</B></td><td Align=center width=440><B>Sports Name</B></td><td width=90 Align=center><B>Result</B></td><td width=90 Align=center><B>Number of Tests PASSED</B></td><td width=90 Align=center><B>Number of Tests FAILED</B></td></tr>");
				bw1.close();
				System.out.println("Final Text Execution Report created");
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	    
//********************************************************************************************************************
//Generic function name :writePass
//Description : To write Pass status for sports.
//********************************************************************************************************************	    
	    public void writePass(String sports, String status) throws IOException
		{
	    	
			try
			{
				Configurations config = new Configurations();
				String Spath = config.FinalReportPath;
				String sport = config.sports;
				int fcntr = Reports.failcntr;
				int pcntr = Reports.passcntr;
				String pth = "./"+sport+"_Test_Results/"+sport;
				System.out.println(pth);
				BufferedWriter bw1 = new BufferedWriter(new FileWriter(Spath+"/Test_Automation_Report.html",true));
				bw1.write("<tr><td Align=center>"+fslno+"</td><td><a href="+pth+"_Summary.html>"+sport+"</a></td><td bgcolor=#00FF00 Align=center>"+status+"</td><td bgcolor=#00FF00 Align=center>"+pcntr+"</td><td bgcolor=#FF0000 Align=center>"+fcntr+"</td></tr>");
				fslno++;
				bw1.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	    
//********************************************************************************************************************
//Generic function name :writeFail
//Description : To write Fail status for sports.
//********************************************************************************************************************	    

	    public void writeFail(String sports, String status) throws IOException
		{
			try
			{
				Configurations config = new Configurations();
				String rpath = config.FinalReportPath;
				String sport = config.sports;
				int fcntr = Reports.failcntr;
				int pcntr = Reports.passcntr;
				String pth = "./"+sport+"_Test_Results/"+sport;
				System.out.println(pth);
				BufferedWriter bw1 = new BufferedWriter(new FileWriter(rpath+"/Test_Automation_Report.html",true));
				bw1.write("<tr><td Align=center>"+fslno+"</td><td><a href="+pth+"_Summary.html>"+sport+"</a></td><td bgcolor=#FF0000 Align=center>"+status+"</td><td bgcolor=#00FF00 Align=center>"+pcntr+"</td><td bgcolor=#FF0000 Align=center>"+fcntr+"</td></tr>");
				fslno++;
				bw1.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}

}
