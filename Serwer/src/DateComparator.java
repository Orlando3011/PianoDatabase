import java.util.Comparator;

public class DateComparator implements Comparator<Instrument> {
    @Override
    public int compare(Instrument p1, Instrument p2) {
        if(p2 == null) return -1;
        if(p1.releaseDate.year > p2.releaseDate.year) return 1;
        else if(p1.releaseDate.year < p2.releaseDate.year) return -1;
        else {
            if(p1.releaseDate.month > p2.releaseDate.month) return 1;
            else if(p1.releaseDate.month < p2.releaseDate.month) return -1;
            else {
                if(p1.releaseDate.day > p2.releaseDate.day) return 1;
                else if(p1.releaseDate.day < p2.releaseDate.day) return -1;
                else return 0;
            }
        }
        
    }
}
