package hust.soict.dsai.test.store;
import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.screen.CartScreen;
import hust.soict.dsai.aims.store.Store;
// Nguyen Manh Hieu - 20215050
public class StoreTest {

	public static void main(String[] args) {
		// tạo một book
		// Khởi tạo một vài Media cho Store
		List<String> tacgia = new ArrayList<String>();
		tacgia.add("Hoan");
		tacgia.add("Nam");
	
		List<String> tacgia2 = new ArrayList<String>();
		tacgia.add("Hoan");
	
		
		List<Track> tr = new ArrayList<Track>();
		
		// Khởi tạo dvd
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Luffy", "Animation", "Oda", 120, 100f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Spiderman", "ACtion", "Marvel", 144, 37.15f);

		// Khởi tạo book
		Book book1 = new Book("Hahaha", "Hai", 20f, tacgia );
		Book book2 = new Book("Vaaa", "Hai", 20f, tacgia );
		Book book3 = new Book("How to make a book", "Xamxi", 12f, tacgia2 );

		// Khởi tạo cd
		CompactDisc cd1 = new CompactDisc("Nghe di", "Hoan", tr, 15f );
		CompactDisc cd2 = new CompactDisc("Nghe di2", "Hai", "Hoan", 16f );
		CompactDisc cd3 = new CompactDisc("Rappp", "Trap", "Hoan", 33f );


		// thêm vài track vào cd
		Track tr1 = new Track("track1", 12);
		Track tr2 = new Track("track2", 3);
		Track tr3 = new Track("track3", 5);
		Track tr4 = new Track("track4", 2);
		cd1.addTrack(tr1);
		cd2.addTrack(tr2);
		cd1.addTrack(tr3);
		cd2.addTrack(tr4);
				
		// tạo store và cart
		Store store = new Store(); // tạo store
		Cart cart = new Cart(); // tạo cart
		
		// thêm vào store
		cart.addMedia(dvd1);
		cart.addMedia(dvd2);
		cart.addMedia(cd2);
		cart.addMedia(book1);
		cart.addMedia(book2);
		cart.addMedia(cd1);
		cart.addMedia(dvd3);
		cart.addMedia(cd3);
		cart.addMedia(book3);
		
		CartScreen cr = new CartScreen(cart, store);
		
	}

}