import java.sql.Array;
import java.util.Arrays;

public class MyQueue {
    private Object[] elements;
    private int size;
    public MyQueue() {
        elements = new Object[10];
        size = 0;
    }
    public void add(Object value) {
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
    public Object peek(){
        return elements[0];
    }
    public Object pull(){
        Object a=elements[0];
        size--;
        for (int i=0;i<size;i++) {
            elements[i] = elements[i + 1];
        }

        return a;
        }


}

