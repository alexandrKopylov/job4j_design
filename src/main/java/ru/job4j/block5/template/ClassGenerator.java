package ru.job4j.block5.template;

import java.util.*;

public class ClassGenerator implements Generator {
    @Override
    public String produce(String template, Map<String, String> args) {
        Set<String> setKeys = new HashSet<>();
        int k = 0;
        while (true) {
            int i = template.indexOf("${", k);
            if (i > 0) {
                int j = template.indexOf('}', i);
                setKeys.add(template.substring(i + 2, j));
                k = j;
            } else {
                break;
            }
        }
        if (setKeys.size() != args.size()) {
            throw new IllegalArgumentException("Keys in template, not equals keys in map");
        }
        for (String str : setKeys) {
            if (!args.containsKey(str)) {
                throw new IllegalArgumentException("Keys in template, not contains in map");
            }
        }
        return template.replace("${name}", args.get("name")).replace("${subject}", args.get("subject"));
    }
}
