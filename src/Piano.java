public class Piano extends Instrument {
    
    int buttonNumber;
    
    public Piano() {
        
    }

    public Piano(CDate oReleaseDate, 
            float oPrice, 
            String oCompany, 
            String oSerialNumber, 
            int oButtonNumber, 
            String oColor)
            throws PriceException {
        super(oReleaseDate, oPrice, oCompany, oSerialNumber, oColor);
        this.buttonNumber = oButtonNumber;
    }
    
    public int showButtonNumber() {
        return this.buttonNumber;
    }

    public void setButtonNumber (int buttonNumber) {
        this.buttonNumber = buttonNumber;
    }
}
