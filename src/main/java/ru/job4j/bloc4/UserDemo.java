package ru.job4j.bloc4;

public class UserDemo {
    private static final long KB = 1024;
    private static final long MB = KB * KB;
    private static final Runtime ENVIRONMENT = Runtime.getRuntime();

    public static void info() {
        final long freeMemory = ENVIRONMENT.freeMemory();
        final long totalMemory = ENVIRONMENT.totalMemory();
        final long maxMemory = ENVIRONMENT.maxMemory();
        System.out.println("======= Environment state =======");
        System.out.printf("Free: %d%n", freeMemory / MB);
        System.out.printf("Total: %d%n", totalMemory / MB);
        System.out.printf("Max: %d%n", maxMemory / MB);
    }


    public static void main(String[] args) {
        User userIvanov = new User(1, 20, "Sasha", "Sasha");
        User userPetrov = new User(2, 25, "Misha", "Misha");
        userIvanov = null;
        userPetrov = null;
        System.gc();
        info();
    }
}