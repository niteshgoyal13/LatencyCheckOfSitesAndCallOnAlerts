package com.highLevel;

import com.lowLevel.CommonMethods;

import jxl.read.biff.BiffException;

public class SlackTestScript{
	private static int flag;
	static long totalTimeTaken;

	public static void main(String args[]) throws BiffException{
		CommonMethods.loadPropertiesFile();
		CommonMethods.windowMax(); //Maximize window 
		CommonMethods.slackTestingFun();

		/*myLoop: for(int i=0;i<3;i++)
		{	
		beforePageLoad();
		totalTimeTaken= CommonMethods.totalLoadTimeForHomePageLoad();
		if (totalTimeTaken>3000) {
			System.out.println("page loaded tried in the specified time limit" + ++flag + " time");
			closeTheBroswer();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
			if(flag==3)
			{
				try {
					CommonMethods.httpCall();
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			continue;
		} else
			System.out.println("page loaded in the specified time limit");
		closeTheBroswer();
		break;
		}
	}
	static void closeTheBroswer()
	{
		CommonMethods.driver.close();
		CommonMethods.driver.quit();
	}
	static void beforePageLoad(){
		CommonMethods.loadPropertiesFile();
		CommonMethods.windowMax(); //Maximize window 
		CommonMethods.InitilazeObjectsOfHomePage();
		CommonMethods.InitilazeObjectsOfLobbyPage();
	}*/

	}
}
