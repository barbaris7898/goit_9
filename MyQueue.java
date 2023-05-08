package Collections;

public class MyQueue<T> {
    private int size;
    private MyLinkedList <T> list;

    public MyQueue(){
        list = new MyLinkedList<>();
    }

    public void add(T value){
        list.add(value);
        size = list.size();
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

    public T poll(){
        T element = list.remove(0);
        size = list.size();
        return element;
    }
}
class MyQueueTest{
    public static void main(String[] args) {
        MyQueue <Integer> queue = new MyQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        System.out.println("queue after added: " + queue.size() + "\n");

        System.out.println("queue.peek() = " + queue.peek() + "\n");

        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue after polled: " + queue.size() + "\n");

        queue.clear();
        System.out.println("queue after cleared: " + queue.size());
    }
}

