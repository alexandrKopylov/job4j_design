package ru.job4j.bloc4.cache;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) throws IOException {
        String value = get(key);
        if (value == null) {
            value = new String(Files.readAllBytes(Paths.get(cachingDir + "//" + key)));
            put(key, value);
        }
        return value;
    }
}