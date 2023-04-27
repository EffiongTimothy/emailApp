package services;


import data.models.User;
import data.repository.UserRepositoryImpl;
import dto.requests.UserRequest;
import dto.response.UserResponse;
import utils.Mapper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserServicesImpl implements UserServices {

    UserRepositoryImpl userRepo = new UserRepositoryImpl();
    @Override
    public String save(UserRequest userRequest){
        if (userExit(userRequest.getEmailAddress()))
            throw new IllegalArgumentException("Can not create User Because This emailAddress already exists");
        return String.valueOf(userRepo.save(Mapper.map(userRequest)));

    }

    private boolean userExit(String emailAddress) {
      User foundUser = userRepo.findByEmailAddress(emailAddress);
        return foundUser != null;
    }

    public boolean validateEmailAddress(String emailAddress){
        String regex = "[a-zA-Z0-9]+@[a-zA-Z.-]+\\.[a-zA-Z]{2,3}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(emailAddress);
        if(!matcher.matches()){
            throw new IllegalArgumentException("Email address format is invalid");
        }
        return matcher.matches();
}

    @Override
    public boolean validatePassword(String password) {
        String regex ="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        if (!matcher.matches()){
            throw new IllegalArgumentException("Password is invalid");
        }
        return matcher.matches();
    }

    @Override
    public UserResponse findById(int id) {
        User foundUser = userRepo.findById(id);
        UserResponse response = new UserResponse();
        if (foundUser==null){
            throw new NullPointerException("foundUser is null");
        }
        Mapper.map(foundUser, response);
        return response;

    }

    @Override
    public UserResponse findByEmailAddress(String emailAddress) {
        User foundUser = userRepo.findByEmailAddress(emailAddress);
        UserResponse response = new UserResponse();
        if (foundUser==null){
            throw new NullPointerException("foundUser is null");
        }
        Mapper.map(foundUser, response);
        return response;
    }

    @Override
    public void deleteBYId(int id) {
          userRepo.deleteBYId(id);

    }

    @Override
    public void deleteByEmailAddress(String emailAddress) {
    userRepo.deleteByEmailAddress(emailAddress);
    }

    public boolean login(String emailAddress,String password){
        User user = userRepo.findByEmailAddress(emailAddress);
        if (user.getPassword().equals(password) && user!=null) return true;
        else throw new NullPointerException("INVALID EMAIL OR PASSWORD");

    }
public void updateLastName(String lastName){
        User user = userRepo.findById(1);
        user.setLastName(lastName);
        userRepo.save(user);
}

    @Override
    public void updateProfile(int id, UserRequest userRequest) {
        User user = userRepo.findById(id);
        user.setLastName(userRequest.getLastName());
        user.setFirstName(userRequest.getFirstName());
        userRepo.save(user);
    }


}
