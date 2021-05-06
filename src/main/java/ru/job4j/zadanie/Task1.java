package ru.job4j.zadanie;


import java.util.*;

/**
 * Требуется написать работающий код, решающий задачу, и приложить
 * инструкцию, как код собрать и запустить.
 * Также надо написать unittest-ы.
 * Задачу реализовать на Java (достаточно как консольное JAVA приложение).
 * Код выложить на любой репозиторий (GitHub, GitLab, Butbucket)
 * <p>
 * Имеется n пользователей, каждому из них соответствует список email-ов
 * (всего у всех пользователей m email-ов).
 * Например:
 * user1 ->xxx@ya.ru,foo@gmail.com,lol@mail.ru
 * user2 ->foo@gmail.com,ups@pisem.net
 * user3 ->xyz@pisem.net,vasya@pupkin.com
 * user4 ->ups@pisem.net,aaa@bbb.ru
 * user5 ->xyz@pisem.net
 * <p>
 * Считается, что если у двух пользователей есть общий email, значит это
 * один и тот же пользователь. Требуется построить
 * и реализовать алгоритм, выполняющий слияние пользователей. На выходе
 * должен быть список пользователей с их email-ами (такой же как на
 * входе).
 * В качестве имени объединенного пользователя можно брать любое из
 * исходных имен. Список email-ов пользователя должен содержать только
 * уникальные email-ы.
 * Параметры n и m произвольные, длина конкретного списка email-ов никак
 * не ограничена.
 * Требуется, чтобы асимптотическое время работы полученного решения было
 * линейным, или близким к линейному.
 */

//public Map<String, Set<String>> merge(Map<String, Set<String>> data)

public class Task1 {

    public static List<Set<String>> mergeUsers(List<List<String>> listUsers) {
        List<Set<String>> listSet = new ArrayList<>();
        for (int i = 0; i < listUsers.size(); i++) {
            List<String> result = listUsers.get(i);
            for (int j = 0; j < result.size(); j++) {
                String stroka = result.get(j);
                searchDublicateEmail(i, listUsers, stroka);
            }
            listSet.addAll(Collections.singleton(new HashSet<>(listUsers.get(i))));
        }
        return listSet;
    }

    private static void searchDublicateEmail(int currentList, List<List<String>> listUsers, String email) {
        for (int i = currentList + 1; i < listUsers.size(); i++) {
            if (listUsers.get(i).contains(email)) {
                listUsers.get(currentList).addAll(listUsers.get(i));
                listUsers.remove(i);
            }
        }
    }





}
