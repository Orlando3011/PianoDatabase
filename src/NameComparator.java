import java.util.Comparator;

public class NameComparator implements Comparator<Instrument> {
    public int compare(Instrument p1, Instrument p2) {
        return p1.showSerialNumber().compareTo(p2.showSerialNumber());
    } 
}
