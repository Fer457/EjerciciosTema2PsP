package ejer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
        static List<Student> oldestStudents(List<Student> srcList){
            // ordena la lista de menor a mayor y le da la vuelta, limita a 3 estudiantes y la devuelve
            return srcList.stream()
                    .sorted(Comparator.comparingInt(Student::getAge).
                    reversed()).
                    limit(3).
                    collect(Collectors.toList());
        }
         static List<Student> filterStudents(List<Student> srcList, Predicate<Student> predicado){
            // devuelve la lista filtrando por el pred. que le llega en los parametros
             return srcList.stream().
                     filter(predicado).
                     collect(Collectors.toList());
        }

    public static void main(String[] args) {
        // creo 3 predicados con las condiciones a aplicar
        Predicate<Student> predEdad = s -> (s.getAge() > 20);
        Predicate<Student> predNombre = s -> Objects.equals(s.getName(), "Peter");
        Predicate<Student> predSubj = s -> Objects.equals(s.getSubjects(), "Programacion");

        //relleno una lista con valores dinamicamente
        List<Student> sourceList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            sourceList.add(new Student(15+i, i == 1 || i == 7 ? "Peter" : "Student" + i,i == 2 ? "Programacion" : "Matemáticas"));
        }

        // creo mas list's para aplicar las funciones
        List<Student> listaAge = filterStudents(sourceList, predEdad);
        List<Student> listaNom = filterStudents(sourceList, predNombre);
        List<Student> listaSub = filterStudents(sourceList, predSubj);
        List<Student> listaMay = oldestStudents(sourceList);

        // se imprimen por pantalla
        System.out.printf("%n Estudiantes filtrados por edad %n");
        for (Student student: listaAge){
            System.out.println(student.toString());
        }System.out.printf("%n Estudiantes filtrados por nombre %n");
        for (Student student: listaNom){
            System.out.println(student.toString());
        }System.out.printf("%n Estudiantes filtrados por asignatura %n");
        for (Student student: listaSub){
            System.out.println(student.toString());
        }
        System.out.printf("%n Los 3 estudiantes más mayores %n");
        for (Student student: listaMay){
            System.out.println(student.toString());
        }
    }
}