public class Main {
    public static void main(String[] args) {
        MyArrayList<String> myArrayList = new MyArrayList<>(5);
        myArrayList.add("a");
        myArrayList.add("b");
        myArrayList.add("e");
        System.out.println(myArrayList);

        myArrayList.set(2, "c");
        System.out.println(myArrayList);

        myArrayList.add("f");
        myArrayList.remove(3);
        System.out.println(myArrayList);

        myArrayList.remove("b");
        System.out.println(myArrayList);

        myArrayList.insert(1, "b");
        System.out.println(myArrayList);

        System.out.println(myArrayList.isEmpty());
        System.out.println(myArrayList.contains("a"));
        System.out.println(myArrayList.get(1));
        System.out.println(myArrayList.size());

        myArrayList.insert(0,"d");
        System.out.println(myArrayList);

        myArrayList.bubbleSort();
        System.out.println(myArrayList);

        for(String s : myArrayList){
            System.out.println(s);
        }

        myArrayList.clear();
        System.out.println(myArrayList);
    }
}