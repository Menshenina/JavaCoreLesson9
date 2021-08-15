package lesson9;

import java.util.List;

public class Student {
    private String name;
    private List<Course> cources;

    public Student(String name, List<Course> cources) {
        this.name = name;
        this.cources = cources;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCources(List<Course> cources) {
        this.cources = cources;
    }

    public String getName() {
        return name;
    }

    public List<Course> getCources() {
        return cources;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
