package ru.job4j.list;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());

            }
        }
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
    }
}
