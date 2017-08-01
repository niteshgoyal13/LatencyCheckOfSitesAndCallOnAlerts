package com.highLevel;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.lowLevel.CommonMethods;
import com.lowLevel.SignUpMethod;

import jxl.read.biff.BiffException;

public class SignupPlaceHolderCheck {

	public static Logger Spclog = Logger.getLogger(SignupPlaceHolderCheck.class);

	public static void main(String args[]) throws BiffException
	{
		try {
			CommonMethods.openBroswerAndInitialzePageObjectRepo();
			SignUpMethod.CheckSignUpPlaceHolder();
		} catch (IOException e) {
			Spclog.error("received error message", e);
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
				Spclog.error("received error message", e);
			}
			System.exit(status);
		}
	}
}	