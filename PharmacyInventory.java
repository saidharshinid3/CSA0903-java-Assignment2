
import java.util.*;

public class PharmacyInventory {

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 50000};

        for (int size : sizes) {
            System.out.println("\nNumber of Medicines: " + size);

            Map<String, Integer> hashMap = new HashMap<>();
            Map<String, Integer> treeMap = new TreeMap<>();
            Map<String, Integer> linkedMap = new LinkedHashMap<>();

            for (int i = 1; i <= size; i++) {
                String code = String.format("MED%06d", i);

                hashMap.put(code, i * 10);
                treeMap.put(code, i * 10);
                linkedMap.put(code, i * 10);
            }

            String searchCode = String.format("MED%06d", size / 2);

            long start = System.nanoTime();

            for (int i = 0; i < 100000; i++)
                hashMap.get(searchCode);

            long end = System.nanoTime();
            System.out.println("HashMap Lookup: " + (end - start) + " ns");

            start = System.nanoTime();

            for (int i = 0; i < 100000; i++)
                treeMap.get(searchCode);

            end = System.nanoTime();
            System.out.println("TreeMap Lookup: " + (end - start) + " ns");

            start = System.nanoTime();

            for (int i = 0; i < 100000; i++)
                linkedMap.get(searchCode);

            end = System.nanoTime();
            System.out.println("LinkedHashMap Lookup: " + (end - start) + " ns");

            start = System.nanoTime();

            for (String code : treeMap.keySet()) { }

            end = System.nanoTime();
            System.out.println("Code Order Report: " + (end - start) + " ns");

            start = System.nanoTime();

            for (String code : linkedMap.keySet()) { }

            end = System.nanoTime();
            System.out.println("Insertion Order Report: " + (end - start) + " ns");

            System.out.println("HashMap Size: " + hashMap.size());
            System.out.println("TreeMap Size: " + treeMap.size());
            System.out.println("LinkedHashMap Size: " + linkedMap.size());
        }
    }
}
