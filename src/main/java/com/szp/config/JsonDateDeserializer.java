package com.szp.config;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

@Component
public class JsonDateDeserializer extends JsonDeserializer<Date> {
	@Override
	public Date deserialize(JsonParser jsonparser, DeserializationContext arg1) throws IOException, JsonProcessingException {
		String dateS = jsonparser.getText();
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		try {
			return format.parse(dateS);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}