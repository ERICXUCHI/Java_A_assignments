package ASSIGNMENT5;

public class MyArrayList<T> {
    private static final int capacity = 20;
    private int size = 0;
    private T[] listT = (T[]) new Object[20];


    public MyArrayList(){

    }
    public void add(T t){
        if (size < capacity){
            listT[size] = t;
            size++;
        }
    }

    public void add(T t, int index){
        if (index <= 0 || index > size){

        }
        if (size < capacity){
            size++;
            for (int i = size-1; i > index; i--){
                listT[i] = listT[i - 1];
            }
            listT[index] = t;
            }
        }

    public boolean isEmpty(){
        boolean IsEmpty = false;
        if (size == 0){
           IsEmpty = true;
        }
        return IsEmpty;
    }

    public int size(){
        return size;
    }

    public T get(int index){
        if (index <= 0 || index > size){

        }
        return listT[index];
    }
}

