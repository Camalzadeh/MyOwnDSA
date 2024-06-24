import java.util.Iterator;
import java.util.function.Consumer;

public class MyLinkedList<T> implements Iterable<T>,MyList<T> {
    static class Node<T> {
        Node(T data, Node<T> next, Node<T> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
        T data;
        Node<T> next;
        Node<T> prev;
    }
    int size;
    Node<T> head;
    Node<T> tail;

    private void add(boolean isHead, T data) {
        Node<T> newNode = new Node<T>(data, null, null);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            if(isHead){
                newNode.next = head;
                head.prev = newNode;
                head = newNode;

            }else{
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }

        }
        size++;
    }

    private void checkIndex(int index) {
        if(index<0) {
            throw new IllegalArgumentException("Index cannot be negative");
        }
        if(index>=size){
            throw new IllegalArgumentException("Index out of bounds");
        }
    }

    private Node<T> findElement(int index) {
        if(index<size/2){
            Node<T> temp = head;
            for(int i=0;i<index;i++){
                temp = temp.next;
            }
            return temp;
        }else{
            Node<T> temp = tail;
            for(int i=size-1;i>index;i--){
                temp = temp.prev;
            }
            return temp;
        }
    }

    private Node<T> findElement(T data) {
        Node<T> temp = head;
        while(temp!=null){
            if(temp.data.equals(data)){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public  void addFirst(T data) {
        add(true, data);
    }

    public  void addLast(T data) {
        add(false, data);
    }

    public void removeFirst(){
        head = head.next;
        size--;
    }

    public void removeLast(){
        tail = tail.prev;
        size--;
    }

    public int size() {
        return size;
    }

    public T get(int index){
        checkIndex(index);
        return findElement(index).data;
    }

    public void set(int index, T data){
        checkIndex(index);
        findElement(index).data = data;
    }

    public boolean remove(int index){
        checkIndex(index);
        if (index == 0) {
            removeFirst();
            return true;
        }
        if (index == size - 1) {
            removeLast();
            return true;
        }
        Node<T> temp = findElement(index);
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        size--;
        return true;
    }

    public boolean remove(T data){
        Node<T> temp = findElement(data);
        if(temp != null){
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            size--;
            return true;
        }
        return false;
    }

    public void insert(int index, T data){
        checkIndex(index);
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size - 1) {
            addLast(data);
            return;
        }
        Node<T> temp = findElement(index);
        Node<T> newNode = new Node<T>(data, temp, temp.prev);
        temp.prev.next = newNode;
        temp.prev = newNode;
        size++;
    }

    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }

    public boolean contains(T data){
        return findElement(data) != null;
    }

    public int indexOf(T data){
        Node<T> temp = head;
        for(int i=0;i<size;i++){
            if(temp.data.equals(data)){
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void add(T data) {
        add(false, data);
    }

    public void bubbleSort(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(findElement(i).data.toString().compareTo(findElement(j).data.toString())<0){
                    T temp = findElement(i).data;
                    findElement(i).data = findElement(j).data;
                    findElement(j).data = temp;
                }
            }
        }
    }

    public void reverse(){
        Node<T> temp = head;
        Node<T> temp2 = tail;
        for(int i=0;i<size/2;i++){
            T temp3 = temp.data;
            temp.data = temp2.data;
            temp2.data = temp3;
            temp = temp.next;
            temp2 = temp2.prev;
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node<T> temp = head;
        for(int i=0;i<size;i++){
            sb.append(temp.data.toString());
            sb.append(" ");
            temp = temp.next;
        }
        return sb.toString();
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
            return (T) get(index++);
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
