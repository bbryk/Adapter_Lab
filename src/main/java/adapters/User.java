package adapters;

import java.util.Date;

public interface User {
    public boolean sendMessage(String text, String country);
    public Date getDate();
    public String getCountry();

}
