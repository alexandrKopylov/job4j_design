package ru.job4j.block2.io.serialization.jsonToPojo;

public class Contact {
    private final String phone;

    public String getPhone() {
        return phone;
    }

    public Contact(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contact{"
                + "phone='" + phone + '\''
                + '}';
    }
}

