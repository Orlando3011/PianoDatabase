
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket serwer = new ServerSocket(7);
        System.out.println("Serwer MultiECHO: " + serwer);
        
        try {
            while(true) {
                Socket gniazdo = serwer.accept();
                try {
                    new EchoServerThread(gniazdo).start();
                    System.out.println("Otwarto polaczenie: " + gniazdo);
                } 
                catch(IOException e) {
                    gniazdo.close();
                }
            }
        } 
        finally {
            serwer.close();
        }
    }
}