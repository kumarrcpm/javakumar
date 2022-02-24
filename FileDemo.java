package fileReading;

import java.io.File;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
File f = new File("/home/kumar/Documents/B18/kumar.txt");
try
{
	f.createNewFile();
	System.out.println(f.exists());
	f.delete();
	System.out.println(f.exists());
	f.createNewFile();
	System.out.println(f.getAbsolutePath());
	System.out.println(f.getCanonicalPath());
	System.out.println(f.canRead());
	System.out.println(f.getName());
f = new File("/home/kumar/Documents/B18/kumar");
f.mkdir();
f = new File("/home/kumar/Documents/B18/kumar/ram");
f.mkdirs();
f = new File("/home/kumar/Documents/B18");
//String[] s = f.list();
//for(String ss:s)
//{//
//	System.out.println(ss);
//}

File[] ff = f.listFiles();
int count=0;
for(File file:ff)
{
//	if(file.isDirectory());
//	System.out.println(file);
	if(file.isFile())
	{
	String name = file.getName();	
	if(name.endsWith(".java"))
	System.out.println(name);
	count++;
	}
}
System.out.println("no of counts "+count);

}
catch(IOException e)
{
	e.printStackTrace();
}
	}

}
