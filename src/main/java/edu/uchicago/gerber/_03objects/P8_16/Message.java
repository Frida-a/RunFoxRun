package edu.uchicago.gerber._03objects.P8_16;

public class Message {
    private String sender;
    private String recipient;
    private StringBuilder messageText;

    public Message(String sender, String recipient) {
        this.sender = sender;
        this.recipient = recipient;
        this.messageText = new StringBuilder();
    }

    public void append(String line) {
        messageText.append(line).append("\n");
    }

    @Override
    public String toString() {
        return "From: " + sender + "\nTo: " + recipient + "\n" + messageText.toString();
    }
}

