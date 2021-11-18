package adapters;

import facebook.FacebookUser;
import twitter.TwitterUser;
import java.util.Date;


public class MyFacebookUser implements User{
    private FacebookUser facebookUser;
    public MyFacebookUser(FacebookUser fu){
        this.facebookUser = fu;
    }


    @Override
    public boolean sendMessage(String text, String country) {
        Date curDate = new Date();
        if (curDate.getTime() - this.getDate().getTime() <= 3600000L && this.getCountry().equals(country)){
            System.out.printf("Sending message %s to %s\n", text, this.facebookUser.getClass().getSimpleName());
            return true;
        }
        return false;

    }

    @Override
    public Date getDate() {
        return this.facebookUser.getUserActiveTime();

    }

    @Override
    public String getCountry() {
        return this.facebookUser.getUserCountry();
    }


}
