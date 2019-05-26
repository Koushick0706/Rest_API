package com.RestAssured.Auth;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.RestAssured.BaseTest.Base;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class Premitive_Auth extends Base
{
	
	@Test
	void Authetication()
	{
		RestAssured.baseURI = "http://restapi.demoqa.com";
		httpreq = RestAssured.given();
		httpreq.auth().preemptive().basic("ToolsQA", "TestPassword");
		reponse = httpreq.request(Method.GET,"/authentication/CheckForAuthentication");
		int statuscode = reponse.getStatusCode();
		logger.info(""+statuscode);
	}
	@Test(dependsOnMethods ="Authetication")
	void CheckResponsebody()
	{
		String Responsebody = reponse.getBody().asString();
		logger.info("The Body is" + Responsebody);
		Assert.assertTrue(Responsebody!=null);
	}

}
