package com.faisaljarkass.demo.repositories;

import com.faisaljarkass.demo.domains.Message;

import java.util.ArrayList;

public interface MessageRepository{

    public void addMessage(Message message);

    public ArrayList<Message> getMessages();
}
