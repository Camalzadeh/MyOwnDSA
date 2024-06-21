import java.util.Iterator;
import java.util.function.Consumer;

public class MyArrayList<T> implements Iterable<T> {
    MyArrayList(int initSize){
        if(initSize<0) throw new IllegalArgumentException("Size cannot be negative");
        else arr = new Object[initSize];
    }
    MyArrayList(){
        arr= new Object[defaultSize];
    };
    private int size;
    private Object[] arr;
    private final int defaultSize=10;

    public void add(T t){
        if(arr.length==size){
            resize();
        }
        arr[size++]= t;
    }
    private void resize(){
        Object[] temp = new Object[arr.length<<1];
        for(int i=0;i<arr.length;i++){
            temp[i] = arr[i];
        }
        arr = temp;
    }

    public void remove(int index){
        if(index>=0){
            if(size>index){
                Object[] temp = new Object[size--];
                for(int i=0;i<index;i++){
                    temp[i] = arr[i];
                }
                for(int i=index;i<size;i++){
                    temp[i] = arr[i+1];
                }
                arr = temp;
            }
            else {
                throw new IllegalArgumentException("Index out of bounds");
            }
        }
        else{
            throw new IllegalArgumentException("Index cannot be negative");
        }

    }

    public boolean remove(T t){
        for(int i=0;i<size;i++){
            if(t.equals(arr[i])){
                remove(i);
                return true;
            }
        }
        return false;
    }

    public int size(){ return size; }

    public T get(int index){
        if(index>=0){
            if(size>index){
                return (T) arr[index];
            }
            else {
                throw new IllegalArgumentException("Index out of bounds");
            }
        }
        else{
            throw new IllegalArgumentException("Index cannot be negative");
        }
    }

    public void set(int index, T t){
        if(index>=0){
            if(size>index){
                arr[index] = t;
            }
            else {
                throw new IllegalArgumentException("Index out of bounds");
            }
        }
        else{
            throw new IllegalArgumentException("Index cannot be negative");
        }
    }

    public void clear(){
        arr = new Object[defaultSize];
        size = 0;
    }

    public T[] toArray(){
        T[] temp = (T[]) new Object[size];
        for(int i=0;i<size;i++){
            temp[i] = (T) arr[i];
        }
        return temp;
    }

    public boolean contains(T t){
        for(int i=0;i<size;i++){
            if(t.equals(arr[i])){
                return true;
            }
        }
        return false;
    }

    public String toString(){
        String temp = "";
        for(int i=0;i<size;i++){
            temp += arr[i] + " ";
        }
        return temp;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void bubbleSort(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(arr[i].toString().compareTo(arr[j].toString())<0){
                    Object temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public void insert(int index, T t){
        if(index>=0){
            if(size+1>index){
                Object[] temp = new Object[size+1];
                for(int i=0;i<index;i++){
                    temp[i] = arr[i];
                }
                temp[index] = t;
                for(int i=index;i<size;i++){
                    temp[i+1] = arr[i];
                }
                arr = temp;
                size++;
            }
            else {
                throw new IllegalArgumentException("Index out of bounds");
            }
        }
        else{
            throw new IllegalArgumentException("Index cannot be negative");
        }
    }

    public Iterator<T> iterator(){
        return new MyIterator();
    }
    private class MyIterator implements Iterator<T>{
        private int index = 0;
        @Override
        public boolean hasNext() {
            return index<size;
        }
        @Override
        public T next() {
            return (T) arr[index++];
        }
        @Override
        public void remove() {
            Iterator.super.remove();
        }
        @Override
        public void forEachRemaining(Consumer<? super T> action) {
            Iterator.super.forEachRemaining(action);
        }
    }
}
