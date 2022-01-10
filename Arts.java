//Child class for Engineering
//Super and super() keywords
//===================================================================================
package college;
import university.Engineering;
public class Arts extends Engineering
{
public Arts()
{
this(60);
System.out.println("This is child class zero argument constructor");
}
public Arts(int totalStudents)
{
super(totalStudents);
System.out.println(totalStudents + " This is child class overloaded constructor");

}
public String principal;
public static void main(String [] args)
{
Arts it = new Arts();
//Arts cse = new Arts(50);
//cse.principal="Ram";
//cse.student();
}
public void student()
{
System.out.println(super.principal);
System.out.println(principal);
super.student();
}

}