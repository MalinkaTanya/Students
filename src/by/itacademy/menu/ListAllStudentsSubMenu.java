package by.itacademy.menu;

import by.itacademy.module.Comp;
import by.itacademy.module.Faculty;
import by.itacademy.module.Student;

import java.util.*;

public class ListAllStudentsSubMenu extends СheckTheMenuNumber implements SubMenu {
    private Scanner sc = new Scanner(System.in);

    @Override
    public String name() {
        return "allStudentDataOutput";
    }

    @Override
    public void run(Map<Student, String> students, Map<String, Faculty> faculties, Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("resource", locale);

        System.out.println("1. " + bundle.getString("sortByLastName"));
        System.out.println("2. " + bundle.getString("sortByAverageScore") + "\n");

        int choice = 0;
        try {
            choice = checkInputValue(sc.next());
        } catch (ChoiceExecutionException e) {
            e.printStackTrace();
        }

        if (choice == 1) {
            for (Student key : students.keySet()) {
                System.out.println(key);
            }
        } else if (choice == 2) {
            Map<Student, String> sortStudents = new TreeMap<>(new Comp());
            sortStudents.putAll(students);

            for (Student key : sortStudents.keySet()) {
                System.out.println(key);
            }
        } else {
            System.out.println(bundle.getString("invalidValue") + "\n");
            run(students, faculties, locale);
        }
    }
}