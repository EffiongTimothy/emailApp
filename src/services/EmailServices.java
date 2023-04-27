package services;

import data.models.Email;
import dto.requests.EmailRequest;
import dto.response.EmailResponse;

import java.util.List;

public interface EmailServices {

    Email sendEmail(EmailRequest emailRequest);
    EmailResponse findBYId(int id);
    EmailResponse findByEmail(String email);
    String deleteEmailById(int id);
    void deleteEmailByTittle(String tittle);
    int mailSize();
    EmailResponse inbox(String email);
    EmailResponse mails(int id);



}
