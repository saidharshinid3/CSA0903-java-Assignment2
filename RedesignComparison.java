
import java.util.*;

public class RedesignComparison {

    static long testArrayList(int size) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        long start = System.nanoTime();

        while (!list.isEmpty()) {
            list.remove(0);
        }

        return System.nanoTime() - start;
    }

    static long testArrayDeque(int size) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < size; i++) {
            deque.addLast(i);
        }

        long start = System.nanoTime();

        while (!deque.isEmpty()) {
            deque.removeFirst();
        }

        return System.nanoTime() - start;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 50000};

        System.out.println("Original vs Redesigned Solution");

        for (int size : sizes) {
            long originalTime = testArrayList(size);
            long redesignedTime = testArrayDeque(size);

            System.out.println("\nQueue Size: " + size);

            System.out.println(
                "Original ArrayList Time: " +
                originalTime + " ns"
            );

            System.out.println(
                "Redesigned ArrayDeque Time: " +
                redesignedTime + " ns"
            );

            if (redesignedTime < originalTime) {
                System.out.println(
                    "Redesigned solution is faster."
                );
            } else {
                System.out.println(
                    "Original solution is faster for this test."
                );
            }
        }
    }
}
