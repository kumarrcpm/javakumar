//Constructor OverLoading
//===================================
public class RationShop
{
String name, pongalparisu;
int rice,sugar,oil;
public static void main(String [] args)
{
RationShop kumar = new RationShop("kumar","done",20,2,1);
RationShop ram = new RationShop("ram","notdone",10,2);
RationShop ramar = new RationShop("ramar","done",1);
kumar.january();
ram.january();
ramar.january();
}
public void january()
{
}
RationShop(String name, String pongalparisu, int rice, int sugar, int oil)
{
	this.name=name;
	this.pongalparisu=pongalparisu;
	this.rice=rice;
	this.sugar=sugar;
	this.oil=oil;
	System.out.println("Beneficiary Name is "+name);
	System.out.println("Pongal Special Items "+pongalparisu);
	System.out.println("January Month Rice "+rice);
	System.out.println("January Month Sugar "+sugar);
	System.out.println("January Month oil "+oil);
}
RationShop(String name, String pongalparisu, int rice, int oil)
{
	this.name=name;
	this.pongalparisu=pongalparisu;
	this.rice=rice;
	this.oil=oil;
	System.out.println("Beneficiary Name is "+name);
	System.out.println("Pongal Special Items "+pongalparisu);
	System.out.println("January Month Rice "+rice);
	System.out.println("January Month oil "+oil);
}
RationShop(String name, String pongalparisu, int oil)
{
	this.name=name;
	this.oil=oil;
	this.pongalparisu=pongalparisu;
	System.out.println("Beneficiary Name is "+name);
	System.out.println("Pongal Special Items "+pongalparisu);
	System.out.println("January Month oil "+oil);
}
}