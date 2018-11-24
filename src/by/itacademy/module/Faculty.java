package by.itacademy.module;

import java.util.ArrayList;
import java.util.List;

public class Faculty implements Comparable {
    private String name;
    private List<Student> listStudents = new ArrayList<>();
    private double averageRating;
    private double sumRatingPaid;
    private double sumRatingBudget;
    private int numberPaidStudents;

    public Faculty(String name) {
        this.name = name;
    }

    public void addStudents(Student student) {
        listStudents.add(student);
        getNumberAndRatingsStudents();
    }

    public void removeStudents(Student student) {
        listStudents.remove(student);
    }

    public String getName() {
        return this.name;
    }

    public void getNumberAndRatingsStudents() {
        this.averageRating = 0;
        this.sumRatingPaid = 0;
        this.sumRatingBudget = 0;
        this.numberPaidStudents = 0;

        for (int i = 0; i < listStudents.size(); i++) {
            this.averageRating += listStudents.get(i).getAverageRating();
            if (listStudents.get(i).paid) {
                this.numberPaidStudents++;
                this.sumRatingPaid += listStudents.get(i).getAverageRating();
            } else this.sumRatingBudget += listStudents.get(i).getAverageRating();

        }

        if (listStudents.size() != 0) this.averageRating /= listStudents.size();
    }

    @Override
    public int compareTo(Object obj) {
        Faculty entry = (Faculty) obj;

        if (entry.averageRating > averageRating) return 1;
        else if (entry.averageRating < averageRating) return -1;
        else if (entry.averageRating == averageRating) {
            int result = name.compareTo(entry.name);
            if (result != 0) {
                return result;
            } else {
                return 0;
            }
        } else return 0;
    }

    @Override
    public String toString() {
        return "Факультет " + name + ":\n" +
                "Средний балл " + Math.round(averageRating) + "\n" +
                (listStudents.size() == 0 ? 0 : numberPaidStudents / listStudents.size() * 100) + "% студентов на платном," +
                " средний бал " + Math.round(numberPaidStudents == 0 ? 0 : sumRatingPaid / numberPaidStudents) + "\n" +
                (listStudents.size() == 0 ? 0 : (listStudents.size() - numberPaidStudents) / listStudents.size() * 100) + "% студентов на бюджетном," +
                " средний бал " + Math.round((listStudents.size() - numberPaidStudents) == 0 ? 0 : sumRatingBudget / (listStudents.size() - numberPaidStudents)) + "\n";
    }
}