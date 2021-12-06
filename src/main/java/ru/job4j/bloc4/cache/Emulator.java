package ru.job4j.bloc4.cache;

import java.io.IOException;

public class Emulator {

    private DirFileCache dirFileCache;

    public void setCacheDirectory(String directory) {
        dirFileCache = new DirFileCache(directory);
    }

    public void loadCache(String fileName) throws IOException {
        dirFileCache.load(fileName);
    }

    public String getCache(String fileName) throws IOException {
        return dirFileCache.get(fileName);
    }

    public static void main(String[] args) throws IOException {
        Emulator emulator = new Emulator();
        emulator.setCacheDirectory("src\\main\\java\\ru\\job4j\\bloc4\\cache");
        emulator.loadCache("Names.txt");
        System.out.println(emulator.getCache("Names.txt"));
    }
}


