package by.itacademy.menu;

import by.itacademy.module.Faculty;
import by.itacademy.module.Student;

import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchStudentsSubMenu extends СheckTheMenuNumber implements SubMenu {
    private Scanner sc = new Scanner(System.in);

    @Override
    public String name() {
        return "searchOfStudent";
    }

    @Override
    public void run(Map<Student, String> students, Map<String, Faculty> faculties, Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("resource", locale);

        System.out.println("1. " + bundle.getString("byLastName"));
        System.out.println("2. " + bundle.getString("byTheRange"));

        int choice = 0;
        try {
            choice = checkInputValue(sc.next());
        } catch (ChoiceExecutionException e) {
            e.printStackTrace();
        }

        if (choice == 1) {
            System.out.println(bundle.getString("enterTheLastName"));
            String choiceSurname = sc.next();
            Pattern pattern = Pattern.compile("^" + choiceSurname.trim().toLowerCase() + "*");

            for (Map.Entry<Student, String> entry : students.entrySet()) {
                Matcher matcher = pattern.matcher(entry.getValue().toLowerCase());
                if (matcher.find()) {
                    System.out.println(entry.getKey());
                }
            }
        } else if (choice == 2) {
            System.out.println(bundle.getString("beginningOfTheRange"));
            int minChoice = sc.nextInt();
            System.out.println(bundle.getString("endingOfTheRange"));
            int maxChoice = sc.nextInt();

            for (Student key : students.keySet()) {
                if (key.getAverageRating() >= minChoice || Math.round(key.getAverageRating()) <= maxChoice) {
                    System.out.println(key);
                }
            }

        } else {
            System.out.println(bundle.getString("invalidValue") + "\n");
            run(students, faculties, locale);
        }
    }
}