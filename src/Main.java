import controllers.EmailController;
import controllers.UserControllers;
import data.models.User;
import dto.requests.EmailRequest;
import dto.requests.UserRequest;

import javax.swing.*;

    public  class Main {
private static final UserRequest userRequest = new UserRequest();

        private static final EmailController emailController = new EmailController();
        private static final UserControllers userControllers  = new UserControllers();
        public static void main(String[] args) {
startApp();
        }

        private static void startApp() {
            String mainManue = """
                      PLEASE REGISTER OR LOGIN
                    1----Register
                    2----Login
                    3----exit
                    """;
            String collectInput = input(mainManue);
            switch (collectInput.charAt(0)){
                case '1'-> register();
                case '2'-> logIn();
                case '3'-> exit();
                default ->{display("INVALID INPUT");
                    startApp();
            }
            }

        }
        private static void register() {
                userRequest.setFirstName(input("enter firstName"));
                userRequest.setLastName(input("enter lastName"));
                userRequest.setEmailAddress(input("create Email"));
                userRequest.setPassword(input("create password"));
                var registeredUser = userControllers.register(userRequest);
            boolean validate = userControllers.validateEmailAndPassWord(userRequest.getEmailAddress(), userRequest.getPassword());
                if (validate){
                display(registeredUser.toString());
                logInPage();}
            else {

                display("Email format or password is invalid");
                display("""
                               password must have
                         At least 8 characters
                         At least one numeric number
                         At least one UPPERCASE and one LOWERCASE character
                         At least one special characters @$!%*#?&
                         """);
                startApp();
            }
        }

        private static void logIn() {
        String emailAddress = input("enter emailAddress");
        String password = input("enter password");
       if(userControllers.login(emailAddress, password)) {
           logInPage();
       }display("invalid login credentials".toUpperCase());
           startApp();
        }
        public static void logInPage(){
            String output =("""
                                YOUR EMAIL
                            1---ViewMail
                            2---Compose
                            3---AllMail
                            4---Delete
                            5---Settings
                            6---LogOut
                            7---Exit""");
            String userInput = input(output);
            switch (userInput.charAt(0)) {
                case '1'->viewMails();
                case '2'->composes();
                case '3'->mailSize();
                case '4'->deleteById();
                case '5'->settings();
                case '6'->logOut();
                case '7'->exit();
                default ->{ display("INVALID INPUT");
                                logInPage();}
            }

        }

        private static void settings() {
         String userInput = """
                 1---Profile
                 2---DeleteUser
                 3---UpdateProfile
                 4---Change Password
                 5---Back
                 """;
        String settingView = input(userInput);
        switch (settingView.charAt(0)){
            case '1'->profile();
            case '2'->deleteUser();
            case '3'->updateProfile();
            case '4'->changePassword();
            case '5'->back();
            default ->{display("INVALID INPUT");settings();}
        }
        }

        private static void back() {
            logInPage();
        }

        private static void changePassword() {
            String newPassword = input("change password");

        }

        private static void updateProfile() {
            String userInput = input("Enter user id");
            display(userControllers.findById(Integer.parseInt(userInput)).toString());
            String firstName = input("chane firstName");
            String lastName = input("chane lastName");
            userRequest.setFirstName(firstName);
            userRequest.setLastName(lastName);
            userControllers.updateProfile(Integer.parseInt(userInput), userRequest);
                settings();
        }

        private static void deleteUser() {
            String userInput = input("enter user id");
            userControllers.deleteById(Integer.parseInt(userInput));
               display("deleted");
                startApp();
        }

        private static void profile() {
            String userInput = input("Enter user id");
            display(userControllers.findById(Integer.parseInt(userInput)).toString());
            settings();
        }

        private static void deleteById() {
                String userInput =(input("enter mail ID to delete "));
                if (emailController.findBYId(Integer.parseInt(userInput))!=null) {
                    display("DELETED");
                emailController.deleteEmailById(Integer.parseInt(userInput));
                }else {
                    display(emailController.deleteEmailById(Integer.parseInt(userInput)));
                }
            logInPage();
        }

        private static void logOut() {
            startApp();
        }

        private static void mailSize() {
            int mailSize = emailController.mailSize();
            display(String.valueOf(mailSize));
            logInPage();
        }


        private static void viewMails() {
                String userInput = input("enter mail id");
                display( emailController.findBYId(Integer.parseInt(userInput)).toString());
            logInPage();
        }

        private static void composes() {
            UserRequest userRequest = new UserRequest();
            EmailRequest request = new EmailRequest();
            request.setSenderEmail(input("senderEmail"));
            request.setTittle(input("MAIL TITTLE"));
            request.setBody(input("ENTER INFO"));
            request.setReceiverEmail(input("SEND TO  "));
            request.setSenderEmail(userRequest.getEmailAddress());
            var sentEmail= emailController.sendMail(request);
            display(request.toString());
            display("sent successfully");
            logInPage();

        }

        private static void exit() {
            System.exit(1);
        }
        private static String input(String userInput) {
            return JOptionPane.showInputDialog(userInput);
        }
        private static void display(String message) {
            JOptionPane.showMessageDialog(null, message);
        }
    }
