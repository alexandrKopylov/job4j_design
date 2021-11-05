package ru.job4j.bloc1.generics;

import java.lang.reflect.ParameterizedType;
import java.util.*;

public class GenericUsage {

    public void printRsl(Collection<?> col) {
        for (Iterator<?> it = col.iterator(); it.hasNext();) {
            Object next = it.next();
            System.out.println(next);
        }
    }

    public void printInfo(Collection<? extends Person> col) {
        for (Iterator<? extends Person> it = col.iterator(); it.hasNext();) {
            Person next = it.next();
            System.out.println(next);
        }
    }

    public void addAll(List<? super Integer> list) {
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
        for (Object o : list) {
            System.out.println("Текущий элемент: " + o);
        }
    }



    public static void main(String[] args) {





        ArrayList<Float> listOfNumbers = new FloatList();

        Class actual = listOfNumbers.getClass();
        ParameterizedType type = (ParameterizedType) actual.getGenericSuperclass();
        System.out.println(type);
        Class parameter = (Class) type.getActualTypeArguments()[0];
        System.out.println(parameter);


    }
}


 class Person {
    private String name;

    private int age;

    private Date birthday;

    public Person(String name, int age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

     @Override
     public boolean equals(Object o) {
         if (this == o) {
             return true;

         }
         if (o == null || getClass() != o.getClass()) {
             return false;
         }
         Person person = (Person) o;
         return age == person.age
                 && Objects.equals(name, person.name)
                 && Objects.equals(birthday, person.birthday);
     }

     @Override
     public int hashCode() {
         return Objects.hash(name, age, birthday);
     }

     @Override
     public String toString() {
         return "Person{"
                 + "name='" + name + '\''
                 + ", age=" + age
                 + ", birthday=" + birthday
                 + '}';
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public int getAge() {
         return age;
     }

     public void setAge(int age) {
         this.age = age;
     }

     public Date getBirthday() {
         return birthday;
     }

     public void setBirthday(Date birthday) {
         this.birthday = birthday;
     }

}



class Programmer extends Person {
    public Programmer(String name, int age, Date birthday) {
        super(name, age, birthday);
    }
}

class GenericsClass<K, V> {
    private K key;
    private V value;

    public GenericsClass(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "GenericsClass{"
                +  "key=" + key
                +  ", value=" + value
                +  '}';
    }
}

class FloatList extends ArrayList<Float> {
}