package com.usatoday.Libraries;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.usatoday.frameworkengine.Testexecutor;


public class ProjectSpecificComponents 
{
	public static WebDriver webdriver;
	public String currtime;
	public String chromedrvpath=System.getProperty("user.dir")+"\\chromedriver_win32_2.1\\chromedriver.exe";
	public String iedrvpath=System.getProperty("user.dir")+"\\IEDriverServer_Win32_2.33.0\\IEDriverServer.exe";
	
	
	
//********************************************************************************************************************
//Generic function name :VerifyTestEnv
//Description : To launch the WebDriver instance of respective browser.
//********************************************************************************************************************
	
	public void VerifyTestEnv(String browser, String Env, String url) throws Exception
	{
		
		if(browser.equalsIgnoreCase("firefox"))
			
		{
			ProfilesIni ProfilesIni = new ProfilesIni();
			// Clone the named profile               
			FirefoxProfile profile = ProfilesIni.getProfile("FFProfile_Automation");
			
			if(Env.equalsIgnoreCase("production"))
			{
			webdriver = new FirefoxDriver(profile);
			webdriver.manage().window().maximize();
			webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			webdriver.get(url);
			Thread.sleep(10000);
			}
			else if(Env.equalsIgnoreCase("qa"))
			{
				this.RunAutoit();
				webdriver = new FirefoxDriver();
				webdriver.manage().window().maximize();
				webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				webdriver.get(url);
				Thread.sleep(10000);
			}
			else if(Env.equalsIgnoreCase("stage"))
			{
				this.RunAutoit();
				webdriver = new FirefoxDriver();
				webdriver.manage().window().maximize();
				webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				webdriver.get(url);
				Thread.sleep(10000);
			}
			
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			final String userProfile= "C:\\Users\\Sri harsha\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
			ChromeOptions options = new ChromeOptions();
			options.addArguments("user-data-dir="+userProfile);
			options.addArguments("--start-maximized");
			
			if(Env.equalsIgnoreCase("production"))
			{
								
				System.setProperty("webdriver.chrome.driver",chromedrvpath);
				webdriver = new ChromeDriver(options);
				webdriver.manage().window().maximize();
				webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				webdriver.get(url);
				Thread.sleep(10000);
				//this.closebreakingnews(webdriver);
				//this.closeTransistionads(webdriver);
				
			}
			else if(Env.equalsIgnoreCase("qa"))
			{
				this.RunAutoit();
				

				System.setProperty("webdriver.chrome.driver",chromedrvpath);
				webdriver = new ChromeDriver(options);
				webdriver.manage().window().maximize();
				webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				webdriver.get(url);
				Thread.sleep(10000);
				//this.closebreakingnews(webdriver);
				//this.closeTransistionads(webdriver);
			}
			else if(Env.equalsIgnoreCase("stage"))
			{
				this.RunAutoit();
				

				System.setProperty("webdriver.chrome.driver",chromedrvpath);
				webdriver = new ChromeDriver(options);
				webdriver.manage().window().maximize();
				webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				webdriver.get(url);
				Thread.sleep(10000);
				//this.closebreakingnews(webdriver);
				//this.closeTransistionads(webdriver);
			}
		}
		else if(browser.equalsIgnoreCase("iexplore"))
		{
			if(Env.equalsIgnoreCase("production"))
			{
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				
				System.setProperty("webdriver.ie.driver",iedrvpath);
				webdriver = new InternetExplorerDriver(capabilities);
				webdriver.manage().window().maximize();
				webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				webdriver.get(url);
				Thread.sleep(10000);
			}
			else if(Env.equalsIgnoreCase("qa"))
			{
				this.RunAutoit();
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				
				System.setProperty("webdriver.ie.driver",iedrvpath);
				webdriver = new InternetExplorerDriver(capabilities);
				webdriver.manage().window().maximize();
				webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				webdriver.get(url);
				Thread.sleep(10000);
			}
			else if(Env.equalsIgnoreCase("stage"))
			{
				this.RunAutoit();
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				
				System.setProperty("webdriver.ie.driver",iedrvpath);
				webdriver = new InternetExplorerDriver(capabilities);
				webdriver.manage().window().maximize();
				webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				webdriver.get(url);
				Thread.sleep(10000);
			}
		}
		
	}
	
//********************************************************************************************************************
//Generic function name :RunAutoit
//Description : To enter the username and password when system asked for authenticate(In QA and Stage).
//********************************************************************************************************************	
	
