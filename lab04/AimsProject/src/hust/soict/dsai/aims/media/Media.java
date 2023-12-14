package hust.soict.dsai.aims.media;
// Nguyen Manh Hieu 20215050
public abstract class Media {
	private int id;
	protected String title;
	protected String category;
	protected float cost;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public Media() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Media) {
			Media media = (Media) obj;
			return this.title.equals(media.title);
		}
		return false;

	}
public static final comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTileCost();

public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
}
