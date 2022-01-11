//superkeyword
//======================================

package chennai; 
import us.CTS; 	
public class CTSC extends CTS
{
public String head;
public CTSC()
{
this(500);
System.out.println("Chennai CTS");
}
public CTSC(int i)
{
super(i);
System.out.println(i);
}
public static void main(String[] args)
{
CTSC obj = new CTSC();
//CTSC emp = new CTSC(5); 
//emp.head = "Pqrs"; 
//emp.recruit(); 
}

public void recruit()
{
super.recruit();

System.out.println(super.head); 
System.out.println(head); 
}
} 