package org.Shoppingcart.common;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface Shoppingcart {
	public void initialize(String person) throws BookException;
	public void initialize(String person, String id) throws BookException;
	public void addBook(String title);
	public void removeBook(String title) throws BookException;
	public List<String> getContents();
	public void remove();
}
