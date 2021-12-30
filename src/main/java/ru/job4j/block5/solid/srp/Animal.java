package ru.job4j.block5.solid.srp;

/**
 * В соответствии с принципом единственной ответственности класс
 * должен решать лишь какую-то одну задачу. Класс Animal же решает две,
 * 1) saveAnimal - метод для сохранения животного
 * 2) feedAnimal - метод кормления животного
 */
public class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    void getAnimalName() {
    }

    void feedAnimal(Animal animal) {
    }
}
