import java.io.*;
import java.io.*;
import java.net.*;

class Main {
    public static final int PORT = 7;
    
    
    public static void main(String[] args) throws IOException, PowerException, PriceException {
        
        Piano ArrayPiano[] = new Piano[100];
                        BufferedReader in = new BufferedReader(
                            new FileReader("C:\\Users\\Ela i Andrzej\\Desktop\\Michał dokumenty\\PianoProject-master\\src\\dataFiles\\dane.txt"));
                            String s;
                            int pianoCounter = 0;
                            while((s = in.readLine())!= null) {
                                switch (s.charAt(0)) {
                                    case 'E': 
                                        Electric e = new Electric(s.substring(2));
                                        ArrayPiano[pianoCounter] = e;
                                        break;
                                    case 'A':
                                        Acustic a = new Acustic(s.substring(2));
                                        ArrayPiano[pianoCounter] = a;
                                        break;
                                    default: return;
                                }
                                pianoCounter++;
                            }
                            in.close();
                            for(int i = 0; i < pianoCounter; i++) {
                                System.out.println(ArrayPiano[i]);
                            }
            
        ServerSocket gniazdoSerwera = new ServerSocket(PORT);
        System.out.println("Uruchomiono serwer: " +
        gniazdoSerwera);
        try {
            System.out.println("Oczekiwanie na polaczenie...");
            Socket gniazdo = gniazdoSerwera.accept();
            BufferedReader in1 = null;
            PrintWriter out = null;
            try {
                in1 = new BufferedReader(
                    new InputStreamReader(gniazdo.getInputStream()));
                out = new PrintWriter(new BufferedWriter(
                    new OutputStreamWriter(
                    gniazdo.getOutputStream())),true);
                System.out.println("Otwarto polaczenie: "+ gniazdo);
                while (true) {
                    String outputTekst = "";
                    String tekst = in1.readLine();
                    if (tekst.equals("END")) break;
                    if (tekst.equals("VIEW")) {
                        for(int i = 0; i < pianoCounter; i++) {
                                outputTekst = outputTekst + (ArrayPiano[i].toString()) + "|";
                            }
                        System.out.print(">>: " + outputTekst);
                        out.println(outputTekst);
                    }
                    System.out.println(">>: " + tekst);
                    out.println(tekst);
                }
            } finally {
            System.out.println("Zamykanie ...");
            try {
                if (in1 != null) in1.close();
                if (out != null) out.close();
            } 
            catch (Exception e) {}
            gniazdo.close();
            }
        } 
        finally {
            gniazdoSerwera.close();
        }
    }   
}
//"C:\\Users\\Ela i Andrzej\\Desktop\\Michał dokumenty\\PianoProject-master\\src\\dataFiles\\dane.txt"
//path on laptop
//"C:\\Users\\User\\Desktop\\JavaApplication1\\src\\dataFiles\\dane.txt"
//path on computer