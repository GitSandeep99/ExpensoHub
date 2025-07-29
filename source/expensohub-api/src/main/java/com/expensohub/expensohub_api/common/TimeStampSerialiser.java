package com.expensohub.expensohub_api.common;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class TimeStampSerialiser extends StdSerializer<Date> {

	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


		protected TimeStampSerialiser(Class<Date> t) {
		super(t);
	}
	    
	  
	    protected TimeStampSerialiser() {
			this(null);
		}
		  

		private SimpleDateFormat formatter = new SimpleDateFormat(CommonConstants.JSON_SLDSL_FORMAT);


	    @Override
	    public void serialize(Date date, JsonGenerator generator, SerializerProvider provider) 
	        throws IOException {

	        generator.writeString(formatter.format(date));
	    }
	}

