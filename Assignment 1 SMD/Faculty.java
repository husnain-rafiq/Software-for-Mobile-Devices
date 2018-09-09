import java.lang.reflect.Field;

public class Faculty extends Person implements person_interface,person_Detail
{
    private String CourseInstructorOf;
    private String Registion_NO;
    private String Specialization;
    protected class Teacher_Assistant
    {
        public void Teacher_TA()
        {
            System.out.println("I am Non_Static Nested Inner Class");
        }
    }


    public Faculty(){};
    public Faculty(String name1,int cn,int age1,String CI,String Reg,String Spec)
    {

        super(name1,cn,age1);
        CourseInstructorOf=CI;
        Registion_NO=Reg;
        Specialization=Spec;



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
        System.out.println("Teacher is married");
    }

    @Override
    public void profession()
    {
        System.out.println("Teacher is Computer Scientics");
    }

    @Override
    public void previous_experience()
    {
        System.out.println("Teacher have some Experience");
    }

    @Override
    void Print()
    {

        System.out.println("Teacher Name : "+ getNmae());
        System.out.println("CourseInstructorOf : "+CourseInstructorOf );
        System.out.println("Teacher CNIC : "+ getCnic());
        System.out.println("Teacher Age : "+ getAge());
        System.out.println("Teacher Registion_NO : "+ Registion_NO);
        System.out.println("Teacher Specialization : "+ Specialization);
        merryStatus();
        profession();

    }
}


