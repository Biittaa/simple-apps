import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;

public class ClientListen implements Runnable  {
    private Socket socket ;
    private BufferedReader b;

    public ClientListen(Socket socket, BufferedReader b) {
        this.socket = socket;
        this.b = b;
    }
   @Override
    public void run(){
        String message;
        while(socket.isConnected()){
            try {
                message =b.readLine();
                System.out.println(message);
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
