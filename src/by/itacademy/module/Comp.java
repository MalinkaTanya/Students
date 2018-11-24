package by.itacademy.module;

import java.util.Comparator;

public class Comp implements Comparator<Student> {
    @Override
    public int compare(Student obj1, Student obj2) {

        if (obj1.getAverageRating() < obj2.getAverageRating()) return 1;
        else if (obj1.getAverageRating() > obj2.getAverageRating()) return -1;
        else return obj1.compareTo(obj2);
    }
}