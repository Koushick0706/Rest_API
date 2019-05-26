package com.RestAssured.BaseTest;



import org.apache.log4j.Level;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Base 
{
	public static RequestSpecification httpreq;
	public static Response reponse;
	
	public static org.apache.log4j.Logger logger;
	
	@BeforeClass
	public void Setup()
	{
		logger = logger.getLogger("EmloyeeRestApi");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
		
	}

}
