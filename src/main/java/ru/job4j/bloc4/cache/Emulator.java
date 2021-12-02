package ru.job4j.bloc4.cache;

import java.io.IOException;

public class Emulator {
    public static void main(String[] args) throws IOException {
        DirFileCache dirFileCache = new DirFileCache(
                "src\\main\\java\\ru\\job4j\\bloc4\\cache");

        System.out.println(dirFileCache.load("Address.txt"));
        System.out.println(dirFileCache.load("Address.txt"));
        System.out.println(dirFileCache.load("Names.txt"));
        System.out.println(dirFileCache.load("Names.txt"));
    }
}
