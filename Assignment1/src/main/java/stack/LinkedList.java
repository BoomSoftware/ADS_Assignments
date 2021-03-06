package stack;

import exceptions.EmptyListException;
import interfaces.List;

public class LinkedList<T> implements List<T> {

    private Node<T> head;
    private int size;

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void addToFront(T data) {

    }

    @Override
    public T removeFirst() throws EmptyListException {
        return null;
    }
}
