package chennai;
import hometown.Parent;
public class Child extends Parent
{
public static void main (String[] args)
{

Child child = new Child();
System.out.println(child.name);
child.call();
child.giveSweets();
//Parent parent = new Parent();
//System.out.println(parent.name);
//parent.call();
	//parent.giveSweets();
}

}