package repository.userRepositoryTest;

import data.models.User;
import data.repository.UserRepository;
import data.repository.UserRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserRepositoryTest {
    private UserRepository userRepository;
    private User user;
@BeforeEach
    public void beforeEach(){
     userRepository =new UserRepositoryImpl();
     user = new User();
    user.setFirstName("John");
    user.setLastName("Dean");
    user.setEmailAddress("test@example.com");
    user.setPassword("password");
}
@Test
    public void userCanCreateProfile_andSaveTest(){
    userRepository.save(user);
    assertEquals(1, userRepository.count());
}
@Test
    public void userCanBeSaved_andGenerateId(){
    userRepository.save(user);
    assertEquals(1, user.getId());
}
    @Test
    public void userCanBeSaved_andGenerateId_andFindProfileById(){
       User savedUser = userRepository.save(user);
        assertEquals(1, user.getId());
        User foundUser = userRepository.findById(1);
        assertEquals(foundUser, savedUser);
    }
    @Test
    public void userCanBeSaved_andFindProfileByEmailAddress(){
        User savedUser = userRepository.save(user);
        assertEquals("test@example.com", user.getEmailAddress());
        User foundUser = userRepository.findByEmailAddress("test@example.com");
        assertEquals(foundUser, savedUser);
    }
    @Test
    public void userCanBeSaved_andGenerateId_andDeleteUserById(){
        User savedUser = userRepository.save(user);
        assertEquals(1, user.getId());
         userRepository.deleteBYId(1);
        assertEquals(0,userRepository.count());
    }
    @Test
    public void userCanBeSaved_andDeleteUserByEmailAddress(){
        User savedUser = userRepository.save(user);
        assertEquals("test@example.com", user.getEmailAddress());
        userRepository.deleteByEmailAddress("test@example.com");
        assertEquals(0,userRepository.count());
    }

}
