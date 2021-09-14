package ru.job4j.bloc1.map.metods;
import java.util.*;

public class Merge4 {
    Map<String, String> emailMap = new HashMap<>();

    Map<String, Set<String>> merge(Map<String, Set<String>> map) {
        String foundUser = null;

        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            Set<String> stringSet = entry.getValue();
            String userInput = entry.getKey();
            foundUser = userInput;

            for (String mail : stringSet) {
                if (emailMap.get(mail) != null) {
                    foundUser = emailMap.get(mail);
                    break;
                }
            }

            for (String email : stringSet) {
                emailMap.put(email, foundUser);
            }

            foundUser = null;
        }
        return getUsersEmails();
    }

    public Map<String, Set<String>> getUsersEmails() {
        Map<String, Set<String>> resultMap = new HashMap<>();
        Set<String> emails;

        for (Map.Entry<String, String> entry : emailMap.entrySet()) {
             emails = resultMap.getOrDefault(entry.getValue(),  new HashSet<>());
             emails.add(entry.getKey());
             resultMap.put(entry.getValue(), emails);
        }
        return resultMap;
    }
}