package by.itacademy.menu;

import by.itacademy.module.Locales;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LocaleChoiceMenu extends СheckTheMenuNumber {
    private RootMenu rootMenu = new RootMenu();
    private Locales locales = new Locales();
    private Scanner sc = new Scanner(System.in);

    public void run() {
        Locale.setDefault(locales.getValue(0));
        List<String> keys = locales.getKeys();
        ResourceBundle bundle = ResourceBundle.getBundle("resource");
        StringBuilder out = new StringBuilder(bundle.getString("choiceLocale") + ":\n");
        for (int i = 1; i <= keys.size(); i++) {
            out.append(i).append(". ").append(keys.get(i - 1)).append("\n");
        }
        System.out.println(out);

        int choice = sc.nextInt();
        System.out.println(locales.getValue(choice - 1));

        rootMenu.run(locales.getValue(choice - 1));
    }
}