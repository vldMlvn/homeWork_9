import java.util.Arrays;

public class MyArrayList<E> {
    private E [] elements;
    private int size;
    public MyArrayList() {
        elements =(E[]) new Object[10];
        size=0;
    }
    public void add(E value) {
        if (size == elements.length) {
            E [] newElements =(E[]) new Object[elements.length * 2];
            for (int i = 0; i < elements.length; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
        elements[size] = value;
        size++;
    }
    public void remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        elements[index] =elements[size-1];
        size--;
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
    public E get(int index){
        if(index>=size){
            throw new IndexOutOfBoundsException();
        }
        return elements[index];
    }
    public void printer(){
        System.out.println(Arrays.toString(Arrays.copyOf(elements,size)));
    }
}
