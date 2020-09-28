
import javax.websocket.server.ServerEndpoint; // Server endpoint communication
import javax.websocket.Session;               // Session information
import javax.websocket.OnClose;               // On close method
import javax.websocket.OnMessage;             // On message method
import javax.websocket.OnOpen;                // On open method

import java.util.logging.Logger;              // Log session info
import java.util.*;                           // List for sessions
import java.io.IOException;                   // Exceptions

@ServerEndpoint("/chat") // Specify displayed path to clients
public class ChatServer{

    /**
     * List containing all open sessions with the websocket server
     */
    private static List<Session> sessions = new ArrayList<Session>();

    /** 
     * Application logger
    */
    private static final Logger LOGGER = Logger.getLogger(ChatServer.class.getName());

    /**
     * Receives connections from peers using the websocket protocol
     * Saves the Session object into the session set for other methods to access
     * @param new_session The new session being created and should be kept track of
     */
    @OnOpen
    public void openSession(Session new_session) 
    {
        // Add session into set
        if (sessions.add(new_session))
        {
            // Log the session establishment
            LOGGER.info("New session established: " + new_session.getId());
        }
        else
        {
            // Session was already being kept track of
            LOGGER.warning("Session was already being kept track of: " + new_session.getId());
        }
    }

    /**
     * Called when a websocket session is being closed with the server
     * Removes the Session object from the set, so no more communication can be done with it
     * @param closing_session Session that is being closed and should no longer be kept track of
     */
    @OnClose
    public void closeSession(Session closing_session)
    {
        // Remove session from set
        if (sessions.remove(closing_session))
        {
            // Log the session removal
            LOGGER.info("Session closed: " + closing_session.getId());
        }
        else
        {
            // Session is not being kept track of
            LOGGER.warning("Session is not being kept track of: " + closing_session.getId());
        }
    }

    /**
     * Receives messages from the client and sends them to all connected sessions
     * @param message Message being sent to all connected sessions
     */
    @OnMessage
    public void transmitMessage(String message) throws IOException
    {
        // Iterate through set
        for(Session session : sessions)
        {
            // Send message to each session
            session.getBasicRemote().sendText(message);
        }
    }

}
