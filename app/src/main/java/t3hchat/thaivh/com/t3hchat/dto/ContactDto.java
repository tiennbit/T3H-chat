package t3hchat.thaivh.com.t3hchat.dto;

/**
 * Created by thais on 2/11/2018.
 */

public class ContactDto {

    String name;
    String message;
    String tel;
    String time;

    public ContactDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
