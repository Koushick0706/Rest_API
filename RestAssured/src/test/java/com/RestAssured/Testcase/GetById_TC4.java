package com.RestAssured.Testcase;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.RestAssured.BaseTest.Base;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class GetById_TC4 extends Base
{
	int Empid =11009;
	@BeforeClass
	void GetallEmployees()
	{
		logger.info("***************Starting TC01************");
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		//it will lauch the given baseURI Link.
		httpreq = RestAssured.given();
		//it will request the set of all employees and store in reponse.
		reponse = httpreq.request(Method.GET,"/employee/"+Empid);
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

}
