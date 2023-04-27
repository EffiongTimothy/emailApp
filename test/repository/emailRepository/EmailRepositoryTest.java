package repository.emailRepository;

import data.models.Email;
import data.repository.EmailRepository;
import data.repository.EmailRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmailRepositoryTest {
    private EmailRepository emailRepository;
    private Email email;
@BeforeEach
public void setUp(){
    emailRepository = new EmailRepositoryImpl();
    email = new Email();
    email.setTittle("the box");
    email.setSendEmail("thisEmail@gmail.com");
    email.setReceiveEmail("thisRecipient@gmail.com");
    email.setBody("i am seniorMan");
}
    @Test
    public void sendOneMailTestThatMailIsSent_AndCountIsOne(){
    emailRepository.sendEmail(email);
    assertEquals(1, emailRepository.count());
    }
@Test
    public void sendTwoMailTestThatMailisSent_AndCountisTwo(){
    Email email1 = new Email();
    emailRepository.sendEmail(email);
    emailRepository.sendEmail(email1);
    assertEquals(2, emailRepository.count());
}
@Test
    public void sendOneMailTest_ViewMailSentBYIdTest(){
    emailRepository.sendEmail(email);
    assertEquals(1, email.getId());
   Email foundEmail = emailRepository.findBYId(1);
    assertEquals(email,foundEmail);
    }
@Test
    public void sendTwoMailTest_ViewMailSentByIdTest(){
Email email1 = new Email();
emailRepository.sendEmail(email1);
emailRepository.sendEmail(email);
assertEquals(1, email1.getId());
assertEquals(2,email.getId());
Email foundEmail = emailRepository.findBYId(1);
assertEquals(email1, foundEmail);
}
@Test
    public void sendONemail_deleteMailByIdTest(){
    emailRepository.sendEmail(email);
    assertEquals(1,email.getId());
    emailRepository.deleteEmailById(1);
    assertEquals(0,emailRepository.count());
}

@Test
    public void sendThreeMails_view_allMail(){
    Email email1 = new Email();
    Email email2 = new Email();
    Email email3 = new Email();
    emailRepository.sendEmail(email1);
    emailRepository.sendEmail(email2);
    emailRepository.sendEmail(email3);
    assertEquals(3,emailRepository.count());
    var foundMail = emailRepository.findAll();
    assertNotNull(foundMail);
}
}