	public void RunAutoit()
	{
		try {
			Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\USATODAY.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//********************************************************************************************************************
//Generic function name :openhtml
//Description : To open final test result summary.html file
//********************************************************************************************************************	
		
	public void openhtml(String path) throws Exception
	{
		String htmlFilePath = path+"Test_Automation_Report.html"; // path to your new file
		File htmlFile = new File(htmlFilePath);
		Desktop.getDesktop().browse(htmlFile.toURI());
//		Desktop.getDesktop().open(htmlFile);
	}
	
//********************************************************************************************************************
//Generic function name :modularsetup
//Description : To enter the username and password when system asked for authenticate(In QA and Stage).
//********************************************************************************************************************	
	
	public void modularsetup() throws Exception
	{
		System.out.println(new File(System.getProperty("user.dir")));
		Calendar c = new GregorianCalendar();
		currtime=c.getTime().toString();
		String curtime = currtime.replace(" ", "_");
		String timenow = "Test_Results_"+curtime.replace(":", ".");
		System.out.println(timenow);
				
		File dir = new File(System.getProperty("user.dir")+"\\Automation_Test_Results\\"+timenow);
		dir.mkdir();
		
		ExcelLibrary ex = new ExcelLibrary();
		String Finalrep = System.getProperty("user.dir")+"\\Automation_Test_Results\\"+timenow+"\\";
		String fpth = Finalrep.replaceAll("\\\\", "/");
		ex.writeToExcel(System.getProperty("user.dir")+"\\Modular.xlsx","FinalReport", 0, 1, fpth);
		Thread.sleep(1000);
		
		String Finalhtml = System.getProperty("user.dir")+"\\Automation_Test_Results\\"+timenow+"\\";
		String hpth = Finalhtml.replaceAll("\\\\", "//");
		ex.writeToExcel(System.getProperty("user.dir")+"\\Modular.xlsx","FinalReport", 1, 1, hpth);
		Thread.sleep(1000);
		
		int rows = ex.getRowCount(System.getProperty("user.dir")+"\\Modular.xlsx", "Sports");
		System.out.println(rows);
		for(int i=1; i<rows; i++)
		{
			String exestat = ex.getExcelData(System.getProperty("user.dir")+"\\Modular.xlsx", "Sports", i, 2);
			if(exestat.equalsIgnoreCase("yes"))
			{
				Thread.sleep(1000);
				String sports = ex.getExcelData(System.getProperty("user.dir")+"\\Modular.xlsx", "Sports", i, 1);
				File sub_dir = new File(System.getProperty("user.dir")+"\\Automation_Test_Results\\"+timenow+"\\"+sports+"_Test_Results");
				sub_dir.mkdir();
				Thread.sleep(1000);
				
				String respath = System.getProperty("user.dir")+"\\Automation_Test_Results\\"+timenow+"\\"+sports+"_Test_Results\\";
				String rpth = respath.replaceAll("\\\\", "/");
				ex.writeToExcel(System.getProperty("user.dir")+"\\Modular.xlsx","Sports", i, 4, rpth);
				Thread.sleep(1000);
				
				String TCpath = System.getProperty("user.dir")+"\\USA Today Automation TestCases\\"+sports+"\\TestCases.xlsx";
				String tpth = TCpath.replaceAll("\\\\", "/");
				ex.writeToExcel(System.getProperty("user.dir")+"\\Modular.xlsx","Sports", i, 3, tpth);
				Thread.sleep(1000);
			}	
		}
	}
	
//********************************************************************************************************************
//Generic function name :splitdata
//Description : General split
//********************************************************************************************************************	
	
	public String[] splitdatabycoma(String data)
	{
//		String data = "FEATURED CONTENT,GALLERIES,USA TODAY ON TWITTER";
		String[] splits = data.split(",");
		return splits;
	}
	
	public String[] splitdatabyspchar(String data)
	{
//		String data = "FEATURED CONTENT,GALLERIES,USA TODAY ON TWITTER";
		String[] splits = data.split("#");
		return splits;
	}
	
	//********************************************************************************************************************
	//Generic function name :driverwait
	//Description : To wait for Ajax Elements.
	//********************************************************************************************************************	
	
	public String driverwait(WebDriver driver, int sec, String ele, String loc) throws Exception
	{
		String val="true";
		WebDriverWait wait = new WebDriverWait(driver, sec);
		if(ele.equalsIgnoreCase("id"))
		{
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(loc)));	
			if(element.equals(null))
			{
				val = "false";
			}
		}
		else if(ele.equalsIgnoreCase("css"))
		{
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(loc)));
			if(element.equals(null))
			{
				val = "false";
			}
		}
		else if(ele.equalsIgnoreCase("xpath"))
		{
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc)));
			if(element.equals(null))
			{
				val = "false";
			}
		}
		return val;
	}
	
	
	public Boolean Standheaders(WebDriver driver, String[] arr)
	{
		List<WebElement> tables = driver.findElements(By.xpath("//table[contains(@id,'DataTables_Table')]"));
		Boolean retval=true;
		for(int i=0; i<tables.size();i++)
		{
			List<WebElement> table = driver.findElements(By.xpath("//table[@id='DataTables_Table_"+i+"']/descendant::tr[1]/th"));
			for(int j=0;j<table.size();j++)
			{
				if(table.get(i).getText().equalsIgnoreCase(arr[i]))
				{
					retval=true;
				}
				else
				{
					retval=false;
				}
			}
		}
		return retval;
	}
	
	public Boolean standlegends(WebDriver driver, String arr[])
	{
		List<WebElement> toplegends = driver.findElements(By.xpath("//div[@class='playoff_status_Cont ']/descendant::dd"));
		List<WebElement> botlegends = driver.findElements(By.xpath("//div[contains(@class,'playoff_status_Cont alt')]/descendant::dd"));
		Boolean retval=true;
		for(int i=0; i<toplegends.size();i++)
		{
			
			if(toplegends.get(i).getText().equalsIgnoreCase(arr[i]) && botlegends.get(i).getText().equalsIgnoreCase(arr[i]))
			{
				retval=true;
			}
			else
			{
				retval=false;
			}
		}
		return retval;
	}
	
	public Boolean standseasons(WebDriver driver, String arr[])
	{
		Boolean retval=true;
//		WebElement dest = driver.findElement(By.xpath("//div[span[contains(text(),'Season')]]"));
//		Actions act = new Actions(driver);
//		act.moveToElement(dest).build().perform();
		List<WebElement> seasons = driver.findElements(By.xpath("//div[span[contains(text(),'Season')]]/descendant::li"));
		for(int i=0; i<seasons.size();i++)
		{
			if(seasons.get(i).getText().equalsIgnoreCase(arr[i]))
			{
				retval=true;
			}
			else
			{
				retval=false;
			}
		}
		return retval;
	}
	
	public Boolean standdivision(WebDriver driver, String arr[])
	{
		Boolean retval=true;
//		WebElement dest = driver.findElement(By.xpath("//div[span[contains(text(),'Division')]]"));
//		Actions act = new Actions(driver);
//		act.moveToElement(dest).build().perform();
		List<WebElement> seasons = driver.findElements(By.xpath("//div[span[contains(text(),'Division')]]/descendant::li"));
		for(int i=0; i<seasons.size();i++)
		{
			if(seasons.get(i).getText().equalsIgnoreCase(arr[i]))
			{
				retval=true;
			}
			else
			{
				retval=false;
			}
		}
		return retval;
	}
	
	public Boolean standribbons(WebDriver driver, String arr[])
	{
		Boolean retval=true;
		List<WebElement> seasons = driver.findElements(By.xpath("//article[@data-page='standings']/descendant::div[@class='panel-header']"));
		for(int i=0; i<seasons.size();i++)
		{
			if(seasons.get(i).getText().equalsIgnoreCase(arr[i]))
			{
				retval=true;
			}
			else
			{
				retval=false;
			}
		}
		return retval;
	}
	
	public boolean scheduledate(String input)
	{
		boolean retval;
		Pattern pattern;
		Matcher matcher;
		final String REGEX = "((MONDAY|TUESDAY|WEDNESDAY|THURSDAY|FRIDAY|SATURDAY|SUNDAY),\\s+( JANUARY|FEBRUARY|MARCH|APRILl|MAY|JUNE|JULY|AUGAST|SEPTEMBER|OCTOBER|NOVEMBER|DECEMBER)\\s+\\d{1,2}[SNRT][TDH])";
		pattern = Pattern.compile(REGEX);
		matcher = pattern.matcher(input);
		if(matcher.matches())
		{
			retval=true;
		}
		else
		{
			retval=false;
		}
		return retval;
	}
	
	public boolean Defschedulefilters(WebDriver driver, String arr[])
	{
		Boolean retval=true;
		List<WebElement> filters = driver.findElements(By.xpath("//div[@class='sp-filters']/div"));
		for(int i=0; i<filters.size();i++)
		{
			if(filters.get(i).getText().equalsIgnoreCase(arr[i]))
			{
				retval=true;
			}
			else
			{
				retval=false;
			}
		}
		return retval;
	}
	
	public Boolean schdheaders(WebDriver driver, String[] arr)
	{
		List<WebElement> tables = driver.findElements(By.xpath("//table[@class='schedule']"));
		Boolean retval=true;
		for(int i=1; i==tables.size();i++)
		{
			List<WebElement> table = driver.findElements(By.xpath("//table[i]/thead/descendant::th"));
			for(int j=1;j<table.size();j++)
			{
				if(table.get(i).getText().equalsIgnoreCase(arr[i]))
				{
					retval=true;
				}
				else
				{
					retval=false;
				}
			}
		}
		return retval;
	}
	
	public Boolean weekribbon(WebDriver driver)
	{
		Boolean retval=true;
		String ele1 = driver.findElement(By.xpath("//span[@class='sp-filter-btn sports-weekly-header-dropdown']")).getText();
		String ele2 = driver.findElement(By.xpath("//div[@class='panel-header']")).getText();
		if(ele1.equalsIgnoreCase(ele2))
		{
			retval=true;
		}
		else
		{
			retval=false;
		}
		return retval;
	}
	
	public boolean select(WebDriver driver, String xpath, String selection)
	{
		boolean retval=true;
		List<WebElement> options = driver.findElements(By.xpath(xpath));
		try
		{
			for(int i=0; i<options.size(); i++)
			{
				if(options.get(i).getText().equalsIgnoreCase(selection))
				{
					options.get(i).click();
					Thread.sleep(1000);
//					this.closesliderads(driver);
					break;
				}
			}
			retval=true;
		}
		catch(Exception e)
		{
			retval=false;
			e.printStackTrace();
		}
		return retval;
	}
	
	/*public void closesliderads(WebDriver driver) throws Exception
	{
		String loc ="//a[contains(@class,'partner-slider-close ui-sprite-before')]";
		String ele = "xpath";
		try
		{
			if(this.driverwait(driver, 10, ele, loc).equalsIgnoreCase("true"))
			{
				WebElement sliderad = driver.findElement(By.xpath(loc));
				sliderad.click();
				System.out.println("Selenium closed the Slider Ads");
			}
			else
			{
				System.out.println("Slider Ads not found");
			}
		}
		catch(Exception e)
		{
			System.out.println("Slider Ads not found");
		}
	}*/
	
