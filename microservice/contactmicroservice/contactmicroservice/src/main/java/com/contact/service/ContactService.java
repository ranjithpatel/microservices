package com.contact.service;

import com.contact.entity.Contact;

import java.util.List;
import java.util.Locale;

public interface ContactService {

    public List<Contact> getContactsOfUser(Long userid);
}
