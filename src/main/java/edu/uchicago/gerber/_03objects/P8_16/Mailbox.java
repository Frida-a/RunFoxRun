package edu.uchicago.gerber._03objects.P8_16;

import java.util.ArrayList;
import java.util.List;

public class Mailbox {
    private List<Message> messages;

    public Mailbox() {
        this.messages = new ArrayList<>();
    }

    public void addMessage(Message m) {
        messages.add(m);
    }

    public Message getMessage(int i) {
        if (i >= 0 && i < messages.size()) {
            return messages.get(i);
        }
        return null; // or throw an exception to indicate invalid index
    }

    public void removeMessage(int i) {
        if (i >= 0 && i < messages.size()) {
            messages.remove(i);
        }
    }
}

