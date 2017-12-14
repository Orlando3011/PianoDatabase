public class Electric extends Piano {
    
    private int power;
    private int soundsNumber;

    public Electric(CDate oReleaseDate, 
                    float oPrice, 
                    String oCompany, 
                    String oSerialNumber, 
                    int oButtonNumber, 
                    String oColor, 
                    int oPower, 
                    int oSoundsNumber)
                    throws PowerException, PriceException {
        super(oReleaseDate, oPrice, oCompany, oSerialNumber, oButtonNumber, oColor);
        if(oPower < 0) throw new PowerException();
        this.power = oPower;
        this.soundsNumber = oSoundsNumber;
    }
    
    public Electric(String s) throws PowerException, PriceException {
        String tab[] = s.split(",");
        this.setReleaseDate(new CDate(tab[0]));
        this.setPrice(Integer.parseInt(tab[1]));
        this.setCompany(tab[2]);
        this.setSerialNumber(tab[3]);
        this.setButtonNumber(Integer.parseInt(tab[4]));
        this.setColor(tab[5]);
        this.setPower(Integer.parseInt(tab[6]));
        this.setSoundsNumber(Integer.parseInt(tab[7]));
    }
    
    
    public int showPower() {
        return this.power;
    }

    public int showSoundsNumber() {
        return this.soundsNumber;
    }

    public void setPower(int power) throws PowerException{
        if(power < 0) throw new PowerException();
        this.power = power;
    }
    
    public void setSoundsNumber(int soundsNumber) {
        this.soundsNumber = soundsNumber;
    }
    
    public String toString() {
        return super.toString() + 
                ", " + this.power + 
                ", " + this.soundsNumber;
    }
}
