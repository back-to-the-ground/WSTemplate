package com.webservice.util;

import static com.jayway.restassured.RestAssured.given;
import com.jayway.restassured.response.Response;

public class HttpUtil {
	public static String get(String url){
		Response response = given().get(url);
		if(response.getStatusCode() == 200){
			return response.asString();
		}else{
			System.out.println("Error in GET request for URL " + url + ", http error: " + response.getStatusLine());
		}
		return null;
	}
	
	public static String post(String url, String postBody){
		Response response = given().headers("Content-Type", "application/json").body(postBody).post(url);
		if(response.getStatusCode() == 200){
			return response.asString();
		}else{
			System.out.println("Error in POST request for URL " + url + ", http error: " + response.getStatusLine());
		}
		return null;
	}
	
	public static String put(String url, String putBody){
		Response response = given().headers("Content-Type", "application/json").body(putBody).put(url);
		if(response.getStatusCode() == 200){
			return response.asString();
		}else{
			System.out.println("Error in PUT request for URL " + url + ", http error: " + response.getStatusLine());
		}
		return null;
	}
	
	public static String delete(String url){
		Response response = given().delete(url);
		if(response.getStatusCode() == 200){
			return response.asString();
		}else{
			System.out.println("Error in DELETE request for URL " + url + ", http error: " + response.getStatusLine());
		}
		return null;
	}
}
