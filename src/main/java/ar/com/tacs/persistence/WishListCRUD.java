package ar.com.tacs.persistence;

import javax.jdo.PersistenceManager;

import ar.com.tacs.domain.WishItem;
import ar.com.tacs.domain.Wishlist;

public class WishListCRUD {

	/**
	 * Crea una wishlist de un usuario.
	 * @param wishlist
	 */
	public void saveWishList(Wishlist wishlist){
		PersistenceManager pm = PersistenceHandler.get().getPersistenceManager();
		try {
			pm.makePersistent(wishlist);
		} finally {
			pm.close();
		}
	}
	
	/**
	 * Elimina la wishlist de un usuario.
	 * @param id
	 */
	public void deleteWishList(long id){
		PersistenceManager pm = PersistenceHandler.get().getPersistenceManager();
		try {
			Wishlist wishlist = (Wishlist) pm.getObjectById(id);
			pm.deletePersistent(wishlist);
		} finally {
			pm.close();
		}
	}

	/**
	 * Agrega un item a la wishlist de un usuario
	 * @param idWishList
	 * @param wishItem
	 */
	public void addWishItem(long idWishList, WishItem wishItem){
		PersistenceManager pm = PersistenceHandler.get().getPersistenceManager();
		try {
			Wishlist wishlist = (Wishlist) pm.getObjectById(idWishList);
			wishlist.getItems().add(wishItem);
		}finally{
			pm.close();
		}
		
	}
	
}
