
import java.util.HashSet;
import java.util.Set;

class Student {
    private final String regNo;
    private final String name;

    Student(String regNo, String name) {
        this.regNo = regNo;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Student))
            return false;

        Student other = (Student) o;
        return regNo.equals(other.regNo);
    }

    @Override
    public int hashCode() {
        return regNo.hashCode();
    }

    @Override
    public String toString() {
        return regNo + " - " + name;
    }
}

public class Attendance {
    public static void main(String[] args) {
        Set<Student> present = new HashSet<>();

        present.add(new Student("192311001", "Arun"));
        present.add(new Student("192311002", "Divya"));
        present.add(new Student("192311001", "Arun"));

        System.out.println("Unique students: " + present.size());

        for (Student student : present) {
            System.out.println(student);
        }

        Set<Student> secondTest = new HashSet<>();

        secondTest.add(new Student("192311003", "Kumar"));
        secondTest.add(new Student("192311003", "Kumar"));
        secondTest.add(new Student("192311004", "Meena"));

        System.out.println("Second test size: " + secondTest.size());
    }
}
