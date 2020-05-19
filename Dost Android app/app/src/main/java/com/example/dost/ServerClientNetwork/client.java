package com.example.dost.ServerClientNetwork;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

public class client implements Protocols {
    private Duplexer duplexer;
    private String username;
    private User.TYPE type;
    private Boolean serverStatus;
    private ArrayList<String> activeVolunteers;
    private String channelID;
    public User user;// so that it can be used in the UI

    public client(String hostname, int port, String username, User.TYPE type) throws IOException {
        this.duplexer=new Duplexer(new Socket(hostname,port));// creating a new Duplexer object
        this.username=username;
        this.type=type;
        this.serverStatus=true;
        this.channelID=null;
        this.user=new User(type, User.STATUS.ONLINE);
    }

    /**
     * Will be implementing the protocols for the server
     */
    public void run() throws CommException {
        while (serverStatus){
            // Receiving data from the Server and updating the client
            if(!this.duplexer.nextLine()){
                try {
                    throw new CommException("The server is down");
                } catch (CommException e) {
                    e.printStackTrace();
                }
            }
            String message=this.duplexer.read();
            ArrayList<String> messages=null;
            messages.addAll(Arrays.asList(message.split(" ")));// adding the message received separated by spaces into a list
            switch (messages.get(0)) {
                case ONLINE:
                    this.duplexer.send(ONLINE+" "+this.username+" "+this.type);
                    // convey user the message that they are online
                    System.out.println("Connected to the server");
                    break;
                case ACTIVE_USERS:
                    this.activeVolunteers.addAll(messages.subList(1, messages.size() - 1));// this list will contain all the active Volunteers
                    this.user.setActiveUsersList(activeVolunteers);// updating the client with the current active Volunteers that they can connect to
                    break;
                case CONNECTED:
                    this.channelID=messages.get(1);
                    break;
                case SENT:
                    if(channelID.equals(messages.get(1))){
                        System.out.println("The message was successfully delivered");
                        // Show in the UI that the message was sent
                    }
                    else{
                        System.out.println("Message was not delivered by the server");
                    }
                    break;
                case USER_OFFLINE:// messages.get(1) will have the username of the person that they were connected to who just went offline
                    System.out.println("The user they were talking to just went offline");
                    break;
                case RECEIVED:
                    if(this.channelID==messages.get(1)){
                        String msg=null;
                        for(int i=0;i<messages.size()-2;i++){
                            msg=msg+" "+messages.get(i+2);// adding all the spaces back and converting it into a string format so that it can be displayed easily
                        }
                        this.user.newMessageFromServer(true);
                        this.user.setMessageFromServer(msg);// sending the message to UI so that it can be updated
                    }
                    else{
                        System.out.println("Message received from different channel");
                    }
                    break;
                case ERROR:
                    serverStatus = false;
                    throw new CommException("There is a error in the server");
            }

            // Updating the server as User does some action
            if(this.user.getStatus()== User.STATUS.OFFLINE){
                this.duplexer.send(USER_OFFLINE+" "+this.username);// communicating with the server that the user just went offline
            }
            else if(this.user.updateServer==true){
                this.duplexer.send(SEND+" "+channelID+" "+this.user.getMessageFromUI());
                this.user.newMessageFromUI(false);// once the client has read the message setting back the UI update to false
            }
            else if (this.user.updateServerNewVolunteer==true){
                this.duplexer.send(CONNECT+" "+this.user.getConnectedUsername());
                this.user.setUpdateServerNewVolunteer(false);// re-initializing it after updating once
            }
            else if(this.user.getStatus()== User.STATUS.OFFLINE) {// if the user wants to disconnect, then send update to the server
                this.duplexer.send(USER_OFFLINE + " " + this.username);
                serverStatus = false;
            }
        }
    }

    /**
     * For closing the client side of the game
     * @throws Exception
     */
    public void close() throws Exception {
        this.duplexer.close();
    }

    /**
     * To create and start a thread of the run method when the GUI is initialized and running
     */
    public void startListener(){
        new Thread(()->{
            try {
                this.run();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
