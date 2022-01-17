package ru.job4j.block5.solid.lsp.kontrakt;

/**
 * 1 )  Предусловия (Preconditions) не могут быть усилены в подклассе
 * <p>
 * Предусловие - это условие, которое проверяет корректность аргументов конструктора или метода.
 * Допустим у нас есть класс автотранспорта. Пусть теперь есть наследник - автобус.
 * Предположим ему нужно больше топлива, чтобы сдвинуться с места
 */
class AutoTransport {
    protected float fuel;

    public AutoTransport(float fuel) {
        this.fuel = fuel;
    }

    public void move(float km) {
        if (km < 0) {
            throw new IllegalArgumentException("Invalid distance!");
        }

        /**
         *   предусловие
         */
        if (fuel < 0) {
            throw new IllegalArgumentException("Need more fuel!");
        }
        System.out.println("transport move");
    }
}


class Bus extends AutoTransport {
    public Bus(float fuel) {
        super(fuel);
    }

    public void move(float km) {
        if (km < 0) {
            throw new IllegalArgumentException("Invalid distance!");
        }

        /**
         *  условие усилено
         */
        if (fuel < 5) {
            throw new IllegalArgumentException("Need more fuel!");
        }
        System.out.println("Bus move");
    }
}

/**
 * От AutoTransport мы ожидаем, что машина сдвинется, но нет. Автобус не сдвигается, т.к. в нем усилено предусловие.
 * Ожидаем мы одно поведение, а получаем другое.
 * Чтобы сдвинуть автобус нам придется дописать доп. условие, чтобы проверить является ли транспорт автобусом.
 * Далее уже скормить ему больше топлива.
 */
public class FirstRule {
    public static void main(String[] args) {
        AutoTransport bus = new Bus(3);
        bus.move(2);
    }
}