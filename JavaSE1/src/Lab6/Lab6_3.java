package Lab6;

import java.util.*;

public class Lab6_3 {
    public static void main(String[] args) {
        // TreeMap内部是一个红黑树
        // HashMap内部是一个数组+链表的结构
        Lab6_3 ll = new Lab6_3();
        ll.hashMap();
        ll.getHashMap();

        System.out.println();
        ll.treeMap();
        ll.getTreeMap();
    }

    Map<String, Integer> hash = new HashMap<String, Integer>();
    Map<String, Integer> tree = new TreeMap<String, Integer>();

    public void hashMap() {
        Scanner sc = new Scanner(System.in);
        int index = 0;
        while (hash.size() <= 10) {
            String word = sc.nextLine();
            hash.put(word, index + 1);
            index++;
        }
    }

    public void getHashMap() {
        for (Map.Entry<String, Integer> entry : hash.entrySet()) {
            System.out.println("word " + entry.getKey());
        }
    }

    public void treeMap() {
        Scanner sc = new Scanner(System.in);
        int index = 0;
        while (tree.size() <= 10) {
            String word = sc.nextLine();
            tree.put(word, index + 1);
            index++;
        }
    }

    public void getTreeMap() {
        for (Map.Entry<String, Integer> entry : tree.entrySet()) {
            System.out.println("word: " + entry.getKey());
        }

    }
}
