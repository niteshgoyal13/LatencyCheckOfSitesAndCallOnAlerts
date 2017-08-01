package com.lowLevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import com.google.gson.JsonObject;

public class HttpCallMethodsToCheckSiteDown {
	
	public static void httpCall(String url) throws ClientProtocolException, IOException {

		String webhookUrl = CommonMethods.prop.getProperty("FreakyBrain_Webhook_url"); // Get url from properties file
		System.out.println(webhookUrl);
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(webhookUrl);

		// add header
		post.setHeader("Content-type", "application/json");
		post.setHeader("status","");

		if(url=="https://www.jungleerummy.com")
		{	
		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("text", "Seems jungleerummy is slow, it is taking more than expected time in loading");
		StringEntity jsonString = new StringEntity(jsonObj.toString(), ContentType.APPLICATION_JSON);
		post.setEntity(jsonString);
		}
		
		else if(url=="https://www.howzat.com")
		{	
			JsonObject jsonObj = new JsonObject();
			jsonObj.addProperty("text", "Seems howzat is slow, it is taking more than expected time in loading");
			StringEntity jsonString = new StringEntity(jsonObj.toString(), ContentType.APPLICATION_JSON);
			post.setEntity(jsonString);
		}
		else if(url=="https://rum.jungleerummy.com/admin/")
		{
			JsonObject jsonObj = new JsonObject();
			jsonObj.addProperty("text", "Seems admin is slow, it is taking more than expected time in loading");
			StringEntity jsonString = new StringEntity(jsonObj.toString(), ContentType.APPLICATION_JSON);
			post.setEntity(jsonString);	
		}
		else if(url=="http://www.jungleeteenpatti.com"){
			JsonObject jsonObj = new JsonObject();
			jsonObj.addProperty("text", "Seems jungleeteenpatti is slow, it is taking more than expected time in loading");
			StringEntity jsonString = new StringEntity(jsonObj.toString(), ContentType.APPLICATION_JSON);
			post.setEntity(jsonString);	
			
		}
		
		HttpResponse response = httpClient.execute(post);
		System.out.println("\nSending 'POST' request to URL : " + webhookUrl);
		System.out.println("Post parameters : " + post.getEntity());
		System.out.println("Response Code of slack integration : " + response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		System.out.println(result.toString());

	}

}
