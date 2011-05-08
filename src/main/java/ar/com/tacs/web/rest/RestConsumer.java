package ar.com.tacs.web.rest;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class RestConsumer {
	
	private HttpClient client;
	
	public RestConsumer() {
		client = new DefaultHttpClient();
	}

	public HttpEntity consume(String url){
		HttpGet get = new HttpGet(url);
		HttpResponse response = null;
		try {
			response = client.execute(get);			
		} catch (Exception e) {			
			return null;
		} 		
		return response.getEntity();
		
	}

	public String parseHTTPEntity(HttpEntity entity) {
		if (entity != null) {
		    long len = entity.getContentLength();
		    if (len != -1) {
		        try {
					return EntityUtils.toString(entity);
				} catch (Exception e) {
					return "";
				}
		    }
		}
		return "";
	}
	
}
