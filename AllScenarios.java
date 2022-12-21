package com.test.user;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.BasePackage.Base_Class;
import com.FunctionCall.Functionality;
import com.Utility.Log;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;


public class AllScenarios extends Base_Class {

	Base_Class Base_Class;
	Log log;
	TestListener TestListener;
	com.Utility.ScreenShot screenShot;
	
	
	
	@BeforeSuite
	public void reference() {
		Base_Class = new Base_Class();

		log=new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
	}

	@Test(dataProvider = "TestData")
	public  void RUNALL(Map <Object,Object> testdata, ITestContext context) throws IOException, InterruptedException {

		
		try {

			if (testdata.get("Run").toString().equalsIgnoreCase("Yes")) {

				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				Functionality fn=new Functionality();
				
//              **************************  Check Mortgage Rate Calculator Starts Here *******************************

				fn.checkMortgageRateCalculator();
				
				
//		        **************************  Check Mortgage Rate Calculator Ends Here   *******************************
				
//              **************************  Check Account Rates Links Starts Here *******************************

				fn.checkAccountRatesLinks();
				
				
//		        **************************  Check Account Rates Links Ends Here   *******************************
				
//              **************************  Check Google Map Functionality Starts Here *******************************

				fn.checkGoogleMapFunctionalityUnderLocationPage();
				
				
//		        **************************  Check Google Map Functionality Ends Here *******************************
				
//              **************************  Check Customer Login Links Starts Here *******************************

				fn.checkLoginFunctionality();
				
				
//		        **************************  Check Customer Login Links Ends Here *******************************
				
//              **************************  Check All Mortgage Calculators Starts Here *******************************

				fn.checkAllMortageCalculatorsUnderLendingScreen();
				
				
//		        **************************  Check All Mortgage Calculators Ends Here *******************************
				
//              **************************  Check All Financial Calculators Starts Here *******************************

				fn.checkAllFinancialCalculatorsUnderBankingScreen();
				
				
//		        **************************  Check All Financial Calculators Ends Here *******************************
				
//              **************************  Check All Features Under Location Page Starts Here *******************************

				fn.checkAllFeaturesUnderLocationPage();
				
				
//		        **************************  Check All Features Under Location Page Ends Here *******************************
				
//              **************************  Check Loan Payment Functionality Starts Here *******************************

				fn.checkLoanPaymentFunctionality();
				
				
//		        **************************  Check Loan Payment Functionality Ends Here *******************************
				
//              ****************  Check Apply Now Functionality Under Banking Section Starts Here *********************

				fn.checkApplyNowFunctionalityUnderBankingSection();
				
				
//		        ****************  Check Apply Now Functionality Under Banking Section Ends Here *********************
				
//              ****************  Check Apply Now Functionality Under Mortgage Section Starts Here *******************

				fn.checkApplyNowFunctionalityUnderMortgageSection();
				
				
//		        ***************  Check Apply Now Functionality Under Mortgage Section Ends Here *********************
				
//EndTest
				
				
				
				System.out.println(("*** Test Suite " +  testdata.get("TestScenario").toString()+ " ending ***"));
				ExtentTestManager.endTest();
				
				ExtentManager.getInstance().flush();
				Log.info("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***");

			}
			

		}
		
		catch (Exception e) {
			System.out.println("*** Test execution " +  testdata.get("TestScenario").toString() + " failed...");
			Log.error("*** Test execution " +  testdata.get("TestScenario").toString() + " failed...");
			Log.error("" + e.getMessage());
			String fileName = (String) context.getAttribute("fileName");

			try {
				File file = new com.Utility.ScreenShot(driver).takeScreenShot(fileName, testdata.get("TestScenario").toString());
				ExtentTestManager.getTest().fail(e.getMessage(),
						MediaEntityBuilder.createScreenCaptureFromPath(file.toString()).build());
			} catch (Exception e1) {
				System.out.println("File not found " + e1);
			}
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");

			// Logout
			context.setAttribute("fileName", "Logout");
			//driver.quit();
			ExtentTestManager.getTest().log(Status.PASS, "Application Logout");
			Log.info("Logout is done");

			// EndTest
			System.out.println(("*** Test Suite " +  testdata.get("TestScenario").toString() + " ending ***"));
			ExtentTestManager.endTest();
			ExtentManager.getInstance().flush();
			Log.info("*** Test Suite " +  testdata.get("TestScenario").toString() + " ending ***");
		}
		catch (AssertionError e) {
			System.out.println("*** Test execution " +  testdata.get("TestScenario").toString() + " failed...");
			Log.error("*** Test execution " +  testdata.get("TestScenario").toString() + " failed...");
			Log.error("" + e.getMessage());
			String fileName = (String) context.getAttribute("fileName");

			try {
				File file = new com.Utility.ScreenShot(driver).takeScreenShot(fileName, testdata.get("TestScenario").toString());
				ExtentTestManager.getTest().fail(e.getMessage(),
						MediaEntityBuilder.createScreenCaptureFromPath(file.toString()).build());
			} catch (Exception e1) {
				System.out.println("File not found " + e1);
			}
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");

			// Logout
			context.setAttribute("fileName", "Logout");
			//driver.quit();
			ExtentTestManager.getTest().log(Status.PASS, "Application Logout");
			Log.info("Logout is done");

			// EndTest
			System.out.println(("*** Test Suite " +  testdata.get("TestScenario").toString() + " ending ***"));
			ExtentTestManager.endTest();
			ExtentManager.getInstance().flush();
			Log.info("*** Test Suite " +  testdata.get("TestScenario").toString() + " ending ***");
		}

	
		
	}

	@DataProvider(name = "TestData")
	public static Object[][] gettestdate() throws IOException{

		Object[][] objectarry=null;
		java.util.List<Map<String,String>> completedata=com.Utility.ExcelReader.getdata();

		objectarry=new Object[completedata.size()][1];

		for(int i=0;i<completedata.size();i++) {
			objectarry[i] [0]= completedata.get(i);
		}
		return objectarry;

	}
	







}
