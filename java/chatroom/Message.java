import java.util.*;
import java.io.*;

public class Message implements Serializable {
    private String content;
    private Date date;
    public Message(String content, Date date) {
        this.content = content;
        this.date = date;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    @Override
    public String toString() {
        return "Message: " + this.content + " (Date: " + this.date.toString() + ")";
    }
}

