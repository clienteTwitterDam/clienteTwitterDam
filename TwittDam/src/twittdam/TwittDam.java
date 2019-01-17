package twittdam;

import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.Twitter;
import twitter4j.TwitterException;

/**
 *
 * @author migue
 */
public class TwittDam {

    public static void main(String[] args) {
        Twitter twitter = GestionTwitter.connectToTwitter();
        try {
            twitter.updateStatus("Prueba conexion metodo estatico");
        } catch (TwitterException ex) {
            Logger.getLogger(TwittDam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
