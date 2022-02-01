package Lab6;

import java.util.*;

public class Lab6_2 implements Comparable<Object> {
    static TreeSet<Lab6_2> tree = new TreeSet<Lab6_2>();

    public static void main(String[] args) {
        Lab6_2 ll1 = new Lab6_2("aaa", 1);
        Lab6_2 ll2 = new Lab6_2("bbb", 2);
        Lab6_2 ll3 = new Lab6_2("ccc", 3);
        Lab6_2 ll4 = new Lab6_2("ddd", 4);
        TreeSet<Lab6_2> tree1 = new TreeSet<Lab6_2>();
        TreeSet<Lab6_2> tree2 = new TreeSet<Lab6_2>();
        TreeSet<Lab6_2> tree3 = new TreeSet<Lab6_2>();
        tree.add(ll1);
        tree.add(ll2);
        tree.add(ll3);
        tree.add(ll4);
        tree1 = (TreeSet) tree.headSet(ll4, true);
        tree2 = (TreeSet) tree.tailSet(ll1, true);
        tree3 = (TreeSet) tree.subSet(ll1, true, ll4, true);

        Iterator<Lab6_2> iter1 = tree1.iterator();
        Iterator<Lab6_2> iter2 = tree2.iterator();
        Iterator<Lab6_2> iter3 = tree3.iterator();
        while (iter1.hasNext()) {
            Lab6_2 it1 = (Lab6_2) iter1.next();
            System.out.println(it1.getName() + " " + it1.getId());
        }
        System.out.println();
        while (iter2.hasNext()) {
            Lab6_2 it2 = (Lab6_2) iter2.next();
            System.out.println(it2.getName() + " " + it2.getId());
        }
        System.out.println();
        while (iter3.hasNext()) {
            Lab6_2 it3 = (Lab6_2) iter3.next();
            System.out.println(it3.getName() + " " + it3.getId());
        }
        System.out.println();
        System.out.println(tree.first());
        System.out.println(tree.last());
    }

    String name;
    long id;

    public Lab6_2(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int compareTo(Object o) {
        Lab6_2 ll = (Lab6_2) o;
        int result = id > ll.id ? 1 : (id == ll.id ? -1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return getName() + " " + getId();
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

}
