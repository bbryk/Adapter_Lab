import adapters.MyFacebookUser;
import adapters.MyTwitterUser;
import adapters.User;
import analytics.ReportBuilder;
import database.Authorization;
import database.DataBase;
import facebook.FacebookUser;
import sender.MessageSender;
import twitter.TwitterUser;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Main {
    public  static void main(String[] args)throws Exception{
        DataBase db = new DataBase();
        Authorization authorization = new Authorization();
        if (authorization.authorize(db)) {
            ReportBuilder br = new ReportBuilder(db);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");

        String dateInString = "7-Jun-2013";
        Date date = formatter.parse(dateInString);

        FacebookUser fb1 = new FacebookUser("bober2@gmail.com", "Ukraine", date);
        MyFacebookUser mfb1 = new MyFacebookUser(fb1);
        TwitterUser tw1 = new TwitterUser("bober1@gmail.com", "Ukraine", new Date());
        MyTwitterUser mtw1 = new MyTwitterUser(tw1);
        MessageSender ms = new MessageSender();
        ms.send("some message",  mtw1, "Ukraine");
        ms.send("some message", mfb1, "Ukraine");
    }
}
