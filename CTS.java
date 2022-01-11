//Super Keyword
//=============================================

package us; 
public class CTS 
{
public String head; 
public CTS()
{
System.out.println("US CTS");
}
public CTS(int i)
{
System.out.println("From Parent" + i);
}
public static void main(String[] args)
{
CTS emp = new CTS(); 
emp.head = "Abcd"; 
System.out.println(emp.head); 
}
public void recruit()
{
System.out.println("US Recruitment");
}
}
//super - instance of super class