package data.repository;


import data.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
private final List<User> users= new ArrayList<>();
    @Override
    public User save(User user) {
        if (userExit(user)){
         user.setId(generateId());
        users.add(user);}
        return user;
    }

    private int generateId() {
        int id = 0;
        return id+1;
    }

    private boolean userExit(User user) {
        return user.getId() == 0;
    }

    @Override
    public User findById(int id) {
        for (User user:users) {
            if (user.getId()==id)
                return user;
        }
        return null;
    }

    @Override
    public User findByEmailAddress(String emailAddress) {
        for (User user:users) {
        if (user.getEmailAddress().equals(emailAddress))
            return user;
        }
        return null;
    }

    @Override
    public void deleteBYId(int id) {
        for (User user : users) {
            if (user.getId() == id)
                users.remove(user);
            break;
        }
    }
        @Override
    public void deleteByEmailAddress(String emailAddress) {
        for (User user:users) {
            if (user.getEmailAddress().equals(emailAddress))
                users.remove(user);
            break;
        }
    }

    @Override
    public List<User> findAll() {
        return users;
    }


    @Override
    public long count() {
        return users.size();
    }
}
