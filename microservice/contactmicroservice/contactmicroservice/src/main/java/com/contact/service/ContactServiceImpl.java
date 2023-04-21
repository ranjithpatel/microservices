package com.contact.service;

import com.contact.entity.Contact;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ContactServiceImpl implements ContactService{

        List<Contact> contacts=List.of(
                new Contact(1,"raju","raju123@gmail.com",101l),
                new Contact(2,"rani","rani123@gmail.com",101l),
                new Contact(3,"sona","sona123@gmail.com",102l),
                new Contact(4,"mona","mona123@gmail.com",102l),
                new Contact(5,"lina","lina123@gmail.com",103l)

                );
    @Override
    public List<Contact> getContactsOfUser(Long userid) {
        return contacts.stream().filter(contact -> contact.getUserid()==userid).collect(Collectors.toList());
    }
}
