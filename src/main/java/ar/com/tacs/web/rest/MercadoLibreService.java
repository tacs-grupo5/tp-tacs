package ar.com.tacs.web.rest;

import org.apache.http.HttpEntity;

public class MercadoLibreService {

	private static final String MERCADO_LIBRE_SITES_URL = "https://api.mercadolibre.com/sites/";
	
	public String getMercadoLibreSites(){
		String entityString = "";
		RestConsumer consumer = new RestConsumer();
		HttpEntity entity = consumer.consume(MERCADO_LIBRE_SITES_URL);
		if(entity != null){
			entityString = consumer.parseHTTPEntity(entity);
		}
		return entityString;
	}
	
}
