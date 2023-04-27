package services;


import dto.requests.UserRequest;
import dto.response.UserResponse;

public interface UserServices {
    String save(UserRequest userRequest);
    UserResponse findById(int id);
    boolean validateEmailAddress(String email);
    boolean validatePassword(String password);
    UserResponse findByEmailAddress(String emailAddress);
    void deleteBYId(int id);
    void deleteByEmailAddress(String emailAddress);
    boolean login(String emailAddress,String password);
    void updateLastName(String lastName);
    void updateProfile(int id, UserRequest userRequest);


}
