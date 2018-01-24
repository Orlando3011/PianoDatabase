public class CDate {
    
    int day;
    int month;
    int year;
    
    public CDate(int oDay, 
                int oMonth, 
                int oYear) {
        day = oDay;
        month = oMonth;
        year = oYear;
    }
    
    public CDate(String s) {
        String Tab[] = s.split("/");
        day = Integer.parseInt(Tab[0]);
        month = Integer.parseInt(Tab[1]);
        year = Integer.parseInt(Tab[2]);      
    }
    
    public void setDate(int d, int m, int y) {
        this.day = d;
        this.month = m;
        this.year = y;
    }
    
  
    
        public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }
}
