package exceptionHandling;

public class PasswordException extends Exception{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void check (String s) throws PasswordException
	{
		System.out.println(s);
		int len = s.length();
		System.out.println(len);
		if(len<8)
		{
			PasswordException pe = new PasswordException();
			throw pe;
		}
	
	}

}
