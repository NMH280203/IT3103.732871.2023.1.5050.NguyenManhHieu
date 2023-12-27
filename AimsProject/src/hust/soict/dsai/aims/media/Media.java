package hust.soict.dsai.aims.media;

import java.util.Comparator;
// Nguyen Manh Hieu - 20215050
public abstract class Media {
	public int id;
	public String title;
	public String category;
	public float cost;
	public static int nbDigitalVideoDiscs = 1;

	
	// getter
	public String getTitle() {
		return title;
	}
	
	public String getCategory() {
		return category;
	}
	
	public float getCost() {
		return cost;
	}
	
	public int getId() {
        return id;
    }
	
	//setter
	public void setTitle(String title) {
		this.title = title;
	}

	public Media() {
		// TODO Auto-generated constructor stub
	}
	
	// override lại equals
	@Override
    public boolean equals(Object obj) { // viet lai ham equals
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Media other = (Media) obj; // media
        return title.equals(other.title);
    }
	
	// comparator
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();

}
