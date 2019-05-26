
package com.RestAssured.Testcase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.RestAssured.BaseTest.Base;
import com.RestAssured.Utilites.RestUtil;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class Delete_TC5 extends Base
{
	
	int Empid = 11009;

	@BeforeClass
	void GetallEmployees()
	{
		logger.info("***************Starting TC01************");
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		//it will lauch the given baseURI Link.
		httpreq = RestAssured.given();
		//it will request the set of all employees and store in reponse.
		reponse = httpreq.request(Method.DELETE,"/delete/"+Empid);
	}
	
	@Test
	void DeleteEmployee()
	{
		String responebody = reponse.getBody().asString();
		logger.info("The Deleted Employee is " + responebody);
	}
}
