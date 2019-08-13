package code.com.johnpank.chapter7.models;

import javax.persistence.*;
import code.com.johnpank.chapter7.dao.DBContract;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = DBContract.USERS_TABLE)
public class User {

    @Id
    @Column(name= DBContract.USER_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name= DBContract.USER_LOGIN)
    private String login;

    @Column(name= DBContract.USER_PASSWORD)
    private String password;

    @Column(name= DBContract.USER_EMAIL)
    private String email;

    @Column(name= DBContract.USER_BIRTH_DATE)
    @Temporal(value=TemporalType.DATE)
    private Date birthDate;

    @Column(name= DBContract.USER_REG_DATE)
    @Temporal(value=TemporalType.DATE)
    private Date regDate;

    @OneToMany(mappedBy = DBContract.NOTE_USER_ID, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Note> notes = new HashSet<Note>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Set<Note> getNotes() {
        return notes;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
//                ", birthDate=" + birthDate +
               ", regDate=" + regDate +
                '}';
    }
}