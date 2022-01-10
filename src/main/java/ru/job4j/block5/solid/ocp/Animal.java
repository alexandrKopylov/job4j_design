package ru.job4j.block5.solid.ocp;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    /**
     * функция определяет то, какой звук издаёт то или иное животное, анализируя конкретные объекты.
     * @param animals
     * @return
     *
     * Функция AnimalSound не соответствует принципу OCP,
     * так как, например, при появлении новых видов животных, нам, для того,
     * чтобы с её помощью можно было бы узнавать звуки, издаваемые ими, придётся её изменить.
     */
    public String animalSound(List<Animal> animals) {
        String str = null;
        for (Animal a : animals) {
            if (a.name.equals("lion")) {
                str = "roar";
            } else if (a.name.equals("mouse")) {
                str = "squeak";
            }
        }
     return str;
    }
}