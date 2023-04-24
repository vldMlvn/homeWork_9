import java.util.Arrays;

public class MyArrayList {




    private Object[] elements;
    private int size;
    public MyArrayList() {
        elements = new Object[10];
        size=0;
    }
    public void add(Object value) {
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
    public Object get(int index){
        return elements[index];
    }
    public void print(){
        System.out.println(Arrays.toString(Arrays.copyOf(elements,size)));
    }
}
