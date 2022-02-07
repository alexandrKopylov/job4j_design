package ru.job4j.block5.solid.isp;

/**
 * Интерфейс Worker нарушает принцип ISP
 * потому что не у всех есть обед
 */
public interface Worker {
    void work();
    void eat();
}


class Cook implements Worker {

    @Override
    public void work() {

    }

    @Override
    public void eat() {

    }
}

/**
 *  взяли на работу официантом, сткдента на 4 часа
 *  обед не предоставляется
 */
class Waiter implements Worker {

    @Override
    public void work() {

    }

    @Override
    public void eat() {
        throw new UnsupportedOperationException();
    }


}