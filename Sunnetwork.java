public class Sunnetwork implements Entertainment
{
public static void main(String [] args)
{
Sunnetwork sun = new Sunnetwork();
sun.serial();
sun.comedy();
sun.movie();
sun.news();
Entertainment md = new Sunnetwork();
md.serial();
md.comedy();
md.movie();
}
public void serial()
{
System.out.println("Evening 6 to 10 serial time");
}
public void comedy()
{
System.out.println("comedy is not in Sun TV, watch aditya for Comedy Shows");
}
public void movie()
{
System.out.println("Movie only weekends");
}
public void news()
{
System.out.println("News only on primetime 7.30AM & 6.00PM");
}
}