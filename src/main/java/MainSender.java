import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MainSender implements Runnable
{
    private void acceptConnection() {
        Thread serverThread = new Thread(this);
        serverThread.start();
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(9777);
            while (true) {
                System.out.println("Starting the server ");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connection accepted from "
                        + clientSocket.getInetAddress().getHostAddress());
                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                int count = 0;
                while (true) {
                    String data = in.readUTF();
                    System.out.println(data);
                    count++;
                    System.out.println(count);
                }
                // in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MainSender().acceptConnection();
    }
}
