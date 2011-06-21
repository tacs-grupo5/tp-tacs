package ar.com.tacs.web.service;

import javax.jdo.JDOEnhancer;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import ar.com.tacs.domain.WishItem;
import ar.com.tacs.domain.Wishlist;
import ar.com.tacs.persistence.PersistenceHandler;
import ar.com.tacs.persistence.WishListCRUD;


public class WishlistService{

	public boolean createWishList(){
		PersistenceManager pm = PersistenceHandler.get().getPersistenceManager();
		Wishlist wishlist = new Wishlist(getCurrentUser());
		WishListCRUD wishListCrud = new WishListCRUD();
		wishListCrud.saveWishList(wishlist);
		return true;
	}	
	
	private User getCurrentUser(){
		UserService userService = UserServiceFactory.getUserService();
		return userService.getCurrentUser();		
	}
	
}