/*	public void closeTransistionads(WebDriver driver) throws Exception
	{
		String loc ="//a[contains(@class,'partner-close partner-overlay-close')]";
		String ele = "xpath";
		try
		{
			if(this.driverwait(driver, 5, ele, loc).equalsIgnoreCase("true"))
			{
				WebElement Transistionad = driver.findElement(By.xpath(loc));
				Transistionad.click();
				System.out.println("Selenium closed the Transistion Ads");
			}
			else
			{
				System.out.println("Transistion Ads not found");
			}
		}
		catch(Exception e)
		{
			System.out.println("Transistion Ads not found");
		}
	}*/
	
	public boolean elementpresent(WebDriver driver, String xpath, String data) throws Exception
	{
		Reports report = Testexecutor.report;
		boolean retval=true;
		try
		{
			driver.findElement(By.xpath(xpath));
			String Passlog="PASS - Element '"+data+"' found";
			report.writePassLog(Passlog);
		}
		catch(Exception e)
		{
			Testexecutor.res=false;
			String Faillog="FAIL - Element '"+data+"' not found";
			report.writeFailLog(Faillog);
		}
		return retval;
	}
	
	
	
	
	public boolean statsteamleaderhdr(WebDriver driver, String xpath, String data) throws Exception
	{
		boolean retval=true;
		if(this.elementpresent(driver, xpath, data))
		{
			String eleval = driver.findElement(By.xpath(xpath)).getText();
			if(eleval.equalsIgnoreCase(data))
			{
				retval=true;
			}
			else
			{
				retval=false;
			}
		}
		return retval;
	}
	
	public Boolean statsKPI(WebDriver driver, String xpath, String arr[])
	{
		Boolean retval=true;
		List<WebElement> elements = driver.findElements(By.xpath(xpath));
		for(int i=0; i<elements.size();i++)
		{
			if(elements.get(i).getText().equalsIgnoreCase(arr[i]))
			{
				retval=true;
			}
			else
			{
				retval=false;
			}
		}
		return retval;
	}
	
	public Boolean KPIleaders(WebDriver driver, String xpath, String arr[]) throws Exception
	{
		Reports report = Testexecutor.report;
		Boolean retval=true;
		List<WebElement> elements = driver.findElements(By.xpath(xpath));
		List<WebElement> kpis = driver.findElements(By.xpath("//div[@class='sp-stats-leader-block ']/descendant::h3[@class='sp-stats-leader-subcategory']"));
		
		for(int i=0; i<elements.size();i++)
		{
			String kpi = kpis.get(i).getText();
			if(elements.get(i).getText().equalsIgnoreCase(arr[i]))
			{
				String Passlog= "PASS - "+kpi+" leader is displayed as '"+elements.get(i).getText()+"' and matched with expected value '"+arr[i]+"'";
				report.writePassLog(Passlog);
			}
			else
			{
				Testexecutor.res=false;
				String Faillog="FAIL - "+kpi+" leader is displayed as '"+elements.get(i).getText()+"' and doesn't matched with expected value '"+arr[i]+"'";
				report.writeFailLog(Faillog);
			}
		}
		return retval;
	}
	
	public Boolean KPIpleadersstats(WebDriver driver, String xpath, String arr[]) throws Exception
	{
		Reports report = Testexecutor.report;
		Boolean retval=true;
		List<WebElement> elements = driver.findElements(By.xpath(xpath));
		List<WebElement> kpis = driver.findElements(By.xpath("//div[@class='sp-stats-leader-block ']/descendant::h3[@class='sp-stats-leader-subcategory']"));
		List<WebElement> leaders = driver.findElements(By.xpath("//div[@class='sp-stats-leader-block ']/descendant::div[contains(@class,'leader-name')]"));
		for(int i=0; i<elements.size();i++)
		{
			String kpi = kpis.get(i).getText();
			String leader = leaders.get(i).getText();
			if(elements.get(i).getText().equalsIgnoreCase(arr[i]))
			{
				String Passlog= "PASS - "+kpi+" leader '"+leader+"' stats displayed as '"+elements.get(i).getText()+"' and matched with expected value '"+arr[i]+"'";
				report.writePassLog(Passlog);
			}
			else
			{
				Testexecutor.res=false;
				String Faillog="FAIL - "+kpi+" leader '"+leader+"' stats displayed as '"+elements.get(i).getText()+"' and doesn't matched with expected value '"+arr[i]+"'";
				report.writeFailLog(Faillog);
			}
		}
		return retval;
	}
	
	public Boolean KPItleadersstats(WebDriver driver, String xpath, String arr[]) throws Exception
	{
		Reports report = Testexecutor.report;
		Boolean retval=true;
		List<WebElement> elements = driver.findElements(By.xpath(xpath));
		List<WebElement> kpis = driver.findElements(By.xpath("//div[contains(@class,'sp-stats-leader-block')]/descendant::h3[@class='sp-stats-leader-subcategory']"));
		for(int i=0; i<elements.size();i++)
		{
			String kpi = kpis.get(i).getText();
			if(elements.get(i).getText().equalsIgnoreCase(arr[i]))
			{
				String Passlog= "PASS - "+kpi+" leader stats displayed as '"+elements.get(i).getText()+"' and matched with expected value '"+arr[i]+"'";
				report.writePassLog(Passlog);
			}
			else
			{
				Testexecutor.res=false;
				String Faillog="FAIL - "+kpi+" leader stats displayed as '"+elements.get(i).getText()+"' and doesn't matched with expected value '"+arr[i]+"'";
				report.writeFailLog(Faillog);
			}
		}
		return retval;
	}
	
	public Boolean viewall4KPI(WebDriver driver, String xpath, String data) throws Exception
	{
		Reports report = Testexecutor.report;
		Boolean retval=true;
		List<WebElement> elements = driver.findElements(By.xpath(xpath));
		List<WebElement> kpis = driver.findElements(By.xpath("//div[contains(@class,'sp-stats-leader-block')]/descendant::h3[@class='sp-stats-leader-subcategory']"));
		
		for(int i=0; i<elements.size();i++)
		{
			String kpi = kpis.get(i).getText();
			if(elements.get(i).getText().equalsIgnoreCase(data))
			{
				String Passlog= "PASS - View All links are displayed for '"+kpi+"' and link text matched with expected value '"+data+"'";
				report.writePassLog(Passlog);
			}
			else
			{
				Testexecutor.res=false;
				String Faillog="FAIL - View All links are not displayed for '"+kpi+"' OR link texts are not matched with expected value '"+data+"'";
				report.writeFailLog(Faillog);
			}
		}
		return retval;
	}
	
	
	public void leaguestatsribbon(WebDriver driver, String xpath, String data, String arr[]) throws Exception
	{
		Reports report = Testexecutor.report;
		List<WebElement> ribbons = driver.findElements(By.xpath(xpath));
		for(int i=0; i<arr.length; i++)
		{
			if(this.elementpresent(driver, xpath, data))
			{
				if(ribbons.get(i).getText().equalsIgnoreCase(arr[i]))
				{
					String Passlog= "PASS - Stats datatable Ribbon header displayed as '"+ribbons.get(i).getText()+"' and matched with expected value '"+arr[i]+"'";
					report.writePassLog(Passlog);
				}
				else
				{
					Testexecutor.res=false;
					String Faillog="FAIL - Stats datatable Ribbon header displayed as '"+ribbons.get(i).getText()+"' and doesn't matched with expected value '"+arr[i]+"'";;
					report.writeFailLog(Faillog);
				}
			}
		}
	}
	
	
	public boolean columnhdrs(WebDriver driver, String xpath, String data, String arr[])
	{
		boolean retval=true;
		List<WebElement> hdrs = driver.findElements(By.xpath(xpath));
		for(int i=0; i<hdrs.size();i++)
		{
			if(hdrs.get(i).getText().equalsIgnoreCase(arr[i]))
			{
				retval=true;
			}
			else
			{
				retval=false;
			}
		}
		return retval;
	}
	
	public void dataperpage(WebDriver driver, String xpath, String data1, String data2) throws Exception
	{
		Reports report = Testexecutor.report;
		List<WebElement> datarows = driver.findElements(By.xpath(xpath));
		if(datarows.size()==Integer.parseInt(data2))
		{
			String Passlog= "PASS - '"+data1+"' datatable displayed "+datarows.size()+" rows by default and matched with expected value "+data2;
			report.writePassLog(Passlog);
		}
		else
		{
			Testexecutor.res=false;
			String Faillog="FAIL - '"+data1+"' datatable displayed "+datarows.size()+" rows by default and doesn't matched with expected value "+data2;
			report.writeFailLog(Faillog);
		}
	}
	
	public boolean showmore(WebDriver driver, String xpath) throws Exception
	{
		boolean retval=true;
		List<WebElement> active = driver.findElements(By.xpath(xpath+"/following-sibling::div[1]/descendant::tbody/tr[not(contains(@class,'inactive'))]"));
		List<WebElement> inactive = driver.findElements(By.xpath(xpath+"/following-sibling::div[1]/descendant::tbody/tr[contains(@class,'inactive')]"));
		int i = active.size();
		int j = inactive.size();
		
		while(j!=0)
		{
			driver.findElement(By.xpath(xpath+"/following-sibling::div[2]/descendant::a")).click();
			Thread.sleep(1000);
			List<WebElement> active1 = driver.findElements(By.xpath(xpath+"/following-sibling::div[1]/descendant::tbody/tr[not(contains(@class,'inactive'))]"));
			if(j>=25)
			{
				if(active1.size()==(i=i+25))
				{
					System.out.println("Show more displayed 25 more data rows");
				}
				else
				{
					retval=false;
				}
			}
			else
			{
				if(active1.size()==(i+j))
				{
					System.out.println("Show more displayed "+j+" more data rows");
				}
				else
				{
					retval=false;
				}
			}
			List<WebElement> inactive1 = driver.findElements(By.xpath(xpath+"/following-sibling::div[1]/descendant::tbody/tr[contains(@class,'inactive')]"));
			j=inactive1.size();
		}
		return retval;
	}
	
	public void verifycolhighlight(WebDriver driver, String data, String darr) throws Exception
	{
		Reports report = Testexecutor.report;
		String node="//table[@data-category='"+data+"']/descendant::";
		try
		{
			driver.findElement(By.xpath(node+"th[contains(@aria-sort,'descending') or contains(@aria-sort,'ascending')]"));
			String colname=driver.findElement(By.xpath(node+"th[contains(@aria-sort,'descending') or contains(@aria-sort,'ascending')]")).getText();
			if(colname.equalsIgnoreCase(darr))
			{
				String Passlog= "PASS - "+colname+" column highlighted on clicking "+data+"'s View All link and matched with expected column name";
				report.writePassLog(Passlog);
			}
			else
			{
				Testexecutor.res=false;
				String Faillog="FAIL - "+colname+" column highlighted on clicking "+data+"'s View All link and doesn't matched with expected column name";
				report.writeFailLog(Faillog);
			}
		}
		catch(Exception e)
		{
			Testexecutor.res=false;
			String Faillog="FAIL - No columns are highlighted on clicking "+data+"'s View All link";
			report.writeFailLog(Faillog);
		}
	}
	
	public void verifyplayer(WebDriver driver, String xpath, String data) throws Exception
	{
		Reports report = Testexecutor.report;
		String tplr = driver.findElement(By.xpath("//table[@data-category='"+data+"']/descendant::tbody/tr[1]/td[2]")).getText();
		String[] arr = tplr.split(",");
		String lplr = driver.findElement(By.xpath(xpath)).getText();
		if(lplr.equalsIgnoreCase(arr[0]))
		{
			String Passlog= "PASS - Player name("+arr[0]+") on datatable matched with player name("+lplr+") in leader module";
			report.writePassLog(Passlog);
		}
		else
		{
			Testexecutor.res=false;
			String Faillog="FAIL - Player name("+arr[0]+") on datatable is not matched with player name("+lplr+") in leader module";
			report.writeFailLog(Faillog);
		}
	}
	
	public void verifyplrstats(WebDriver driver, String xpath, String data) throws Exception
	{
		Reports report = Testexecutor.report;
		String tstats = driver.findElement(By.xpath("//table[@data-category='"+data+"']/descendant::tbody/tr[1]/td[contains(@class,'sorting')]")).getText();
		System.out.println(tstats);
		String lstats = driver.findElement(By.xpath(xpath)).getText();
		System.out.println(lstats);
		String[] arr = lstats.split(" ");
		System.out.println(arr[0]);
		String[] arr1 = arr[0].split(",");
		System.out.println(arr1[0]);
		String lstat="";
		if(arr1.length>1)
		{
		lstat = arr1[0] + arr1[1];
		System.out.println(lstat);
		}
		else
		{
			lstat = arr1[0];
		}
		
		
		if(tstats.equalsIgnoreCase(lstat))
		{
			String Passlog= "PASS - Player stats("+tstats+") on datatable matched with player stats("+arr[0]+") in leader module";
			report.writePassLog(Passlog);
		}
		else
		{
			Testexecutor.res=false;
			String Faillog="FAIL - Player stats("+tstats+") on datatable is not matched with player stats("+arr[0]+") in leader module";
			report.writeFailLog(Faillog);
		}
	}
	
	
	public void pagescrollup(WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(250, 0)"); 
	}
	
	/*public void closebreakingnews(WebDriver driver) throws Exception
	{
		String loc ="//div[@id='breaking-bar']/descendant::span[text()='Close']";
		String ele = "xpath";
		try
		{
			if(this.driverwait(driver, 10, ele, loc).equalsIgnoreCase("true"))
			{
				WebElement sliderad = driver.findElement(By.xpath(loc));
				sliderad.click();
				System.out.println("Selenium closed the Breaking News Ads");
			}
			else
			{
				System.out.println("Breaking News Ads not found");
			}
		}
		catch(Exception e)
		{
			System.out.println("Breaking News Ads not found");
		}
	}*/
	
	public boolean NFLfinalcards(WebDriver driver, String season, String week) throws Exception
	{
		Reports report = Testexecutor.report;
		boolean retval=true;
		List<WebElement> pscrcards = driver.findElements(By.xpath("//div[contains(@class,'post-event')]"));
			for(int i=0; i<pscrcards.size(); i++)
			{
				List<WebElement> eles = pscrcards.get(i).findElements(By.className("teamname"));
				try
				{
					String txt = pscrcards.get(i).findElement(By.tagName("h3")).getText();
					if(txt.equals("Final") || txt.equals("Final OT"))
					{
						retval=true;
						//System.out.println("All Post event score cards displayed 'Final' status");
					}
					else
					{
						Testexecutor.res=false;
						String Faillog="Post event score cards status displayed as "+txt+" instead of 'Final' or 'Final OT', for game b/n teams "+eles.get(0).getText()+" Vs "+eles.get(1).getText()+" from Season="+season+" and Week="+week;
						report.writeFailLog(Faillog);
						retval=false;
						//System.out.println("Post event score cards status displayed as "+txt+" instead of 'Final' or 'Final OT', for game b/n teams "+eles.get(0).getText()+" Vs "+eles.get(1).getText()+" from Season="+season+" and Week="+week);
					}
				}
				catch(Exception e)
				{
					Testexecutor.res=false;
					String Faillog="Score card's status element not found for game b/n teams "+eles.get(0).getText()+" Vs "+eles.get(1).getText()+" from Season="+season+" and Week="+week;
					report.writeFailLog(Faillog);
					retval=false;
					//System.out.println("Score card's status element not found for game b/n teams "+eles.get(0).getText()+" Vs "+eles.get(1).getText()+" from Season="+season+" and Week="+week);
				}
			}
		return retval;
	}
	
	public boolean NHLfinalcards(WebDriver driver, String date) throws Exception
	{
		Reports report = Testexecutor.report;
		boolean retval=true;
		List<WebElement> pscrcards = driver.findElements(By.xpath("//div[contains(@class,'post-event')]"));
			for(int i=0; i<pscrcards.size(); i++)
			{
				List<WebElement> eles = pscrcards.get(i).findElements(By.className("teamname"));
				try
				{
					String txt = pscrcards.get(i).findElement(By.tagName("h3")).getText();
					if(txt.equals("Final") || txt.equals("Final SO"))
					{
						retval=true;
						//System.out.println("All Post event score cards displayed 'Final' status");
					}
					else
					{
						Testexecutor.res=false;
						String Faillog="Post event score cards status displayed as "+txt+" instead of 'Final' or 'Final OT', for game b/n teams "+eles.get(0).getText()+" Vs "+eles.get(1).getText()+" of date:"+date;
						report.writeFailLog(Faillog);
						retval=false;
						//System.out.println("Post event score cards status displayed as "+txt+" instead of 'Final' or 'Final OT', for game b/n teams "+eles.get(0).getText()+" Vs "+eles.get(1).getText()+" from Season="+season+" and Week="+week);
					}
				}
				catch(Exception e)
				{
					Testexecutor.res=false;
					String Faillog="Score card's status element not found for game b/n teams "+eles.get(0).getText()+" Vs "+eles.get(1).getText()+" of date:"+date;
					report.writeFailLog(Faillog);
					retval=false;
					//System.out.println("Score card's status element not found for game b/n teams "+eles.get(0).getText()+" Vs "+eles.get(1).getText()+" from Season="+season+" and Week="+week);
				}
			}
		return retval;
	}
	
	
	public boolean dispofNFLldrmodule(WebDriver driver, String season, String week) throws Exception
	{
		Reports report = Testexecutor.report;
		boolean retval=true;
		List<WebElement> pscrcards = driver.findElements(By.xpath("//div[contains(@class,'post-event')]"));
			for(int i=0; i<pscrcards.size(); i++)
			{
				List<WebElement> eles = pscrcards.get(i).findElements(By.className("teamname"));
				try
				{
					pscrcards.get(i).findElement(By.className("breakdown"));
					retval=true;
				}
				catch(Exception e)
				{
					Testexecutor.res=false;
					String Faillog="Leader module is not displayed for post event score cards of teams "+eles.get(0).getText()+" Vs "+eles.get(1).getText()+" from Season="+season+" and Week="+week;
					report.writeFailLog(Faillog);
					retval=false;
					//System.out.println("Leader module is not displayed for post event score cards of teams "+eles.get(0).getText()+" Vs "+eles.get(1).getText()+" from Season="+season+" and Week="+week);
				}	
			}
		return retval;
	}
	
	public boolean dispofNHLldrmodule(WebDriver driver, String date) throws Exception
	{
		Reports report = Testexecutor.report;
		boolean retval=true;
		List<WebElement> pscrcards = driver.findElements(By.xpath("//div[contains(@class,'post-event')]"));
			for(int i=0; i<pscrcards.size(); i++)
			{
				List<WebElement> eles = pscrcards.get(i).findElements(By.className("teamname"));
				try
				{
					pscrcards.get(i).findElement(By.className("breakdown"));
					retval=true;
				}
				catch(Exception e)
				{
					Testexecutor.res=false;
					String Faillog="Leader module is not displayed for post event score cards of teams "+eles.get(0).getText()+" Vs "+eles.get(1).getText()+" of date "+date;
					report.writeFailLog(Faillog);
					retval=false;
					//System.out.println("Leader module is not displayed for post event score cards of teams "+eles.get(0).getText()+" Vs "+eles.get(1).getText()+" from Season="+season+" and Week="+week);
				}	
			}
		return retval;
	}
	
	public boolean contextlinkclick(WebDriver driver, String t1, String t2, String link) throws Exception
	{
		Reports report = Testexecutor.report;
		boolean retval=false;
		WebElement ele = driver.findElement(By.xpath("//div[ul[li/ul[@class='teamgroupcont']/descendant::a[contains(text(),'"+t1+"')] and li/ul[@class='teamgroupcont']/descendant::a[contains(text(),'"+t2+"')]]]"));
		WebElement ele1 = ele.findElement(By.className("contextlinks"));
		List<WebElement> list = ele1.findElements(By.tagName("a"));
		List<WebElement> ele2 = ele.findElements(By.className("label"));
		String team1 = ele2.get(0).findElement(By.tagName("a")).getText();
		String team2 = ele2.get(1).findElement(By.tagName("a")).getText();
		
		for(int i=0; i<list.size(); i++)
		{
			if(list.get(i).getText().equalsIgnoreCase(link))
			{
				Thread.sleep(5000);
				list.get(i).click();
				retval=true;
//				System.out.println("Selenium clicked on '"+list.get(i).getText()+"' contextlink of teams '"+team1+"' Vs '"+team2+"'");
				String Passlog= "PASS - Selenium clicked on '"+list.get(i).getText()+"' contextlink of teams '"+team1+"' Vs '"+team2+"'";
				report.writePassLog(Passlog);
				try
				{
					driver.findElement(By.xpath("//div[@id='overlay']"));
					List<WebElement> ovteams = driver.findElements(By.xpath("//div[@class='details']/descendant::h2"));
					String tab = driver.findElement(By.xpath("//div[@class='navigation']/descendant::a[@class='active']")).getText();	
					if(team1.equals(ovteams.get(0).getText()) && team2.equals(ovteams.get(1).getText()))
						{
							Passlog= "PASS - "+tab+"' overlay page displayed for teams '"+ovteams.get(0).getText()+"' Vs '"+ovteams.get(1).getText()+"'";
							report.writePassLog(Passlog);
//							System.out.println(tab+"' overlay page displayed for teams '"+ovteams.get(0).getText()+"' Vs '"+ovteams.get(1).getText()+"'");
						}
						else
						{
							Testexecutor.res=false;
							String Faillog="FAIL - "+tab+"' overlay page is not displayed for teams teams '"+ovteams.get(0).getText()+"' Vs '"+ovteams.get(1).getText()+"'";
							report.writeFailLog(Faillog);
//							System.out.println(tab+"' overlay page is not displayed for teams teams '"+ovteams.get(0).getText()+"' Vs '"+ovteams.get(1).getText()+"'");
						}	
				}
				catch(Exception e)
				{
					Testexecutor.res=false;
					String Faillog="FAIL - Overlay page is not displayed";
					report.writeFailLog(Faillog);
//					System.out.println("Overlay page is not displayed");
				}
			}
		}
	return retval;
	}
	
	
	public boolean ctrlonoverview(WebDriver driver, String t1, String t2, String tabselect)
	{
		boolean retval=true;
		List<WebElement> ovteams = driver.findElements(By.xpath("//div[@class='details']/descendant::h2"));
		String tab = driver.findElement(By.xpath("//div[@class='navigation']/descendant::a[@class='active']")).getText();	
		if(tabselect.equals(tab))
		{
			if(t1.equals(ovteams.get(0).getText()) && t2.equals(ovteams.get(1).getText()))
			{
				retval=true;
			}
			else
			{
				retval=false;
			}
		}
		else
		{
			retval=false;
		}
		return retval;
	}
	
	public int getelementscnt(WebDriver driver, String xpath)throws Exception
	{
		List<WebElement> eles = driver.findElements(By.xpath(xpath));
		return eles.size();
	}
	
	public boolean teamIndexCrdLinks(WebDriver driver) throws Exception
	{
		Reports report = Testexecutor.report;
		MouseActions act = new MouseActions();
		boolean retval=false;
		List<WebElement> divcnt = driver.findElements(By.xpath("//div[@class='sports index']/div"));
		int cnt = divcnt.size()-1;
		for(int i=0; i<divcnt.size()-cnt; i++)
		{
			int p=0;
			p=i+1;
			List<WebElement> scrcardscnt = driver.findElements(By.xpath("//div[@class='sports index']/div["+p+"]/descendant::li"));
			for(int j=0; j<scrcardscnt.size(); j++)
			{
				int q=0;
				q=j+1;
				List<WebElement> hoverlinkscnt = driver.findElements(By.xpath("//div[@class='sports index']/div["+p+"]/descendant::li["+q+"]/descendant::dt"));
				for(int k=0; k<hoverlinkscnt.size(); k++)
				{
					int r=0;
					r=k+1;
					System.out.println(p);
					System.out.println(q);
					System.out.println(r);
					
					String tname1 = driver.findElement(By.xpath("//div[@class='sports index']/div["+p+"]/descendant::li["+q+"]/descendant::label")).getText();
					String tname2 = driver.findElement(By.xpath("//div[@class='sports index']/div["+p+"]/descendant::li["+q+"]/descendant::strong")).getText();
					String tname = tname1.concat(" "+tname2);
					
					WebElement ele = driver.findElement(By.xpath("//div[@class='sports index']/div["+p+"]/descendant::li["+q+"]/descendant::dt["+r+"]"));
					act.movetoelement(driver, ele);
					Thread.sleep(2000);
					String link = ele.getText();
					System.out.println(link);
					Thread.sleep(2000);
					
					if(link.equalsIgnoreCase("Roster"))
					{
						String rtname = tname.concat(" "+link);
						System.out.println(rtname);
						act.movetoelement(driver, ele);
						ele.click();
						Set<String> allHandles = driver.getWindowHandles();
						Iterator<String> it = allHandles.iterator();
						String parentWindow = it.next();
						String childWindow = it.next();
						driver.switchTo().window(childWindow);
						String roster_pg_hdr = driver.findElement(By.xpath("//td[@class='TSN1d']")).getText();
						System.out.println(roster_pg_hdr);
						if(rtname.equalsIgnoreCase(roster_pg_hdr))
						{
							retval=true;
							System.out.println("Displayed "+roster_pg_hdr+" page in new browser tab.");
						}
						else
						{
							Testexecutor.res=false;
							String Faillog="FAIL - Failed to open "+roster_pg_hdr+" page in new browser tab.";
							report.writeFailLog(Faillog);
						}
						String url = driver.getCurrentUrl();
						String title = driver.getTitle();
						System.out.println(url);
						System.out.println(title);
						driver.close();
						driver.switchTo().window(parentWindow);
					}
					else if(link.equalsIgnoreCase("Team Home"))
					{
						String purl = driver.getCurrentUrl();
						System.out.println(purl);
						Thread.sleep(3000);
						ele.click();
						Thread.sleep(20000);
						String curl = driver.getCurrentUrl();
						String tmname1 = driver.findElement(By.xpath("//span[contains(@class,'first-name')]")).getText();
						String tmname2 = driver.findElement(By.xpath("//span[contains(@class,'last-name')]")).getText();
						String tmname = tmname1.concat(" "+tmname2);
						System.out.println(tmname);
						System.out.println(tname);
						if(tname.equalsIgnoreCase(tmname))
						{
							retval=true;
							System.out.println("Displayed "+tmname+"'s team front.");
						}
						else
						{
							Testexecutor.res=false;
							String Faillog="FAIL - Failed to open "+tmname+"'s team front.";
							report.writeFailLog(Faillog);
						}
						System.out.println(curl);
						driver.navigate().to(purl);
						Thread.sleep(5000);
					}
					else if(link.equalsIgnoreCase("Schedule"))
					{
						String purl = driver.getCurrentUrl();
						System.out.println(purl);
						System.out.println(tname);
						Thread.sleep(6000);
						ele.click();
						Thread.sleep(20000);
						String curl = driver.getCurrentUrl();
						String tmname1 = driver.findElement(By.xpath("//span[contains(@class,'first-name')]")).getText();
						String tmname2 = driver.findElement(By.xpath("//span[contains(@class,'last-name')]")).getText();
						String tmname = tmname1.concat(" "+tmname2);
						System.out.println(tmname);
						String head = driver.findElement(By.xpath("//h3[contains(@class,'sp-page-type')]")).getText();
						if(tname.equalsIgnoreCase(tmname))
						{
							if(link.equalsIgnoreCase(head))
							{
								retval=true;
								System.out.println(tmname+"'s "+link+" page is displayed.");
							}
							else
							{
								Testexecutor.res=false;
								String Faillog="FAIL - "+tmname+"'s "+head+" page is displayed instead of "+link;
								report.writeFailLog(Faillog);
							}
						}
						else
						{
							retval=false;
							System.out.println("Failed to open proper page");
						}
						System.out.println(curl);
						driver.navigate().to(purl);
						Thread.sleep(10000);
					}
					else if(link.equalsIgnoreCase("Statistics"))
					{
						
						System.out.println(tname);
						Thread.sleep(6000);
						String purl = driver.getCurrentUrl();
						ele.click();
						Thread.sleep(20000);
						Set<String> allHandles = driver.getWindowHandles();
						Iterator<String> it = allHandles.iterator();
						int wcnt = allHandles.size();
						System.out.println(wcnt);
						/*	wcnt=1;
						while(it.hasNext())
						{
							wcnt++;
						}*/
						if(wcnt>1)
						{
							String rtname = tname.concat(" "+link);
							System.out.println(rtname);
							String parentWindow = it.next();
							String childWindow = it.next();
							driver.switchTo().window(childWindow);
							String stats_pg_hdr = driver.findElement(By.xpath("//font[@class='TSN1d']")).getText();
							System.out.println(stats_pg_hdr);
								if(stats_pg_hdr.contains(tname.concat(" Team "+link)))
								{
								retval=true;
								System.out.println("Displayed "+stats_pg_hdr+" page in new browser tab.");
								}
								else
								{
								Testexecutor.res=false;
								String Faillog="FAIL - Failed to open "+stats_pg_hdr+" page in new browser tab.";
								report.writeFailLog(Faillog);
								}
							String url = driver.getCurrentUrl();
							String title = driver.getTitle();
							System.out.println(url);
							System.out.println(title);
							driver.close();
							driver.switchTo().window(parentWindow);	
						}
						
						else {	
						/*	String purl = driver.getCurrentUrl();
							System.out.println(purl);
							String url = driver.getCurrentUrl();
							String title = driver.getTitle();
							System.out.println(url);
							System.out.println(title);
							driver.close();
							driver.switchTo().window(parentWindow);*/
							
						
						System.out.println(purl);
						System.out.println(tname);
						String curl = driver.getCurrentUrl();
						String tmname1 = driver.findElement(By.xpath("//span[contains(@class,'first-name')]")).getText();
						String tmname2 = driver.findElement(By.xpath("//span[contains(@class,'last-name')]")).getText();
						String tmname = tmname1.concat(" "+tmname2);
						System.out.println(tmname);
						String head = driver.findElement(By.xpath("//h3[contains(@class,'sp-page-type')]")).getText();
						if(tname.equalsIgnoreCase(tmname))
						{
							if(link.equalsIgnoreCase(head))
							{
								retval=true;
								System.out.println(tmname+"'s "+link+" page is displayed.");
							}
							else
							{
								Testexecutor.res=false;
								String Faillog="FAIL - "+tmname+"'s "+head+" page is displayed instead of "+link;
								report.writeFailLog(Faillog);
							}
						}
						else
						{
							Testexecutor.res=false;
							String Faillog="FAIL - Failed to open proper page.";
							report.writeFailLog(Faillog);
							retval=false;
						}
						System.out.println(curl);
						driver.navigate().to(purl);
						Thread.sleep(10000);
					}
				}
			}
		}
		}	
		return retval;
	}
	
	
	public boolean TmIndexDrpdn(WebDriver driver, String select,String arr[]) throws Exception
	{
		MouseActions act = new MouseActions();
		boolean retval=true;
		WebElement ele = driver.findElement(By.xpath("//span[@class='sp-filter-btn sports-weekly-header-dropdown']"));
		act.movetoelement(driver, ele);
		String xpath = "//li[@class='sp-filter-item']/descendant::a";
		String selection = select;
		this.select(driver,xpath,selection);
		Thread.sleep(3000);
//		String selected = ele.getText();
		List<WebElement> headers = driver.findElements(By.xpath("//div[contains(@class,'teams') and @style='display: block;']/descendant::h3"));
		System.out.println(headers.size());
		System.out.println(arr.length);
		for(int i=0; i<headers.size();i++)
		{
			if(headers.get(i).getText().equalsIgnoreCase(arr[i]))
			{
				retval=true;
			}
			else
			{
				retval=false;
			}
		}
		return retval;
	}
	
	public boolean VerifyConnectionErrs(WebDriver driver)
	{
		boolean retval = false;	
		try
		{
			WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'Connection Error')]"));
			retval = true;
		}
		catch(Exception e)
		{
			//e.printStackTrace();	
		}
		return retval;
	}
	
	public void CloseConnectionErrs(WebDriver driver)
	{
		driver.findElement(By.xpath("//span[contains(text(),'Connection Error')]/following-sibling::span")).click();
	}
	
	public void selectmonth(WebDriver driver, String mnth)
	{
		WebElement month = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select select = new Select(month);
		select.selectByVisibleText(mnth);
	}
	
	public void selectyear(WebDriver driver, String yrs)
	{
		WebElement year = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select select = new Select(year);
		select.selectByVisibleText(yrs);
	}
	
	public void selectdate(WebDriver driver, String date) throws Exception
	{
		String sdate=null;
		List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/descendant::tbody/tr/td/a"));
		for(int i=0; i<dates.size();i++)
		{
			String sval = dates.get(i).getText();
			if(sval.equalsIgnoreCase(date))
			{
				dates.get(i).click();
			}
		}
	//	this.closesliderads(driver);
		sdate = driver.findElement(By.xpath("//input[@class='ui-date-picker sp-filter-date-picker-input hasDatepicker']")).getAttribute("value");
		if(this.VerifyConnectionErrs(driver))
		{
			Reports report = Testexecutor.report;
			System.out.println("Connection Error displayed on selecting date: "+sdate+" from the DatePicker.");
			Testexecutor.res=false;
			String Faillog="FAIL - Connection Error displayed on selecting date: "+sdate+" from the DatePicker.";
			report.writeFailLog(Faillog);
			this.CloseConnectionErrs(driver);
		}
		else
		{
			System.out.println("No Connection Error displayed on selecting date: "+sdate+" from the DatePicker.");
		}
	}
	
	public void waitforPageLoad(WebDriver driver)
	{
		String locxpath = "//section[@id='sections_sports' and @class='card sports card-loading']";
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try
		{
			Boolean element = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locxpath)));
			if(element)
			{
				System.out.println("Overlay Load event closed");
			}
		}
		catch(Exception e)
		{
			System.out.println("Overlay load event not found");
		}
	}
	
	public void waitforOverlayLoad(WebDriver driver)
	{
		String locxpath = "//article[@class='asset clearfix story ui-loading light-medium']";
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try
		{
			Boolean element = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locxpath)));
			if(element)
			{
				System.out.println("Overlay Load event closed");
			}
		}
		catch(Exception e)
		{
			System.out.println("Overlay load event not found");
		}
	}
}
