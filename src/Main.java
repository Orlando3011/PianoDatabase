import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.util.Comparator;

class Main {
    public static final int PORT = 7;
    
    
    public static void main(String[] args) throws IOException, PowerException, PriceException {
        
        Instrument TempArray[] = new Instrument[100];
        
        BufferedReader in = new BufferedReader(
        new FileReader("C:\\Users\\User\\Desktop\\IT\\Piano_project\\Server\\src\\dataFiles\\dane.txt"));
        String s;
        int pianoCounter = 0;
        while((s = in.readLine())!= null) {
            switch (s.charAt(0)) {
                case 'E': 
                    Electric e = new Electric(s.substring(2));
                    TempArray[pianoCounter] = e;
                    break;
                case 'A':
                    Acustic a = new Acustic(s.substring(2));
                    TempArray[pianoCounter] = a;
                    break;
                default: return;
            }
            pianoCounter++;
        }
        
        in.close();         
        Instrument ArrayPiano[] = new Instrument[pianoCounter];      
        for(int i = 0; i < pianoCounter; i++) {
            ArrayPiano[i] = TempArray[i];
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
                    
                    switch (tekst) {
                        
                        case "help": {
                            outputTekst = outputTekst + "Dostępne komendy:"
                                    + "|  help -> lista komend;"
                                    + "|  show -> pokaż wszystkie produkty;"
                                    + "|  show acustic -> pokaż wszystkie pianina akustyczne;"
                                    + "|  show electric -> pokaż wszystkie pianina elektryczne;"
                                    + "|  show <nazwa firmy> -> pokaż wszystkie pianina danej firmy (Yamaha, Casio;"
                                    + "|  show stats -> pokaż informacje o aktyalnych produktach;"
                                    + "|  sort_name -> Posortuj produkty rosnąco po nazwie"
                                    + "|  sort price -> Posortuj produkty rosnąco po cenie"
                                    + "|  sort date -> Posortuj produkty rosnąco po dacie wydania"
                                    + "|  end -> zakończ działanie programu;";
                                    
                            
                            System.out.print(">>: " + outputTekst);
                            out.println(outputTekst);
                            outputTekst = "";
                        }
                        
                        case "end": break;
                        
                        case "show": {
                            outputTekst = outputTekst + "Data wydania\tCena\t\tFirma\tTyp\t\tKolor\t\tKlawisze\tMoc (W)\tIlość brzmień\tOstatnie strojenie|"        
                                    + "-------------------------------------------------------------------------------------------------------------------|";
                            for(int i = 0; i < pianoCounter; i++) {
                                outputTekst = outputTekst + (ArrayPiano[i].toString()) + "|";
                            }
                            System.out.print(">>: " + outputTekst);
                            out.println(outputTekst);
                            outputTekst = "";
                        }
                        
                        case "show stats": {
                            float averagePrice = 0;
                            int acusticCounter = 0;
                            for(int i = 0; i < pianoCounter; i++) {
                                averagePrice =  averagePrice + ArrayPiano[i].showPrice();
                                if(ArrayPiano[i] instanceof Acustic){
                                    acusticCounter++;
                                }
                            }
                            averagePrice = averagePrice/pianoCounter;
                            outputTekst = outputTekst + "Statystki obecnych produktów:"
                                    + "|  Liczba dostępnych opcji: " + pianoCounter
                                    + "|     Liczba pianin elektrycznych: " + (pianoCounter - acusticCounter)
                                    + "|     Liczba pianin akustycznych: " + acusticCounter
                                    + "|  Średnia cena: " + averagePrice;
                            System.out.print(">>: " + outputTekst);
                            out.println(outputTekst);
                            outputTekst = "";
                        }
                        
                        case "show acustic": {
                            outputTekst = outputTekst + "Data wydania\tCena\t\tFirma\tTyp\t\tKolor\t\tKlawisze\tMoc (W)\tIlość brzmień\tOstatnie strojenie|"        
                                    + "----------------------------------------------------------------------------------------------------------------------------------|";
                            for(int i = 0; i < pianoCounter; i++) {
                                if(ArrayPiano[i] instanceof Acustic)
                                outputTekst = outputTekst + (ArrayPiano[i].toString()) + "|";
                            }
                            System.out.print(">>: " + outputTekst);
                            out.println(outputTekst);
                            outputTekst = "";
                        }
                        
                        case "show electric": {
                            outputTekst = outputTekst + "Data wydania\tCena\t\tFirma\tTyp\t\tKolor\t\tKlawisze\tMoc (W)\tIlość brzmień\tOstatnie strojenie|"        
                                    + "----------------------------------------------------------------------------------------------------------------------------------|";
                            for(int i = 0; i < pianoCounter; i++) {
                                if(ArrayPiano[i] instanceof Electric)
                                outputTekst = outputTekst + (ArrayPiano[i].toString()) + "|";
                            }
                            System.out.print(">>: " + outputTekst);
                            out.println(outputTekst);
                            outputTekst = "";
                        }
                        
                        case "show Yamaha": {
                            outputTekst = outputTekst + "Data wydania\tCena\t\tFirma\tTyp\t\tKolor\t\tKlawisze\tMoc (W)\tIlość brzmień\tOstatnie strojenie|"        
                                    + "----------------------------------------------------------------------------------------------------------------------------------|";
                            for(int i = 0; i < pianoCounter; i++) {
                                if(ArrayPiano[i].showCompany().equals("Yamaha"))
                                outputTekst = outputTekst + (ArrayPiano[i].toString()) + "|";
                            }
                            System.out.print(">>: " + outputTekst);
                            out.println(outputTekst);
                            outputTekst = "";
                        }
                        
                        case "show Casio": {
                            outputTekst = outputTekst + "Data wydania\tCena\t\tFirma\tTyp\t\tKolor\t\tKlawisze\tMoc (W)\tIlość brzmień\tOstatnie strojenie|"        
                                    + "----------------------------------------------------------------------------------------------------------------------------------|";
                            for(int i = 0; i < pianoCounter; i++) {
                                if(ArrayPiano[i].showCompany().equals("Casio"))
                                outputTekst = outputTekst + (ArrayPiano[i].toString()) + "|";
                            }
                            System.out.print(">>: " + outputTekst);
                            out.println(outputTekst);
                            outputTekst = "";
                        }
                        
                        case "sort name": {
                            outputTekst = outputTekst + "Data wydania\tCena\t\tFirma\tTyp\t\tKolor\t\tKlawisze\tMoc (W)\tIlość brzmień\tOstatnie strojenie|"        
                                    + "----------------------------------------------------------------------------------------------------------------------------------|";
                            Instrument SortedPiano[] = new Instrument[pianoCounter];
                            SortedPiano = ArrayPiano.clone();
                            
                            NameComparator comp = new NameComparator();
                            Arrays.sort(SortedPiano, comp);
                            
                            for(int i = 0; i < pianoCounter; i++) {
                                outputTekst = outputTekst + SortedPiano[i] + "|";
                            }
                            System.out.print(">>: " + outputTekst);
                            out.println(outputTekst);
                            outputTekst = "";
                        }
                        
                        case "sort date": {
                            outputTekst = outputTekst + "Data wydania\tCena\t\tFirma\tTyp\t\tKolor\t\tKlawisze\tMoc (W)\tIlość brzmień\tOstatnie strojenie|"        
                                    + "----------------------------------------------------------------------------------------------------------------------------------|";
                            Instrument SortedPiano[] = new Instrument[pianoCounter];
                            SortedPiano = ArrayPiano.clone();
                            
                            DateComparator comp = new DateComparator();
                            Arrays.sort(SortedPiano, comp);
                            
                            for(int i = 0; i < pianoCounter; i++) {
                                outputTekst = outputTekst + SortedPiano[i] + "|";
                            }
                            System.out.print(">>: " + outputTekst);
                            out.println(outputTekst);
                            outputTekst = "";
                        }
                        
                        case "sort price": {
                            outputTekst = outputTekst + "Data wydania\tCena\t\tFirma\tTyp\t\tKolor\t\tKlawisze\tMoc (W)\tIlość brzmień\tOstatnie strojenie|"        
                                    + "----------------------------------------------------------------------------------------------------------------------------------|";
                            Instrument SortedPiano[] = new Instrument[pianoCounter];
                            SortedPiano = ArrayPiano.clone();
                            
                            PriceComparator comp = new PriceComparator();
                            Arrays.sort(SortedPiano, comp);

                            for(int i = 0; i < pianoCounter; i++) {
                                outputTekst = outputTekst + SortedPiano[i] + "|";
                            }
                            System.out.print(">>: " + outputTekst);
                            out.println(outputTekst);
                            outputTekst = "";
                            }
                        
                        default: {
                            outputTekst = outputTekst + "Niepoprawna komenda.";
                            System.out.print(">>: " + outputTekst);
                            out.println(outputTekst);
                            outputTekst = "";
                        }
                    }
                }
            }
            finally {
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