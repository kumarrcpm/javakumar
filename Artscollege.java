package college;
import university.Engineering;
public class Artscollege extends Engineering
{
public String principal;
public static void main(String [] args)
{
Admission cse = new Admission();
cse.principal="Ram";
cse.student();

}
public void student()
{
System.out.println(super.principal);
System.out.println(principal);
super.student();
}




}