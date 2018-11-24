package by.itacademy.menu;

import by.itacademy.module.Faculty;
import by.itacademy.module.Student;

import java.util.*;

public class RootMenu extends СheckTheMenuNumber {
    private Scanner sc = new Scanner(System.in);
    private SubMenu[] subMenus = {new AdministrationMenu(), new InformationMenu()};
    private Map<Student, String> students = new TreeMap<>();
    private Map<String, Faculty> faculties = new TreeMap<>();
    private Faculty faculty;
    private Student student;


    {
        faculty = new Faculty("FT");
        faculties.put("FT", faculty);
        student = new Student("Ivanov", "Sergey", "02-07-2010", faculty, true, Arrays.asList(8, 10, 7, 5, 9, 9, 6));
        faculty.addStudents(student);
        students.put(student, "Ivanov");
        student = new Student("Petrova", "Anna", "12-05-2008", faculty, false, Arrays.asList(5, 10, 9, 7, 8, 6, 9));
        faculty.addStudents(student);
        students.put(student, "Petrova");

        faculty = new Faculty("FM");
        faculties.put("FM", faculty);
        student = new Student("Ivanov", "Andrey", "07-11-2009", faculty, true, Arrays.asList(8, 10, 7, 5, 9, 9, 6));
        faculty.addStudents(student);
        students.put(student, "Ivanov");

        faculty = new Faculty("BF");
        faculties.put("BF", faculty);
        student = new Student("Sergeev", "Denis", "12-05-2008", faculty, false, Arrays.asList(4, 8, 6, 5, 7, 5, 9));
        faculty.addStudents(student);
        students.put(student, "Sergeev");
    }

    public void run(Locale locale) {
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
            return;
        }

        if (choice <= subMenus.length) {
            subMenus[choice - 1].run(students, faculties, locale);
        } else {
            System.out.println(bundle.getString("invalidValue"));
            run(locale);
        }
    }
}
