package hust.soict.dsai.aims.screen;

import java.io.IOException;

import java.net.URL;
import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
// Nguyen Manh Hieu 20215050
public class CartScreen extends JFrame {
	
	private Cart cart;
	private Store store;
	
	public CartScreen(Cart cart, Store store) {
		super();
		this.cart = cart;
		this.store =store;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Cart - Lưu Việt Hoàn - 20215054");
		
		this.setVisible(true);

		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					URL url = getClass().getResource("cart.fxml");
					FXMLLoader loader = new FXMLLoader(url);
					
					CartScreenController controller = new CartScreenController(cart, store);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		

	}
	
}
