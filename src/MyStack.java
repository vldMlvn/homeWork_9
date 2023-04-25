import java.util.Arrays;

public class MyStack {
    private Object[] elements;
    private int size;
    public MyStack() {
        elements = new Object[10];
        size = 0;
    }
    public void push(Object value) {
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
    public Object peek(){
        return elements[size-1];
    }
    public Object pop(){
        Object a=elements[size-1];
        size--;

        return a;
    }


}
