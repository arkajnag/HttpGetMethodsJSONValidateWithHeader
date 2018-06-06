package com.JSONValidateNoHeader.qa.TestCase;

import java.io.IOException;
import java.util.HashMap;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.JSONValidateNoHeader.qa.RestClients.GetMethodJSONValidateWithHeader;
import com.JSONValidateNoHeader.qa.TestBase.TestBase;

public class GetMethodJSONValidateWithHeaderTest extends TestBase{

	public GetMethodJSONValidateWithHeaderTest()
	{
		super();
	}
	
	String HostingUrl;
	String ServiceUrl;
	String URI;
	GetMethodJSONValidateWithHeader JsonValidateClass;
	CloseableHttpResponse response;
	
	@BeforeMethod
	public void SetUp() throws ClientProtocolException, IOException
	{
		JsonValidateClass=new GetMethodJSONValidateWithHeader();
		HostingUrl=prop.getProperty("hostUrl");
		ServiceUrl=prop.getProperty("ServiceUrl");
		URI=HostingUrl+ServiceUrl;
		HashMap<String, String> HashMapHeader=new HashMap<String, String>();
		HashMapHeader.put("Content-Type", "Application/json");
		response=JsonValidateClass.JsonValidateWithHeader(URI, HashMapHeader);
	}
	
	@Test(priority=1)
	public void JsonValidateWithHeaderTest()
	{
		int ResponseStatusCode=response.getStatusLine().getStatusCode();
		System.out.println("Response Status Code::"+ResponseStatusCode);
		Assert.assertEquals(ResponseStatusCode, 200, "Status Code is matching in Response");
	}
}
