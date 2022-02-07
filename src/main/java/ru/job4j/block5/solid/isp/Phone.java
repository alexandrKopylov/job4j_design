package ru.job4j.block5.solid.isp;

/**
 * Интерфейс Phone нарушает принцип ISP
 * выполнеет 2 функции call и sendSMS
 * для соблюдения принципа ISP  нужно
 * разделить на два интерфейса
 */

public interface Phone {
    void call();
    void sendSMS();
}
