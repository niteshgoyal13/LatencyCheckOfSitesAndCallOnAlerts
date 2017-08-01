package com.highLevel;

import java.io.IOException;

import com.lowLevel.CommonMethods;
import com.lowLevel.LoginMethods;

import jxl.read.biff.BiffException;

public class LoginUsernameBlankValidationPopUp {

	public static void main(String args[]) throws BiffException
	{
		try {
			CommonMethods.openBroswerAndInitialzePageObjectRepo();

			LoginMethods.ValidationCheckOnBlankUserName();

		} catch (IOException e) {
			e.printStackTrace();
		}
		finally
		{
			CommonMethods.driver.close();
			CommonMethods.driver.quit();
		}
		int status= CommonMethods.getFinalStatusOfPassOrFailure();
		if(status == 0){
			try {
				CommonMethods.httpCall(""+status);	
			}
			catch(Exception e){
				System.out.println(e.getCause());
			}
			System.exit(status);
		}
	}
}	