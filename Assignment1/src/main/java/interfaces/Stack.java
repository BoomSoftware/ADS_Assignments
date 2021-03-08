package interfaces;

public interface Stack<T> {
    boolean isEmpty();
    void push(T element);
    T pop() throws Exception;
}
