package ejer;

import javax.security.auth.Subject;

public class Student {
    private int age;
    private String name;
    private String subject;

    private Subject subjects;

    public Student(int age, String name, String subjects) {
        this.age = age;
        this.name = name;
        this.subject = subjects;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubjects() {
        return subject;
    }
    public void setSubjects(String subjects) {
        this.subject = subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", subjects='" + subject + '\'' +
                '}';
    }


}
