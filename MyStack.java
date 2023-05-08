package Collections;

public class MyStack<T>{
    private int size;
    private MyLinkedList<T> list;

    public MyStack() {
        list = new MyLinkedList<>();
    }

    public void push(T element) {
        list.add(element);
        size = list.size();
    }

    public T remove(int index) {
        T element = list.remove(index);
        size = list.size();
        return element;
    }

    public void clear() {
        list.clear();
        size = list.size();
    }

    public int size() {
        return size;
    }

    public T peek() {
        return list.get(0);
    }

    public T pop() {
        T element = list.remove(list.size() - 1);
        size = list.size();
        return element;
    }
}

class StackTest {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println("stack after push: " + stack.size() + "\n");

        System.out.println("stack.peek() = " + stack.peek() + "\n");

        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack after pop: " + stack.size() + "\n");

        System.out.println("stack.remove() = " + stack.remove(1));
        System.out.println("stack after removed: " + stack.size() + "\n");

        stack.clear();
        System.out.println("stack after cleared: " + stack.size());
    }
}

