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

        System.out.println("=== Add New Student ===");
        System.out.print("Enter name: ");
        String name = input.nextLine();

        System.out.print("Enter age: ");
        int age = Integer.parseInt(input.nextLine());

        System.out.print("Enter student ID: ");
        String studentId = input.nextLine();

        Student newStudent = new Student(name, age, studentId);
        students.add(newStudent);

        System.out.println("New student added successfully!");

        System.out.print("How many courses to add for this student? ");
        int courseCount = Integer.parseInt(input.nextLine());

        for (int i = 1; i <= courseCount; i++) {
            System.out.println("Course #" + i);
            System.out.print("Enter course name: ");
            String courseName = input.nextLine();

            System.out.print("Enter course code: ");
            String courseCode = input.nextLine();

            Course course = new Course(courseName, courseCode);
            boolean duplicate = false;
            for (Course c : newStudent.courses) {
                if (c.courseCode.equals(courseCode)) {
                    duplicate = true;
                    break;
                }
            }

            if (duplicate) {
                System.out.println("This course code already exists for this student. Skipping...");
                i--;
                continue;
            }

            newStudent.addCourse(course);
        }

        System.out.print("Enter student ID to search: ");
        String searchId = input.nextLine();
        searchStudentById(students, searchId);

        System.out.print("Enter student ID to remove: ");
        String removeId = input.nextLine();
        removeStudentById(students, removeId);

        System.out.println("=== Updated Student List ===");
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
