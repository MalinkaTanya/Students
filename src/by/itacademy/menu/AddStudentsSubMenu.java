package by.itacademy.menu;

import by.itacademy.module.Faculty;
import by.itacademy.module.Student;

import java.util.*;

public class AddStudentsSubMenu extends СheckTheMenuNumber implements SubMenu {
    private Scanner sc = new Scanner(System.in);

    @Override
    public String name() {
        return "addStudentData";
    }

    @Override
    public void run(Map<Student, String> students, Map<String, Faculty> faculties, Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("resource", locale);
        System.out.println(bundle.getString("enterData"));
        String surname = sc.next();
        String name = sc.next();
        String birthday = sc.next();
        String enteredFaculty = sc.next();
        Faculty faculty;

        if (faculties.get(enteredFaculty) == null) {
            System.out.println(bundle.getString("faculty") + enteredFaculty + " " + bundle.getString("notFound") + "\n");
            return;
        } else {
            faculty = faculties.get(enteredFaculty);
        }

        boolean paid = false;
        System.out.println("1." + bundle.getString("paidEducation") + "\n" + "2." + bundle.getString("budgetEducation") + "\n");

        int choice = 0;
        try {
            choice = checkInputValue(sc.next());
        } catch (ChoiceExecutionException e) {
            e.printStackTrace();
        }

        if (choice == 1) paid = true;

        System.out.println(bundle.getString("enter7Points") + ":\n");
        List<Integer> listRatings = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {

            choice = 0;
            try {
                choice = checkInputValue(sc.next());
            } catch (ChoiceExecutionException e) {
                e.printStackTrace();
            }

            listRatings.add(choice);
        }

        Student student = new Student(surname, name, birthday, faculty, paid, listRatings);
        faculty.addStudents(student);
        students.put(student, surname);
        System.out.println(bundle.getString("studentAdded") + "\n" + student);

        System.out.println(bundle.getString("addMore"));
        System.out.println("1. " + bundle.getString("yes"));
        System.out.println("2. " + bundle.getString("no"));

        choice = 0;
        try {
            choice = checkInputValue(sc.next());
        } catch (ChoiceExecutionException e) {
            e.printStackTrace();
        }

        if (choice == 1) run(students, faculties, locale);
        else return;
    }
}