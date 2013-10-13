package com.usatoday.Libraries;
import com.usatoday.Libraries.*;
import com.usatoday.frameworkengine.Maindriver;

public class Configurations 
{
	public String Browser;
	public String Url;
	public String Os;
	public String BrowserVersion;
	public String Environment;
	public String Utilpath = System.getProperty("user.dir")+"/Utility.xls";
	public String Testpath = Maindriver.testpath;
	public String ResultPath = Maindriver.rspath;
	public String FinalReportPath;
	public String sports = Maindriver.Sports;
	
	public Configurations()
	{
		ExcelLibrary xl = new ExcelLibrary();
		this.Browser =xl.getExcelData(Utilpath,"Setup", 1, 1);
		this.Url =xl.getExcelData(Utilpath,"Setup", 2, 1);
		this.Os =xl.getExcelData(Utilpath,"Setup", 3, 1);
		this.BrowserVersion =xl.getExcelData(Utilpath,"Setup", 4, 1);
		this.Environment = xl.getExcelData(Utilpath,"Setup", 5, 1);
		this.FinalReportPath = xl.getExcelData(System.getProperty("user.dir")+"\\Modular.xlsx", "FinalReport", 0, 1);
	}

}
