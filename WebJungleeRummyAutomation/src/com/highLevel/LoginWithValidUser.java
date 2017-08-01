package com.highLevel;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.apache.log4j.Logger;

import com.lowLevel.CommonMethods;
import com.lowLevel.CsvWritter;
import com.lowLevel.LoginMethods;

import jxl.read.biff.BiffException;


public class LoginWithValidUser {
	static Logger LwvuLog = Logger.getLogger(LoginWithValidUser.class);
	public static void main(String args[]) throws BiffException
	{
		try {
			CsvWritter.checkIfCsvFileAlreadyExists(); //Check if csv file already exists 
			CommonMethods.openBroswerAndInitialzePageObjectRepo();
			CsvWritter.appendUrlinCsvFile();
			try {
				LoginMethods.loginWithValidUser("rummyking66", "hitesh654" ); 
			} catch (TimeoutException e) {
				LwvuLog.error("received error message ", e);
			}
			CommonMethods.appendTodayDateAndCurrentTime();

		} catch (IOException e) {
			LwvuLog.error("received error message", e);
		}
		finally
		{
			CommonMethods.driver.close();
			CommonMethods.driver.quit();
		}
		int status= CommonMethods.getFinalStatusOfPassOrFailure(); //0 is for fail and 1 is for pass
		if(status == 0){
			try {
				CommonMethods.httpCall(""+status);	
				CommonMethods.pythonScriptForCalling();
			}
			catch(Exception e){
				LwvuLog.error("received error message", e);
			}
		}
		try {
			CsvWritter.appendPassOrFailStatusInCsvFile(""+status);
			CsvWritter.csvOutput.endRecord();
		} catch (IOException e) {
			LwvuLog.error("received error message", e);
		}
		CsvWritter.addNewLineInCsvfile();
		System.exit(status);

	} 
}
