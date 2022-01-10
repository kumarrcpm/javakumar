//Method Over Riding
//==================================================================================
package socialmedia;
public class Facebook extends Whatsapp
{
String name = "Fb";
public static void main (String [] args)
{
Facebook fbuser1 = new Facebook();
System.out.println(fbuser1.name);
fbuser1.accountCreation("Kumar",123);
fbuser1.accountCreation("Ram",422489248,123);
fbuser1.accountCreation("Kumar",422489248,123);
//fbuser1.accountCreation("Sweet Solutions",827732723,"chennai");
//int password = fbuser1.accountCreation("Ram",99999888,77770653,8971);
System.out.println(fbuser1.name);
//fbuser1.accountCreation();

}

public void accountCreation(String name,int password)
{
System.out.println("Name "+name+" Password "+password);
System.out.println("This is from child class");
}

//public void accountCreation(String name,long mobileno,String address)
{
//System.out.println("Name "+name+" Mobile No "+mobileno+" Password "+password);
//System.out.println("This is from child class");
}
//public void accountCreation()
{
//System.out.println("How I can change final method");
}
}



