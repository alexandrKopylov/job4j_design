package ru.job4j.map.Metods;

import java.util.*;

public class Merge4 {

    Map<String, String> emailMap = new HashMap<>();

    Map<String, Set<String>> merge(Map<String, Set<String>> map) {
        String foundUser = null;

        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            Set<String> stringSet = entry.getValue();
            String kk = entry.getKey();

            for (String mail : stringSet) {
                if (emailMap.get(mail) != null) {
                    foundUser = emailMap.get(mail);
                    break;
                }
            }

            if (foundUser != null) {
                for (String email : stringSet) {
                    emailMap.put(email, foundUser);
                }
            } else {
                for (String email : stringSet) {
                    emailMap.put(email, kk);
                }
            }
            foundUser = null;
        }
        return getUsersEmails();
    }

    public Map<String, Set<String>> getUsersEmails() {
        Map<String, Set<String>> resultMap = new HashMap<>();
        for (Map.Entry<String, String> entry : emailMap.entrySet()) {
            if (resultMap.get(entry.getValue()) == null) {
                Set<String> emails = new HashSet<>();
                emails.add(entry.getKey());
                resultMap.put(entry.getValue(), emails);
            } else {
                Set<String> emails = resultMap.get(entry.getValue());
                emails.add(entry.getKey());
                resultMap.put(entry.getValue(), emails);
            }
        }
        return resultMap;
    }

}
