package com.example.service;

import com.example.model.MailBox;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class MailBoxServiceImpl implements MailBoxService{
    private static Map<String,MailBox> mailBoxMap;

    static {
        mailBoxMap = new HashMap<>();
        mailBoxMap.put("1", new MailBox("1", "Vietnamese ", "25", " ", "Thor King"));
        mailBoxMap.put("2", new MailBox("2", "English", "5", " ", "Thor King"));
        mailBoxMap.put("3", new MailBox("3", "Japanese", "15", " ", "Bar King"));
        mailBoxMap.put("4", new MailBox("4", "Chinese", "50", " ", "ken King"));
    }
    @Override
    public List<MailBox> listMailBox() {
        return new ArrayList<>(mailBoxMap.values());
    }

    @Override
    public MailBox findByID(String id) {
        return mailBoxMap.get(id);
    }

    @Override
    public void update(MailBox mailBox) {
        if (mailBoxMap.containsKey(mailBox.getId())) {
            mailBoxMap.put(mailBox.getId(), mailBox);
        }
    }
}
