package com.faisaljarkass.demo.repositories;

import com.faisaljarkass.demo.domains.Message;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MessageRepositoryImpl implements MessageRepository {
    private ArrayList<Message> messages;

    public MessageRepositoryImpl() {
        this.messages = new ArrayList<Message>();
    }

    @Override
    public void addMessage(Message message) {
        messages.add(message);
    }

    @Override
    public ArrayList<Message> getMessages() {
        return messages;
    }
}
