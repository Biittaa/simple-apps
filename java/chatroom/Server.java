import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args){
       // ExecutorService executorService = Executors.newCachedThreadPool();
        try {
            ServerSocket serverSocket = new ServerSocket(6000);
            while(!serverSocket.isClosed()) {
                Socket client = serverSocket.accept();
               // executorService.execute(new ClientHandler(client));
                Thread t = new Thread(new ClientHandler(client));
                t.start();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
}
