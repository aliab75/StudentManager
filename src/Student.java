import java.util.ArrayList;

public class Student {
    String name;
    int age;
    String studentId;
    ArrayList<Course> courses = new ArrayList<>();

    public Student(String name, int age, String studentId) {
        this.name = name;
        this.age = age;
        this.studentId = studentId;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void printCourses() {
        System.out.println("Courses:");
        for (Course c : courses) {
            c.printCourseInfo();
        }
    }

    public void printInfo() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        printCourses();
    }
}
