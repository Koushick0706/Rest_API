package com.RestAssured.Testcase;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.RestAssured.BaseTest.Base;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class Get_TC1 extends Base 
{
	@BeforeClass
	void GetallEmployees()
	{
		logger.info("***************Starting TC01************");
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		//it will lauch the given baseURI Link.
		httpreq = RestAssured.given();
		//it will request the set of all employees and store in reponse.
		reponse = httpreq.request(Method.GET,"/employees");
	}
	@Test
	void CheckresponseBody()
	{
		String responebody = reponse.getBody().asString();
		String Header = reponse.getHeaders().toString();
		logger.info("The Headers are " + Header);
		logger.info("The Response Body is " + responebody);
		Assert.assertTrue(responebody!=null);
	}
	@Test
	void CheckStatuscode()
	{
		logger.info("************Checking status code**********");
		int Statuscode = reponse.getStatusCode();
		logger.info("The Status Code is " + Statuscode);
		Assert.assertEquals(Statuscode, 200);
		
	}
	
	@Test
	void CheckresponseTime()
	{
		logger.info("************Checking Reponse Time**********");
		long responsetime = reponse.getTime();
		logger.info("The Response Time is " + responsetime);
		if(responsetime>2000)
		{
			logger.warn("The Response time is Greater than 2000");
		}
		Assert.assertTrue(responsetime<10000);
	}
	@Test
	void CheckstatusLine()
	{
		logger.info("************Checking status Line**********");
		
		String Statusline = reponse.getStatusLine();
		logger.info("The Status Line is " + Statusline);
		Assert.assertEquals(Statusline, "HTTP/1.1 200 OK");
	}
	@Test
	void CheckContenttype()
	{
		logger.info("************Checking Content Type**********");
		
		String ContentType = reponse.header("Content-Type");
		logger.info("The Content Type is " + ContentType);
		Assert.assertEquals(ContentType, "text/html; charset=UTF-8");
		
	}
	@Test
	void Checkresponseheader()
	{
		logger.info("************Checking Response header**********");
		
		String Responseheader = reponse.header("Server");
		logger.info("The Response header is " + Responseheader);
		Assert.assertEquals(Responseheader, "nginx/1.14.1");
	}
	
	@Test
	void CheckResponseheader_Content()
	{
		logger.info("************Checking Response header content**********");
		
		String Responseheader_content = reponse.header("Content-Encoding");
		logger.info("The Response header is " + Responseheader_content);
		Assert.assertEquals(Responseheader_content, "gzip");
	}
	@Test
	void CheckResponseheader_Content_Length()
	{
		logger.info("************Checking Response header Content Length**********");
		String Responseheader_content_Length = reponse.header("Content-Length");
		logger.info("The Response header is " + Responseheader_content_Length);
		Assert.assertEquals(Responseheader_content_Length, "762");
	}
}
