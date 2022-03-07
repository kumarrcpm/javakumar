package generics;

public class Generic <T>{

	T obj;
	public Generic(T obj) {
		
		this.obj=obj;
	}
	public void display()
	{
		System.out.println(obj.getClass());
	}
}
