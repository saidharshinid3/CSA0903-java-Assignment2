
import java.util.*;

public class ListComparison {

    static void testArrayList(int size) {
        ArrayList<Integer> list = new ArrayList<>();

        long start = System.nanoTime();

        for (int i = 0; i < size; i++)
            list.add(i);

        long end = System.nanoTime();
        System.out.println("ArrayList Add End: " + (end - start));

        start = System.nanoTime();
        list.add(0, -1);
        end = System.nanoTime();
        System.out.println("ArrayList Add Front: " + (end - start));

        start = System.nanoTime();
        list.get(size / 2);
        end = System.nanoTime();
        System.out.println("ArrayList Get Middle: " + (end - start));

        start = System.nanoTime();
        list.remove(size / 2);
        end = System.nanoTime();
        System.out.println("ArrayList Remove Middle: " + (end - start));

        start = System.nanoTime();
        for (int value : list) { }
        end = System.nanoTime();
        System.out.println("ArrayList Iteration: " + (end - start));
    }

    static void testLinkedList(int size) {
        LinkedList<Integer> list = new LinkedList<>();

        long start = System.nanoTime();

        for (int i = 0; i < size; i++)
            list.add(i);

        long end = System.nanoTime();
        System.out.println("LinkedList Add End: " + (end - start));

        start = System.nanoTime();
        list.addFirst(-1);
        end = System.nanoTime();
        System.out.println("LinkedList Add Front: " + (end - start));

        start = System.nanoTime();
        list.get(size / 2);
        end = System.nanoTime();
        System.out.println("LinkedList Get Middle: " + (end - start));

        start = System.nanoTime();
        list.remove(size / 2);
        end = System.nanoTime();
        System.out.println("LinkedList Remove Middle: " + (end - start));

        start = System.nanoTime();
        for (int value : list) { }
        end = System.nanoTime();
        System.out.println("LinkedList Iteration: " + (end - start));
    }

    static void testArrayDeque(int size) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        long start = System.nanoTime();

        for (int i = 0; i < size; i++)
            deque.addLast(i);

        long end = System.nanoTime();
        System.out.println("ArrayDeque Add End: " + (end - start));

        start = System.nanoTime();
        deque.addFirst(-1);
        end = System.nanoTime();
        System.out.println("ArrayDeque Add Front: " + (end - start));

        start = System.nanoTime();
        deque.removeFirst();
        end = System.nanoTime();
        System.out.println("ArrayDeque Remove Front: " + (end - start));

        start = System.nanoTime();
        for (int value : deque) { }
        end = System.nanoTime();
        System.out.println("ArrayDeque Iteration: " + (end - start));
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 50000};

        for (int size : sizes) {
            System.out.println("\nPlaylist Size: " + size);

            testArrayList(size);
            testLinkedList(size);
            testArrayDeque(size);
        }
    }
}
