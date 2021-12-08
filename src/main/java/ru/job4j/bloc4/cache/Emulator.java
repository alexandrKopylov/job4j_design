package ru.job4j.bloc4.cache;



public class Emulator {

    private DirFileCache dirFileCache;

    public void setCacheDirectory(String directory) {
        dirFileCache = new DirFileCache(directory);
    }

    public void loadCache(String fileName)  {
        dirFileCache.load(fileName);
    }

    public String getCache(String fileName) {
        return dirFileCache.get(fileName);
    }

    public static void main(String[] args) {
        Emulator emulator = new Emulator();
        emulator.setCacheDirectory("src\\main\\java\\ru\\job4j\\bloc4\\cache");
        emulator.loadCache("Names.txt");
        emulator.getCache("Names.txt");
        String str = emulator.getCache("Names.txt");
        System.out.println(str);
    }
}


