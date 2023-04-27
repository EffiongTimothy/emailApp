package utils;

import data.models.Email;
import data.models.User;
import dto.requests.EmailRequest;
import dto.requests.UserRequest;
import dto.response.EmailResponse;
import dto.response.UserResponse;

import java.time.format.DateTimeFormatter;

public class Mapper {

    public static User map(UserRequest request){
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmailAddress(request.getEmailAddress());
        user.setPassword(request.getPassword());
        return user;
    }
    public static void map(User user, UserResponse response){
        response.setFullName(user.getLastName()+" "+user.getFirstName()) ;
        response.setEmailAddress(user.getEmailAddress());
        response.setId(user.getId());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" dd /MM /YYYY");
        response.setLocalDate(formatter.format(user.getLocalDateTime()));
    }

        public static Email map(EmailRequest emailRequest){
        Email email = new Email();
        email.setTittle(emailRequest.getTittle());
            email.setBody(emailRequest.getBody());
            email.setReceiveEmail(emailRequest.getReceiverEmail());
            email.setSendEmail(emailRequest.getSenderEmail());
        return email;
    }
    public static void map(Email email, EmailResponse response){
        response.setId(email.getId());
        response.setTittle(email.getTittle());
        response.setBody(email.getBody());
        response.setRecieverEmail(email.getReceiveEmail());
        response.setSenderEmail(email.getSendEmail());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" dd /MM /yyyy  hh:mm:ss ");
        response.setLocalDateAndTime(formatter.format(email.getLocalDateTime()));

    }

}
