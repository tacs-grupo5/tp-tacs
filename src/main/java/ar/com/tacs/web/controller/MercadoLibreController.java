package ar.com.tacs.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.appengine.api.users.User;

import ar.com.tacs.domain.Wishlist;
import ar.com.tacs.persistence.PersistenceHandler;
import ar.com.tacs.persistence.WishListCRUD;
import ar.com.tacs.web.service.MercadoLibreService;
import ar.com.tacs.web.service.WishlistService;

@Controller
@RequestMapping(value="/")
public class MercadoLibreController {

	private static final String MERCADO_LIBRE_SITES_PAGE = "mercadoLibreSites";
	private static final String INFO_SITE_PAGE = "siteInformation";
	private static final String CATEGORY_PAGE = "categoryInformation";
	private static final String MERCADO_LIBRE_HOME_PAGE = "mercadoLibreHome";

	
	private MercadoLibreService mercadoLibreService = new MercadoLibreService();
	
	@RequestMapping(value="/")
	public String getMercadoLibreHomePage(){
		return MERCADO_LIBRE_HOME_PAGE;
	}
	
	@RequestMapping(value="/sites")
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
		
	@RequestMapping(value="/wishlist/create")
	public @ResponseBody String createWishList(){
			
		WishlistService service = new WishlistService();
		service.createWishList();
		return "success";
			
	}
	
	void setMercadoLibreService(MercadoLibreService mercadoLibreService) {
		this.mercadoLibreService = mercadoLibreService;
	}		
}
