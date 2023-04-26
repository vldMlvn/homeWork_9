import java.sql.Array;
import java.util.Arrays;

public class MyQueue<E> {
    private E[] elements;
    private int size;
    public MyQueue() {
        elements =(E[]) new Object[10];
        size = 0;
    }
    public void add(E value) {
        if (size == elements.length) {
            E [] newElements =(E[]) new Object[elements.length * 2];
            for (int i = 0; i < elements.length; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
        elements[size]=value;
        size++;
    }
    public void clear(){
        for(int i=0;i<size;i++){
            elements[i]=null;
        }
        size=0;
    }
    public int size(){
        return size;
    }
    public E peek(){
        return elements[0];
    }
    public E pull(){
        E a=elements[0];
        size--;
        for (int i=0;i<size;i++) {
            elements[i] = elements[i + 1];
        }
        return a;
        }
}

