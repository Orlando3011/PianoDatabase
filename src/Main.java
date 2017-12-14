import java.io.*;

class Main {
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
    }   
}
//"C:\\Users\\Ela i Andrzej\\Desktop\\Michał dokumenty\\PianoProject-master\\src\\dataFiles\\dane.txt"
//path on laptop
//"C:\\Users\\User\\Desktop\\JavaApplication1\\src\\dataFiles\\dane.txt"
//path on computer