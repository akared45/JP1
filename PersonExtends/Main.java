package PersonExtends;
import Controller.StudentController;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args){
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(1, "Vinh","Le",LocalDate.of(2001,5,6),Gender.Male));
        students.add(new Student(2, "A","B",LocalDate.of(2000,1,2),Gender.Female));
        students.add(new Student(3, "C","A",LocalDate.of(2007,2,3),Gender.Female));

        List<Staff> staffs = new ArrayList<Staff>();
        staffs.add(new Staff(1,"Vinh","Le","Abc",10000,"Employee",Gender.Female));



    }
}
