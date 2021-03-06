package stack;

import interfaces.Stack;

import java.util.EmptyStackException;

public class LinkedStack<T> implements Stack<T> {

    private LinkedList<T> list;

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void push(Object element) {

    }

    @Override
    public T pop() throws EmptyStackException {
        return null;
    }
}
