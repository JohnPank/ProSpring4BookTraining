package code.com.johnpank.chapter7.models;

import javax.persistence.*;
import code.com.johnpank.chapter7.dao.DBContract;
import java.util.Date;

@Entity
@Table(name = DBContract.NOTES_TABLE)
public class Note {

    @Id
    @Column(name= DBContract.NOTE_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name= DBContract.NOTE_USER_ID)
    private int userId;

    @Column(name= DBContract.NOTE_CONTENT)
    private String content;

    @Column(name= DBContract.NOTE_ADD_DATA)
    @Temporal(TemporalType.DATE)
    private Date addDate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                ", addDate=" + addDate +
                '}';
    }
}
