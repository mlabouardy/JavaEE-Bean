import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateful;

import org.Shoppingcart.common.BookException;
import org.Shoppingcart.common.Shoppingcart;


@Stateful
public class ShoppingcartBean implements Shoppingcart{
	private String id;
	private String person;
	private List<String> items;

	public void initialize(String person) throws BookException {
		if(person==null){
			throw new BookException("Null person not allowed!");
		}else{
			this.person=person;
		}
		this.id="0";
		this.items=new ArrayList();
		
	}

	public void initialize(String person, String id) throws BookException {
		initialize(person);
		this.id=id;
		
	}

	public void addBook(String title) {
		items.add(title);
	}

	public void removeBook(String title) throws BookException {
		int index=findBook(title);
		if(index==-1){
			throw new BookException("Book not found in cart!");
		}else{
			items.remove(index);
		}
	}

	public List<String> getContents() {
		return items;
	}

	public void remove() {
		items=null;
	}

	public int findBook(String title){
		for(int i=0;i<items.size();i++){
			String tmp=items.get(i);
			if(tmp.compareTo(tmp)==0)
				return i;
		}
		return -1;
	}
}
