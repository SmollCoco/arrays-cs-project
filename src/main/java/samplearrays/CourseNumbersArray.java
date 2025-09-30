package samplearrays;

import java.util.Arrays;

public class CourseNumbersArray {
    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};

        // Add a new course
        int newCourse = 4242;
        int[] updatedCourses = Arrays.copyOf(registeredCourses, registeredCourses.length + 1);
        updatedCourses[registeredCourses.length] = newCourse;

        // Print contents of updatedCourses
        System.out.print("Updated courses array: ");
        for (int course : updatedCourses) {
            System.out.print(course + " ");
        }
        System.out.println();

        // Check if updatedCourses contains a course
        int check_course = 1;  // Doesn't belong to the array of courses
        boolean check = false;
        for (int course : updatedCourses) {
            if (course == check_course) {
                System.out.println("Course 1 is in the array of courses.");
                check = true;
            }
        }
        if (!check) {
            System.out.println("Course 1 is NOT in the array of courses.");
        }
    }
}
