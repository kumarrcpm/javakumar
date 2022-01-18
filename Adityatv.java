public class Adityatv extends Sunnetwork implements Entertainment
{
public static void main (String [] args)
{
Adityatv aditya = new Adityatv();
aditya.serial();
aditya.comedy();
aditya.movie();
aditya.news();
}
public void serial()
{ 
System.out.println("Serial only in Sun TV");
}
public void comedy()
{
System.out.println("Aditya is a 24 hrs comedy channel");
}
public void movie()
{
System.out.println("Everyday afternoon one comedy movie");
}
public void news()
{
System.out.println("It is a comedy channel no news show. Watch 24 hrs sun news channel");
}


}