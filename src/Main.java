import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Ali", 28, "ST001"));
        students.add(new Student("Sara", 22, "ST002"));
        students.add(new Student("Reza", 23, "ST003"));

        Course math = new Course("Mathematics", "MATH101");
        Course java = new Course("Java Programming", "CS201");

        students.get(0).addCourse(math);
        students.get(0).addCourse(java);
        students.get(1).addCourse(math);
        students.get(2).addCourse(java);

        Scanner input = new Scanner(System.in);

        System.out.print("Enter student ID to search: ");
        String searchId = input.nextLine();
        searchStudentById(students, searchId);

        System.out.print("Enter student ID to remove: ");
        String removeId = input.nextLine();
        removeStudentById(students, removeId);

        System.out.println("=== Remaining Students ===");
        for (Student s : students) {
            s.printInfo();
            System.out.println("-----------");
        }

        input.close();
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

    public static void removeStudentById(ArrayList<Student> students, String targetId) {
        Student toRemove = null;
        for (Student s : students) {
            if (s.studentId.equals(targetId)) {
                toRemove = s;
                break;
            }
        }
        if (toRemove != null) {
            students.remove(toRemove);
            System.out.println("Student with ID " + targetId + " removed.");
        } else {
            System.out.println("No student found with ID: " + targetId);
        }
    }
}
