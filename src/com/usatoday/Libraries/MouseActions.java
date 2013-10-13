package com.usatoday.Libraries;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseActions 
{
	public void movetoelement(WebDriver driver, WebElement delement)
	{
		Actions act = new Actions(driver);
		act.moveToElement(delement).build().perform();
	}
	
	public void pagescroll(WebDriver driver)
	{
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.HOME).perform();
	}

}
