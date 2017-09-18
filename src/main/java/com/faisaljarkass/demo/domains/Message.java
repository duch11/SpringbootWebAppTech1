package com.faisaljarkass.demo.domains;

import java.io.Serializable;
import java.util.ArrayList;

public class Message implements Serializable {
    String title;
    String text;

    public Message(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public Message() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
