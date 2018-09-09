import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Main
{

    private static String filepath = "D:\\java code\\Assignment 1\\src\\husnain.txt";

    public static void main(String[] args)
    {

        int Age=0;
        String Name="";
        int Cnic=0;
        String Dicipline="";
        String Roll="";
        String CourseInstructor="";
        String Reg="";
        String Spec="";
        Boolean flag=true;
        Boolean flag1=true;


        BufferedReader br = null;
        String curline;
        try {
            br = new BufferedReader(new FileReader(filepath));

            while ((curline = br.readLine()) != null)
            {

                System.out.println(curline);

            }
        } catch (IOException e)
        {
            System.err.println("An IOException was caught :"+e.getMessage());
        }finally{

            try {
                if(br != null)

                br.close();

            } catch (IOException e) {
                e.printStackTrace();

            }

        }

        System.out.println("");

        Scanner s = new Scanner(System.in);

        while(flag)
        {

            try {


                System.out.println("Enter the Student Information ");
                System.out.println("");

                System.out.println("Enter the Name ");
                Name = s.nextLine();

                System.out.println("Enter the Age ");
                Age = s.nextInt();

                System.out.println("Enter the CNIC ");
                Cnic = s.nextInt();

                s.nextLine();

                System.out.println("Enter the Roll No ");
                Roll = s.nextLine();

                System.out.println("Enter the Dicipline ");
                Dicipline = s.nextLine();

                System.out.println("");

                System.out.println("%%%%%%%%%%%%%% Student Information is : %%%%%%%%%%%%%%");
                System.out.println("");

                Student s1=new Student(Name,Cnic,Age,Dicipline,Roll);
                s1.Print();

                flag=false;

            }
            catch (java.util.InputMismatchException e)    //Handling the Exception
            {
                System.out.println("You Enter Bad Input, Enter Again");
                s.nextLine();                           //Clear out all previous input

            }
        }



        while(flag1)
        {

            try {

                System.out.println("");
                System.out.println("");

                System.out.println("Enter the Teacher Information ");
                System.out.println("");

                System.out.println("Enter the Name ");
                Name = s.nextLine();

                System.out.println("Enter the Age ");
                Age = s.nextInt();

                System.out.println("Enter the CNIC ");
                Cnic = s.nextInt();
                s.nextLine();

                System.out.println("Enter the Course Instructor Of ");
                CourseInstructor= s.nextLine();

                System.out.println("Enter the Instructor Registrion No ");
                Reg= s.nextLine();

                System.out.println("Enter the Instructor Specialization ");
                Spec= s.nextLine();

                System.out.println("");

                System.out.println("%%%%%%%%%%%%%% Teacher Information is : %%%%%%%%%%%%%%");
                System.out.println("");

                Faculty f1=new Faculty(Name,Cnic,Age,CourseInstructor,Reg,Spec);
                f1.Print();

                flag1=false;

            }
            catch (java.util.InputMismatchException e)    //Handling the Exception
            {
                System.out.println("You Enter Bad Input, Enter Again");
                s.nextLine();                           //Clear out all previous input

            }
        }

        System.out.println("");

        System.out.println("%%%%%%%%%%%%%% Static or Non Static Inner Class Output %%%%%%%%%%%%%%");
        System.out.println("");


        Student.ICS_Student I1=new Student.ICS_Student();
        I1.Message();

        Faculty f2=new Faculty();
        Faculty.Teacher_Assistant T1=f2.new Teacher_Assistant();
        T1.Teacher_TA();

        System.out.println("Hello World!"); // Display the string.


    }
}


