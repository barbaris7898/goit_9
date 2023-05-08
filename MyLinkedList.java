package Collections;

import java.util.LinkedList;
import java.util.List;

public class MyLinkedList<T> {
   private int size;
   Node<T> first;
   Node<T> last;

   public void clear() {
      first = last = null;
      size = 0;
   }

   public int size() {
      return size;
   }

   public void add(T value) {
      Node<T> newNode = new Node<>(value);
      if (isEmpty()) {
         last = newNode;
      } else {
         newNode.setNext(first);
         first.setPrev(newNode);
      }
      first = newNode;
      size++;
   }

   public T remove(int index) {
      throwException(index);
      Node<T> current = getNode(index);
      T value = current.getElement();
      if (size == 1) {
         clear();
         return value;
      }

      if (current == first) {
         first = first.getNext();
         first.setPrev(null);
         size--;
         return value;
      }

      if (current == last) {
         last = last.getPrev();
         last.setNext(null);
      } else {
         current.getNext().setPrev(current.getPrev());
         current.getPrev().setNext(current.getNext());
      }
      size--;
      return value;
   }

   public T get(int index) {
      throwException(index);
      return getNode(index).getElement();
   }

   private boolean isEmpty() {
      return size == 0;
   }

   private boolean isIndexOk(int index) {
      return index >= 0 && index < size;
   }

   private void throwException(int index) {
      if (!isIndexOk(index)) {
         throw new IndexOutOfBoundsException("Index " + index +
                 " out of bounds for length " + size());
      }
   }

   private Node<T> getNode(int index) {
      Node<T> current = first;
      int start = 0;
      while (start < index) {
         start++;
         current = current.getNext();
      }
      return current;
   }
}

class MyLinkedListTest {
   public static void main(String[] args) {
      MyLinkedList<String> list = new MyLinkedList<>();
      list.add("Apple");
      list.add("Pear");
      list.add("Currant");
      list.add("Strawberry");
      list.add("Watermelon");
      list.add("Melon");
      System.out.println("After added: "+ list.size() + "\n");


      System.out.println("Output by the get method: ");
      for (int i = 0; i < list.size(); i++) {
         System.out.println(list.get(i));
      }
      System.out.println();

      System.out.println("list.remove() = " + list.remove(2));
      System.out.println("list.remove() = " + list.remove(list.size() - 1));
      System.out.println("list after removed: " + list.size() + "\n");

      list.clear();
      System.out.println("list after cleared: " + list.size());
   }
}
