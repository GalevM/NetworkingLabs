package LabsNetworking.src.udp;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client extends Thread{
    private String serverName;
    private int serverPort;

    private DatagramSocket socket;
    private InetAddress address;
    private String message;
    private byte[] buffer;

    public Client(String serverName,  int serverPort, String message){
        this.serverPort = serverPort;
        this.serverName = serverName;
        this.message = message;

        try {
            this.socket = new DatagramSocket();
            this.address = InetAddress.getByName(serverName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        Client client = new Client(System.getenv("SERVER_NAME"), Integer.parseInt(System.getenv("SERVER_PORT")), "login");
        client.start();
    }
}
