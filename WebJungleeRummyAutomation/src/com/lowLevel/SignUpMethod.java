package com.lowLevel;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pageObjectRepo.HomePage;

public class SignUpMethod {
	public static String newUserName;
	public static String userpassword;
	public static String emailAddress;
	
	static WebDriverWait wait = new WebDriverWait(CommonMethods.driver, 20);
	
	static Logger smLog = Logger.getLogger(SignUpMethod.class);
	
	public static int registratiOnWebRummy() 
	{
		myloop: for (int i = 0; i < 3; i++) {
           smLog.info("Registration with new user");
		 //  System.out.println("Registration with new user");
			CommonMethods.driver.get("https://jungleerummy.com");
			try {
				Boolean checkIfAlreadyLogged = (CommonMethods.driver.findElements(By.id("logout-btn")).size()!=0);
				if (checkIfAlreadyLogged) {
					CommonMethods.driver.findElement(By.id("logout-btn")).click();
				//	System.out.println("logged out before logging in");
					smLog.info("logged out before logging in");
					CommonMethods.driver.navigate().refresh();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//signup//div[2]//input[1]")));

				} else {
					//Do nothing
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				smLog.error(e.getMessage());
			}
			String getNewUserName = CommonMethods.currentTimeMenthod();
			// System.out.println(getNewUserName);
			smLog.info(getNewUserName);
			HomePage.SignUpName.sendKeys(getNewUserName);
			HomePage.SignUpPassword.sendKeys("hitesh654");
			HomePage.SignUpEmail.sendKeys("test"+Math.random()*100+"@xyz.com");

			// Check for bottom left notification
			boolean temp = (CommonMethods.driver.findElements(By.xpath(".//*[@id='ltr-bottom-right']/div/div[1]/span/span")).size()!=0);
			try{
				if(temp)
				{	
					CommonMethods.driver.findElement(By.xpath(".//*[@id='ltr-bottom-right']/div/div[1]/span/span")).click();
				//	System.out.println("close the bottom left notification");
					smLog.info("close the bottom left notification");
				}
			}
			catch(Exception e)
			{
				// TODO Auto-generated catch block
				// System.err.println("");
				smLog.error(e.getMessage());
			}
			try{
				WebElement playNow = wait.until(ExpectedConditions.visibilityOf(HomePage.ButtonPlayRummyNow));
				boolean status=playNow.isDisplayed();
				if(status)
					//Click on play rummy now button
					HomePage.ButtonPlayRummyNow.click();
				long start=System.currentTimeMillis();
				smLog.info("Clicked on Play now Button");
			//	System.out.println("PLAY NOW DONE");
				wait = new WebDriverWait(CommonMethods.driver, 20);
			    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("logout-btn")));
			    long finish = System.currentTimeMillis();
		        long totalTime = finish - start; 
		        System.out.println("Total Time for page load - "+totalTime);
				
			}
			catch(Exception e)
			{
				smLog.error(e.getMessage());
			}

			File scrFile = ((TakesScreenshot)CommonMethods.driver).getScreenshotAs(OutputType.FILE);
			// Now you can do whatever you need to do with it, for example copy somewhere
			try {
				FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				smLog.error(e.getMessage());
			}

			String url = CommonMethods.driver.getCurrentUrl();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				smLog.error(e.getMessage());;
			}
			if (url.contains("Reg=success"))
			{
				smLog.info("reg is successful");
			//	System.out.println("reg is successful");
				CommonMethods.flag= true;
				break myloop;

			}

			else {
				smLog.warn("login tried" + ++CommonMethods.temp + " time");
			//	System.out.println("login tried" + ++CommonMethods.temp + " time");
				CommonMethods.driver.navigate().refresh();
				continue;
			}

		}
	return CommonMethods.temp;

	}

	public static int CheckSignUpPlaceHolder() { 
		myloop: for (int i = 0; i < 3; i++) {
			try {
				Boolean checkIfAlreadyLogged = (CommonMethods.driver.findElements(By.id("logout-btn")).size()!=0);
				if (checkIfAlreadyLogged) {
					CommonMethods.driver.findElement(By.id("logout-btn")).click();
					smLog.warn("logged out before logging in");
				//	System.out.println("logged out before logging in");
					CommonMethods.driver.navigate().refresh();
					wait.until(ExpectedConditions.visibilityOf(HomePage.SignUpName));

				} else {
					//Do nothing
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				smLog.error(e.getMessage());
			}
			String username =HomePage.SignUpName.getAttribute("placeholder"); 
			System.out.println(HomePage.SignUpName.getAttribute("placeholder"));
			String password= HomePage.SignUpPassword.getAttribute("placeholder");
			String email = HomePage.SignUpEmail.getAttribute("placeholder");
			String Signup_Username_AR = username;
			String Signup_Password_AR = password;
			String Signup_Email_AR = email;
			String SignUp_Username_ER = CommonMethods.prop.getProperty("Signup__PlaceHolder_Name");
			String SignUp_Password_ER = CommonMethods.prop.getProperty("Signup__PlaceHolder_Password");
			String SignUp_Email_ER = CommonMethods.prop.getProperty("Signup__PlaceHolder_Email");
			if((Signup_Username_AR.equals(SignUp_Username_ER) && (Signup_Password_AR.equals(SignUp_Password_ER) 
					&& (Signup_Email_AR.equals(SignUp_Email_ER)))))
			{
				smLog.warn("Placeholder test cases done successfully");
			//	System.out.println("Placeholder test cases done successfully");
				CommonMethods.flag= true;
				break myloop;
			}
			else {
				smLog.warn("tried" + ++CommonMethods.temp + " time");
			//	System.out.println("tried" + ++CommonMethods.temp + " time");
				CommonMethods.driver.navigate().refresh();
				continue;
			}

		}
	return CommonMethods.temp;
	}

	public static void CheckValidationErrorMessage() { 
		myloop: for (int i = 0; i < 3; i++) {	
			try {
				Boolean checkIfAlreadyLogged = (CommonMethods.driver.findElements(By.id("logout-btn")).size()!=0);
				if (checkIfAlreadyLogged) {
					CommonMethods.driver.findElement(By.id("logout-btn")).click();
					smLog.warn("logged out before logging in");
					//	System.out.println("logged out before logging in");
					CommonMethods.driver.navigate().refresh();
					wait.until(ExpectedConditions.visibilityOf(HomePage.SignUpName));

				} else {
					//Do nothing
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				smLog.error(e.getMessage());
			}

			CommonMethods.driver.navigate().refresh();
			wait.until(ExpectedConditions.visibilityOf(HomePage.ButtonPlayRummyNow));
			// Special character validation message + Already registered email id 
			HomePage.SignUpName.sendKeys("addab@2djsds");
			HomePage.SignUpPassword.sendKeys("hitesh654");
			HomePage.SignUpEmail.sendKeys("nitesh@jungleegames.com");
			HomePage.ButtonPlayRummyNow.click();
			String AR= HomePage.ValidationCheckOnUserName.getText();
			String ER= CommonMethods.prop.getProperty("Signup_ValidationCheckOnUserName");
			if(AR.equals(ER))
			{
				smLog.info("Vlaidation check for username done successfully");
			//	System.out.println("Vlaidation check for username done successfully");
				CommonMethods.flag= true;
				break myloop;

			}
			else{
			//	System.out.println("tried" + ++CommonMethods.temp + " time");
				smLog.warn("tried" + ++CommonMethods.temp + " time");		
				CommonMethods.driver.navigate().refresh();
				continue;
			}
		}


	}

}