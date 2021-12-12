import java.io.*;
public class Documen implements Serializable {
    private String title;
    private String type;
    private String detail;

    public Documen() {
        this("","","");
    }

    public Documen(String title, String type, String detail) {
        this.title = title;
        this.type = type;
        this.detail = detail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
    
    
}
