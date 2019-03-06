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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import modelo.Tweet;
import modelo.Usuario;
import twitter4j.PagableResponseList;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.RateLimitStatus;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Trend;
import twitter4j.Trends;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
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

    public static List<User> seguidores(Twitter twitter) {
        List<User> followers = new ArrayList<>();
        PagableResponseList<User> page;
        long cursor = -1;

        try {
            while (cursor != 0) {
                page = twitter.getFollowersList(twitter.getId(), cursor, 200);
                followers.addAll(page);
                cursor = page.getNextCursor();
                GestionTwitter.handleRateLimit(page.getRateLimitStatus());
            }
        } catch (TwitterException e) {
            e.printStackTrace();
        }

        return followers;
    }

    public static List<User> seguidos(Twitter twitter) {
        List<User> friends = new ArrayList<>();
        PagableResponseList<User> page;
        long cursor = -1;

        try {
            while (cursor != 0) {
                page = twitter.getFriendsList(twitter.getId(), cursor, 200);
                friends.addAll(page);
                cursor = page.getNextCursor();
                GestionTwitter.handleRateLimit(page.getRateLimitStatus());
            }
        } catch (TwitterException e) {
            e.printStackTrace();
        }

        return friends;
    }

    public static void handleRateLimit(RateLimitStatus rls) {
        int remaining = rls.getRemaining();
        System.out.println("Rate Limit Remaining: " + remaining);
        if (remaining == 0) {
            int resetTime = rls.getSecondsUntilReset() + 5;
            int sleep = (resetTime * 1000);
            try {
                if (sleep > 0) {
                    System.out.println("Wait-" + (sleep / 1000) + " seconds..");
                    Thread.sleep(sleep);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static DefaultListModel trendindTopicsGlobales(Twitter twitter) {
        Trends placeTrends = null;
        try {
            placeTrends = twitter.getPlaceTrends(1);
        } catch (TwitterException ex) {
            Logger.getLogger(GestionTwitter.class.getName()).log(Level.SEVERE, null, ex);
        }
        Trend[] trends = placeTrends.getTrends();
        DefaultListModel listaModeloTT = new DefaultListModel();

        for (int i = 0; i < 10; i++) {
            listaModeloTT.addElement(trends[i].getName());
        }
        return listaModeloTT;
    }

    public static DefaultListModel trendindTopicsEsp(Twitter twitter) {
        Trends placeTrends = null;
        try {
            placeTrends = twitter.getPlaceTrends(766273);
        } catch (TwitterException ex) {
            Logger.getLogger(GestionTwitter.class.getName()).log(Level.SEVERE, null, ex);
        }
        Trend[] trends = placeTrends.getTrends();
        DefaultListModel listaModeloTT = new DefaultListModel();

        for (int i = 0; i < 10; i++) {
            listaModeloTT.addElement(trends[i].getName());
        }
        return listaModeloTT;
    }

    public static void retwitear(Twitter twitter, long statusID) {
        try {
            twitter.retweetStatus(statusID);
        } catch (TwitterException ex) {
            Logger.getLogger(GestionTwitter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<Status> buscarTopic(Twitter twitter, String tema) {
        List<Status> resultadoBusqueda = null;
        try {
            Query temaBuscar = new Query(tema);
            QueryResult search = twitter.search(temaBuscar);
            resultadoBusqueda = search.getTweets();
        } catch (TwitterException ex) {
            Logger.getLogger(GestionTwitter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultadoBusqueda;
    }

    public static List<Status> buscarUsuario(Twitter twitter, String usuario) {
        ResponseList<User> usuarios = null;
        List<Status> userTimeline = null;
        try {
            usuarios = twitter.searchUsers(usuario, 0);
        } catch (TwitterException ex) {
            Logger.getLogger(GestionTwitter.class.getName()).log(Level.SEVERE, null, ex);
        }
        String screenName = usuarios.get(0).getScreenName();
        try {
            userTimeline = twitter.getUserTimeline(screenName);
        } catch (TwitterException ex) {
            Logger.getLogger(GestionTwitter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userTimeline;
    }
    
    
public static List<Tweet> listaTweetsPropiosInforme(Twitter twitter) {
        List<Tweet> tweets = new ArrayList<>();
        List<Status> userTimeline = GestionTwitter.getUserTimeline(twitter);
        for (Status status : userTimeline) {
            tweets.add(new Tweet(status.getUser().getName(), status.getId(), status.getText()));
        }
        return tweets;
    }

    public static List<Tweet> listaTweetsUsuarioInforme(Twitter twitter,String usuario) {
        List<Tweet> tweets = new ArrayList<>();
        List<Status> userTimeline = GestionTwitter.buscarUsuario(twitter, usuario);
        for (Status status : userTimeline) {
            tweets.add(new Tweet(status.getUser().getName(), status.getId(), status.getText()));
        }
        return tweets;
    }

    public static List<Usuario> listaSeguidosInforme(Twitter twitter) {
        List<Usuario> usuarios = new ArrayList<>();
        List<User> seguidos = GestionTwitter.seguidos(twitter);
        for (User seguido : seguidos) {
            usuarios.add(new Usuario(seguido.getName()));
        }
        return usuarios;
    }

    public static List<Usuario> listaSeguidoresInforme(Twitter twitter) {
        List<Usuario> usuarios = new ArrayList<>();
        List<User> seguidores = GestionTwitter.seguidores(twitter);
        for (User seguidor : seguidores) {
            usuarios.add(new Usuario(seguidor.getName()));
        }
        return usuarios;
    }

}
