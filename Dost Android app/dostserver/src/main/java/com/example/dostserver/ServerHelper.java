package com.example.dostserver;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

import static com.example.dostserver.Protocols.CONNECT;
import static com.example.dostserver.Protocols.ONLINE;
import static com.example.dostserver.Protocols.SEND;
import static com.example.dostserver.Server.TYPE.AFFLICTED;
import static com.example.dostserver.Server.TYPE.VOLUNTEER;

public class ServerHelper implements Runnable{

    private Duplexer duplexer;
    public String username;
    public String volunteer;
    public Server.TYPE type;
    public ArrayList<ServerHelper> onlineUsers;
    public ArrayList<ServerHelper> activeVolunteers;

    public ServerHelper(Socket socket) throws IOException {
        duplexer=new Duplexer(socket);
        this.username=null;
        this.type=null;
        this.volunteer=null;
        this.onlineUsers=null;
    }

    /**
     * This function updates the list of active online users and Volunteers
     * @param s The list of active users
     */
    public void addActiveUsers(ArrayList<ServerHelper> s){
        onlineUsers=s;
        // Adding all the active volunteers in the list
        for(ServerHelper serverHelper: onlineUsers){
            if(serverHelper.type.equals(VOLUNTEER)){
                activeVolunteers.add(serverHelper);
            }
        }
    }

    public String generateChannelID(String username){
        if(this.type!=VOLUNTEER){
            return username+" "+this.username;
        }
        else{
            return this.username+" "+username;
        }
    }
    @Override
    public void run() {
        ArrayList<String> messages=new ArrayList<>();
        messages.addAll(Arrays.asList(duplexer.read().split(" ")));
        while(true){
            switch (messages.get(0)) {
                case ONLINE:
                    this.username = messages.get(1);
                    if (messages.get(2).equals(AFFLICTED)) {
                        this.type = AFFLICTED;
                    } else {
                        this.type = VOLUNTEER;
                    }
                    break;
                case CONNECT:
                    this.volunteer=messages.get(1);
                    if(!this.activeVolunteers.contains(this.volunteer)){
                        System.out.println("The volunteer is not in the list");
                    }
                    break;
                case SEND:

            }
        }
    }
}
