public abstract class Person
{
    protected String Name;
    protected int Cnic;
    protected int Age;



    public Person(){};


    public Person(String name1,int cn,int age1)
    {
        Name=name1;
        Cnic=cn;
        Age=age1;

    }

    public String getNmae()
    {
        return Name;
    }

    public int getCnic()
    {
        return Cnic;
    }

    public int getAge()
    {
        return Age;
    }


    public abstract void setName(String name);
    public abstract void setCnic(int Cnic);
    public abstract void setAge(int Age);

    abstract void Print();
}

interface person_interface
{

    public void profession();
    public void merryStatus();

}

interface person_Detail
{
    public void previous_experience();
}
