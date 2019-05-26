package com.RestAssured.Testcase;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.RestAssured.BaseTest.Base;
import com.RestAssured.Utilites.RestUtil;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class Post_TC2 extends Base
{

	
	String EmpName = RestUtil.Empname();
	String EmpSal = RestUtil.EmpSal();
	String EmpAge = RestUtil.EmpAge();
	
	@BeforeClass
	void Post() throws InterruptedException
	{
		logger.info("***************Starting TC02 Post************");
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		//it will lauch the given baseURI Link.
		httpreq = RestAssured.given();
		
		JSONObject requestparm = new JSONObject();
		requestparm.put("name",EmpName);
		requestparm.put("salary",EmpSal);
		requestparm.put("age",EmpAge);
		
		httpreq.header("Content-Type","application/json");
		httpreq.body(requestparm.toJSONString());
		reponse = httpreq.request(Method.POST,"/create");
        Thread.sleep(5000);
	}
	@Test
	void CheckResponsebody()
	{
		String Responsebody = reponse.getBody().asString();
		logger.info("Post Body Message is " + Responsebody);
		Assert.assertEquals(Responsebody.contains(EmpName),true);
		Assert.assertEquals(Responsebody.contains(EmpSal),true);
		Assert.assertEquals(Responsebody.contains(EmpAge),true);
	}
	
	@Test(dependsOnMethods ="CheckResponsebody")
	void getid() throws InterruptedException
	{
		JsonPath randomnumber = reponse.jsonPath();
		String EmployeeID = randomnumber.get("id");
		System.out.println("Employee ID Recived From The Response " + EmployeeID);
		Thread.sleep(3000);
		
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

	
}
