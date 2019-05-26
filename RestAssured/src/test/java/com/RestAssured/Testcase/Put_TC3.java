package com.RestAssured.Testcase;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.RestAssured.BaseTest.Base;
import com.RestAssured.Utilites.RestUtil;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class Put_TC3 extends Base
{

	String EmpName = RestUtil.Empname();
	String EmpSal = RestUtil.EmpSal();
	String EmpAge = RestUtil.EmpAge();
	
	int Empid = 11009;
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
		reponse = httpreq.request(Method.PUT,"/update/"+Empid);
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
}
