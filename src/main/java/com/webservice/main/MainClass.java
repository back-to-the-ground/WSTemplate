package com.webservice.main;

import com.webservice.util.HttpUtil;

public class MainClass {

	public static void main(String[] args) {
		System.out.println("Start testing");
		String response = HttpUtil.get("http://www.yahoo.com:80");
		System.out.println(response);
	}
}
