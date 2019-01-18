package twittdam;

import java.util.List;
import twitter4j.Twitter;

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
