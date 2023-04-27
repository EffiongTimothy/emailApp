package dto.requests;



public class EmailRequest {
private String tittle;
private String body;
private  String receiverEmail;
private String senderEmail;

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
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

    public String getReceiverEmail() {
        return receiverEmail;
    }

    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

    @Override
    public String toString() {
        return String.format("""
                    REVIEW
                SENDER-EMAIL: %S
                TITTLE: %S
                BODY: %S
                Receiver-Email: %S
                """,senderEmail,tittle,body,receiverEmail);
    }
}
