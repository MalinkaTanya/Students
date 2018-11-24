package by.itacademy.menu;

import by.itacademy.module.Faculty;
import by.itacademy.module.Student;

import java.util.Locale;
import java.util.Map;

public interface SubMenu {
    String name();

    void run(Map<Student, String> students, Map<String, Faculty> faculties, Locale locale);
}