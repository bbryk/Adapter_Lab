package adapters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sender.MessageSender;
import twitter.TwitterUser;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class MyTwitterUserTest {
    MessageSender ms;
    MyTwitterUser mtw;
    Date date;
    @BeforeEach
    void setUp() throws Exception{

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");

        String dateInString = "7-Jun-2013";
        Date date = formatter.parse(dateInString);
        this.date = date;

        TwitterUser tw1 = new TwitterUser("bober1@gmail.com", "Ukraine", date);
        MyTwitterUser mtw1 = new MyTwitterUser(tw1);
        MessageSender ms = new MessageSender();
        this.ms = ms;
        this.mtw = mtw1;

    }

    @Test
    void sendMessage() {
        assertFalse(this.ms.send("some message",  this.mtw, "Ukraine"));
    }

    @Test
    void getDate() {
        assertTrue(this.mtw.getDate().equals(this.date));
    }

    @Test
    void getCountry() {
        assertTrue(this.mtw.getCountry().equals("Ukraine"));
    }
}