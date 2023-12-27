package hust.soict.dsai.aims.store;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;
//Luu Viet Hoan - 20215054

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();	
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	public PropertyChangeSupport getPcs() {
		return pcs;
	}

	public void setPcs(PropertyChangeSupport pcs) {
		this.pcs = pcs;
	}

	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}

	// Hàm tìm Media theo Title
	public Media FindByTitleStore(String Stitle) {
		Media med = null; // Nếu không thấy trả về null
		for ( int i = 0; i < itemsInStore.size(); i++) {
			if (Stitle.equals(itemsInStore.get(i).getTitle())) {
				med = itemsInStore.get(i); // Nếu thấy --> trả về Media đó
				break;
			}
		}
		return med;
	}
	
	// Hàm thêm Media vào Store
		public String addMedia(Media med) {
			String str = "";
			boolean ans = true;
			for (int i = 0; i < itemsInStore.size(); i++) {// Kiểm tra xem Media đã tồn tại chưa
				if (med.equals(itemsInStore.get(i))) {
					str = "San pham da ton tai";// Nếu đã có thì báo lỗi
					ans = false;
					break;
				}
			}
			if (ans) {
				ArrayList<Media> oldItemsInStore = new ArrayList<Media>(itemsInStore); 
				itemsInStore.add(med);// Chưa có --> thêm
				pcs.firePropertyChange("itemsInStore", oldItemsInStore, itemsInStore);
				str = "San pham da duoc them vao";
			}
			return str;
		}
		
	// Hàm xóa Media khỏi Store
	public void removeMedia(Media med) {
		boolean ans = false;
			for (int i = 0; i < itemsInStore.size(); i++) { // Nếu tìm thấy Media
				if (med.equals(itemsInStore.get(i))) {
					itemsInStore.remove(i); // Thực hiện xóa
					System.out.println("San pham da duoc xoa");
					ans = true;
					break;
				}
			}
			if (!ans ) {// Nếu không thấy báo lỗi
				System.out.println("Khong tim thay san pham nay");
			}
		}
	
	// Hàm in danh sách sản phẩm
	public void printlist() {
		for (int i = 0; i < itemsInStore.size(); i++) {
			System.out.println((i+1) + ". " + itemsInStore.get(i).toString());
		}
	}
	
	
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }
	
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }
	
	
	
	
}

