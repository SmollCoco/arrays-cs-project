package samplearrays;

public class ManageStudent {
    // 2) Find the Oldest Student (null-safe)
    public static Student findOldest(Student[] students) {
        if (students == null) return null;
        Student oldest = null;
        for (Student s : students) {
            if (s == null) continue;
            if (oldest == null || s.getAge() > oldest.getAge()) {
                oldest = s;
            }
        }
        return oldest;
    }

    // 3) Count Adult Students (age >= 18) (null-safe)
    public static int countAdults(Student[] students) {
        if (students == null) return 0;
        int res = 0;
        for (Student student : students) {
            if (student != null && student.isAdult()) {
                ++res;
            }
        }
        return res;
    }

    // 4) Average Grade (returns NaN if no students with grades) (null-safe)
    public static double averageGrade(Student[] students) {
        if (students == null || students.length == 0) {
            return Double.NaN;
        }
        double sum = 0.0;
        int count = 0;
        for (Student student : students) {
            if (student == null) continue;
            sum += student.getGrade();
            ++count;
        }
        return count == 0 ? Double.NaN : sum / count;
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired) (null-safe)
    public static Student findStudentByName(Student[] students, String name) {
        if (students == null || name == null) return null;
        for (Student student : students) {
            if (student != null && name.equals(student.getName())) {
                return student;
            }
        }
        return null;
    }

    // 6) Sort Students by Grade (descending). Nulls moved to end.
    public static void sortByGradeDesc(Student[] students) {
        if (students == null) return;
        int n = students.length;
        for (int i = 0; i < n - 1; ++i) {
            int bestIdx = i;
            for (int j = i + 1; j < n; ++j) {
                Student a = students[bestIdx];
                Student b = students[j];
                if (a == null && b != null) {
                    bestIdx = j; // non-null first over null
                } else if (a != null && b != null && b.getGrade() > a.getGrade()) {
                    bestIdx = j; // higher grade first
                }
            }
            if (bestIdx != i) {
                Student tmp = students[i];
                students[i] = students[bestIdx];
                students[bestIdx] = tmp;
            }
        }
    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        if (students == null) return;
        for (Student student : students) {
            if (student != null && student.getGrade() >= 15) {
                System.out.println(student);
            }
        }
    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        if (students == null) return false;
        for (Student student : students) {
            if (student != null && student.getId() == id) {
                student.setGrade(newGrade);
                return true;
            }
        }
        return false;
    }

    // 9) Find Duplicate Names (null-safe)
    public static boolean hasDuplicateNames(Student[] students) {
        if (students == null) return false;
        for (int i = 0; i < students.length - 1; ++i) {
            if (students[i] == null) continue;
            for (int j = i + 1; j < students.length; ++j) {
                if (students[j] == null) continue;
                if (students[i].getName().equals(students[j].getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        if (newStudent == null) return students; // nothing to append
        if (students == null) {
            return new Student[]{newStudent};
        }
        Student[] newArr = new Student[students.length + 1];
        System.arraycopy(students, 0, newArr, 0, students.length);
        newArr[students.length] = newStudent;
        return newArr;
    }

    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Initialize array with 5 concrete students
        Student[] arr = new Student[]{
                new Student(1, "Ali", 19, 14),
                new Student(2, "Biba", 17, 12),
                new Student(3, "Carlos", 21, 16),
                new Student(4, "Dina", 20, 18),
                new Student(5, "Eli", 22, 10)
        };

        // Print all
        System.out.println("== All Students ==");
        for (Student s : arr) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest
        System.out.println("\n== Oldest Student ==");
        System.out.println(findOldest(arr));

        // 3) Count adults
        System.out.println("\nNumber of adult students: " + countAdults(arr));

        // 4) Average grade
        System.out.println("\nAverage grade: " + averageGrade(arr));

        // 5) Find by name
        System.out.println("\nFind by name 'Dina': " + findStudentByName(arr, "Dina"));

        // 6) Sort by grade desc
        System.out.println("\n== Sorted by grade (desc) ==");
        sortByGradeDesc(arr);
        for (Student s : arr) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(arr);

        // 8) Update grade by id
        boolean updated = updateGrade(arr, 4, 19); // bump Dina to 19
        System.out.println("\nUpdated id=4? " + updated);
        System.out.println(findStudentByName(arr, "Dina"));

        // 9) Duplicate names
        System.out.println("\nHas duplicate names? " + hasDuplicateNames(arr));

        // 10) Append new student
        Student newStudent = new Student(6, "Zara", 22, 20);
        arr = appendStudent(arr, newStudent);
        System.out.println("\nAfter appending new student:");
        for (Student s : arr) System.out.println(s);
    }
}