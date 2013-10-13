package com.usatoday.frameworkengine;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.usatoday.Libraries.Configurations;
import com.usatoday.Libraries.ExcelLibrary;
import com.usatoday.Libraries.MouseActions;
import com.usatoday.Libraries.ProjectSpecificComponents;
import com.usatoday.Libraries.Reports;


public class Testexecutor {

	/**
	 * @param args
	 */
	public static WebDriver drv;
	
	public static boolean res;	
	public static String[] split;
	public static String[] split1;
	public static String[] split2;
//	public static int passcntr;
//	public static int failcntr;
	
	public static Reports report;
	public Testexecutor()
	{
		drv = Maindriver.driver;
		res=true;
	}
	
	
	public void executeTest(String scenarioName) throws Exception {
		
//		drv = Maindriver.driver;
//		res=true;
		drv.manage().window().maximize();
		report = new Reports(scenarioName);
		ProjectSpecificComponents pjsc = new ProjectSpecificComponents();
		Testexecutor te = new Testexecutor();		
		ExcelLibrary library = new ExcelLibrary();
		Configurations config = new Configurations();
		report.createLogFile();
		
		int numTestSteps = library.getRowCount(config.Testpath, scenarioName);
		for(int i=1;i<=numTestSteps;i++){
			String action = library.getExcelData(config.Testpath,scenarioName, i, 0);
			String elementId = library.getExcelData(config.Testpath,scenarioName, i, 1);
			String locatorVal = library.getExcelData(config.Testpath,scenarioName, i, 2);
			String data = library.getExcelData(config.Testpath,scenarioName, i, 3);
//			System.out.println(data);
			split = pjsc.splitdatabycoma(data);
		
			String darr = library.getExcelData(config.Testpath,scenarioName, i, 4);
//			System.out.println(darr);
			split1 = pjsc.splitdatabycoma(darr);
			
			split2 = pjsc.splitdatabyspchar(data);
			//System.out.println(action+"--"+elementId+"--"+locatorVal+"--"+data);
			action.toString();
			try
			{
				if(action.equals("type")){
					String result = te.type(elementId,locatorVal,data);
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("click")){
					String result =te.click(elementId, locatorVal, data);
//					pjsc.closesliderads(drv);
//					pjsc.closeTransistionads(drv);
//					Thread.sleep(1000);
//					pjsc.closebreakingnews(drv);
					this.verifyClickConnectionErrors(data);
					
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("select")){
					String result =te.select(elementId, locatorVal, data);
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("alert")){
					String result =te.alert(data);
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("verifyTitle")){
					String result =te.verifyTitle(data);
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("verifyText")){
					te.verifyText(elementId, locatorVal, data);
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("verifyTexts")){
					te.verifyTexts( locatorVal, split);
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("verifyPageHeader")){
					String result =te.verifyPageHeader(elementId, locatorVal, data);
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("verifyleftrail")){
					String result =te.verifyleftrail(elementId, locatorVal, data);
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("verifyfrontmodules")){
					String result =te.verifyfrontmodules(elementId, locatorVal, data);
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("verifyscorecards")){
					te.verifyscorecards(split[0], split[1], split[2]);
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("verifystandingsheaders")){
					te.verifystandingsheaders();
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("verifystandingslegends")){
					te.verifystandingslegends();
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("verifystandingsseasons")){
					te.verifystandingsseasons();
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("verifystandingsdivisions")){
					te.verifystandingsdivisions();
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("verifystandingsribbons")){
					te.verifystandingsribbons();
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("verifyscheduledate")){
					te.verifyscheduledate();
					//				System.out.println(res);
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("verifyDefaultScheduleFilters")){
					te.verifyDefaultScheduleFilters();
					//				System.out.println(res);
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("verifyScheduleheaders")){
					te.verifyScheduleheaders();
					// 				System.out.println(res);
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("verifyweekribbon")){
					te.verifyweekribbon();
					//				System.out.println(res);
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("movetoelement")){
					te.movetoelement(locatorVal);
					Thread.sleep(1000);
					System.out.println(res);
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("selectfromdropdown")){
					te.selectfromdropdown(locatorVal,data);
					this.verifySelectConnectionErrors(data);
					System.out.println(res);
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("verifycoveragelinks")){
					te.verifycoveragelinks(split1,split);
					System.out.println(res);
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("verifyelementpresent")){
					te.verifyelementpresent(locatorVal, data);
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("verifystatsteamleaderhdr")){
					te.verifystatsteamleaderhdr(locatorVal, data);
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("verifystatsKPI")){
					te.verifystatsKPI(locatorVal, data);
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("verifystatsKPIleaders")){
					te.verifystatsKPIleaders(locatorVal, data);
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("verifyKPIpleadersstats")){
					te.verifyKPIpleadersstats(locatorVal, data);
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("verifyKPItleadersstats")){
					te.verifyKPItleadersstats(locatorVal, data);
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("verifyviewall4KPI")){
					te.verifyviewall4KPI(locatorVal, data);
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("verifyleaguestatsribbon")){
					te.verifyleaguestatsribbon(locatorVal, data);
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("verifycolumnhdrs")){
					te.verifycolumnhdrs(locatorVal, data);
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("verifydataperpage")){
					te.verifydataperpage(locatorVal, data, darr);
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("verifyshowmore")){
					te.verifyshowmore(locatorVal, data);
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("verifystatscolhighlight")){
					te.verifystatscolhighlight(data, darr);
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("verifystatsplayer")){
					te.verifystatsplayer(locatorVal, data);
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("verifystatsplrstats")){
					te.verifystatsplrstats(locatorVal, data);
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("webpagescrollup")){
					te.webpagescrollup();
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("verifydispofNFLldrmodule")){
					te.verifydispofNFLldrmodule();
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("verifydispofNHLldrmodule")){
					te.verifydispofNHLldrmodule();
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("verifyNFLfinalcards")){
					te.verifyNFLfinalcards();
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("verifyNHLfinalcards")){
					te.verifyNHLfinalcards();
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("verifycontextlinkclick")){
					te.verifycontextlinkclick(split[0],split[1],darr);
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("verifyctrlonoverview")){
					te.verifyctrlonoverview(split[0],split[1],darr);
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("verifyMoreGamesCnt")){
					te.verifyMoreGamesCnt(locatorVal, data);
				}
				else if(action.equals("verifydispofRecapTxtInfo")){
					te.verifydispofRecapTxtInfo(locatorVal);
					Thread.sleep(1000);
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("verifyteamIndexCrdLinks")){
					te.verifyteamIndexCrdLinks();
					Thread.sleep(1000);
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("verifyTmIndexDrpdn")){
					te.verifyTmIndexDrpdn(data);
					Thread.sleep(1000);
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("selectmonth")){
					pjsc.selectmonth(drv,data);
					Thread.sleep(1000);
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("selectyear")){
					pjsc.selectyear(drv,data);
					Thread.sleep(1000);
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
				else if(action.equals("selectdate")){
					pjsc.selectdate(drv,data);
					Thread.sleep(1000);
					//	library.writeToExcel(scenarioName, i, 4,result);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

		}	
		System.out.println(res);
//		for(int k=1;k<=library.getRowCount(Maindriver.Path,"Scenarios");k++)
//		{
//			if(library.getExcelData(Maindriver.Path, "Scenarios", k, 0).equals(scenarioName))
//			{
				if(res==false)
				{
//					failcntr++;
					report.writeFailSummary(scenarioName, "FAIL");
					System.out.println("inside write fail summary");
				//	library.writeToExcel("Scenarios", k, 2, "FAIL");
				}
				else{
//					passcntr++;
					report.writePassSummary(scenarioName, "PASS");
					System.out.println("inside write pass summary");
				//	library.writeToExcel("Scenarios", k, 2, "PASS");
				}
//			}
//		}		
		//library.writeToExcel(scenarioName, 2, 2, res);
		//driver.findElement(By.elementId(locatorVal)).action(data);
	}
	public String type(String elementId,String locatorVal, String data) throws Exception{
		String retVal=null;
		if(elementId.equals("name")){
			try {
				drv.findElement(By.name(locatorVal)).sendKeys(data);
				//System.out.println("typed "+data+" into "+locatorVal+" text box");
				String Passlog = "PASS-typed "+data+" into "+locatorVal+" text box";
				report.writePassLog(Passlog);
				retVal = "PASS";
			} catch (Exception e) {
				//System.out.println(locatorVal+" element not found");
				String Faillog = "FAIL-"+locatorVal+" element not found";
				report.writeFailLog(Faillog);
				retVal="FAIL";
				res=false;
			}			
		}
		else if(elementId.equals("id")){
			try {
				drv.findElement(By.id(locatorVal)).sendKeys(data);
				//System.out.println("typed "+data+" into "+locatorVal+" text box");
				//System.out.println("typed "+data+" into "+locatorVal+" text box");
				String Passlog = "PASS-typed "+data+" into "+locatorVal+" text box";
				report.writePassLog(Passlog);
				retVal = "PASS";
			} catch (Exception e) {
				//System.out.println(locatorVal+" element not found");
				String Faillog = "FAIL-"+locatorVal+" element not found";
				report.writeFailLog(Faillog);
				retVal="FAIL";
				res=false;
			}			
		}
		else if(elementId.equals("xpath")){
			try {
				//String xpt = getXpath(locatorVal);
				//Driver.driver.findElement(By.xpath(xpt)).click();
				drv.findElement(By.xpath(locatorVal)).sendKeys(data);
				//System.out.println("typed "+data+" into "+locatorVal+" text box");
				String Passlog = "PASS-typed "+data+" into "+locatorVal+" text box";
				report.writePassLog(Passlog);
				retVal = "PASS";;
			} catch (Exception e) {
				//System.out.println(locatorVal+" element not found");
				String Faillog = "FAIL-"+locatorVal+" element not found";
				report.writeFailLog(Faillog);
				retVal="FAIL";
				res=false;
			}
		}
		return retVal;
	}
	public String click(String elementId,String locatorVal,String data) throws Exception{
		String retVal=null;
		if(elementId.equals("css")){
			try {
				drv.findElement(By.cssSelector(locatorVal)).click();
				String Passlog = "PASS - Clicked on "+data+"("+locatorVal+")";
				report.writePassLog(Passlog);
				retVal="PASS";
			} catch (Exception e) {
				String Faillog = "FAIL - Element "+data+"("+locatorVal+") not found";
				report.writeFailLog(Faillog);
				retVal="FAIL";
				res=false;
			}			
		}
		else if(elementId.equals("xpath")){
				
			try {
				System.out.println(locatorVal);
				//String xpt = getXpath(locatorVal);
				drv.findElement(By.xpath(locatorVal)).click();
				String Passlog = "PASS - Clicked on "+data+"("+locatorVal+")";
				report.writePassLog(Passlog);
				retVal="PASS";
			} catch (Exception e) {
				String Faillog = "FAIL - Element "+data+"("+locatorVal+") not found";
				report.writeFailLog(Faillog);
				retVal="FAIL";
				res=false;
			}
		}
		else if(elementId.equals("linktext")){
			try {
				drv.findElement(By.linkText(locatorVal)).click();
				String Passlog = "PASS-Clicked on "+locatorVal;
				report.writePassLog(Passlog);
				retVal="PASS";
			} catch (Exception e) {
				String Faillog = "FAIL-"+locatorVal+" not found";
				report.writeFailLog(Faillog);
				retVal="FAIL";
				res=false;
			}
		}
		return retVal;
	}
	public String select(String elementId,String locatorVal, String data){
		String retVal=null;
		if(elementId.equals("name")){
			try {
				WebElement selectdd = drv.findElement(By.name(locatorVal));
				Select dd = new Select(selectdd);
				dd.selectByVisibleText(data);
				retVal="PASS-selected "+data+" from "+locatorVal+" dropdown";
			} catch (Exception e) {
				retVal="FAIL-dropdown "+locatorVal+" not found";
				res=false;
			}			
		}
		else if(elementId.equals("id")){
			try {
				WebElement selectdd = drv.findElement(By.id(locatorVal));
				Select dd = new Select(selectdd);
				dd.selectByVisibleText(data);
				retVal="PASS-selected "+data+" from "+locatorVal+" dropdown";
			} catch (Exception e) {
				retVal="FAIL-dropdown "+locatorVal+" not found";
				res=false;
			}
		}
		else if(elementId.equals("xpath")){
			try {
				//String xpt = getXpath(locatorVal);
				//Driver.driver.findElement(By.xpath(xpt)).click();
				WebElement selectdd = drv.findElement(By.xpath(locatorVal));
				Select dd = new Select(selectdd);
				dd.selectByVisibleText(data);
				retVal="PASS-selected "+data+" from "+locatorVal+" dropdown";
			} catch (Exception e) {
				retVal="FAIL-dropdown "+locatorVal+" not found";
				res=false;
			}
		}
		return retVal;
	}
	public String alert(String data){
		String retVal=null;
		Alert alrt = drv.switchTo().alert();
		if(data.equals("ok")){
			String alrtMsg = alrt.getText();
			alrt.accept();			
			retVal="PASS-clicked ok on "+alrtMsg;
			
		}
		else if(data.equals("cancel")){
			String alrtMsg = alrt.getText();
			alrt.dismiss();			
			retVal="PASS-clicked cancel on "+alrtMsg;
		}	
		return retVal;
	}
	public String verifyTitle(String data){
		String retVal=null;
		String title = drv.getTitle();
		if(title.equals(data)){
			retVal="PASS-Title match";
		}
		else{
			retVal="FAIL-Title failed to match";
			res=false;
		}
		return retVal;
	}
	public void verifyText(String elementId,String locatorVal, String data) throws Exception
	{
		if(elementId.equals("xpath"))
		{
			try 
			{
				String txt = drv.findElement(By.xpath(locatorVal)).getText();
				if(txt.equals(data))
				{
					String Passlog = "PASS - Expected text '"+data+"' matches Actual text '"+txt+"'";
					report.writePassLog(Passlog);
				}
				else
				{
					String Faillog = "FAIL - Expected text '"+data+"' doesn't matches Actual text '"+txt+"'";
					report.writeFailLog(Faillog);
					res=false;
				}
			}
			catch (Exception e) 
			{
				String Faillog = "FAIL - Expected text '"+data+"' not found";
				report.writeFailLog(Faillog);
				res=false;
			}
		}	
	}
	
	public void verifyTexts(String locatorVal, String arr[]) throws Exception
	{
		List<WebElement> texts = drv.findElements(By.xpath(locatorVal));
		for(int i=0; i<arr.length; i++)
		{	
				try 
				{
					String txt = arr[i];
					if(txt.equalsIgnoreCase(texts.get(i).getText()))
					{
						String Passlog = "PASS - Expected text '"+arr[i]+"' matches Actual text '"+txt+"'";
						report.writePassLog(Passlog);
					}
					else
					{
						String Faillog = "FAIL - Expected text '"+arr[i]+"' doesn't matches Actual text '"+txt+"'";
						report.writeFailLog(Faillog);
						res=false;
					}
				}
				catch (Exception e) 
				{
					String Faillog = "FAIL - Expected text '"+arr[i]+"' not found";
					report.writeFailLog(Faillog);
					res=false;
				}
				
		}
	}
	
	
	
	public String verifyPageHeader(String elementId,String locatorVal, String data) throws Exception{
		String retVal=null;
		String txt="";
//		try{
//			drv.findElement(By.xpath(locatorVal)).getText();
//		}
//		catch(Exception e)
//		{
//			String Faillog = "FAIL-"+locatorVal+" not found";
//			report.writeFailLog(Faillog);
//			retVal="FAIL";
//			res=false;
//		}

		if(elementId.equals("xpath")){
			try {
				System.out.println(locatorVal);
				 txt = drv.findElement(By.xpath(locatorVal)).getText();
				if(txt.equals(data)){
					String Passlog = "PASS-Expected PageHeader "+data+" matches Actual PageHeader "+txt;
					report.writePassLog(Passlog);
					retVal="PASS";
					}	
				else
				{
					String Faillog = "FAIL-Expected PageHeader "+data+" does not matches Actual PageHeader "+txt;
					report.writeFailLog(Faillog);
					retVal="FAIL";
					res=false;
				}
			} catch (Exception e) {		
				String Faillog = "FAIL-"+locatorVal+" not found";
				report.writeFailLog(Faillog);
				retVal="FAIL";
				res=false;
			}
		}
		
		return retVal;		
	}
	public String verifyleftrail(String elementId,String locatorVal,String data) throws Exception
	{
		String retVal=null;
		if(elementId.equals("xpath"))
		{
			try 
			{
				List<WebElement> leftrail = drv.findElements(By.xpath(locatorVal));
				for(int i=0;i<=leftrail.size()-1;i++)
				{
					System.out.println(leftrail.get(i).getText());
					ProjectSpecificComponents pjsc = new ProjectSpecificComponents();
					String[] split = pjsc.splitdatabycoma(data);
					if(leftrail.get(i).getText().equals(split[i]))
					{
						String Passlog = "PASS-Expected Left rail Header "+leftrail.get(i).getText()+" matches Actual Value "+split[i];
						report.writePassLog(Passlog);
						retVal="PASS";
						
					}
					else
					{
						String Faillog = "FAIL-Expected Left rail Header "+leftrail.get(i).getText()+" dosen't matches Actual Value "+split[i];
						report.writePassLog(Faillog);
						retVal="FAIL";
						res=false;
					}
				}	
			} 
			catch (Exception e) 
			{
				String Faillog = "FAIL-"+locatorVal+" not found";
				report.writeFailLog(Faillog);
				retVal="FAIL";
				res=false;
			}			
		}
		return retVal;	
	}
	
	public String verifyfrontmodules(String elementId,String locatorVal, String data) throws Exception
	{
		String retVal=null;
		if(elementId.equals("xpath"))
		{
			try 
			{
				ProjectSpecificComponents pjsc1 = new ProjectSpecificComponents();
				String val=pjsc1.driverwait(drv, 60, elementId, locatorVal);
				if(val.equalsIgnoreCase("true"))
				{
					String Passlog = "PASS-"+data+" Loaded properly ";
					report.writePassLog(Passlog);
					retVal="PASS";
				}
				else
				{
					String Faillog = "FAIL-"+data+" not Loaded properly";
					report.writeFailLog(Faillog);
					retVal="FAIL";
					res=false;
				}
			} 
			catch (Exception e) 
			{
				System.out.println(e);
				String Faillog = "FAIL-"+locatorVal+" not found";
				report.writeFailLog(Faillog);
				res=false;
			}	
		}
		
		return retVal;	
	}
	
	public void verifyscorecards(String sports, String team1, String Team2) 
	{
		ProjectSpecificComponents pjsc = new ProjectSpecificComponents();
		try
		{
//			this.navigates(drv, sports);
			this.getscrcardcnt(drv);
			//		scrds.getseason(t1,t2);
			if(this.geteventstate(drv, team1,Team2).equalsIgnoreCase("Post-Game"))
			{
				this.getscore(drv, team1,Team2);
				this.getstatus(drv, team1,Team2);
				this.getwinloss(drv, team1,Team2);
				this.getteamleaders(drv, team1,Team2);
				this.getcontextlinks(drv, team1,Team2);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public String geteventstate(WebDriver driver, String t1, String t2)
	{
		String retval="";
		String node="//div[ul[li/ul[@class='teamgroupcont']/descendant::a[contains(text(),'"+t1+"')] and li/ul[@class='teamgroupcont']/descendant::a[contains(text(),'"+t2+"')]] and ";
		try
		{
			WebElement event = driver.findElement(By.xpath(node+"contains(@class,'post-event')]"));
			retval="Post-Game";
			System.out.println("Event state is Post-Game");
		}
		catch(Exception e)
		{
			
		}
		try
		{
			WebElement event = driver.findElement(By.xpath(node+"contains(@class,'pre-event')]"));
			retval="Pre-Game";
			System.out.println("Event state is Pre-Game");
		}
		catch(Exception e)
		{
			
		}
		try
		{
			WebElement event = driver.findElement(By.xpath(node+"contains(@class,'mid-event')]"));
			retval="Inprogress-Game";
			System.out.println("Event state is Inprogress-Game");
		}
		catch(Exception e)
		{
			
		}
		return retval;
	}
	
	public void getscrcardcnt(WebDriver driver) throws Exception
	{
		List<WebElement> scrcardcnt = driver.findElements(By.xpath("//article[@id='scorespage']/descendant::div[contains(@id,'com')]"));
		String Passlog = "Number of Score Cards displayed- "+scrcardcnt.size();
		report.writePassLog(Passlog);
	}
	
	public void getscore(WebDriver driver, String t1, String t2) throws Exception
	{
		String node = "//div[ul[li/ul[@class='teamgroupcont']/descendant::a[contains(text(),'"+t1+"')] and li/ul[@class='teamgroupcont']/descendant::a[contains(text(),'"+t2+"')]]]";
		List<WebElement> scr = driver.findElements(By.xpath(node+"/descendant::li[contains(@class,'outcomes   first') or contains(@class,'outcomes total')]"));
//		System.out.println(scr.size());
		if(scr.get(0).getText().equalsIgnoreCase(""))
		{
			String Faillog = t1+" team's final score is not displayed";
			report.writeFailLog(Faillog);
			res=false;
		}
		else
		{
			String Passlog = t1+" team's final score is- "+scr.get(0).getText();
			report.writePassLog(Passlog);
		}
		
		if(scr.get(1).getText().equalsIgnoreCase(""))
		{
			String Faillog = t2+" team's final score is not displayed";
			report.writeFailLog(Faillog);
			res=false;
		}
		else
		{
			String Passlog = t2+" team's final score is- "+scr.get(1).getText();
			report.writePassLog(Passlog);
		}
		
		
	}
	
	public void getstatus(WebDriver driver, String t1, String t2) throws IOException
	{
		String node = "//div[ul[li/ul[@class='teamgroupcont']/descendant::a[contains(text(),'"+t1+"')] and li/ul[@class='teamgroupcont']/descendant::a[contains(text(),'"+t2+"')]]]";
		WebElement status = driver.findElement(By.xpath(node+"/descendant::h3"));
		String Passlog = "Game status of game between "+t1+" and "+t2+" is "+status.getText();
		report.writePassLog(Passlog);
	}
	
	public void getwinloss(WebDriver driver, String t1, String t2) throws Exception
	{
		String node = "//div[ul[li/ul[@class='teamgroupcont']/descendant::a[contains(text(),'"+t1+"')] and li/ul[@class='teamgroupcont']/descendant::a[contains(text(),'"+t2+"')]]]";
		List<WebElement> winloss = driver.findElements(By.xpath(node+"/descendant::li[@class='record']"));
		if(winloss.get(0).getText().equalsIgnoreCase(""))
		{
			String Faillog = t1+" team's Win-Loss info is not displayed";
			report.writeFailLog(Faillog);
			res=false;
		}
		else
		{
			String Passlog = t1+" team's Win-Loss info is displayed as - "+winloss.get(0).getText();
			report.writePassLog(Passlog);
		}
		
		if(winloss.get(1).getText().equalsIgnoreCase(""))
		{
			String Faillog = t2+" team's Win-Loss info is not displayed";
			report.writeFailLog(Faillog);
			res=false;
		}
		else
		{
			String Passlog = t2+" team's Win-Loss info is displayed as - "+winloss.get(1).getText();
			report.writePassLog(Passlog);
		}
	}
	
	public String verifyteamleader(WebDriver driver, String t1, String t2) throws Exception
	{
		String node = "//div[ul[li/ul[@class='teamgroupcont']/descendant::a[contains(text(),'"+t1+"')] and li/ul[@class='teamgroupcont']/descendant::a[contains(text(),'"+t2+"')]]]";
		String retval="";
		try
		{
		driver.findElement(By.xpath(node+"/descendant::ul[@class='head']"));
		retval="true";
		String Passlog = "Team Leader module is displayed in score card of game between "+t1+" and "+t2;;
		report.writePassLog(Passlog);
		List<WebElement> teams = driver.findElements(By.xpath(node+"/descendant::ul[@class='head']/li"));
		System.out.println("Team Names in Team Leader module are "+teams.get(0).getText()+" and "+teams.get(2).getText());
		}
		catch(Exception e)
		{
			String Faillog = "Team Leader module is not displayed in score card of game between "+t1+" and "+t2;
			report.writeFailLog(Faillog);
			res=false;
		}
		return retval;
	}
	
	public void getteamleaders(WebDriver driver, String t1, String t2) throws Exception
	{
		
		if(this.verifyteamleader(driver, t1, t2).equalsIgnoreCase("true"))
		{
			String node="//div[ul[li/ul[@class='teamgroupcont']/descendant::a[contains(text(),'"+t1+"')] and li/ul[@class='teamgroupcont']/descendant::a[contains(text(),'"+t2+"')]]]";
			List<WebElement> rows = driver.findElements(By.xpath(node+"/descendant::li[@class='breakdown']/ul"));

			if(rows.size()==2)
			{
				List<WebElement> leader1 = driver.findElements(By.xpath(node+"/descendant::li[@class='breakdown']/ul[2]/li"));
				List<WebElement> teams = driver.findElements(By.xpath(node+"/descendant::li[@class='breakdown']/ul[1]/li"));
				String team1 = teams.get(0).getText();
				String team2 = teams.get(2).getText();
				String ldr1 = leader1.get(1).getText();
				String plr1 = leader1.get(0).getText();
				String plr2 = leader1.get(2).getText();
				String Passlog1 = ldr1+" Team Leader from "+team1+ " is "+plr1;
				report.writePassLog(Passlog1);
				String Passlog2 = ldr1+" Team Leader from "+team2+ " is "+plr2 ;
				report.writePassLog(Passlog2);

			}
			else if(rows.size()==3)
			{
				List<WebElement> leader1 = driver.findElements(By.xpath(node+"/descendant::li[@class='breakdown']/ul[2]/li"));
				List<WebElement> teams = driver.findElements(By.xpath(node+"/descendant::li[@class='breakdown']/ul[1]/li"));
				List<WebElement> leader2 = driver.findElements(By.xpath(node+"/descendant::li[@class='breakdown']/ul[3]/li"));
				String team1 = teams.get(0).getText();
				String team2 = teams.get(2).getText();
				String ldr1 = leader1.get(1).getText();
				String plr11 = leader1.get(0).getText();
				String plr12 = leader1.get(2).getText();
				String ldr2 = leader2.get(1).getText();
				String plr21 = leader2.get(0).getText();
				String plr22 = leader2.get(2).getText();
				String Passlog1 = ldr1+" Team Leader from "+team1+ " is "+plr11;
				report.writePassLog(Passlog1);
				String Passlog2 = ldr1+" Team Leader from "+team2+ " is "+plr12;
				report.writePassLog(Passlog2);
				String Passlog3 = ldr2+" Team Leader from "+team1+ " is "+plr21;
				report.writePassLog(Passlog3);
				String Passlog4 = ldr2+" Team Leader from "+team2+ " is "+plr22;
				report.writePassLog(Passlog4);
				
			}
			else if(rows.size()==4)
			{
				List<WebElement> leader1 = driver.findElements(By.xpath(node+"/descendant::li[@class='breakdown']/ul[2]/li"));
				List<WebElement> teams = driver.findElements(By.xpath(node+"/descendant::li[@class='breakdown']/ul[1]/li"));
				List<WebElement> leader2 = driver.findElements(By.xpath(node+"/descendant::li[@class='breakdown']/ul[3]/li"));
				List<WebElement> leader3 = driver.findElements(By.xpath(node+"/descendant::li[@class='breakdown']/ul[4]/li"));

				String team1 = teams.get(0).getText();
				String team2 = teams.get(2).getText();
				String ldr1 = leader1.get(1).getText();
				String plr11 = leader1.get(0).getText();
				String plr12 = leader1.get(2).getText();
				String ldr2 = leader2.get(1).getText();
				String plr21 = leader2.get(0).getText();
				String plr22 = leader2.get(2).getText();
				String ldr3 = leader3.get(1).getText();
				String plr31 = leader3.get(0).getText();
				String plr32 = leader3.get(2).getText();
				System.out.println(ldr1+" Team Leader from "+team1+ " is "+plr11 );
				System.out.println(ldr1+" Team Leader from "+team2+ " is "+plr12 );
				System.out.println(ldr2+" Team Leader from "+team1+ " is "+plr21 );
				System.out.println(ldr2+" Team Leader from "+team2+ " is "+plr22 );
				System.out.println(ldr3+" Team Leader from "+team1+ " is "+plr31 );
				System.out.println(ldr3+" Team Leader from "+team2+ " is "+plr32 );
				
				String Passlog1 = ldr1+" Team Leader from "+team1+ " is "+plr11;
				report.writePassLog(Passlog1);
				String Passlog2 = ldr1+" Team Leader from "+team2+ " is "+plr12;
				report.writePassLog(Passlog2);
				String Passlog3 = ldr2+" Team Leader from "+team1+ " is "+plr21;
				report.writePassLog(Passlog3);
				String Passlog4 = ldr2+" Team Leader from "+team2+ " is "+plr22;
				report.writePassLog(Passlog4);
				String Passlog5 = ldr3+" Team Leader from "+team1+ " is "+plr31;
				report.writePassLog(Passlog5);
				String Passlog6 = ldr3+" Team Leader from "+team2+ " is "+plr32;
				report.writePassLog(Passlog6);
				
			}
		}
	}
	
	public void getcontextlinks(WebDriver driver, String t1, String t2) throws IOException
	{
		String node="//div[ul[li/ul[@class='teamgroupcont']/descendant::a[contains(text(),'"+t1+"')] and li/ul[@class='teamgroupcont']/descendant::a[contains(text(),'"+t2+"')]]]";
		List<WebElement> links = driver.findElements(By.xpath(node+"/descendant::li[@class='contextlinks']/a"));
		for(int i=0; i<links.size();i++)
		{
			int j=1;
			String Passlog = "Context link"+j+" = "+links.get(i).getText();
			report.writePassLog(Passlog);
			j++;
		}
	}
	
	public void navigates(WebDriver driver, String sports)
	{
		driver.navigate().to("http://www.usatoday.com/sports/"+sports+"/scores");
	}
	
	public void verifystandingsheaders() throws Exception
	{
		ProjectSpecificComponents pjc = new ProjectSpecificComponents();
		if(pjc.Standheaders(drv, split))
		{
			String Passlog="PASS - Standing tables column headers matched with expected values.";
			report.writePassLog(Passlog);
		}
		else
		{
			res=false;
			String Faillog="FAIL - Standing tables column headers are not matched with expected values.";
			report.writeFailLog(Faillog);
		}
	}
	public void verifystandingslegends() throws Exception
	{
		ProjectSpecificComponents pjc = new ProjectSpecificComponents();
		if(pjc.standlegends(drv, split))
		{
			String Passlog="PASS - Top and Bottom playoff legends matched with expected values.";
			report.writePassLog(Passlog);
		}
		else
		{
			res=false;
			String Faillog="FAIL - Top or Bottom playoff legends not matched with expected values.";
			report.writeFailLog(Faillog);
		}
	}
	
	public void verifystandingsseasons() throws Exception
	{
		ProjectSpecificComponents pjc = new ProjectSpecificComponents();
		if(pjc.standseasons(drv, split))
		{
			String Passlog="PASS - Standing page Season dropdown values are matched with expected values.";
			report.writePassLog(Passlog);
		}
		else
		{
			res=false;
			String Faillog="FAIL - Standing page Season dropdown values are not matched with expected values.";
			report.writeFailLog(Faillog);
		}
	}
	
	public void verifystandingsdivisions() throws Exception
	{
		ProjectSpecificComponents pjc = new ProjectSpecificComponents();
		if(pjc.standdivision(drv, split))
		{
			String Passlog="PASS - Standing page Division dropdown values are matched with expected values.";
			report.writePassLog(Passlog);
		}
		else
		{
			res=false;
			String Faillog="FAIL - Standing page Division dropdown values are not matched with expected values.";
			report.writeFailLog(Faillog);
		}
	}
	
	public void verifystandingsribbons() throws Exception
	{
		ProjectSpecificComponents pjc = new ProjectSpecificComponents();
		if(pjc.standribbons(drv, split))
		{
			String Passlog="PASS - Standing page Division Ribbons are displayed and ordered properly.";
			report.writePassLog(Passlog);
		}
		else
		{
			res=false;
			String Faillog="FAIL - Standing page Division Ribbons are missing or doesn't ordered properly.";
			report.writeFailLog(Faillog);
		}
	}
	
	public void verifyscheduledate() throws Exception
	{
		String Passlog;
		String Faillog;
		ProjectSpecificComponents pjc = new ProjectSpecificComponents();
		List<WebElement> dates = drv.findElements(By.xpath("//table/descendant::th[@class='day']"));
		for(int i=0; i<dates.size(); i++)
		{
			if(dates.get(i).getText()!="")
			{
				Passlog = "PASS - League Schedule Date Displayed for Datatable_"+i;
				report.writePassLog(Passlog);
				if(pjc.scheduledate(dates.get(i).getText()))
				{
					Passlog = "PASS - League Schedule Date Format is displayed properly for Datatable_"+i;
					report.writePassLog(Passlog);
				}
				else
				{
					res=false;
					Faillog = "FAIL - League Schedule Date Format is not displayed properly for Datatable_"+i;
					report.writeFailLog(Faillog);
				}
			}
			else
			{
				res=false;
				Faillog = "FAIL - League Schedule Date is not Displayed for Datatable_"+i;
				report.writeFailLog(Faillog);
			}
		}
	}
	
	public void verifyDefaultScheduleFilters() throws Exception
	{
		ProjectSpecificComponents pjc = new ProjectSpecificComponents();
		if(pjc.standribbons(drv, split))
		{
			String Passlog="PASS - Default Schedule page season filters reads expected values.";
			report.writePassLog(Passlog);
		}
		else
		{
			res=false;
			String Faillog="FAIL - Default Schedule page week filters values dosen't match with expected values.";
			report.writeFailLog(Faillog);
		}
	}
	
	public void verifyScheduleheaders() throws Exception
	{
		ProjectSpecificComponents pjc = new ProjectSpecificComponents();
		if(pjc.schdheaders(drv, split))
		{
			String Passlog="PASS - Schedule page datatables column headers matched with expected values.";
			report.writePassLog(Passlog);
		}
		else
		{
			res=false;
			String Faillog="FAIL - Schedule page datatables column headers are not matched with expected values.";
			report.writeFailLog(Faillog);
		}
	}
	
	public void verifyweekribbon() throws Exception
	{
		ProjectSpecificComponents pjc = new ProjectSpecificComponents();
		if(pjc.weekribbon(drv))
		{
			String Passlog="PASS - Schedule page ribbon header matches with option selected in 'WEEK' dropdown.";
			report.writePassLog(Passlog);
		}
		else
		{
			res=false;
			String Faillog="FAIL - Schedule page ribbon header doesn't matches with option selected in 'WEEK' dropdown.";
			report.writeFailLog(Faillog);
		}
	}
	
	public void movetoelement(String xpath)
	{
		MouseActions actns = new MouseActions();
		WebElement ele = drv.findElement(By.xpath(xpath));
		actns.movetoelement(drv, ele);
	}
	
	public void selectfromdropdown(String xpath, String data) throws Exception
	{
		ProjectSpecificComponents pjc = new ProjectSpecificComponents();
		if(pjc.select(drv, xpath, data))
		{
			String Passlog="PASS - Selected "+data+" From the dropdown";
			report.writePassLog(Passlog);
		}
		else
		{
			res=false;
			String Faillog="FAIL - Not selected "+data+" From the dropdown";
			report.writeFailLog(Faillog);
		}
	}
	
	public void verifycoveragelinks(String split1[], String split[]) throws Exception
	{
		String plr1 = split1[0];
		String plr2 = split1[1];
		String node="//tr[th/descendant::div[div/descendant::span[@class='city' and contains(text(),'"+plr1+"')] and div/descendant::span[@class='city' and contains(text(),'"+plr2+"')]]]";
		List<WebElement> coverage = drv.findElements(By.xpath(node+"/descendant::ul[contains(@class,'coverage')]/li"));
		for(int i=0; i<split.length;i++)
		{
			if(coverage.get(i).getText().equalsIgnoreCase(split[i]))
			{
				String Passlog="PASS - Coverage link '"+coverage.get(i).getText()+"' for game between "+plr1+" and "+plr2+" is matched with expected value '"+split[i]+"'";
				report.writePassLog(Passlog);
			}
			else
			{
				res=false;
				String Faillog="FAIL - Coverage link '"+coverage.get(i).getText()+"' for game between "+plr1+" and "+plr2+" is not matched with expected value '"+split[i]+"'";
				report.writeFailLog(Faillog);
			}
		}
	}
	
	public void verifyelementpresent(String xpath, String data) throws Exception
	{
		ProjectSpecificComponents pjc = new ProjectSpecificComponents();
		pjc.elementpresent(drv, xpath, data);
	}
	
	public void verifyMoreGamesCnt(String xpath, String data) throws Exception
	{
		ProjectSpecificComponents pjc = new ProjectSpecificComponents();
		int moregamesscrcrds= Integer.parseInt(data);
		try
		{
			if(pjc.getelementscnt(drv, xpath)==moregamesscrcrds)
			{
				String Passlog="PASS - MORE GAMES displayed "+pjc.getelementscnt(drv, xpath)+" score cards and matched with expected value "+moregamesscrcrds;
				report.writePassLog(Passlog);
			}
			else
			{
				res=false;
				String Faillog="FAIL - MORE GAMES displayed "+pjc.getelementscnt(drv, xpath)+" score cards and doesn't matched with expected value "+moregamesscrcrds;
				report.writeFailLog(Faillog);
			}
		}
		catch(Exception e)
		{
			res=false;
			String Faillog="FAIL - MORE GAMES module doesn't displayed any score cards";
			report.writeFailLog(Faillog);
		}
	}
	
	public void verifydispofRecapTxtInfo(String xpath) throws Exception
	{
		ProjectSpecificComponents pjc = new ProjectSpecificComponents();
		try
		{
			if(pjc.getelementscnt(drv, xpath)>0)
			{
				String Passlog="PASS - Recap text info displayed in "+pjc.getelementscnt(drv, xpath)+" Paragraphs";
				report.writePassLog(Passlog);
			}
			else
			{
				res=false;
				String Faillog="FAIL - Recap text info not displayed in 'Recap' overlay page";
				report.writeFailLog(Faillog);
			}
		}
		catch(Exception e)
		{
			res=false;
			String Faillog="FAIL - Recap text info not displayed in 'Recap' overlay page";
			report.writeFailLog(Faillog);
		}
	}
	
	public void verifystatsteamleaderhdr(String xpath, String data) throws Exception
	{
		ProjectSpecificComponents pjc = new ProjectSpecificComponents();
		if(pjc.statsteamleaderhdr(drv, xpath, data))
		{
			String Passlog="PASS - Stats Leader module header on "+xpath+" matched with expected value "+data;
			report.writePassLog(Passlog);
		}
		else
		{
			res=false;
			String Faillog="PASS - Stats Leader module header on "+xpath+" is not matched with expected value "+data;
			report.writeFailLog(Faillog);
		}
	}
	
	public void verifystatsKPI(String xpath, String data) throws Exception
	{
		ProjectSpecificComponents pjc = new ProjectSpecificComponents();
		if(pjc.statsKPI(drv, xpath, split))
		{
			String Passlog="PASS - Statistics leader module KPI's are matched with expected values "+data;
			report.writePassLog(Passlog);
		}
		else
		{
			res=false;
			String Faillog="PASS - Statistics leader module KPI's are not matched with expected values "+data;
			report.writeFailLog(Faillog);
		}
	}
	
	public void verifystatsKPIleaders(String xpath, String data) throws Exception
	{
		ProjectSpecificComponents pjc = new ProjectSpecificComponents();
		pjc.KPIleaders(drv, xpath, split);
	}
	
	public void verifyKPIpleadersstats(String xpath, String data) throws Exception
	{
		ProjectSpecificComponents pjc = new ProjectSpecificComponents();
		pjc.KPIpleadersstats(drv, xpath, split2);
	}
	public void verifyKPItleadersstats(String xpath, String data) throws Exception
	{
		ProjectSpecificComponents pjc = new ProjectSpecificComponents();
		pjc.KPItleadersstats(drv, xpath, split2);
	}
	
	public void verifyviewall4KPI(String xpath, String data) throws Exception
	{
		ProjectSpecificComponents pjc = new ProjectSpecificComponents();
		pjc.viewall4KPI(drv, xpath, data);
	}
	
	public void verifyleaguestatsribbon(String xpath, String data) throws Exception
	{
		ProjectSpecificComponents pjc = new ProjectSpecificComponents();
		pjc.leaguestatsribbon(drv, xpath, data, split1);
	}
	
	public void verifycolumnhdrs(String xpath, String data) throws Exception
	{
		ProjectSpecificComponents pjc = new ProjectSpecificComponents();
		if(pjc.columnhdrs(drv, xpath, data, split1))
		{
			String Passlog= "PASS - "+data+" column headers are matched with expected values";
			report.writePassLog(Passlog);
		}
		else
		{
			res=false;
			String Faillog="FAIL - "+data+" column headers are not matched with expected values";
			report.writeFailLog(Faillog);
		}
	}
	
	public void verifydataperpage(String xpath, String data, String darr) throws Exception
	{
		ProjectSpecificComponents pjc = new ProjectSpecificComponents();
		pjc.dataperpage(drv, xpath, data, darr);
	}
	
		
	public String getXpath(String locatorElement){
		String xp=null;
		return xp = "//input[@value='"+locatorElement+"']";
	}
	
	public void verifyshowmore(String xpath, String data) throws Exception
	{
		ProjectSpecificComponents pjc = new ProjectSpecificComponents();
		if(pjc.showmore(drv, xpath))
		{
			String Passlog= "PASS - "+data+" datatable's 'Show More' button functionality working as expected";
			report.writePassLog(Passlog);
		}
		else
		{
			res=false;
			String Faillog="FAIL - "+data+" datatable's 'Show More' button functionality in not working as expected";
			report.writeFailLog(Faillog);
		}
	}
	
	public void verifystatscolhighlight(String data, String darr) throws Exception
	{
		ProjectSpecificComponents pjc = new ProjectSpecificComponents();
		pjc.verifycolhighlight(drv, data, darr);
	}
	
	public void verifystatsplayer(String xpath, String data) throws Exception
	{
		ProjectSpecificComponents pjc = new ProjectSpecificComponents();
		pjc.verifyplayer(drv, xpath, data);
	}
	
	public void verifystatsplrstats(String xpath, String data) throws Exception
	{
		ProjectSpecificComponents pjc = new ProjectSpecificComponents();
		pjc.verifyplrstats(drv, xpath, data);
	}
	
	public void webpagescrollup() throws Exception
	{
		ProjectSpecificComponents pjc = new ProjectSpecificComponents();
		pjc.pagescrollup(drv);
	}
	
	public void verifycontextlinkclick(String t1,String t2,String contextlink) throws Exception
	{
		ProjectSpecificComponents pjc = new ProjectSpecificComponents();
		if(!pjc.contextlinkclick(drv, t1, t2, contextlink))
		{
			res=false;
			String Faillog="FAIL - Selenium doesn't clicked on '"+contextlink+"' contextlink of teams '"+t1+"' Vs '"+t2+"'";
			report.writeFailLog(Faillog);
//			System.out.println("Selenium doesn't clicked on '"+contextlink+"' contextlink of teams '"+t1+"' Vs '"+t2+"'");
		}
	}
	
	public void verifyctrlonoverview(String t1,String t2,String contextlink) throws Exception
	{
		ProjectSpecificComponents pjc = new ProjectSpecificComponents();
		if(pjc.ctrlonoverview(drv, t1, t2, contextlink))
		{
			String Passlog= "PASS - Controll is on proper overlay page";
			report.writePassLog(Passlog);
		}
		else
		{
			res=false;
			String Faillog="FAIL - Controll is not on proper overlay page";
			report.writeFailLog(Faillog);
		}
	}
	
	
	
	public void verifydispofNFLldrmodule()
	{
		ProjectSpecificComponents pjc = new ProjectSpecificComponents();
		String season = drv.findElement(By.xpath("//span[contains(@class,'sports-wide-header')]")).getText();
		String week = drv.findElement(By.xpath("//span[contains(@class,'sports-weekly-header')]")).getText();
		List<WebElement> pscrcards = drv.findElements(By.xpath("//div[contains(@class,'post-event')]"));
		if(pscrcards.size()!=0)
		{
			try
			{
				if(pjc.dispofNFLldrmodule(drv,season,week))
				{
					String Passlog= "PASS - Leader module is displayed for all the post-event score cards of Season="+season+" and Week="+week;
					report.writePassLog(Passlog);
					//System.out.println("Leader module is displayed for all the post-event score cards of Season="+season+" and Week="+week);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("No post-event score cards displayed for Season="+season+" and Week="+week);
		}
	}
	
	public void verifydispofNHLldrmodule()
	{
		ProjectSpecificComponents pjc = new ProjectSpecificComponents();
		String date = drv.findElement(By.xpath("//input[@class='ui-date-picker sp-filter-date-picker-input hasDatepicker']")).getAttribute("value");
		
		List<WebElement> pscrcards = drv.findElements(By.xpath("//div[contains(@class,'post-event')]"));
		if(pscrcards.size()!=0)
		{
			try
			{
				if(pjc.dispofNHLldrmodule(drv,date))
				{
					String Passlog= "PASS - Leader module is displayed for all the post-event score cards of date:"+date;
					report.writePassLog(Passlog);
					//System.out.println("Leader module is displayed for all the post-event score cards of Season="+season+" and Week="+week);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("No post-event score cards displayed for date:"+date);
		}

	}
	
	public void verifyNFLfinalcards()
	{
		ProjectSpecificComponents pjc = new ProjectSpecificComponents();
		String season = drv.findElement(By.xpath("//span[contains(@class,'sports-wide-header')]")).getText();
		String week = drv.findElement(By.xpath("//span[contains(@class,'sports-weekly-header')]")).getText();
		List<WebElement> pscrcards = drv.findElements(By.xpath("//div[contains(@class,'post-event')]"));
		if(pscrcards.size()!=0)
		{
			try
			{
				if(pjc.NFLfinalcards(drv,season,week))
				{
					String Passlog= "PASS - Final status is displayed for all the post-event score cards of Season="+season+" and Week="+week;
					report.writePassLog(Passlog);
					//System.out.println("Final status is displayed for all the post-event score cards of Season="+season+" and Week="+week);
				}

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("No post-event score cards displayed for Season="+season+" and Week="+week);
		}
	}
	
	public void verifyNHLfinalcards()
	{
		ProjectSpecificComponents pjc = new ProjectSpecificComponents();
		String date = drv.findElement(By.xpath("//input[@class='ui-date-picker sp-filter-date-picker-input hasDatepicker']")).getAttribute("value");
		List<WebElement> pscrcards = drv.findElements(By.xpath("//div[contains(@class,'post-event')]"));
		if(pscrcards.size()!=0)
		{
			try
			{
				if(pjc.NHLfinalcards(drv,date))
				{
					String Passlog= "PASS - Final status is displayed for all the post-event score cards of date:"+date;
					report.writePassLog(Passlog);
					//System.out.println("Final status is displayed for all the post-event score cards of Season="+season+" and Week="+week);
				}

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("No post-event score cards displayed for date:"+date);
		}
	}
	
	public void verifyteamIndexCrdLinks() throws Exception
	{
		ProjectSpecificComponents pjc = new ProjectSpecificComponents();
		if(pjc.teamIndexCrdLinks(drv))
		{
			String Passlog= "PASS - All mouse hover links on team index cards are working properly";
			report.writePassLog(Passlog);
		}
	}
	
	public void verifyTmIndexDrpdn(String data) throws Exception
	{
		ProjectSpecificComponents pjc = new ProjectSpecificComponents();
		if(pjc.TmIndexDrpdn(drv,data,split1))
		{
			String Passlog= "PASS - Team index page's division/conference selection dropdown is working properly for "+data;
			report.writePassLog(Passlog);
		}
		else
		{
			res=false;
			String Faillog="FAIL - Team index page's division/conference selection dropdown is not working properly for "+data;
			report.writeFailLog(Faillog);
		}
	}
	
	public void verifyClickConnectionErrors(String data) throws Exception
	{
		ProjectSpecificComponents pjc = new ProjectSpecificComponents();
		if(pjc.VerifyConnectionErrs(drv))
		{
			System.out.println("Connection Error displayed on clicking "+data+" link.");
			res=false;
			String Faillog="FAIL - Connection Error displayed on clicking "+data+" link.";
			report.writeFailLog(Faillog);
			pjc.CloseConnectionErrs(drv);
		}
		else
		{
			System.out.println("No Connection Error displayed on clicking "+data+" link.");
		}
	}
	
	public void waitforElement(String ele, String loc) throws Exception
	{
		ProjectSpecificComponents pjc = new ProjectSpecificComponents();
		pjc.driverwait(drv, 30, ele, loc);
	}
	
	
	public void verifySelectConnectionErrors(String data) throws Exception
	{
		ProjectSpecificComponents pjc = new ProjectSpecificComponents();
	if(pjc.VerifyConnectionErrs(drv))
		{
			System.out.println("Connection Error displayed on selecting "+data+" from the dropdown.");
			res=false;
			String Faillog="FAIL - Connection Error displayed on selecting "+data+" from the dropdown.";
			report.writeFailLog(Faillog);
			pjc.CloseConnectionErrs(drv);
		}
		else
		{
			System.out.println("No Connection Error displayed on selecting "+data+" from the dropdown.");
		}
	}
	
}

