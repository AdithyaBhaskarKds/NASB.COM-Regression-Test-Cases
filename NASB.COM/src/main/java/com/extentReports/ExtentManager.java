package com.extentReports;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.Utility.GetTCName;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	private static SimpleDateFormat formatter = new SimpleDateFormat("MMddyyyy_HHmmss");  
	private static Date date= new Date();
	    public static ExtentReports extent;
//	    private static String reportFileName = "Automaton_Report_"+formatter.format(date)+".html";
	   private static String reportFilepath = System.getProperty("user.dir") + "\\TestReport\\";
	    
	  
	    public static ExtentReports getInstance() {
	        if (extent == null)
	            createInstance();
	        return extent;
	    }
	 
	    //Create an extent report instance
	    public static ExtentReports createInstance() {
	        String fileName = getReportPath(reportFilepath);
	       
	        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
	        htmlReporter.config().setTheme(Theme.DARK);
	        GetTCName gt=new GetTCName();
//	        System.out.println("Before TCName "+tcName);
//	        tcName=gt.returnTCName();
//	        System.out.println("Updated TCName "+tcName);
	        String reportFileName = "Automation_Report_"+formatter.format(date)+".html";
	        htmlReporter.config().setDocumentTitle(reportFileName);
	        htmlReporter.config().setEncoding("utf-8");
	        htmlReporter.config().setReportName(reportFileName);
	        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	 
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        //Set environment details
			extent.setSystemInfo("OS", "Windows");
			extent.setSystemInfo("AUT", "QA");
			extent.setSystemInfo("Author", "Adithya Bhaskar");
	 
	        return extent;
	    }
	     
	    //Create the report path
	    private static String getReportPath (String path) {
	    	String reportFileName ="Automation_Report_"+formatter.format(date)+".html";
	    	String reportFileLocation =  reportFilepath + reportFileName;
	    	File testDirectory = new File(path);
	        if (!testDirectory.exists()) {
	        	if (testDirectory.mkdir()) {
	                System.out.println("Directory: " + path + " is created!" );
	                return reportFileLocation;
	            } else {
	                System.out.println("Failed to create directory: " + path);
	                return System.getProperty("user.dir");
	            }
	        } else {
	            System.out.println("Directory already exists: " + path);
	        }
			return reportFileLocation;
	    }
	 
	}

