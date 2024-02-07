import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class Client {
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;
    private Socket socket;
    private String username;

    public Client(String username, Socket socket) {
        try {
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.socket = socket;
            this.username = username;
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("****** welcome to my chatroom ******");
        System.out.println("enter your username: ");
        String userName = scan.nextLine();
        try {
            Socket socket = new Socket("127.0.0.1", 6000);
            Client c = new Client(userName,socket);
            ClientHandler.addClient(c);
            c.listen();
            c.send();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void send(){
        Scanner scan = new Scanner(System.in);
        try{
            bufferedWriter.write(username);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            while(socket.isConnected()){
                String m = scan.nextLine();
                Message message = new Message(m, new Date());
                bufferedWriter.write(username+": "+message.getContent());
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public void listen(){
        ClientListen l =new ClientListen(socket,bufferedReader);
        Thread t = new Thread(l);
        t.start();
    }

    public String getUsername() {
        return username;
    }

    public Socket getSocket() {
        return socket;
    }
}
