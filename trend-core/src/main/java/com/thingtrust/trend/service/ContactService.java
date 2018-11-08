package com.thingtrust.trend.service;

import com.thingtrust.trend.data.ContactRepository;
import com.thingtrust.trend.domain.Contact;
import com.thingtrust.trend.domain.example.ContactExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public void insertContact(final Contact contact) {
        contactRepository.insert(contact);
    }

    public void updateContact(final Contact contact) {
        contactRepository.updateById(contact);

    }

    public void delete(final int id) {
        contactRepository.deleteById(id);
    }

    public List<Contact> showAll() {
        final ContactExample contactExample = new ContactExample();
        contactExample.setOrderByClause("sort");
        return contactRepository.selectByExample(null);
    }

    public List<Contact> showOne(final int status) {
        final ContactExample contactExample = new ContactExample();
        contactExample
                .createCriteria()
                .andStatusEqualTo(status);
        contactExample.setOrderByClause("sort");
        return contactRepository.selectByExample(contactExample);
    }
}
