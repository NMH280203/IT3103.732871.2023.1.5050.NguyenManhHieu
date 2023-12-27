package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;
// Nguyen Manh Hieu - 20215050
public class Book extends Media {
	private List<String> authors = new ArrayList<String>();

	// getter
	public List<String> getAuthors() {
		return authors;
	}

	// Constructor
	public Book() {
		super();
		this.id = nbDigitalVideoDiscs++;

	}
	
	public Book(String title, String category, float cost ) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.id = nbDigitalVideoDiscs++;

	}

	public Book(String title, String category, float cost, List<String> authors ) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.authors = authors;
		this.id = nbDigitalVideoDiscs++;
	}
	
	// Hàm thêm tác giả
	public void addAuthor(String name) {
		boolean check = true;
		for (int i = 0; i < authors.size(); i++) {
			if (authors.get(i).equals(name)) { // Kiểm tra xem tác giả đã có chưa
				System.out.println("Tac gia nay da ton tai");
				check = false;
				break;
			}
		}
		if (check){ // nếu chưa thực hiện thêm
			authors.add(name);
			System.out.println("Tac gia da duoc them");
		}
	}
	
	// Hàm xóa tác giả 
	public void removeAuthor(String name) {
		boolean check = false;
		for (int i = 0; i < authors.size(); i++) {
			if (authors.get(i).equals(name)) { // kiểm tra tác giả
				authors.remove(i);
				System.out.println("Da xoa tac gia nay");
				check = true;
				break;
			}
		}
		if (!check) {
			System.out.println("Tac gia nay khong ton tai");
		}
	}
	
	// Hàm in danh sách tác giả
	public void showAuthor() {
		System.out.print("Danh sach tac gia: ");
		for (String name : authors) { // in lần lượt
			System.out.print("\t" + name);
		}
		System.out.println();
	}
	
	// overrdie lại toString
	@Override
	public String toString() {
		return "Book - " + getId() + " - " + getTitle() + " - " + getCategory() + " - " + getCost() + " $" ;
	}

}
