package sender;

import adapters.MyFacebookUser;
import adapters.MyTwitterUser;
import adapters.User;
import facebook.FacebookUser;
import twitter.TwitterUser;

import java.util.Date;

public class MessageSender {
    public boolean send(String text, User user, String country) {

        return user.sendMessage(text, country);
    }
}
