package com.highLevel;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.lowLevel.CommonMethods;
import com.lowLevel.SignUpMethod;

import jxl.read.biff.BiffException;

public class SignupWithNewUser {
	
	public static Logger Swnulog = Logger.getLogger(SignupWithNewUser.class);
	
	
	public static void main(String args[]) throws BiffException
	{
		
		try {
			CommonMethods.openBroswerAndInitialzePageObjectRepo();
			SignUpMethod.registratiOnWebRummy();
		} catch (IOException e) {
			Swnulog.error("received error message", e);
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
				Swnulog.error("received error message", e);
			}
			System.exit(status);
		}
	}
}	