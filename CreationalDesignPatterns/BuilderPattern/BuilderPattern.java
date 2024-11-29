package CreationalDesignPatterns.BuilderPattern;

import java.util.ArrayList;
import java.util.List;

class Student{
    int rollNumber;
    int age;
    String name;
    String fatherName;
    String motherName;
    List<String> subjects;
    public Student(StudentBuilder studentBuilder){
        this.rollNumber=studentBuilder.rollNumber;
        this.age=studentBuilder.age;
        this.name=studentBuilder.name;
        this.fatherName=studentBuilder.fatherName;
        this.motherName=studentBuilder.motherName;
        this.subjects=studentBuilder.subjects;

    }
    public String display(){
        System.out.println("hii");

        return this.rollNumber+" "+this.age+" "+this.name+" "+this.fatherName+" "+this.motherName+" "+this.subjects;
    }

}
abstract class StudentBuilder{
    int rollNumber;
    int age;
    String name;
    String fatherName;
    String motherName;
    List<String> subjects;
    public StudentBuilder setRollNumber(int rollNumber){
        this.rollNumber=rollNumber;
        return this;
    }
    public StudentBuilder setAge(int age){
        this.age=age;
        return this;
    }
    public StudentBuilder setName(String name){
        this.name=name;
        return this;
    }
    public StudentBuilder setFatherName(String fatherName){
        this.fatherName=fatherName;
        return this;
    }
    public StudentBuilder setMotherName(String motherName){
        this.motherName=motherName;
        return this;
    }
    abstract public StudentBuilder setSubjects();
    public Student build(){
        return new Student(this);
    }
}

class EngineeringBuilder extends StudentBuilder{

    @Override
    public StudentBuilder setSubjects() {
        List<String> subs= new ArrayList<>();
        subs.add("Maths");
        subs.add("Physics");
        this.subjects=subs;
        return this;
    }
    
}


class Director{
    StudentBuilder studentBuilder;
    Director(StudentBuilder studentBuilder){
        this.studentBuilder=studentBuilder;
    }
    public Student createStudent(){
        if(studentBuilder instanceof EngineeringBuilder){
            return createEngineeringStudent();
        }
        return createEngineeringStudent();
    }
    private Student createEngineeringStudent(){
        return studentBuilder.setAge(25).setName("madhu").build();
    }
}
public class BuilderPattern {
    public static void main(String[] args) {
        Director director= new Director(new EngineeringBuilder());
        Student student=director.createStudent();
        student.display();
    }
}
