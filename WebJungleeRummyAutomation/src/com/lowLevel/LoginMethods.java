package com.lowLevel;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pageObjectRepo.HomePage;
import jxl.read.biff.BiffException;

public class LoginMethods extends HomePage {

	static Logger lmLog = Logger.getLogger(LoginMethods.class);
	public static String userName;
	public static String password;
	private static long start=0;
	private static long finish=0;
	private static long totalTime=0;

	static WebDriverWait wait = new WebDriverWait(CommonMethods.driver, 10);
	public static int loginWithValidUser(String userName,String password) throws BiffException, IOException, TimeoutException {
		myloop: for (int i = 0; i < 3; i++) {
			try {
				Boolean checkIfUserAlreadyLogged = (CommonMethods.driver.findElements(By.id("logout-btn")).size()!=0);
				if (checkIfUserAlreadyLogged) {
					CommonMethods.driver.findElement(By.id("logout-btn")).click();
					lmLog.warn("logged out before checking another case");
				} 
			} catch (Exception e) {
				lmLog.error("received error message", e);
			}	
			try{
				CommonMethods.driver.navigate().refresh();
				wait.until(ExpectedConditions.visibilityOf(loginName));	
				loginName.clear();
				loginName.sendKeys(userName);
				loginPassword.clear();
				loginPassword.sendKeys(password);
				submitLogin.click();
				start=System.currentTimeMillis();
				//Look for logout button after successful logging in 
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id("logout-btn"))); 
				// 	Count the total login time 
				String url= CommonMethods.driver.getCurrentUrl();
				CommonMethods.driver.get(url);
				finish = System.currentTimeMillis();
				totalTime = finish - start; 
				lmLog.info("Total time for page load - "+totalTime);
				System.out.println("Total time for page load - "+totalTime); 
				CsvWritter.appendAvgResponseTimeInCsvFile(""+totalTime);
				lmLog.info("Login with valid user test done successfully");
				CommonMethods.flag= true;
				break myloop;
			}
			catch (NoSuchElementException e){
				lmLog.error("received error message", e);
			}
			lmLog.info("login tried" + ++CommonMethods.temp + " time");
			CommonMethods.driver.navigate().refresh();
			continue;
		}
	return CommonMethods.temp;
	}

	public static int ValidationCheckOnWrongCredentails() throws BiffException, IOException {
		myloop: for (int i = 0; i < 3; i++) {
			try {
				Boolean checkIfAlreadyLogged = (CommonMethods.driver.findElements(By.id("logout-btn")).size()!=0);
				if (checkIfAlreadyLogged) {
					CommonMethods.driver.findElement(By.id("logout-btn")).click();
					//	System.out.println("logged out before checking another case");
					lmLog.warn("logged out before checking another case");
					CommonMethods.driver.navigate().refresh();
					wait.until(ExpectedConditions.visibilityOf(LoginMethods.loginName));

				} else {
					//Do nothing
				}
			} catch (Exception e) {
				lmLog.error("received error message", e);
			}
			LoginMethods.loginName.sendKeys("chajaskjhh@sdbck.com");
			LoginMethods.loginPassword.sendKeys("asjhdas");
			LoginMethods.submitLogin.click(); 
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				lmLog.error("received error message", e);
			}
			String AR= HomePage.ErrorPopUp.getText(); 
			String ER= CommonMethods.prop.getProperty("Login_ValidationErrorPopUp");
			//	Assert.assertEquals(CommonMethods.prop.getProperty("Login_ValidationErrorPopUp"), HomePage.ErrorPopUp.getText()); 
			//	System.out.println("Validation Check On wrong credentails test case done successfully");
			lmLog.info("Validation Check On wrong credentails test case done successfully");
			if (AR.equals(ER)) {
				CommonMethods.flag= true;
				break myloop;
			}

			else {
				// System.out.println("login tried" + ++CommonMethods.temp + " time");
				lmLog.info("login tried" + ++CommonMethods.temp + " time");
				CommonMethods.driver.navigate().refresh();
				continue;
			}
		}
	return CommonMethods.temp;
	}


	public static int CheckPlaceHolder() { 
		myloop: for (int i = 0; i < 3; i++) {
			try {
				Boolean checkIfAlreadyLogged = (CommonMethods.driver.findElements(By.id("logout-btn")).size()!=0);
				if (checkIfAlreadyLogged) {
					CommonMethods.driver.findElement(By.id("logout-btn")).click();
					//	System.out.println("logged out before logging in");
					lmLog.warn("logged out before logging in");	
					CommonMethods.driver.navigate().refresh();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//signup//div[2]//input[1]")));

				} else {
					//Do nothing
				}
			} catch (Exception e) {
				lmLog.error("received error message", e);
			}
			String username =CommonMethods.driver.findElement(By.cssSelector("#username")).getAttribute("placeholder"); 
			String password= CommonMethods.driver.findElement(By.cssSelector("#password")).getAttribute("placeholder"); 
			String login_Username_AR = username;
			String login_Password_AR = password;
			String login_Username_ER = CommonMethods.prop.getProperty("Login_PlaceHolder_Name");
			String login_Password_ER = CommonMethods.prop.getProperty("Login_PlaceHolder_Password");
			if(login_Username_AR.equals(login_Username_ER) && login_Password_AR.equals(login_Password_ER))
			{

				//	System.out.println("Placeholder test cases done successfully");
				lmLog.info("Placeholder test cases done successfully");	
				CommonMethods.flag= true;
				break myloop;
			}

			else {
				//	System.out.println("tried" + ++CommonMethods.temp + " time");
				lmLog.info("login tried" + ++CommonMethods.temp + " time");
				CommonMethods.driver.navigate().refresh();
				continue;
			}

		}
	return CommonMethods.temp;
	}

	public static int ValidationCheckOnBlankUserName() throws BiffException, IOException {
		myloop: for (int i = 0; i < 3; i++) {
			try {
				Boolean checkIfAlreadyLogged = (CommonMethods.driver.findElements(By.id("logout-btn")).size()!=0);
				if (checkIfAlreadyLogged) {
					CommonMethods.driver.findElement(By.id("logout-btn")).click();
					//System.out.println("logged out before logging in");
					lmLog.warn("logged out before checking another case");
					CommonMethods.driver.navigate().refresh();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//signup//div[2]//input[1]")));

				} else {
					//Do nothing
				}
			} catch (Exception e) {
				lmLog.error("received error message", e);
			}
			loginPassword.sendKeys("abcdefg");
			submitLogin.click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				lmLog.error("received error message", e);
			} 
			String AR= HomePage.ErrorPopUp.getText(); 
			String ER= CommonMethods.prop.getProperty("Login_ValidationErrorPopUp");
			if(AR.equals(ER))	
			{
				System.out.println("Test case:: Blank user name validation pop up working as expected");
				CommonMethods.flag= true;
				break myloop;
			}

			else {
				System.out.println("tried" + ++CommonMethods.temp + " time");
				CommonMethods.driver.navigate().refresh();
				continue;
			}
		}
	return CommonMethods.temp;
	}


}
