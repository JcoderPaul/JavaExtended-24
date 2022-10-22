package Less_24_ch_5_Stream_Sorted.MyFavoriteStudents;

import java.util.Objects;

public class GoodStudent implements Comparable<GoodStudent>{
    private String name;
    private char sex;
    private int age;
    private int course;
    private double avgGrade;

    public GoodStudent(String name, char sex, int age, int course, double avgGrade) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.course = course;
        this.avgGrade = avgGrade;
    }

    @Override
    public String toString() {
        return "Student: {" +
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
        GoodStudent student = (GoodStudent) o;
        return sex == student.sex &&
               age == student.age &&
               course == student.course &&
               Double.compare(student.avgGrade, avgGrade) == 0 &&
               Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sex, age, course, avgGrade);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }

    @Override
    public int compareTo(GoodStudent std) {
        int res = this.name.compareTo(std.name);
        if(res == 0){
            if (this.age == std.age) {
                return 0;
            } else if (this.age > std.age) {
                return +1;
            } else
                return -1;
        } else
            return res;
    }
}
