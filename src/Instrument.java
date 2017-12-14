public class Instrument {
    CDate releaseDate;
    float price;
    String company;
    String type;
    String serialNumber;
    String color;
    
    public Instrument() {
    }
    
    public Instrument(CDate oReleaseDate, 
                      float oPrice, 
                      String oCompany, 
                      String oSerialNumber, 
                      String oColor)
                      throws PriceException {
        if(oPrice < 0) throw new PriceException();
        releaseDate = oReleaseDate;
        price = oPrice;
        company = new String(oCompany);
        serialNumber = new String(oSerialNumber);
        color = new String(oColor);
    }
    
    public float showPrice() {
        return this.price;
    }

    public String showCompany() {
        return this.company;
    }

    public String showSerialNumber() {
        return this.serialNumber;
    }
    
    public String showColor() {
        return this.color;
    }

    public void setReleaseDate(CDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setPrice(float price) throws PriceException {
        if(price < 0) throw new PriceException();
        this.price = price;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
}
