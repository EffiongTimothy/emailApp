package dto.response;

import java.time.LocalDateTime;

public class UserResponse {
private int id;
    private String fullName;
private  String emailAddress;
private String localDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return String.format("""
                id = %s
                fullName = %s
                emailAddress = %s
                DateCreated = %s
                """,id,fullName,emailAddress,localDate);
    }
}
