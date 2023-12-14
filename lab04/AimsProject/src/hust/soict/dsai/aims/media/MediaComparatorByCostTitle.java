import java.util.Comparator;
// Nguyen Manh Hieu 20215050
public class MediaComparatorByCostTitle implements Comparator<Media>{
    public int compare(Media media1, Media media2) {
        int costComparison = Float.compare(media1.getCost(), media2.getCost());
        if (costComparison != 0) {
            return costComparison;
        }
        return media1.getTitle().compareTo(media2.getTitle());
    }
}
