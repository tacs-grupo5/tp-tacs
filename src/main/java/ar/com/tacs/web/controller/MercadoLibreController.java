package ar.com.tacs.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.com.tacs.web.rest.MercadoLibreService;

@Controller
@RequestMapping(value="/")
public class MercadoLibreController {

	private static final String MERCADO_LIBRE_SITES_PAGE = "mercadoLibreSites";
	private static final String INFO_SITE_PAGE = "siteInformation";
	private static final String CATEGORY_PAGE = "categoryInformation";
	
	private MercadoLibreService mercadoLibreService = new MercadoLibreService();
	
	@RequestMapping(value="/")
	public String getMercadoLibreSitesPage(ModelMap modelMap){
		modelMap.addAttribute("sites", mercadoLibreService.getMercadoLibreSites());
		return MERCADO_LIBRE_SITES_PAGE;
	}
	
	@RequestMapping(value="/site/{idSite}")
	public String getSiteInfoPage(ModelMap modelMap,
			@PathVariable String idSite){
		modelMap.addAttribute("siteInfo", mercadoLibreService.getSite(idSite));
		return INFO_SITE_PAGE;
	}
	
	@RequestMapping(value="/categories/{idCategory}")
	public String getCategoryInfoPage(ModelMap modelMap,
			@PathVariable String idCategory){
		modelMap.addAttribute("categoryInfo", mercadoLibreService.getCategory(idCategory));
		return CATEGORY_PAGE;
	}
	
}
