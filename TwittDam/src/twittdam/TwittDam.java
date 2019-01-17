package twittdam;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

/**
 *
 * @author migue
 */
public class TwittDam {

    public static void main(String[] args) {
        Twitter twitter = GestionTwitter.connectToTwitter();
        List<String> timeline = GestionTwitter.getTimeline(twitter);
        System.out.println("TIMELINE : ");
        System.out.println("----------------------------------------------");
        for (String twitt : timeline) {
            System.out.println(twitt);
        }
    }
}
