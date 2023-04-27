package userServices;

import data.models.User;
import data.repository.UserRepository;
import data.repository.UserRepositoryImpl;
import dto.requests.UserRequest;
import dto.response.UserResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.UserServices;
import services.UserServicesImpl;
import utils.Mapper;

import static org.junit.jupiter.api.Assertions.*;

public class UserservicesTest {
    private UserServices userServices;
    private UserRequest userRequest;
    private UserResponse userResponse;
    private User user;
    private UserRepository userRepository;
    @BeforeEach
    public void setUp(){
user = new User();
userRepository = new UserRepositoryImpl();
        userResponse = new UserResponse();
        userServices = new UserServicesImpl();
        userRequest = new UserRequest();
        userRequest.setFirstName("John");
        userRequest.setLastName("Dean");
        userRequest.setPassword("password");
        userRequest.setEmailAddress("email@example.com");


    }
@Test
    public void userRequestCanBeSaved(){
        userServices.save(userRequest);
        assertEquals(1, userServices);
}
@Test
    public void userRequestCanSaved_userCanFindById(){
      var saveduser=  userServices.save(userRequest);
        userRepository.save(user);
        userResponse.setId(user.getId());
       var found = userServices.findById(userResponse.getId());
       assertEquals(found,saveduser);
    }
}