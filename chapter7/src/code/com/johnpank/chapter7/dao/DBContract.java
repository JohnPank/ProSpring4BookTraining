package code.com.johnpank.chapter7.dao;

public class DBContract {

    public static final String DB_NAMES = "usersNotes";

    //------users-------
    public static final String USERS_TABLE = "users";
    public static final String USER_ID= "id";
    public static final String USER_LOGIN = "login";
    public static final String USER_PASSWORD = "password";
    public static final String USER_EMAIL = "email";
    public static final String USER_BIRTH_DATE = "birthDate";
    public static final String USER_REG_DATE = "regDate";

    //------notes-------
    public static final String NOTES_TABLE = "notes";
    public static final String NOTE_ID = "id";
    public static final String NOTE_USER_ID = "userId";
    public static final String NOTE_CONTENT = "content";
    public static final String NOTE_ADD_DATA = "addDate";
}
