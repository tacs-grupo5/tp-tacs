package ar.com.tacs.web.service;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.expect;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;
import junit.framework.Assert;

import org.apache.http.HttpEntity;
import org.junit.Test;

import ar.com.tacs.web.service.MercadoLibreService;
import ar.com.tacs.web.service.RestConsumer;


public class MercadoLibreServiceTest {

	private MercadoLibreService service;
	
	@Test
	public void shouldReturnEmptyStringIfServiceIsDown(){
		service = new MercadoLibreService();
		service.setConsumer(getServiceDownMock());
		Assert.assertEquals("", service.getMercadoLibreSites());
	}
	
	@Test
	public void shouldReturnInfoIfServiceIsUp(){
		service = new MercadoLibreService();
		service.setConsumer(getServiceUpMock());
		Assert.assertEquals("resultado test", service.getMercadoLibreSites());
	}

	private RestConsumer getServiceDownMock() {
		RestConsumer consumerMock = createMock(RestConsumer.class);
		expect(consumerMock.consume((String)anyObject())).andReturn(null);
		replay(consumerMock);
		return consumerMock;
	}

	private RestConsumer getServiceUpMock() {
		RestConsumer consumerMock = createMock(RestConsumer.class);
		expect(consumerMock.consume((String)anyObject())).andReturn(getHTTPentityMock());
		expect(consumerMock.parseHTTPEntity((HttpEntity)anyObject())).andReturn("resultado test");
		replay(consumerMock);
		return consumerMock;
	}

	private HttpEntity getHTTPentityMock() {
		HttpEntity entityMock = createMock(HttpEntity.class);
		return entityMock;
	}
}
