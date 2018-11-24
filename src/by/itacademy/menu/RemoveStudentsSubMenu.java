package by.itacademy.menu;

import by.itacademy.module.Faculty;
import by.itacademy.module.Student;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveStudentsSubMenu extends СheckTheMenuNumber implements SubMenu {
    private Scanner sc = new Scanner(System.in);

    @Override
    public String name() {
        return "deleteStudentData";
    }

    @Override
    public void run(Map<Student, String> students, Map<String, Faculty> faculties, Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("resource", locale);

        System.out.println(bundle.getString("enterTheLastName"));
        String choiceSurname = sc.next();
        Pattern pattern = Pattern.compile("^" + choiceSurname.trim().toLowerCase() + "*");

        int i = 0;
        List<Student> foundStudents = new ArrayList<>();
        for (Map.Entry<Student, String> entry : students.entrySet()) {
            Matcher matcher = pattern.matcher(entry.getValue().toLowerCase());
            if (matcher.find()) {
                System.out.println(++i + ". " + entry.getKey().getName() + " " + entry.getValue());
                foundStudents.add(entry.getKey());
            }
        }

        if (i > 1) {
            System.out.println("\n" + bundle.getString("chooseAStudent"));

            int choice = 0;
            try {
                choice = checkInputValue(sc.next());
            } catch (ChoiceExecutionException e) {
                e.printStackTrace();
            }

            students.remove(foundStudents.get(choice - 1));
            System.out.println(bundle.getString("studentRemoved"));

        } else if (i == 1) {
            students.remove(foundStudents.get(i - 1));
            System.out.println(bundle.getString("studentRemoved"));
        } else {
            System.out.println(bundle.getString("studentNotFound"));
        }


        System.out.println(bundle.getString("removeMore"));
        System.out.println("1. " + bundle.getString("yes"));
        System.out.println("2. " + bundle.getString("no"));

        int choice = 0;
        try {
            choice = checkInputValue(sc.next());
        } catch (ChoiceExecutionException e) {
            e.printStackTrace();
        }

        if (choice == 1) run(students, faculties, locale);
        else return;
    }
}