/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
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
            String pin = JOptionPane.showInputDialog("Introduce el pin que recibes de la web de twitter :   ");
            AccessToken access = null;
            try {
                access = twitter.getOAuthAccessToken(request, pin);
            } catch (TwitterException te) { //comprobamos errores
                if (te.getStatusCode() == 401) {
                    JOptionPane.showMessageDialog(null, "Imposible conseguir el token de acceso", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    te.printStackTrace();
                }
                System.exit(-1); //salimos de la aplicación si hay
            }
            JOptionPane.showMessageDialog(null, "Acceso conseguido.");
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

    public static List<Status> getUserTimeline(Twitter twitter) {
        ArrayList<Status> timeline = new ArrayList();
        try {
            ResponseList<Status> userTimeline = twitter.getUserTimeline();
            for (Status status : userTimeline) {
                timeline.add(status);
            }
        } catch (TwitterException ex) {
            ex.printStackTrace();
        }
        return timeline;
    }
    
    public static List<Status> getHomeTimeline(Twitter twitter) {
        ArrayList<Status> timeline = new ArrayList();
        try {
            ResponseList<Status> homeTimeline = twitter.getHomeTimeline();
            for (Status status : homeTimeline) {
                timeline.add(status);
            }
        } catch (TwitterException ex) {
            ex.printStackTrace();
        }
        return timeline;
    }

}
