package com.webservice.util;

import java.util.ResourceBundle;

public class ConfigurationUtil {
	public static ResourceBundle bundle = ResourceBundle.getBundle("SystemProperty");
	public static String getProperty(String property){
		return bundle.getString(property);
	}
}
