import java.util.Arrays;

public class MyStack<E> {
    private E[] elements;
    private int size;
    public MyStack() {
        elements =(E[]) new Object[10];
        size = 0;
    }
    public void push(E value) {
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
    public void remove(int index){
        if(index>=size){
            throw new IndexOutOfBoundsException();
        }
        elements[index]=null;
        size --;
        for (int i=index;i<elements.length-1;i++)
            elements[i]=elements[i+1];
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
        return elements[size-1];
    }
    public E pop(){
        E a=elements[size-1];
        size--;
        return a;
    }


}
