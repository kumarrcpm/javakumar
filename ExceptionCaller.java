package exceptionHandling;

public class ExceptionCaller {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
ExceptionDemo ed = new ExceptionDemo();
//ed.example3();
PasswordException pe = new PasswordException();
pe.check("kumarram");
	}

}
