package controllers;

import dto.requests.UserRequest;
import services.UserServices;
import services.UserServicesImpl;

public class UserControllers {
    UserServices userServices = new UserServicesImpl();
public Object register(UserRequest userRequest){
 try {
     return userServices.save(userRequest);
 }catch (IllegalArgumentException e){
    return e.getMessage();
 }

}
public Object findById(int id){
    try {
        return userServices.findById(id);
    }catch (NullPointerException e){
        return e.getMessage();
    }
}
public Object findByEmailAddress(String emailAddress){
    try {
        return userServices.findByEmailAddress(emailAddress);
    }catch (NullPointerException e){
        return e.getMessage();
    }
}
public void deleteById(int id){
        userServices.deleteBYId(id);
}
public void deleteByEmail(String emailAddress){
    userServices.deleteByEmailAddress(emailAddress);
}
public boolean login(String emailAddress,String password){
    try {
    return userServices.login(emailAddress,password);
}catch (NullPointerException e){
       return Boolean.parseBoolean(e.getMessage());
    }
}
public boolean validateEmail(String emailAddress){
    try {
       return userServices.validateEmailAddress(emailAddress);
    }catch (IllegalArgumentException e){
        return Boolean.parseBoolean(e.getMessage());
    }

}
public boolean validatePassword(String password){
    try {
        return userServices.validatePassword(password);
    }catch (IllegalArgumentException e){
        return Boolean.parseBoolean(e.getMessage());
    }
}
public boolean validateEmailAndPassWord(String email,String password){
    try {
        validatePassword(password);
      return   validateEmail(email);
    }catch (IllegalArgumentException e){
        return Boolean.parseBoolean(e.getMessage());
    }
}
public String update(String lastName){
    try {
         userServices.updateLastName(lastName);
    }catch (IllegalArgumentException e){
        return e.getMessage();
    }
    return lastName;
}
public void updateProfile(int id, UserRequest userRequest){
    userServices.updateProfile(id,userRequest);
}
}
