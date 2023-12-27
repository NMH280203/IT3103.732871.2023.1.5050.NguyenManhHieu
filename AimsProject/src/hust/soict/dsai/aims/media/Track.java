package hust.soict.dsai.aims.media;
// Nguyen Manh Hieu - 20215050
public class Track implements Playable {
	private String title;
	private int length;
	
	//getter
	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	//Constructor
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}

	public Track() {
		super();
	}
	
	// play
	public void play() {
		System.out.println("Playing Track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
	}

	@Override
	public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Track other = (Track) obj;
        return title.equals(other.title) && length == other.length;
    }
}
