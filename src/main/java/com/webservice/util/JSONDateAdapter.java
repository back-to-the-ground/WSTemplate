package com.webservice.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class JSONDateAdapter extends XmlAdapter<String, Date>{
	private static final String dateFormat = "yyyy-MM-dd'T'HH:mm:ssZ";
	SimpleDateFormat df = new SimpleDateFormat(dateFormat);
	
	@Override
	public String marshal(Date arg0) throws Exception {
		return df.format(arg0);
	}

	@Override
	public Date unmarshal(String arg0) throws Exception {
		return df.parse(arg0);
	}
	
}
