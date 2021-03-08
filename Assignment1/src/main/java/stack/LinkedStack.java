package stack;

import interfaces.Stack;

public class LinkedStack<T> implements Stack<T> {

    private final LinkedList<T> list;

    public LinkedStack() {
        list = new LinkedList<>();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(T element) {
        list.addToFront(element);
    }

    @Override
    public T pop() throws Exception {
        if(list.isEmpty()) {
            throw new Exception("Error: Stack is empty!");
        }
        return list.removeFirst();
    }
}
