package com.Utility;

import java.io.File;
import java.io.IOException;

import com.BasePackage.Base_Class;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.extentReports.ExtentTestManager;

public class SuccessScreenShotCapture extends Base_Class{
	public void capture(String name,String msg) throws IOException
	{
		File file = new com.Utility.ScreenShot(driver).takeScreenShot(name, msg.toString());
		ExtentTestManager.getTest().pass(msg,
				MediaEntityBuilder.createScreenCaptureFromPath(file.toString()).build());
	}

}
