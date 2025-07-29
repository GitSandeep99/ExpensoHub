package com.expensohub.expensohub_api.common;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class TimeStampDeserializer extends StdDeserializer<Date> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected TimeStampDeserializer(Class<?> vc) {
		super(vc);
	}
	
	protected TimeStampDeserializer() {
		this(null);
	}

	@Override
	public Date deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException {
		String date = jsonParser.getText();
		
		try {
		SimpleDateFormat sdf = new SimpleDateFormat(CommonConstants.JSON_SLDSL_FORMAT);
		return sdf.parse(date);
		}
		catch(Exception e) {
			return null;
		}
		
	}

}
