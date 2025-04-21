public class Course {
    String courseName;
    String courseCode;

    public Course(String courseName, String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
    }

    public void printCourseInfo() {
        System.out.println(courseCode + " - " + courseName);
    }
}
