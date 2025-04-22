import java.io.*;
import java.util.*;

public class StudentManager {
    private final String filePath = "students.txt";
    private List<Student> students = new ArrayList<>();

    public StudentManager() {
        loadFromFile();
    }

    public void addStudent(Student s) {
        students.add(s);
        saveToFile();
    }

    public boolean removeStudent(int id) {
        boolean removed = students.removeIf(s -> s.getId() == id);
        if (removed) saveToFile();
        return removed;
    }

    public Student getStudent(int id) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public void updateStudent(int id, String name, int age, String course) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setName(name);
                s.setAge(age);
                s.setCourse(course);
                saveToFile();
                break;
            }
        }
    }

    private void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))) {
            for (Student s : students) {
                pw.println(s.toString());
            }
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        File file = new File(filePath);
        if (!file.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                students.add(Student.fromString(line));
            }
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }
}
