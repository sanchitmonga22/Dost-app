package com.example.dostserver;

import java.io.IOException;
import java.net.ServerSocket;

public class Server implements Runnable{
    private static ServerSocket socket;
    private Duplexer Volunteer;
    private Duplexer Afflicted;

    /**
     * Enumerator that defines the type of the user
     */
    public enum TYPE{
        VOLUNTEER,AFFLICTED
    }
    public enum STATUS{
        ONLINE,OFFLINE
    }

    public Server(int port) {
        try {
            this.socket=new ServerSocket(port);
            this.Afflicted=new Duplexer(socket.accept());
            this.Afflicted=new Duplexer(socket.accept());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * For the multi-threaded functionality
     */
//    //TODO: Implement all the functionality to handle all the protocols to and from the client
//    @Override
//    public void run() {
//        ArrayList<ServerHelper> activeUsers = new ArrayList<>();
//        while (true) {
//            try {
//                Socket server = socket.accept();
//                if(server!=null) {
//                    ServerHelper serverHelper = new ServerHelper(server);
//                    activeUsers.add(serverHelper);
//                    serverHelper.addActiveUsers(activeUsers);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    @Override
    public void run() {

    }
    /**
     * Running the server in the main
     * @param args
     */
    public static void main(String[] args){
        if(args.length!=3){
            System.out.println("Usage: java Server <port>");
        }
        Server server=new Server(Integer.parseInt(args[2]));
        server.run();
    }
}