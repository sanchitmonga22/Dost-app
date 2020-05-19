package com.example.dost.ServerClientNetwork;

public interface Protocols {
    /**
     * Defining the protocols:
     * 1. ONLINE(to letting the client know that they are online) username(sending the username if connecting for the first time) type(either AFFLICTED or VOLUNTEER)
     * 2. SEND channelID(id of the channel so that it can be sent to a specific person) message(the message that they want to send)
     * 3. CONNECT USER_NAME(to connect to a specific user, and this will create a unique channel for them, also only in the case of a AFFLICTED person)
     * 4. ACTIVE_USERS USER_NAMES(names of all the users who are active separated by a space, this will only be in the case of a AFFLICTED person, and not for a Volunteer)
     * 5. ERROR(if there is any kind of error, either the server is inactive or anything similar)
     * 6. TYPE VOLUNTEER/AFFLICTED(either of them just letting know their type to the server)
     * 7. DISCONNECT USER_NAME(to disconnect their chat with a particular user)
     * 8. VOLUNTEER (defines the type volunteer)
     * 9. AFFLICTED (defines the type afflicted)
     * 10. SENT(will be sent by the server to the user that the message was sent to the specific channel) channelID
     * 11. CONNECTED(when the user is connected to the other user) channelID(the ID of the channel that the user will be connected to)
     * 12. USER_OFFLINE(if the user they are talking to goes offline) username(the user they were talking to)
     * 13. RECEIVED(when we receive a message from the server) channelID(channelID of the user that has sent the message) message(the actual message)
     */
    public static final String ONLINE="ONLINE";
    public static final String SEND="SEND";
    public static final String SENT="SENT";
    public static final String CONNECT="CONNECT";
    public static final String CONNECTED="CONNECTED";
    public static final String ACTIVE_USERS="ACTIVE_USERS";
    public static final String ERROR="ERROR";
    public static final String TYPE="TYPE";
    public static final String DISCONNECT="DISCONNECT";
    public static final String USER_OFFLINE="USER_OFFLINE";
    public static final String RECEIVED="RECEIVED";
}
