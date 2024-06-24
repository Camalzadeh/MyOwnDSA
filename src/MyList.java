import java.util.Iterator;

public interface MyList<T> extends Iterable<T>{
    public void addFirst(T data);
    public void addLast(T data);
    public void removeFirst();
    public void removeLast();
    public T get(int index);
    public void set(int index, T data);
    public boolean remove(T data);
    public boolean remove(int index);
    public boolean contains(T data);
    public int indexOf(T data);
    public  boolean isEmpty();
    public void add(T data);
    public int size();
    public void clear();
    public String toString();
    public void reverse();
    public void bubbleSort();
    public void insert(int index, T data);
    public Iterator<T> iterator();
}
