package hust.soict.dsai.aims.screen;
// Nguyen Manh Hieu 20215050
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public class StoreScreen extends JFrame {
    private Store store;
    private Cart cart;
    Container cp;
	
	ViewCartButtonListener viewCartBtnListener = new ViewCartButtonListener();
	MenuItemListener menuItemListener = new MenuItemListener();
	
	
    JPanel createNorth() {
        // Tạo panel phía Bắc
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        // Tạo thanh menuBar
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
		JMenuItem addBook = new JMenuItem("Add Book");
		JMenuItem addCD = new JMenuItem("Add CD");
		JMenuItem addDVD = new JMenuItem("Add DVD");
		
		smUpdateStore.add(addBook);
		smUpdateStore.add(addCD);
		smUpdateStore.add(addDVD);
		
		addBook.addActionListener(menuItemListener);
		addCD.addActionListener(menuItemListener);
		addDVD.addActionListener(menuItemListener);
        
        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View store"));
        JMenuItem viewCart = new JMenuItem("View cart");
		menu.add(viewCart);
		viewCart.addActionListener(menuItemListener);
		
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        // Tạo phần Header
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS - Nguyễn Mạnh Hiếu - 20215050");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton viewcart = new JButton("View cart");
        viewcart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println("Đã nhấp vào nút Xem giỏ hàng");
            	new CartScreen(cart, store).setVisible(true);
            }
        });

        
        viewcart.setPreferredSize(new Dimension(100, 50));
        viewcart.setMaximumSize(new Dimension(100, 50));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(viewcart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        // Tạo panel trung tâm
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < mediaInStore.size(); i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
			center.add(cell);
		}

        return center;
    }

    public StoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
        
        this.store.addPropertyChangeListener(new StoreListener());
        
        cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }
    
    
    private class ViewCartButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String button = e.getActionCommand();
			if (button.equals("View cart")) {
				new CartScreen(cart, store);
			}
		}
	}
	
	protected class MenuItemListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String menuItem = e.getActionCommand();
			if (menuItem.equals("Add Book")) {
				new AddBookToStoreScreen(store);
			}
			else if (menuItem.equals("Add CD")) {
				new AddCDToStoreScreen(store);
			}
			else if (menuItem.equals("Add DVD")) {
				new AddDVDToStoreScreen(store);
			}
			else if(menuItem.equals("View cart")) {
				new CartScreen(cart, store);
			}
		}
	}
	
	protected class StoreListener implements PropertyChangeListener {
		
		@Override
		public void propertyChange(PropertyChangeEvent e) {
	        String propertyName = e.getPropertyName();
	        if ("itemsInStore".equals(propertyName)) {
	        	BorderLayout layout = (BorderLayout) cp.getLayout();
	        	cp.remove(layout.getLayoutComponent(BorderLayout.CENTER));
	        	cp.add(createCenter(),BorderLayout.CENTER);
	        	revalidate();
	        }
		}

		
	}

	

}

