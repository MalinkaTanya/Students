package by.itacademy.menu;

import by.itacademy.module.Faculty;
import by.itacademy.module.Student;

import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class ListFacultiesSubMenu implements SubMenu {
    private Scanner sc = new Scanner(System.in);

    @Override
    public String name() {
        return "displaysAlistOfFaculties";
    }

    @Override
    public void run(Map<Student, String> students, Map<String, Faculty> faculties, Locale locale) {
        for (Map.Entry<String, Faculty> entry : faculties.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}