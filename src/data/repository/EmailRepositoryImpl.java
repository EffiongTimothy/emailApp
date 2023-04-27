package data.repository;


import data.models.Email;

import java.util.ArrayList;
import java.util.List;

public class EmailRepositoryImpl implements EmailRepository {
private int count;
private List<Email> emails = new ArrayList<>();
    @Override
    public Email sendEmail(Email email) {
        if (email.getId()==0){
            email.setId(generateId());
            emails.add(email);
            count++;
        }
    return email;
    }

    private int generateId() {
        return count+1;
    }

    @Override
    public Email findBYId(int id) {
        for (Email emailBody:emails) {
            if (emailBody.getId()==id)
                return emailBody;
        }
        return null;
    }

    @Override
    public Email findByEmail(String emailAddress) {
        for (Email email :emails){
            if (email.getSendEmail().equals(emailAddress))
                return email;
        }
        return null;
    }

    @Override
    public Email findByTitlle(String tittle) {
        for (Email email :emails){
            if (email.getTittle().equals(tittle))
                return email;
        }
        return null;
    }

    @Override
    public void deleteEmailById(int id) {
        for (Email emailBody:emails) {
            if (emailBody.getId()==id)
                emails.remove(emailBody);
                count--;
            break;
        }
    }

    @Override
    public void deleteEmailByTittle(String tittle) {
        for (Email emailBody:emails) {
            if (emailBody.getTittle().equals(tittle))
                emails.remove(emailBody);
                count--;
            break;
        }
    }

    @Override
    public List<Email> findAll() {
        return emails;
    }

    @Override
    public long count() {
        return emails.size();
    }
}
