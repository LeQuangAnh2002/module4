package com.example.service;

import com.example.model.MailBox;

import java.util.List;

public interface MailBoxService {
     List<MailBox> listMailBox();
     MailBox findByID(String id);
     void update(MailBox mailBox);

}
