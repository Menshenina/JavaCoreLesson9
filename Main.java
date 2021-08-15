package lesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args){
        List<Student> students = new ArrayList<>();
        Course math = new Course("Математика");
        Course bd = new Course("Базы данных");
        Course baseTesting = new Course("Основы тестирвоания");
        Course autoTest = new Course("Автоматизация тестирования");
        Course mobileTest = new Course("Тестирование мобильный приложений");
        Course baseBush = new Course("Основы бух. учета");

        students.add(new Student("Степан", Arrays.asList( bd, autoTest, mobileTest)));
        students.add(new Student("Виктор", Arrays.asList( math, baseTesting, autoTest, mobileTest)));
        students.add(new Student("Татьяна", Arrays.asList( baseBush, baseTesting, math)));
        students.add(new Student("Наталья", Arrays.asList( autoTest, baseTesting, mobileTest, bd)));

        List<Course> cources = getCources(students);
        //System.out.println(cources);

        List<Student> bestStudents = getBestStudents(students);
        //System.out.println(bestStudents);

        List<Student> studentsByCourse =getStudentsByCource(students, bd);
        System.out.println(studentsByCourse);
    }

    public static List<Course> getCources(List<Student> students){

        List<Course> result = new ArrayList<>(
         students.stream().map(s -> s.getCources()).flatMap(m -> m.stream()).collect(Collectors.toSet()));
        return  result;
    }

    public static  List<Student> getBestStudents(List<Student> students){
        List<Student> result = new ArrayList<>(
                students.stream().sorted((s1, s2) -> s2.getCources().size() - s1.getCources().size() ).limit(2).collect(Collectors.toList()));
        return  result;
    }

    public  static  List<Student> getStudentsByCource(List<Student> students, Course course){
        List<Student> result = new ArrayList<>(
                students.stream().filter(s -> s.getCources().indexOf(course) >= 0).collect(Collectors.toList()));
        return  result;
    }
}
