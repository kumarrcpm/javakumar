public class Calculator
{
public static void main(String [] args)
{
Calculator calc = new Calculator();
float output =calc.add();
calc.subtract(output,5);
System.out.println(output);
}
public void subtract(float no1, int no2)
{
System.out.println(no1);
System.out.println(no2);
System.out.println(no1-no2);
}
public float add ()
{
int no1=10;
float no2=15;
float result = no1+no2;
System.out.println(result);
return result;
}
}