package com.JSONValidateNoHeader.qa.RestClients;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import com.JSONValidateNoHeader.qa.TestBase.TestBase;

public class GetMethodJSONValidateWithHeader extends TestBase{

	public CloseableHttpResponse JsonValidateWithHeader(String URI, HashMap<String, String> hashmapHeader) throws ClientProtocolException, IOException
	{
		CloseableHttpClient httpRequestclient=HttpClients.createDefault();
		HttpGet httpRequestGet=new HttpGet(URI);
		for(Map.Entry<String, String> entry: hashmapHeader.entrySet())
		{
			httpRequestGet.addHeader(entry.getKey(), entry.getValue());
		}
		CloseableHttpResponse httpResponseWithHeaders=httpRequestclient.execute(httpRequestGet);
		return httpResponseWithHeaders;
	}
}
