package data.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {
   private  int id;
    private String firstName;
    private String lastName;
    private String password;
    private String emailAddress;
    private LocalDateTime localDateTime = LocalDateTime.now();
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("""
                id = %d
                firstName = %s
                lastName = %s
                emailAddress = %s
                password = %s
                DateCreated = %s
                """,id,firstName,lastName,emailAddress,password,localDateTime);
    }
}