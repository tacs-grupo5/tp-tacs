package ar.com.tacs.web.service;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * 
 * Clase encargada de consumir servicios REST
 *
 */
public class RestConsumer {
	
	private HttpClient client;
	
	public RestConsumer() {
		client = new DefaultHttpClient();
	}

	/**
	 * consume un servicio rest con la url dada
	 * @param url
	 * @return
	 */
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

	/**
	 * Parsea el resultado de un pedido rest y lo devuelve como String
	 * @param entity
	 * @return
	 */
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
