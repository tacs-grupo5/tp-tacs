package ar.com.tacs.domain;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.users.User;

@PersistenceCapable(identityType=IdentityType.DATASTORE)
public class Wishlist {

	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private long id;
	
	@Persistent
	private User author;
	
	@Persistent
	private List<WishItem> items;
	
	public Wishlist(User author) {
		this.author = author;
		this.items = new ArrayList<WishItem>();
	}
	
	public List<WishItem> getItems() {
		return items;
	}
	
	public void setItems(List<WishItem> items) {
		this.items = items;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public User getAuthor() {
		return author;
	}
	
	public void setAuthor(User author) {
		this.author = author;
	}
}
