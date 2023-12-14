package hust.soict.dsai.aims.media;
import java.util.List;
import java.util.ArrayList;
// Nguyen Manh Hieu 20215050
public class CompactDisc extends Media implements Playable{
	private String artist;
    private List<Track> tracks = new ArrayList<Track>();
    
    public boolean addTrack(Track newTrack) {
        if(tracks.contains(newTrack)){
            return false;
        } else {
            tracks.add(newTrack);
            return true;
        }
    }

    public boolean removeTrack(Track track) {
        if(tracks.contains(track)){
            tracks.remove(track);
            return true;
        } else {
            return false;
        }
    }

    public int getLength(){
        int total = 0;
        for (Track i : tracks) {
            total += i.getLength();
          }
        return total;
    }
    
    @Override
    public void play() {
        System.out.println("Artist: " + artist);
        for (Track i : tracks) {
            i.play();
        }
    }

    public String toString(){
		StringBuffer builder = new StringBuilder();
        builder.append("CompactDisc - ");
        if (super.getTitle() != null) {
            builder.append(super.getTitle());
        }
        builder.append(" - ");
        if (super.getCategory() != null) {
            builder.append(super.getCategory());
        }
        builder.append(" - ");
        if (super.getCost() >= 0) {
            builder.append(String.format("%.2f $", super.getCost()));
        }
        builder.append(" - ");
        if (artist != null) {
            builder.append("Artist: ").append(artist);
        }
        return builder.toString();
	}
}
