
public class StringComparison {

    static String usingString(int fields) {
        String result = "";
        for (int i = 1; i <= fields; i++) {
            result = result + "Field" + i + " ";
        }
        return result;
    }

    static String usingStringBuilder(int fields) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= fields; i++) {
            result.append("Field").append(i).append(" ");
        }
        return result.toString();
    }

    static String usingStringBuffer(int fields) {
        StringBuffer result = new StringBuffer();
        for (int i = 1; i <= fields; i++) {
            result.append("Field").append(i).append(" ");
        }
        return result.toString();
    }

    static void measure(String name, int fields, int runs, int method) {
        long totalTime = 0;
        String result = "";

        for (int i = 0; i < runs; i++) {
            long start = System.nanoTime();

            if (method == 1)
                result = usingString(fields);
            else if (method == 2)
                result = usingStringBuilder(fields);
            else
                result = usingStringBuffer(fields);

            long end = System.nanoTime();
            totalTime += end - start;
        }

        System.out.println(name + " Average Time: " +
            (totalTime / runs) + " ns");

        System.out.println("Generated Length: " + result.length());
    }

    public static void main(String[] args) {
        int[] workloads = {10, 50, 1000, 10000};
        int runs = 5;

        for (int fields : workloads) {
            System.out.println("\nFields: " + fields);

            measure("String", fields, runs, 1);
            measure("StringBuilder", fields, runs, 2);
            measure("StringBuffer", fields, runs, 3);
        }
    }
}
