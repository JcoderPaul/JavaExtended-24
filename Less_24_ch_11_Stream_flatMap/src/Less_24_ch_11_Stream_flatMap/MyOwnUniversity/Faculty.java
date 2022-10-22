package Less_24_ch_11_Stream_flatMap.MyOwnUniversity;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private String name_of_faculty;
    private List<Student> students_on_faculty;

    public Faculty(String name_of_faculty) {
        this.name_of_faculty = name_of_faculty;
        students_on_faculty = new ArrayList<Student>();
    }

    public List<Student> getStudents_on_faculty() {
        return students_on_faculty;
    }

    public void addStudentsOnFaculty(Student st){
        students_on_faculty.add(st);
    }

    public String getName_of_faculty() {
        return name_of_faculty;
    }
}
