package ru.job4j.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTwo<E> extends Tree<E> {
    TreeTwo(E root) {
        super(root);
    }

    public boolean isBinary() {
        boolean rsl = true;
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.children.size() > 2) {
                rsl = false;
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}
