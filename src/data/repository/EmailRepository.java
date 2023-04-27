package data.repository;


import data.models.Email;

import java.util.List;

public interface EmailRepository {
    Email sendEmail(Email email);
    Email findBYId(int id);
    Email findByEmail(String email);
    Email findByTitlle(String tittle);
    void deleteEmailById(int id);
    void deleteEmailByTittle(String tittle);
    List<Email> findAll();
    long count();




}
