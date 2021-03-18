package Stack;

import Exceptions.EmptyListException;
import Interfaces.List;

public class LinkedList<T> implements List<T> {

    private Node<T> head;
    private int size;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;

    }

    @Override
    public void addToFront(T data) {
        Node<T> newNode = new Node<T>();
        newNode.setData(data);

        newNode.setNext(head);
        head = newNode;
        size++;
    }

    @Override
    public T removeFirst() throws EmptyListException {
        if(isEmpty()){
            throw new EmptyListException("Error: List is empty!");
        }

        Node<T> oldHead = head;
        head = head.getNext();
        size--;
        return oldHead.getData();
    }
}
