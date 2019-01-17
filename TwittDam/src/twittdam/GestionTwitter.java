/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twittdam;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

/**
 *
 * @author migue
 */
public class GestionTwitter {

    public static Twitter connectToTwitter() {
        Twitter twitter = null;
        try {
            twitter = TwitterFactory.getSingleton();
            twitter.setOAuthConsumer("bO7G77qRTp3YVxWM0Hq3OTMdb", "BX3L2qvVGFM6X4XHbBmvbwwNCiNp8gX1AvPw41Mh0ksBDuPviE"); //poco seguro
            RequestToken request = twitter.getOAuthRequestToken();
            Desktop.getDesktop().browse(new URI(request.getAuthorizationURL()));
            System.out.println("Introduce el pin: "); //se introduce el pin
            String pin = new Scanner(System.in).nextLine();
            AccessToken access = null;
            try {
                access = twitter.getOAuthAccessToken(request, pin);
            } catch (TwitterException te) { //comprobamos errores
                if (te.getStatusCode() == 401) {
                    System.out.println("Unable to get the access token.");
                } else {
                    te.printStackTrace();
                }
                System.exit(-1); //salimos de la aplicación si hay
            }
            System.out.println("acceso con éxito");
            twitter.setOAuthAccessToken(access);
        } catch (URISyntaxException | TwitterException | IOException ex) {
            ex.printStackTrace();
        }
        return twitter;
    }

    public static boolean sendTwitt(Twitter twitter, String twitt) {
        if (twitt.length() <= 280) {
            try {
                twitter.updateStatus(twitt);
                return true;
            } catch (TwitterException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public static List<String> getTimeline(Twitter twitter) {
        ArrayList<String> timeline = new ArrayList();
        try {
            ResponseList<Status> userTimeline = twitter.getUserTimeline();
            for (Status status : userTimeline) {
                timeline.add(status.getText());
            }
        } catch (TwitterException ex) {
            Logger.getLogger(GestionTwitter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return timeline;
    }

}
