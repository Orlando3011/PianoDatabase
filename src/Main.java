import java.io.*;

class Main {
    public static void main(String[] args) throws IOException, PowerException, PriceException {
        Electric ArrayElectric[] = new Electric[100];
        Acustic ArrayAcustic[] = new Acustic[100];
        BufferedReader in = new BufferedReader(
            new FileReader("C:\\Users\\Ela i Andrzej\\Desktop\\Michał dokumenty\\PianoProject-master\\src\\dataFiles\\dane.txt"));
            String s;
            int electricCounter = 0;
            int acusticCounter = 0;
            while((s = in.readLine())!= null) {
                switch (s.charAt(0)) {
                    case 'E': 
                        Electric e = new Electric(s.substring(2));
                        ArrayElectric[electricCounter] = e;
                        electricCounter ++;
                        break;
                    case 'A':
                        Acustic a = new Acustic(s.substring(2));
                        ArrayAcustic[acusticCounter] = a;
                        acusticCounter++;
                        break;
                    default: return;
                }
            }
            in.close();
            for(int i = 0; i < electricCounter; i++) {
                System.out.println(ArrayElectric[i]);
            }
            for(int i = 0; i < acusticCounter; i++) {
                System.out.println(ArrayAcustic[i]);
            }
    }   
}
//"C:\\Users\\Ela i Andrzej\\Desktop\\Michał dokumenty\\PianoProject-master\\src\\dataFiles\\dane.txt"
//ścieżka na laptopie
//"C:\\Users\\User\\Desktop\\JavaApplication1\\src\\dataFiles\\dane.txt"
//dane na komputerze