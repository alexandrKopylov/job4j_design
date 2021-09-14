package ru.job4j.bloc1.tree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.function.Predicate;

class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;
    int size;

    Tree(final E root) {
        this.root = new Node<>(root);
        size = 1;
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional<Node<E>> optionalParent = findBy(parent);
        Optional<Node<E>> optionalChild = findBy(child);
        if (optionalParent.isPresent() && !optionalChild.isPresent()) {
            Node<E> el = optionalParent.get();
            el.children.add(new Node<>(child));
            size++;
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        return findByPredicate(el -> el.value.equals(value));
    }

    public boolean isBinary() {
        return findByPredicate(el -> (el.children.size() > 2)).isEmpty();
    }

    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (condition.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }

}