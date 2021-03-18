package Stack;

import Exceptions.EmptyListException;
import Exceptions.EmptyStackException;
import Interfaces.Stack;

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
    public T pop() throws EmptyStackException {
        try {
            return list.removeFirst();
        }
        catch (EmptyListException e){
            throw new EmptyStackException("Error: Stack is empty!");
        }
    }
}
