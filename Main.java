import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("\n--- Student Record Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. View Student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();
                    manager.addStudent(new Student(id, name, age, course));
                    System.out.println("Student added.");
                    break;
                case 2:
                    for (Student s : manager.getAllStudents()) {
                        System.out.println(s);
                    }
                    break;
                case 3:
                    System.out.print("Enter ID to search: ");
                    int sid = sc.nextInt();
                    Student found = manager.getStudent(sid);
                    if (found != null) System.out.println(found);
                    else System.out.println("Student not found.");
                    break;
                case 4:
                    System.out.print("Enter ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Name: ");
                    String nname = sc.nextLine();
                    System.out.print("New Age: ");
                    int nage = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Course: ");
                    String ncourse = sc.nextLine();
                    manager.updateStudent(uid, nname, nage, ncourse);
                    System.out.println("Student updated.");
                    break;
                case 5:
                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt();
                    boolean removed = manager.removeStudent(did);
                    System.out.println(removed ? "Student removed." : "Student not found.");
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
