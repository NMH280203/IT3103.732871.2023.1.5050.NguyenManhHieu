package hust.soict.dsai.aims.screen;

import static hust.soict.dsai.aims.cart.Cart.itemsOrdered;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.FloatBinding;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
// Nguyen Manh Hieu 20215050
public class CartScreenController {

	private Cart cart;
	private Store store;
	
    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;
    
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;
    
    @FXML
    private RadioButton radioBtnFilterId;
    
    @FXML
    private RadioButton radionBtnFilterTitle;

    @FXML
    private TextField tfFilter;
    
    @FXML
    private Label lbTotalCost;
    
    @FXML
    void addBookMenuItemChosen(ActionEvent event) {
    	new AddBookToStoreScreen(store);
    }

    @FXML
    void addCDMenuItemChosen(ActionEvent event) {
    	new AddCDToStoreScreen(store);
    }

    @FXML
    void addDVDMenuItemChosen(ActionEvent event) {
    	new AddDVDToStoreScreen(store);
    }
    
    @FXML
    void viewStoreMenuItemChosen(ActionEvent event) {
    	new StoreScreen(store, cart);
    }
    

    
	public CartScreenController(Cart cart, Store store) {
		super();
		this.cart = cart;
		this.store = store;
	}


	@FXML
    private void initialize() {
    	colMediaTitle.setCellValueFactory( new PropertyValueFactory<Media, String>("title"));
    	colMediaCategory.setCellValueFactory( new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory( new PropertyValueFactory<Media, Float>("cost"));
    	tblMedia.setItems(this.cart.getItemsOrdered());
    	
    	// in tổng tiền
    	FloatBinding totalCostDoubleBinding = Bindings.createFloatBinding(() -> {
		    return cart.totalCost(); 
		}, tblMedia.getItems());
		lbTotalCost.textProperty().bind(totalCostDoubleBinding.asString("%.2f $"));
    	
		// 2 nút dưới 
    	btnPlay.setVisible(false);
    	btnRemove.setVisible(false);
    	
    	// set model 
    	tblMedia.getSelectionModel().selectedItemProperty().addListener(
    			(ChangeListener<? super Media>) new ChangeListener<Media>() {
    				@Override
    				public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
    					if(newValue != null) {
    						updateButtonBar(newValue);
    					}
    				}
    			}
    			);
    	
    	
    	// nhập text filter
    	tfFilter.textProperty().addListener( new ChangeListener<String>() {
    		@Override
    		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
    			showFilterMedia(newValue);
    		}
    	});
    }
	
	 private void showFilterMedia(String filter) {
		 // nếu chọn filter theo title
		 if (radionBtnFilterTitle.isSelected()) {
			 cart.filterByTitle(filter);
		 }
		 
		 // nếu chọn filter theo id
		 if (radioBtnFilterId.isSelected()) {
			 cart.filterById(filter);
		 }
	            
		 SortedList<Media> sortedList = new SortedList<>(cart.getFilteredMedia());
		 sortedList.comparatorProperty().bind(tblMedia.comparatorProperty());
		 tblMedia.setItems(sortedList);
	 }
	
	
	void updateButtonBar(Media media) {
		btnRemove.setVisible(true);
		if (media instanceof Playable) {
			btnPlay.setVisible(true);
		}
		else {
			btnPlay.setVisible(false);
		}
	}
	
	// xóa media khỏi cart
	@FXML
    void btnRemovePressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
    }
	
	// play media trong cart
	@FXML
    void btnPlayPressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		if ( media instanceof CompactDisc) { // Kiểm tra xem media có phải CD không
			try {
				( (CompactDisc) media ).play();
			} catch (PlayerException e) {
				e.printStackTrace();
			} 
		}
		else if ( media instanceof DigitalVideoDisc) { // Kiểm tra xem media có phải DVD không
			try {
				( (DigitalVideoDisc) media ).play();
			} catch (PlayerException e) {
				e.printStackTrace();
			}
		}    
	}
	
	// đặt hàng
	@FXML
    void btnPlaceOrderPressed(ActionEvent event) {
		if (cart.getItemsOrdered().size() == 0) {
    		placeOrderDialog(false);
    	}
    	else {
	    	itemsOrdered.clear();
	    	initialize();
	    	placeOrderDialog(true);
    	}
    }
	
	void placeOrderDialog(boolean input) {
		if (input == true) {
			JDialog orderDialog1 = new JDialog(new JFrame(), "Notification");
			
			String orderLabelText1 = "Order has been created.";
			
			JLabel orderLabel1 = new JLabel(orderLabelText1, SwingConstants.CENTER);
			orderDialog1.add(orderLabel1);
			orderDialog1.setLocation(300,300);
			orderDialog1.pack();
			orderDialog1.setVisible(true);
		}
		else {
			JDialog orderDialog0 = new JDialog(new JFrame(), "Notification");
			
			String orderLabelText0 = "Cart is empty.";
			
			JLabel orderLabel0 = new JLabel(orderLabelText0, SwingConstants.CENTER);
			orderDialog0.add(orderLabel0);
			orderDialog0.setLocation(300,300);
			orderDialog0.pack();
			orderDialog0.setVisible(true);
		}

	}

	
	

}
