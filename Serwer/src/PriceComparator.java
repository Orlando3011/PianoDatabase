import java.util.Comparator;

public class PriceComparator implements Comparator<Instrument> {
    @Override
    public int compare(Instrument p1, Instrument p2) {
        if(p2 == null) return -1;
        if(p1.showPrice() > p2.showPrice()) return 1;
        else if(p1.showPrice() < p2.showPrice()) return -1;
        else return 0;
    }
}
