package services;


import data.models.Email;
import data.repository.EmailRepository;
import data.repository.EmailRepositoryImpl;
import dto.requests.EmailRequest;
import dto.response.EmailResponse;
import utils.Mapper;

public class EmailUserServiceImpl implements EmailServices {
EmailRepository emailRepository = new EmailRepositoryImpl();
    @Override
    public EmailResponse findBYId(int id) {
       Email foundEmail = emailRepository.findBYId(id);
       EmailResponse emailResponse = new EmailResponse();
       if (foundEmail != null){
       Mapper.map(foundEmail, emailResponse);
       return emailResponse;}
       throw new NullPointerException("No email found");
    }

    @Override
    public EmailResponse findByEmail(String email) {
        Email foundEmail = emailRepository.findByEmail(email);
        EmailResponse emailResponse = new EmailResponse();
        if (foundEmail != null){
        Mapper.map(foundEmail, emailResponse);
        return emailResponse;}
            throw new NullPointerException("inbox is empty");
    }


    @Override
    public Email sendEmail(EmailRequest request) {
      return emailRepository.sendEmail(Mapper.map(request));
    }

    private boolean emailExists(String tittle) {
        Email email = emailRepository.findByTitlle(tittle);
        return email != null;
    }

    public EmailResponse inbox(String email) {
        Email foundUser = emailRepository.findByEmail(email);
        EmailResponse emailResponse = new EmailResponse();
        if (foundUser != null){
            Mapper.map(foundUser,emailResponse);
        return emailResponse;}
        throw new NullPointerException("inbox is null");
    }
    @Override
    public String deleteEmailById(int id) {
        if (emailRepository.findBYId(id)!=null) {
            emailRepository.deleteEmailById(id);
        }
        throw new NullPointerException("inbox is null");
    }

    @Override
    public void deleteEmailByTittle(String tittle) {
        emailRepository.deleteEmailByTittle(tittle);
    }

    @Override
    public int mailSize() {
        return (int) emailRepository.count();
    }

    @Override
    public EmailResponse mails(int id) {
        Email email = emailRepository.findBYId(id);
        EmailResponse emailResponse = new EmailResponse();
        if (email == null) {
            throw new NullPointerException("Email not found");
        }
        Mapper.map(email,emailResponse);
        return emailResponse;
    }
}

