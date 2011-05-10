package ar.com.tacs.web.rest;

import org.apache.http.HttpEntity;

/**
 * 
 * Servicio encargado de hacer pedidos a la api de mercado libre
 *
 */
public class MercadoLibreService {

	private static final String MERCADO_LIBRE_SITES_URL = "https://api.mercadolibre.com/sites/";
	
	private RestConsumer consumer;
	
	public MercadoLibreService() {
		consumer = new RestConsumer();
	}
	
	/**
	 * retorna los sites de mercado libre de los distintos paises
	 * @return
	 */
	public String getMercadoLibreSites(){
		String entityString = "";
		HttpEntity entity = consumer.consume(MERCADO_LIBRE_SITES_URL);
		if(entity != null){
			entityString = consumer.parseHTTPEntity(entity);
		}
		return entityString;
	}
	
	protected void setConsumer(RestConsumer consumer) {
		this.consumer = consumer;
	}
	
	protected RestConsumer getConsumer() {
		return consumer;
	}
	
}
