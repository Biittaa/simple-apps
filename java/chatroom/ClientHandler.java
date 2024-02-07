import java.net.Socket;
import java.util.ArrayList;
import java.util.*;
import java.net.*;
import java.io.*;
import java.util.concurrent.Callable;


public class ClientHandler implements Runnable {
    public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
    private static ArrayList<Client> clients = new ArrayList<>();
    private Socket socket;
    private String name;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    public ClientHandler(Socket socket){
        try {
            this.socket = socket;
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.name = bufferedReader.readLine();
            clientHandlers.add(this);
            send(new Message(name+" joined the chatroom!",new Date()));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    @Override
    public void run(){
        Message message;
        while(socket.isConnected()){
            try{
                String t = bufferedReader.readLine();
                if(t.contains("exit")){
                    leave();
                    return;
                }
                message = new Message(t,new Date());
                send(message);
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public void send(Message message){
        for(ClientHandler c : clientHandlers){
            try{
                if(!c.getName().equals(name)){
                    c.bufferedWriter.write(message.getContent());
                    c.bufferedWriter.newLine();
                    c.bufferedWriter.flush();
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    public void leave(){
        clientHandlers.remove(this);
        send(new Message(name+" left the chatroom!",new Date()));

    }
    public static void addClient(Client c){
        clients.add(c);
    }

    public String getName() {
        return name;
    }
}
