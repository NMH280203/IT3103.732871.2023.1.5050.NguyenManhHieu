// Nguyen Manh Hieu 20215050
package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;

import java.util.ArrayList;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20; // so luong dia toi da trong mot gio hang
	public static ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	public static FilteredList<Media> filteredMedia = new FilteredList<>(itemsOrdered, p -> true);
	
	// Hàm tính tổng tiền
	public float totalCost() {
		float total = 0.0f;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			total += itemsOrdered.get(i).getCost(); // Cộng lần lượt
		}
		return total;
	}

	

	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}



	public void setItemsOrdered(ObservableList<Media> itemsOrdered) {
		this.itemsOrdered = itemsOrdered;
	}



	// Hàm thêm Media vào giỏ hàng
	public void addMedia(Media med) {
		boolean ans = true;
		for (int i = 0; i < itemsOrdered.size(); i++) { // Kiểm tra xem Media đã có chưa
			if (med.equals(itemsOrdered.get(i))) {
				System.out.println("Media da ton tai"); // nếu có rồi --> báo lỗi
				ans = false;
				break;
			}
		}
		if (ans) { // Nếu chưa có --> thêm
			itemsOrdered.add(med);
			System.out.println("Media da duoc them vao");
		}
	}
	
	// Hàm xóa Media từ giỏ hàng
	public void removeMedia(Media med) {
		boolean ans = false;
		for (int i = 0; i < itemsOrdered.size(); i++) { // Kiểm tra xem Media có hay không
			if (med.equals(itemsOrdered.get(i))) { // Nếu có thì xóa
				itemsOrdered.remove(i);
				System.out.println("Media da duoc xoa");
				ans = true;
				break;
			}
		}
		if (!ans) { // Không thì báo lỗi
			System.out.println("Khong tim thay Media nay");
		}
	}

	// Ham in danh sách trong giỏ hàng
	public void printList() {
		for (int i = 0; i < itemsOrdered.size(); i++) {
			System.out.println((i+1) + ". " + itemsOrdered.get(i).toString());
		}
	}
	
	// Ham tim kiem theo ID - LVHoan - 20215054
	public void searchbyID(int idsearch) {
		boolean found = false; // bien kiem tra xem co tim thay hay khong
		    for (int i = 0; i < itemsOrdered.size(); i++) {
		        if (idsearch == itemsOrdered.get(i).getId()) {
		            System.out.println(itemsOrdered.get(i).toString());
		            found = true; // da tim thay
		            break; // dung vong lap ngay khi thay
		        }
		    }

		    // In ra thong bao neu khong thay
		    if (!found) {
		        System.out.println("Media với ID " + idsearch + " khong ton tai trong gio hang.");
		    }
		}

	// Ham tim kiem theo tieu de
	public void searchbyTitle(String titlesearch) {
		boolean found = false; // bien kiem tra xem co tim thay hay khong
			for (int i = 0; i < itemsOrdered.size(); i++) {
				if( itemsOrdered.get(i).getTitle().equals(titlesearch) ) {
					System.out.println(itemsOrdered.get(i).toString());
					found = true; // da tim thay'
					break; // dung vong lap
				}
			}
				if(!found) // neu khong tim thay
					System.out.println("Media voi tieu de " + titlesearch + " khong ton tai trong gio hang.");
		}

	// Hàm trả về Media 
	public Media FindByTitleCart(String Stitle) {
		Media med = null; // neu khong co tra ve null
			for ( int i = 0; i < itemsOrdered.size(); i++) {
				if (Stitle.equals(itemsOrdered.get(i).getTitle())) {// neu thay title
					med = itemsOrdered.get(i); // tra ve media
					break;
				}
			}
			return med;
		}
	
	
	public void filterByTitle(String title) {
		getFilteredMedia().setPredicate(media -> {
			
			// nếu filter trống --> show full media
			if (title == null || title.trim().isEmpty()) {
				return true;
			}
			
			String lowerCaseFilter = title.toLowerCase();
			return media.getTitle().toLowerCase().contains(lowerCaseFilter);
		});
	}

	
	
	public void filterById(String id) {
		getFilteredMedia().setPredicate(media -> {
			
			// nếu filter trống --> show full media
			if (id == null || id.trim().isEmpty()) {
				return true;
			}
			
			try {
	            int idFilter = Integer.parseInt(id.trim());

	            // If the media's ID matches the filter, return true
	            return media.getId() == idFilter;
	        } catch (NumberFormatException e) {
	            // Filter is not a valid integer, continue with string filtering
	        }
			
			String lowerCaseFilter = id.toLowerCase();
			return media.getTitle().toLowerCase().contains(lowerCaseFilter);
		});
	}


	public FilteredList<Media> getFilteredMedia() {
		return filteredMedia;
	}
	


}