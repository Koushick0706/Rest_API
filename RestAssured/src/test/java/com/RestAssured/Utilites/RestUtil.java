package com.RestAssured.Utilites;

import org.apache.commons.lang3.RandomStringUtils;

import com.RestAssured.BaseTest.Base;

import io.restassured.path.json.JsonPath;

public class RestUtil extends Base
{
	
	public static String Empname()
	{
		String GeneratedString = RandomStringUtils.randomAlphabetic(1);
		return("Koushick" + GeneratedString);
	}
	
	public static String EmpSal()
	{
		String GeneratedString = RandomStringUtils.randomNumeric(5);
		return GeneratedString;
	}
	public static String EmpAge()
	{
		String GeneratedString = RandomStringUtils.randomNumeric(2);
		return GeneratedString;
	}
	
}
