public class Main {
    static void implement(MyList<String> myList) {
        myList.add("a");
        myList.add("b");
        myList.add("e");
        System.out.println(myList);

        myList.set(2, "c");
        System.out.println(myList);

        myList.add("f");
        myList.remove(3);
        System.out.println(myList);

        myList.remove("b");
        System.out.println(myList);

        myList.insert(1, "b");
        System.out.println(myList);

        System.out.println(myList.isEmpty());
        System.out.println(myList.contains("a"));
        System.out.println(myList.get(1));
        System.out.println(myList.size());

        myList.insert(0,"d");
        System.out.println(myList);

        myList.bubbleSort();
        System.out.println(myList);

        for(String s : myList){
            System.out.println(s);
        }

        myList.clear();
        System.out.println(myList);
    }
    public static void main(String[] args) {
        MyArrayList<String> myList = new MyArrayList<>();
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        implement(myList);
        implement(myLinkedList);
    }
}