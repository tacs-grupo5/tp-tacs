package ar.com.tacs.web.rest;

import org.apache.http.HttpEntity;

/**
 * 
 * Servicio encargado de hacer pedidos a la api de mercado libre
 *
 */
public class MercadoLibreService {

	private static final String MERCADO_LIBRE_SITES_URL = "https://api.mercadolibre.com/sites/";
	
	/**
	 * retorna los sites de mercado libre en los distintos paises
	 * @return
	 */
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
