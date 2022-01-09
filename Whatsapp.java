package socialmedia;
public class Whatsapp 
{
final String name = "Meta";
public static void main (String [] args)
{
Whatsapp member = new Whatsapp();
member.accountCreation("kumar",948278872,28);
member.accountCreation("Sweet Solutions",827732723,"Bangalore");
int password = member.accountCreation("Ram",99999888,77770653,8970);
member.moneytransfer(99999888,password);
member.accountCreation();
}
public void accountCreation(String name, long mobileno, int age)
{
System.out.println("This is normal Whatsapp Account");
System.out.println("Mobile Number "+mobileno + " Name "+ name+ " Age "+age);
System.out.println("Welcome to " + this.name+ " Family"+ " Share your happiness to your family,friends and relat with end to end encryption");
}
public final void accountCreation(String companyName, long mobileNo, String address)
{
System.out.println("This is "+companyName+" Business Account");
System.out.println("Mobile Number "+mobileNo + " Company Location "+address);
System.out.println("Welcome to "+this.name+" Family " + " We will help your Business Growth" );
}
private int accountCreation(String name, long mobileno, long cardnumber, int upipin)
{
System.out.println("This is your whatsapp payment Account");
System.out.println("Name " +name +" Mobile No " + mobileno +" Card Number " +cardnumber+" UPI PIN Number " + upipin);
System.out.println("Welcome to " + this.name+ " Family " +" This is very secure payment process");

return upipin;
}
public void moneytransfer(long mobileno, int password)
{
System.out.println("Your Mobile Number is "+mobileno);
System.out.println("Your UPI PIN is "+password);
System.out.println("Successfully logged in your whatsapp payment");
}
public final void accountCreation()
{
System.out.println("This is final");
}
}


