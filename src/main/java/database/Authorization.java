package database;


public class Authorization {
    public boolean authorize(DataBase db) {
        db.getUserdata();
        return true;
    }
}
