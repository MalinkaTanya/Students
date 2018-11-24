package by.itacademy.menu;

import by.itacademy.module.Faculty;
import by.itacademy.module.Student;

import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;

public class AdministrationMenu extends СheckTheMenuNumber implements SubMenu {
    private Scanner sc = new Scanner(System.in);
    private SubMenu[] subMenus = {new AddStudentsSubMenu(), new RemoveStudentsSubMenu()};
    private Map<String, Faculty> faculties;
    private Map<Student, String> students;

    @Override
    public String name() {
        return "enterStudentData";
    }

    @Override
    public void run(Map<Student, String> students, Map<String, Faculty> faculties, Locale locale) {
        this.faculties = faculties;
        this.students = students;
        ResourceBundle bundle = ResourceBundle.getBundle("resource", locale);

        StringBuilder out = new StringBuilder(bundle.getString("selectAnAction") + ":\n");
        for (int i = 1; i <= subMenus.length; i++) {
            out.append(i).append(". ").append(bundle.getString(subMenus[i - 1].name())).append("\n");
        }
        System.out.println(out);

        int choice = 0;
        try {
            choice = checkInputValue(sc.next());
        } catch (ChoiceExecutionException e) {
            e.printStackTrace();
        }

        if (choice <= subMenus.length) {
            subMenus[choice - 1].run(students, faculties, locale);
        } else {
            System.out.println(bundle.getString("invalidValue"));
            run(students, faculties, locale);
        }
    }
}