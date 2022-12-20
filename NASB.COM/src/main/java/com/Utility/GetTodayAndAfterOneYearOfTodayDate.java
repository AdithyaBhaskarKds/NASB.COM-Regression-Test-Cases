package com.Utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

public class GetTodayAndAfterOneYearOfTodayDate {
	Date currDate=new Date();
	SimpleDateFormat te=new SimpleDateFormat("MM/dd/YYYY");
	public String today()
	{
		
		String todayDate=te.format(currDate);
		return todayDate;
		
	}
	public String afterOneYearOftoday()
	{
		
		Date aftOneYear =DateUtils.addYears(currDate, 1);
		String dateAfterOneYear=te.format(aftOneYear);
		return dateAfterOneYear;
		
	}

}
