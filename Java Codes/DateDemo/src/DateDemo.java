import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

public class DateDemo {

	public static void main(String[] args) throws ParseException {
		/*
		 * SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); String a =
		 * sdf.format("07/12/2004"); SimpleDateFormat formatter = new
		 * SimpleDateFormat("yyyy-MM-dd"); String format = formatter.format(sdf);
		 * System.out.println(format);
		 */
	  
		/*
		 * DateTimeFormatter formatter =
		 * DateTimeFormatter.ofPattern("dd/MM/yyyy").withLocale(Locale.US);
		 * SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd"); SimpleDateFormat
		 * sdf2 = new SimpleDateFormat("dd/MM/yyyy"); Date dob =
		 * sdf1.parse("2004/12/09"); System.out.println(sdf2.format(dob)); Date today =
		 * new Date(); System.out.println(sdf2.format(today)); String a
		 * =sdf2.format(dob); String b = sdf2.format(today); Date c = sdf2.parse(a);
		 * Date d = sdf2.parse(b);
		 */
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		Date dob = new Date("2004/12/09");
		System.out.println(sdf1.format(dob)); 
		Date a = sdf1.parse(null);
	}

	
	}

	

