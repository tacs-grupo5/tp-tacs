package ar.com.tacs.web.controller;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ModelMap;

import ar.com.tacs.web.service.MercadoLibreService;

import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.expect;
import static org.easymock.classextension.EasyMock.replay;
import static org.easymock.EasyMock.anyObject;

public class MercadoLibreControllerTest {

	private static final String SITES_RESULT = "Resultado mercado libre sites test";
	private static final String SITE_RESULT = "Resultado site especifico test";
	private static final String CATEGORY_RESULT = "Resultado categoria test";
		
	private MercadoLibreController controller;
	private ModelMap model;
	
	@Before
	public void init(){
		controller = new MercadoLibreController();
		controller.setMercadoLibreService(getMercadoLibreServiceMock());
		model = new ModelMap();
	}

	@Test
	public void shouldSetSitesInModel(){
		controller.getMercadoLibreSitesPage(model);
		Assert.assertEquals(SITES_RESULT, model.get("sites"));
	}
	
	@Test
	public void shouldSetSiteInfoInModel(){
		controller.getSiteInfoPage(model, "any id");
		Assert.assertEquals(SITE_RESULT, model.get("siteInfo"));
	}	
	
	@Test
	public void shouldSetCategoryInfoInModel(){
		controller.getCategoryInfoPage(model, "any id");
		Assert.assertEquals(CATEGORY_RESULT, model.get("categoryInfo"));
	}
	
	@Test
	public void shouldReturnSitesPage(){
		Assert.assertEquals("mercadoLibreSites", controller.getMercadoLibreSitesPage(model));		
	}
	
	@Test
	public void shouldReturnSiteInfoPage(){
		Assert.assertEquals("siteInformation",controller.getSiteInfoPage(model, "any id"));
		
	}	
	
	@Test
	public void shouldReturnCategoryInfoPage(){
		Assert.assertEquals("categoryInformation", controller.getCategoryInfoPage(model, "any id"));		
	}
	private MercadoLibreService getMercadoLibreServiceMock() {
		MercadoLibreService serviceMock = createMock(MercadoLibreService.class);
		expect(serviceMock.getMercadoLibreSites()).andReturn(SITES_RESULT);
		expect(serviceMock.getSite((String)anyObject())).andReturn(SITE_RESULT);
		expect(serviceMock.getCategory((String)anyObject())).andReturn(CATEGORY_RESULT);
		replay(serviceMock);
		return serviceMock;
	}
}
