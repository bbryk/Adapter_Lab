package adapters;

import twitter.TwitterUser;
import java.util.Date;


public class MyTwitterUser implements User{
    private TwitterUser twitterUser;
    public MyTwitterUser(TwitterUser tu){
        this.twitterUser = tu;
    }


    @Override
    public boolean sendMessage(String text, String country) {
        Date curDate = new Date();
        if (curDate.getTime() - this.getDate().getTime() <= 3600000L && this.getCountry().equals(country)){
            System.out.printf("Sending message %s to %s\n", text, this.twitterUser.getClass().getSimpleName());
            return true;
        }
        return false;
    }

    @Override
    public Date getDate() {
        return this.twitterUser.getLastActiveTime();

    }

    @Override
    public String getCountry() {
        return this.twitterUser.getCountry();
    }


}
