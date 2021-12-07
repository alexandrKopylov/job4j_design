package ru.job4j.bloc4.reference;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class SoftDemo {

    public static void main(String[] args) throws InterruptedException {
        example1();
        example2();
    }

    private static void example1() {
        Object strong = new Object();
        SoftReference<Object> soft = new SoftReference<>(strong);
        strong = soft.get();
        if (strong != null) {
            System.out.println(strong);
        }
    }

    private static void example2() throws InterruptedException {

        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        List<SoftReference<Object>> objects = new ArrayList<>();
        for (int j = 0; j < 60; j++) {
            for (int i = 0; i < 1_000_000; i++) {
                objects.add(new SoftReference<Object>(new Object() {
                    String value = String.valueOf(System.currentTimeMillis());
                    @Override
                    protected void finalize() throws Throwable {
                        System.out.println("Object removed!");
                    }
                }));
            }
            System.out.println(" milion " + (j + 1));
            TimeUnit.SECONDS.sleep(5);
        }
        System.out.println("*****");
        System.gc();
        int liveObject = 0;
        for (SoftReference<Object> ref : objects) {
            Object object = ref.get();
            if (object != null) {
                liveObject++;
            }
        }
        System.out.println(liveObject);
    }
}