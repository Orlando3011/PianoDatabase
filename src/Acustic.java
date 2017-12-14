public class Acustic extends Piano {
    
    private CDate tuningDate;

    public Acustic(CDate oReleaseDate, 
           float oPrice, 
           String oCompany, 
           String oSerialNumber, 
           int oButtonNumber, 
           String oColor, 
           CDate oTuningDate)
           throws PriceException {
        super(oReleaseDate, oPrice, oCompany, oSerialNumber,oButtonNumber, oColor);
        this.tuningDate = oTuningDate;
    }
    
        public Acustic(String s) throws PriceException {
        String tab[] = s.split(",");
        this.setReleaseDate(new CDate(tab[0]));
        this.setPrice(Integer.parseInt(tab[1]));
        this.setCompany(tab[2]);
        this.setSerialNumber(tab[3]);
        this.setButtonNumber(Integer.parseInt(tab[4]));
        this.setColor(tab[5]);
        this.setTuningDate(new CDate(tab[6]));
    }
    
    public CDate showTuningDate() {
        return this.tuningDate;
    }
    
    public void setTuningDate(CDate tuningDate) {
        this.tuningDate = tuningDate;
    }
    
    public String toString() {
        return this.releaseDate.toString() + 
                ", " + this.price + 
                ", " + this.company + 
                ", " + this.serialNumber + 
                ", " + this.buttonNumber + 
                ", " + this.color + 
                ", " + this.tuningDate.toString();
    }
    
}
