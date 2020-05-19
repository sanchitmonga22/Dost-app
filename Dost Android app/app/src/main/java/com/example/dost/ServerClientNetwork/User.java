package com.example.dost.ServerClientNetwork;

import java.util.ArrayList;
//InetAddress address = InetAddress.getByName(host);
public class User {
    /**
     * Enumerator that defines the type of the user
     */
    public enum TYPE{
        VOLUNTEER,AFFLICTED
    }
    public enum STATUS{
        ONLINE,OFFLINE
    }

    /**
     * TODO: functions to be used in the UI
     */
    private TYPE type;
    private STATUS status; // whether online/offline
    private String messageFromUI;
    private String messageFromServer;
    private ArrayList<String> activeUsers;
    private String connectedUser;
    public Boolean updateServer;
    public Boolean updateUI;
    public Boolean updateServerNewVolunteer;
    public Boolean conveyType;

    public User(TYPE type, STATUS status) {
        this.type=type;
        this.status=status;
        this.messageFromServer=null;
        this.messageFromUI=null;
        this.updateServer=false;
        this.updateUI=false;
        activeUsers=new ArrayList<>();
        connectedUser=null;
        updateServerNewVolunteer=false;
        conveyType=false;
    }

    /**
     * Communication Between the server and the UI
     */

    /**
     * This function will be called in the server and will update the message
     * @param message message from the server
     */
    public void setMessageFromServer(String message){
        this.messageFromServer=message;
    }
    /**
     * This function will be called in the UI and will update the message
     * @param message message from the UI
     */
    public void setMessageFromUI(String message){
        if(this.type==TYPE.AFFLICTED){
            this.messageFromUI=message;
        }
    }
    /**
     * For getting the message from the UI
     * @return message from the UI
     */
    public String getMessageFromUI(){
        return this.messageFromUI;
    }
    /**
     * For getting the message from the server
     * @return message from the server
     */
    public String getMessageFromServer() {
        return this.messageFromServer;
    }

    /**
     * If there is a new message from the server, then set updateUI to be true
     * @param newMessage
     */
    public void newMessageFromServer(Boolean newMessage){
        this.updateUI=newMessage;
    }

    /**
     * If there is a newMessage from the UI, then set updateServer to be true
     * @param newMessage
     */
    public void newMessageFromUI(Boolean newMessage){
        this.updateServer=newMessage;
    }


    // STATUS OF THE USER
    /**
     * Setting the current status of the user
     * @param status: either OFFLINE or ONLINE
     */
    public void setStatus(STATUS status){
        // Also include in the UI if the user closes their chat they go offline and immediately let the server know of the status of the user
        this.status=status;
    }

    /**
     * The current status of the user
     * @return either OFFLINE or ONLINE
     */
    public STATUS getStatus(){
        return this.status;
    }

    // Active USERS functionality
    public void setActiveUsersList(ArrayList<String> usernames){
        this.activeUsers.addAll(usernames);
    }
    public ArrayList<String> getActiveUsersList(){
        if(this.type==TYPE.AFFLICTED) {
            return this.activeUsers;
        }
        return null;
    }

    // CONNECT to a specific User functionality

    /**
     * This function will be called in the UI to enter the name of the person they are trying to connect with
     * @param username
     */
    public void connectToVolunteer(String username){
        if(this.type==TYPE.AFFLICTED){
            this.connectedUser=username;
        }
    }
    public void setUpdateServerNewVolunteer(Boolean update){
        this.updateServerNewVolunteer=update;
    }

    /**
     * This function will be called in the Client server side to get the name of the connected person
     * @return
     */
    public String getConnectedUsername(){
        return this.connectedUser;
    }

    //DISCONNECT USER
    // call this function in the UI
    public void disconnectUser(){
        this.status=STATUS.OFFLINE;
    }
}
