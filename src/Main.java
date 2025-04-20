import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Ali", 28, "ST001"));
        students.add(new Student("Sara", 22, "ST002"));
        students.add(new Student("Reza", 23, "ST003"));

        System.out.println("=== All Students ===");
        for (Student s : students) {
            s.printInfo();
            System.out.println("-----------");
        }

        System.out.println("=== Search Result ===");
        searchStudentById(students, "ST002");
    }

    public static void searchStudentById(ArrayList<Student> students, String targetId) {
        boolean found = false;
        for (Student s : students) {
            if (s.studentId.equals(targetId)) {
                s.printInfo();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No student found with ID: " + targetId);
        }
    }
}
