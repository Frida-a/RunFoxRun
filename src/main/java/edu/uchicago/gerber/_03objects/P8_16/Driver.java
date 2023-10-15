package edu.uchicago.gerber._03objects.P8_16;

public class Driver {
    public static void main(String[] args) {
        Message message1 = new Message("bbb@example.com", "rrrr@example.com");
        message1.append("Hi there!");
        message1.append("How are you?");
        System.out.println(message1);

        Mailbox mailbox = new Mailbox();
        mailbox.addMessage(message1);

        Message message2 = new Message("aaaa@example.com", "rrrr@example.com");
        message2.append("Hello!");
        mailbox.addMessage(message2);

        Message retrievedMessage = mailbox.getMessage(0);
        System.out.println(retrievedMessage);

        mailbox.removeMessage(0);
        retrievedMessage = mailbox.getMessage(0);
        System.out.println(retrievedMessage);
    }
}
