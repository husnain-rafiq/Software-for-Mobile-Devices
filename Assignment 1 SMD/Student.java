
import java.util.Scanner;
public class Student extends Person implements person_interface,person_Detail
{
    private String dicipline;
    private String roll_no;

    protected static class ICS_Student
    {
        public final void Message()
        {
            System.out.println("I am Static Nested Inner Class ");
        }
    }

    public Student(){};




    public Student(String name1, int cn, int age1, String dcp, String roll)
        {


            super(name1, cn, age1);
            dicipline = dcp;
            roll_no = roll;


        }


    public void setName(String name1)
    {  // define setter
        Name=name1;

    }


    public void setCnic(int cn)
    {
        Cnic=cn;

    }


    public void setAge(int age1)
    {
        Age=age1;
    }

    @Override
    public void merryStatus()
    {
        System.out.println("Student is not married");
    }

    @Override
    public void profession()
    {
        System.out.println("Student is UnderGraduate");
    }

    @Override
    public void previous_experience()
    {
        System.out.println("Student have not any Experience");
    }

    public void Print()
    {

        System.out.println("Student Name : "+ getNmae());
        System.out.println("Student CNIC : "+ getCnic());
        System.out.println("Student Age : "+ getAge());
        System.out.println("Student Roll No : "+ roll_no);
        System.out.println("Student Dicipline : "+ dicipline);
        merryStatus();
        profession();

    }


}
