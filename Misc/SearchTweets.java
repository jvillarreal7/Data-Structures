package twitter4j.examples.search;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import twitter4j.*;

import java.util.List;
import java.util.Scanner;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Twitter4J by Yusuke Yamamoto - yusuke at mac.com
 * 
 */
public class SearchTweets {
    public static void main(String[] args) throws IOException {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        //Las llaves y tokens son proporcionadas por el API de Twitter.
        cb.setDebugEnabled(true)
          .setOAuthConsumerKey("")
          .setOAuthConsumerSecret("")
          .setOAuthAccessToken("")
          .setOAuthAccessTokenSecret("");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        try {
            Scanner sc = new Scanner(System.in);
            PrintStream ps = new PrintStream("tweets.txt");
            int c = 0;
            String q = "";
            q = sc.nextLine();
            Query query = new Query(q);
            QueryResult result;
            do {
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets) {
                    //System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
                    ps.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
                    c++;
                }
            } while ((query = result.nextQuery()) != null);
            ps.close();
            System.out.println("Búsqueda terminada, " + c + " resultados encontrados.");
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Se encontró una falla al buscar tweets: " + te.getMessage());
            System.exit(-1);
        }
    }
}
