package com.expensohub.expensohub_api.common;

import java.text.SimpleDateFormat;
import java.util.Date;


import org.apache.el.parser.ParseException;

public class DateUtil {
	
	
		
		/**
		 * getCurrentDateAsString is used to get current date as String.
		 *
		 * @param pattern
		 * @return String
		 */
		public static String getCurrentDateAsString(String pattern) {
			SimpleDateFormat sf = new SimpleDateFormat(pattern);
			return sf.format(new Date());
		}

		
		public static String getStringFromTime(Date date, String pattern) {
			SimpleDateFormat sf = new SimpleDateFormat(pattern);
			return sf.format(date);
		}

		/**
		 * getMexicoCurrentDate is used to get current date of Mexico.
		 *
		 * @return Date
		 * @throws java.text.ParseException 
		 * @throws ParseException 
		 * @throws Exception
		 */
		

		public static Date getCurrentSystemDate() throws java.text.ParseException {

			String pattern = CommonConstants.DD_M_MYYYY_HH_MM_SS;
			SimpleDateFormat formatter = new SimpleDateFormat(pattern);
			String currentDateInString = formatter.format(new Date());
			// Convert to String first Create a new Date object
			Date systemDate = null;
			systemDate = formatter.parse(currentDateInString);
			return systemDate;
		}


}
