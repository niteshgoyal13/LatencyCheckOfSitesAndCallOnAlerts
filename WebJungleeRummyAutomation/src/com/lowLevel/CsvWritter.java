package com.lowLevel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.csvreader.CsvWriter;
import com.highLevel.LoginWithValidUser;

public class CsvWritter {
	static Logger csvLog = Logger.getLogger(CsvWritter.class);
    private static final String outputFile = "users.csv";
//	private static final String outputFile = "users.csv";
	public static CsvWriter csvOutput;

	public static void checkIfCsvFileAlreadyExists(){
		try{
			boolean alreadyExists = new File(outputFile).exists();
			csvOutput = new CsvWriter((new FileWriter(outputFile, true)), ',');
			if (!alreadyExists)
			{
				csvOutput.write("endpoint");
				csvOutput.write("avg_response_time_MiliSecs");
				csvOutput.write("date and time");
				csvOutput.write("status");

				csvOutput.endRecord();
				csvOutput.flush();
			}
		}
		catch(IOException e){
			csvLog.error("received error message", e);
		} 
	}
	public static void appendUrlinCsvFile() {
		try {
			csvOutput.write(CommonMethods.prop.getProperty("url"));
			csvOutput.flush();
		} catch(IOException e){
			csvLog.error("received error message", e);
		} 
	}	
	public static void appendDateinCsvFile(String date) {
		try {
			csvOutput.write(date);
			csvOutput.flush();
		} catch(IOException e){
			csvLog.error("received error message", e);
		} 
	}
	public static void appendPassOrFailStatusInCsvFile(String status) {
		try {
			csvOutput.write(status);
			csvOutput.flush();

		} catch(IOException e){
			csvLog.error("received error message", e);
		} 
	}

	public static void appendAvgResponseTimeInCsvFile(String timeTakenForLogIn) {
		try {
			csvOutput.write(timeTakenForLogIn);
			csvOutput.flush();
		} catch(IOException e){
			csvLog.error("received error message", e);
		} 
	}

	public static void addNewLineInCsvfile() {
		try {
			csvOutput.endRecord();
			csvOutput.close();
		} catch(IOException e){
			csvLog.error("received error message", e);
		} 
	}


}