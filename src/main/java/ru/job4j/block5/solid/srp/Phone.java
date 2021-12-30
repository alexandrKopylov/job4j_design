package ru.job4j.block5.solid.srp;

/**
 * Интерфейс Phone нарушает принцип SRP
 * выполнеет 2 функции call и sendSMS
 * для соблюдения принципа SRP  нужно
 * разделить на два интерфейса
 */

public interface Phone {
    void call();

    void sendSMS();
}
