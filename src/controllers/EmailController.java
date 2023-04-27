package controllers;

import dto.requests.EmailRequest;
import services.EmailServices;
import services.EmailUserServiceImpl;

public class EmailController {
    EmailServices emailServices = new EmailUserServiceImpl();

        public Object sendMail(EmailRequest emailRequest) {
            try {
                return emailServices.sendEmail(emailRequest);
            }catch (IllegalArgumentException e){
                return e.getMessage();
            }
        }

        public Object findBYId(int id) {
            try {
            return emailServices.findBYId(id);
        }catch (NullPointerException e){
            return e.getMessage();
            }
        }
        public String deleteEmailById(int id){
            try {
              return  emailServices.deleteEmailById(id);
            }catch (NullPointerException e){
               return e.getMessage();
            }
        }

        public void deleteEmailByTittle(String tittle) {
            try {
                emailServices.deleteEmailByTittle(tittle);
            }catch (NullPointerException e){
                e.getMessage();
            }
        }
        public int mailSize(){
            try {
            return emailServices.mailSize();
            }catch (NullPointerException e) {
              return Integer.parseInt(e.getMessage());
            }
        }
        public Object mail(int id){
            try {
                return emailServices.mails(id);
            }catch (NullPointerException e){
                return e.getMessage();
            }
        }
public Object inbox(String title){
            try {
                return emailServices. inbox(title);
            }catch (NullPointerException e){
                return e.getMessage();
            }
}
public Object findByEmail(String email){
            try {
                return emailServices. findByEmail(email);
            }catch (NullPointerException e){
                return e.getMessage();
            }
}

}


