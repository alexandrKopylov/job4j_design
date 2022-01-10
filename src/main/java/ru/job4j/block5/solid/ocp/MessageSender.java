package ru.job4j.block5.solid.ocp;

/**
 * здесь нарушен OCP принцип,
 * т.к. при изменении способов отправки уведомлений
 * придется менять существующий код
 */

public class MessageSender {
    public void send(String msg, MessageType type) {
        if (type == MessageType.SMS) {
            sendSMS(msg);
        } else if (type == MessageType.EMAIL) {
            sendEMAIL(msg);
        }
    }

    private void sendEMAIL(String msg) {
        System.out.println("sendEMAIL :" + msg);
    }

    private void sendSMS(String msg) {
        System.out.println("sendSMS :" + msg);
    }
}

 enum MessageType {
    SMS, EMAIL
 }