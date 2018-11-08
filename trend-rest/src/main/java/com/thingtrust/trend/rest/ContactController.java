package com.thingtrust.trend.rest;

import com.thingtrust.trend.common.model.ResponseResult;
import com.thingtrust.trend.domain.Contact;
import com.thingtrust.trend.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/contact")
@Slf4j
public class ContactController {
    @Autowired
    private ContactService contactService;

    @PostMapping("/add-contact")
    public ResponseResult addContact(final Contact contact) {
        contactService.insertContact(contact);
        return ResponseResult.success();
    }

    @PostMapping("/update-contact")
    public ResponseResult updateContact(final Contact contact) {
        contactService.updateContact(contact);
        return ResponseResult.success();
    }

    @GetMapping("/show-all")
    public ResponseResult showAll() {
        final List<Contact> contactList = contactService.showAll();
        return ResponseResult.success(contactList);
    }


    @GetMapping("/show-one")
    public ResponseResult showOne(final int status) {
        final List<Contact> aboutList = contactService.showOne(status);
        return ResponseResult.success(aboutList);
    }

    @PostMapping("/remove")
    public ResponseResult remove(final int id) {
        contactService.delete(id);
        return ResponseResult.success();
    }
}
