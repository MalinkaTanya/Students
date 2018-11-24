package by.itacademy.module;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student implements Comparable {
    private String surname;
    private String name;
    private Date birthday;
    private Faculty faculty;
    private List<Integer> listRatings = new ArrayList<>();
    boolean paid;

    public Student(String surname, String name, Date birthday, Faculty faculty, boolean paid, List<Integer> listRatings) {
        this.surname = surname;
        this.name = name;
        this.birthday = birthday;
        this.faculty = faculty;
        this.listRatings = listRatings;
        this.paid = paid;
    }

    public Student(String surname, String name, String birthday, Faculty faculty, boolean paid, List listRatings) {
        this(surname, name, toDate(birthday), faculty, paid, listRatings);
    }

    private static Date toDate(String birthday) {
        SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
        try {
            return format.parse(birthday);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public double getAverageRating() {
        double averageRating = 0;

        for (int i = 0; i < listRatings.size(); i++) {
            averageRating += listRatings.get(i);
        }

        if (listRatings.size() == 0) return averageRating;
        else return averageRating / listRatings.size();
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Object obj) {
        Student entry = (Student) obj;
        int result = surname.compareTo(entry.surname);
        if (result != 0) {
            return result;
        } else {
            result = name.compareTo(entry.name);
            if (result != 0) {
                return result;
            } else {
                return 0;
            }
        }
    }

    @Override
    public String toString() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");

        return "Student{" + name + " " + surname +
                "\nbirthday: " + simpleDateFormat.format(birthday) +
                "\nfaculty: " + faculty.getName() +
                "\nratings: " + listRatings +
                "\naverage rating: " + Math.round(getAverageRating()) + "\n" +
                (paid ? "paid" : "budget") + " education}\n";
    }
}