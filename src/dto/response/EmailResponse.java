package dto.response;

import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.title;

public class EmailResponse {
private int id;
    private String tittle;
    private String body;
    private String SenderEmail;
    private String recieverEmail;
    private String LocalDateAndTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocalDateAndTime() {
        return LocalDateAndTime;
    }

    public void setLocalDateAndTime(String localDateAndTime) {
        LocalDateAndTime = localDateAndTime;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSenderEmail() {
        return SenderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        SenderEmail = senderEmail;
    }

    public String getRecieverEmail() {
        return recieverEmail;
    }

    public void setRecieverEmail(String recieverEmail) {
        this.recieverEmail = recieverEmail;
    }

    @Override
    public String toString() {
        return String.format("""
                ------------------
                 FROM: %s
                 Subject: %s
                 ID-NUMBER: %d.
                   %s.
                --------%s--------
                """,SenderEmail,tittle,id,body,LocalDateAndTime);
    }
}
