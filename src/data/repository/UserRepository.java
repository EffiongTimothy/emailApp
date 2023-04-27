package data.repository;


import data.models.User;

import java.util.List;

public interface UserRepository {
User save(User user);
User findById(int id);
User findByEmailAddress(String emailAddreass);
void deleteBYId(int id);
void deleteByEmailAddress(String emailAddress);
List<User> findAll();
    long count();

}
