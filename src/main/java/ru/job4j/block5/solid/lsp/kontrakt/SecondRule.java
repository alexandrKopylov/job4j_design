package ru.job4j.block5.solid.lsp.kontrakt;

import java.time.LocalDate;
import java.time.Month;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * 2. Постусловия (Postconditions) не могут быть ослаблены в подклассе.
 *
 * Постусловие - это условие, налагаемое на возвращаемое значение метода.
 *
 * Рассмотрим такой пример. Пусть есть бухгалтерия, которая считает по табелю сколько работник отработал
 * и если он отработал норму, то высчитывает для него зарплату. Далее мы наследуемся допустим для бухгалтерии магазина.
 * В нем мы забываем про условие когда добавляем специфическое поведение
 * и когда запускаем пример, то получаем, что недобросовестный работник получает зарплату.
 */

class WorkDays implements Iterable<Integer> {

    private Map<LocalDate, Integer> workDays = new LinkedHashMap<>();

    public void add(LocalDate date, int hours) {
        workDays.put(date, hours);
    }

    @Override
    public Iterator<Integer> iterator() {
        return workDays.values().iterator();
    }
}

class CountingRoom {
    protected int normHours;
    protected int payPerHour;

    public CountingRoom(int normHours, int payPerHour) {
        this.normHours = normHours;
        this.payPerHour = payPerHour;
    }

    public int pay(WorkDays workDays) {
        int factHours = 0;
        for (Integer hoursPerDay : workDays) {
            factHours += hoursPerDay;
        }
        if (factHours < normHours) {
            throw new IllegalArgumentException("Worker didn't work enough!");
        }
        return factHours * payPerHour;
    }
}

class ShopCountingRoom extends CountingRoom {
    public ShopCountingRoom(int normHours, int payPerHour) {
        super(normHours, payPerHour);
    }

    @Override
    public int pay(WorkDays workDays) {
        int factHours = 0;
        for (Integer hoursPerDay : workDays) {
            factHours += hoursPerDay;
        }

        /**
         * здесь нарушелн LSP
         * в родительском классе есть условие
         * а в подклассе его нет
         *        if (factHours < normHours) {
         *             throw new IllegalArgumentException("Worker didn't work enough!");
         *         }
         */
        return factHours * payPerHour;
    }
}

public class SecondRule {
    public static void main(String[] args) {
/**
 * Правила 1-2 не распространяются на приватные поля, т.е. когда вы проверяете специфичные только для объекта поля,
 * то вы не нарушаете эти правила. Принцип Лисков контролирует отношения между классами при наследовании.
 */
        WorkDays workDays = new WorkDays();
        workDays.add(LocalDate.of(2020, Month.DECEMBER, 1), 8);
        workDays.add(LocalDate.of(2020, Month.DECEMBER, 2), 6);
        workDays.add(LocalDate.of(2020, Month.DECEMBER, 3), 7);

        CountingRoom countingRoom = new ShopCountingRoom(3 * 8, 500);
        System.out.println(countingRoom.pay(workDays));
    }
}