package Collections;

import java.util.Objects;

public class MyArrayList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int size;

    public MyArrayList() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(T t) {
        if (size == array.length) {
            Object[] newArray = new Object[(int)(array.length * 1.5)];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[size++] = t;
    }

    public T remove(int index) {
        if (this.size <= index || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        T toRemove = (T) array[index];
        Object[] withoutToRemove = new Object[array.length];
        System.arraycopy(array, 0, withoutToRemove, 0, index);
        System.arraycopy(array, index + 1, withoutToRemove, index, array.length - index - 1);
        array = withoutToRemove;
        this.size--;
        return toRemove;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (this.size <= index || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return (T) array[index];
    }

    public void clear() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
}

class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Apple");
        list.add("Pear");
        list.add("Currant");
        list.add("Strawberry");
        list.add("Watermelon");
        list.add("Melon");
        System.out.print("After added: ");
        System.out.println(list.size()+"\n");

        System.out.println("Output by the get method: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println();

        System.out.println("list.remove() = " + list.remove(2));
        System.out.println("list.remove() = " + list.remove(list.size() - 1));
        System.out.println("list after removed: " + list.size()+"\n");

        list.clear();
        System.out.println("list after cleared: " + list.size());
    }
}
