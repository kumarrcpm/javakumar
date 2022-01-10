//Constructor overloading and super command parent class for Arts.java
//====================================================================
package university;
public class Engineering
{
public Engineering()
{
System.out.println("This is parent class zero Argument constructor");
}
public Engineering(int totalStudents)
{
System.out.println(totalStudents + " This is parent class overloaded constructor");
}
public String principal;
public static void main(String [] args)
{
Engineering ece = new Engineering();
ece.principal = "Kumar";
System.out.println(ece.principal);
}
public void student()
{
System.out.println("Engineering College student");
}

}