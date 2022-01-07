package korea.south;
public class Desktop extends Samsung
{
public static void main(String [] args)
{
Desktop dt = new Desktop();
dt.makeQuality();
dt.giveWarranty();
//dt.research();
System.out.println(dt.pinno);
dt.changepin();
}
}