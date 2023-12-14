import java.util.Comparator;
// Nguyen Manh Hieu 20215050
public class MediaComparatorByTitleCost implements Comparator<Media>{
    public int compare(Media media1, Media media2) {
        int titleComparison = media1.getTitle().compareTo(media2.getTitle());
        if (titleComparison != 0) {
            return titleComparison;
        }
        return Float.compare(media1.getCost(), media2.getCost());

    }
}
