package adapters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sender.MessageSender;
import twitter.TwitterUser;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class MyFacebookUserTest {

    MessageSender ms;
    MyTwitterUser mfb;
    Date date;
    @BeforeEach
    void setUp() throws Exception{

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");

        String dateInString = "7-Jun-2013";
        Date date = formatter.parse(dateInString);
        this.date = date;

        TwitterUser fb1 = new TwitterUser("bober1@gmail.com", "Ukraine", date);
        MyTwitterUser mfb1 = new MyTwitterUser(fb1);
        MessageSender ms = new MessageSender();
        this.ms = ms;
        this.mfb = mfb1;

    }

    @Test
    void sendMessage() {
        assertFalse(this.ms.send("some message",  this.mfb, "Ukraine"));
    }

    @Test
    void getDate() {
        assertTrue(this.mfb.getDate().equals(this.date));
    }

    @Test
    void getCountry() {
        assertTrue(this.mfb.getCountry().equals("Ukraine"));
    }
}