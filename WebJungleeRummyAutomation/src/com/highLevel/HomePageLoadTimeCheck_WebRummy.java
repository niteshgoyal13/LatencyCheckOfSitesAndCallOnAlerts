package com.highLevel;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.Logger;

import com.lowLevel.CommonMethods;
import com.lowLevel.HttpCallMethodsToCheckSiteDown;

import jxl.read.biff.BiffException;

public class HomePageLoadTimeCheck_WebRummy{
	private static int flag;
	static long totalTimeTaken;

	static Logger homePageloadingTime = Logger.getLogger(HomePageLoadTimeCheck_WebRummy.class);
	public static void main(String args[]) throws BiffException{
		
		String url= "https://www.jungleerummy.com";
		
		myLoop: for(int i=0;i<3;i++)
		{	
			CommonMethods.invokeBrowser("phantomjs");
			totalTimeTaken= CommonMethods.totalLoadTimeForHomePageLoad(url);
			if (totalTimeTaken>7000) {
				System.out.println("page couldn't loaded in specified time limit " + ++flag + " time");
				CommonMethods.closeTheBroswer();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					homePageloadingTime.warn(e);
				}
				if(flag==3)
				{
					try {
						HttpCallMethodsToCheckSiteDown.httpCall(url);
						CommonMethods.pythonScriptForCalling();
					} catch (ClientProtocolException e) {
						homePageloadingTime.error(e);
					} catch (IOException e) {
						homePageloadingTime.error(e);
					}
				}
				continue myLoop;
			} else
				System.out.println("page loaded in the specified time limit - " + totalTimeTaken + " MilliSeconds");
			CommonMethods.closeTheBroswer();
			break myLoop;
		}
	}



}
