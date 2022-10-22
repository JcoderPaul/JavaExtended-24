package Less_24_ch_5_Stream_Sorted.MyFavoriteStudents;

import java.util.Objects;

public class BadStudent {
    private String name;
    private char sex;
    private int age;
    private int course;
    private double avgGrade;

    public BadStudent(String name, char sex, int age, int course, double avgGrade) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.course = course;
        this.avgGrade = avgGrade;
    }

    @Override
    public String toString() {
        return "BadStudent: {" +
                "name= '" + name + '\'' +
                ", sex= " + sex +
                ", age= " + age +
                ", course= " + course +
                ", avgGrade= " + avgGrade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BadStudent that = (BadStudent) o;
        return sex == that.sex && age == that.age && course == that.course && Double.compare(that.avgGrade, avgGrade) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sex, age, course, avgGrade);
    }

    public String getName() {
        return name;
    }

    public char getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public int getCourse() {
        return course;
    }

    public double getAvgGrade() {
        return avgGrade;
    }
}
