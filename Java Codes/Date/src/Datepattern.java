import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Datepattern {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		Datepattern date = new Datepattern();
		// date.checkinginrange();
		// date.checkinginrange1();
		// date.ageChecking();
		// date.yearsDifference();
		// date.ageDifference();
		// date.ageCalculator();
		// date.policySelection();
		// date.difference();
	}

	//// Finding Difference between two dates in year, mins
	private void difference() {
		LocalDate nowDate = LocalDate.now();
		LocalDate pastDate = LocalDate.of(1947, 8, 15);
		System.out.println("Difference in Years " + ChronoUnit.YEARS.between(pastDate, nowDate));
		System.out.println("Difference in Months " + ChronoUnit.MONTHS.between(pastDate, nowDate));
		System.out.println("Difference in Days " + ChronoUnit.DAYS.between(pastDate, nowDate));
		LocalDateTime nowDateTime = LocalDateTime.now();
		LocalDateTime pastDateTime = LocalDateTime.of(1947, 8, 15, 12, 0, 0);
		System.out.println("Difference in Years " + ChronoUnit.YEARS.between(pastDateTime, nowDateTime));
		System.out.println("Difference in Months " + ChronoUnit.MONTHS.between(pastDateTime, nowDateTime));
		System.out.println("Difference in Days " + ChronoUnit.DAYS.between(pastDateTime, nowDateTime));
		System.out.println("Difference in Hours " + ChronoUnit.HOURS.between(pastDateTime, nowDateTime));
		System.out.println("Difference in Minutes " + ChronoUnit.MINUTES.between(pastDateTime, nowDateTime));
		System.out.println("Difference in Seconds " + ChronoUnit.SECONDS.between(pastDateTime, nowDateTime));

	}

	/////////// Policy Range Selection
	private void policySelection() throws ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		Date startDate = sdf.parse("2022-01-01");
		System.out.println("startDate : " + sdf2.format(startDate));
		System.out.println("Please Select Your Policy");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Policy Type");
		System.out.println("1 . Three Month Policy ");
		System.out.println("2 . Six Month Policy ");
		System.out.println("3 . One Year Month Policy ");
		int policyRange = sc.nextInt();
		switch (policyRange) {
		case 1:
			System.out.println("You are Selected Three month Policy");
			System.out.println("Your Policy Start Date = " + sdf2.format(startDate));
			LocalDate endDate = LocalDate.of(2022, 01, 01).plusMonths(3);
			Date date = Date.from(endDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
			System.out.println("Your Policy End Date is " + sdf2.format(date));
			break;
		case 2:
			System.out.println("You are Selected Six month Policy");
			System.out.println("Your Policy Start Date = " + sdf2.format(startDate));
			LocalDate endDate1 = LocalDate.of(2022, 01, 01).plusMonths(6);
			Date date1 = Date.from(endDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
			System.out.println("Your Policy End Date is " + sdf2.format(date1));
			break;
		case 3:
			System.out.println("You are Selected One year Policy");
			System.out.println("Your Policy Start Date = " + sdf2.format(startDate));
			LocalDate endDate11 = LocalDate.of(2022, 01, 01).plusMonths(12);
			Date date11 = Date.from(endDate11.atStartOfDay(ZoneId.systemDefault()).toInstant());
			System.out.println("Your Policy End Date is " + sdf2.format(date11));
			break;
		default:
			System.out.println("Please select correct Policy");
			break;
		}
	}

	/////// Policy Start Date, End Date, Accident Date, Claim Date
	private void checkinginrange() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		Date startDate = sdf.parse("2022-01-01");
		Date endDate = sdf.parse("2022-12-25");
		System.out.println("startDate : " + sdf2.format(startDate));
		System.out.println("endDate : " + sdf2.format(endDate));
		Date accidentDate = sdf.parse("2022-01-15");
		System.out.println("accidentDate : " + sdf2.format(accidentDate));
		if (accidentDate.after(startDate) && accidentDate.before(endDate)) {
			System.out
					.println("Accident Date is within the policy range, so you are eligible for your insurance policy");
		} else {
			System.out.println(
					"Accident Date is not within the policy range, so you are not eligible for your insurance policy");
		}
		Date claimDate = sdf.parse("2022-12-11");
		System.out.println("claimDate :" + sdf2.format(claimDate));
		if (claimDate.after(accidentDate)) {
			System.out.println("You are eligible for insurance");
		} else
			System.out
					.println("You are not eligible for insurance because your claim date is before your accident date");
		long daysBetween = accidentDate.getTime() - startDate.getTime();
		System.out.println("Number of Days between Policy Start Date and Accident Date = "
				+ TimeUnit.DAYS.convert(daysBetween, TimeUnit.MILLISECONDS));
		long a = TimeUnit.DAYS.convert(daysBetween, TimeUnit.MILLISECONDS);
		if (a > 30) {
			System.out.println(
					"No of days between Policy Date and Accident Date is more than 30 Days, so you are eligible for your insurance policy");
		} else
			System.out.println(
					"No of days between Policy Date and Accident Date is less than 30 Days, so you are not eligible for your insurance policy");

	}

	////// Age Difference Calculator
	private void ageCalculator() throws ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date d = sdf.parse("07/10/2006");
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int date = c.get(Calendar.DATE);
		LocalDate l1 = LocalDate.of(year, month, date);
		LocalDate now1 = LocalDate.now();
		Period diff1 = Period.between(l1, now1);

		if (diff1.getYears() > 18) {
			System.out.println("You are  Eligible for this policy");
		} else
			System.out.println("You are not  Eligible for this policy");
	}

	private void ageDifference() {
		// TODO Auto-generated method stub
		LocalDate date1 = LocalDate.parse("1997-04-28");
		LocalDate date2 = LocalDate.parse("2022-04-15");
		Period period = date1.until(date2);
		int ageDifference = period.getYears();
		System.out.println("yearsBetween:" + ageDifference);
		if (ageDifference > 18)
			System.out.println("You are eligible for applying this policy");
		else
			System.out.println("You are not eligible for applying this policy");
	}

	private void yearsDifference() throws ParseException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy").withLocale(Locale.US);
		LocalDate dateOfBirth = LocalDate.parse("01/09/1995", formatter);
		LocalDate endDate = LocalDate.parse("15/04/2022", formatter);
		Period period = Period.between(dateOfBirth, endDate);
		// System.out.println(String.format("No Of Years : %d Years, \nNo Of Months : %d
		// Months, \nNo Of Days : %d Days, ",
		// period.getYears(), period.getMonths(), period.getDays()));
		String age = (String.format("No Of Years : %d Years", period.getYears()));
		System.out.println(age);
		int i = Integer.parseInt(age);
		if (i > 18) {
			System.out.println("You are eligible for this Insurance Policy");
		} else
			System.out.println("You are not eligible for this Insurance Policy");
		
		
	}

	private void ageChecking() throws ParseException {
		// TODO Auto-generated method stub
		Date today = new Date();
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		// Date dateOfBirth = sdf2.parse("07/10/1996");
		LocalDate nowDate = LocalDate.now();
		LocalDate dateOfBirth = LocalDate.of(1996, 10, 07);
		System.out.println("Years " + ChronoUnit.YEARS.between(dateOfBirth, nowDate));
		long yearsDifference = ChronoUnit.YEARS.between(dateOfBirth, nowDate);
		if (yearsDifference > 18)
			System.out.println("You are eligible for this Insurance Policy");
		else
			System.out.println("You are not eligible for this Insurance Policy");
		
	}

	// private Temporal startDate;
	// private Temporal accidentDate;

	/*
	 * private void checkinginrange1() throws ParseException {
	 * 
	 * SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
	 * 
	 * Scanner sc = new Scanner(System.in);
	 * System.out.println("Enter Policy Start Date Example :dd/mm/yyyy"); String
	 * startDate = sc.next(); // String endDate = sc.next(); try { Date sd =
	 * sdf2.parse(startDate); } catch(Exception e) {
	 * System.out.println("Please Enter Valid Date Format Example :dd/mm/yyyy");
	 * startDate = sc.next(); Date sd = sdf2.parse(startDate); }
	 * 
	 * System.out.println("Enter Policy End Date Example :dd/mm/yyyy"); String
	 * endDate = sc.next(); try { Date ed = sdf2.parse(endDate); } catch(Exception
	 * e) {
	 * System.out.println("Please Enter Valid Date Format Example :dd/mm/yyyy");
	 * endDate = sc.next(); Date ed = sdf2.parse(endDate);
	 * 
	 * }
	 * 
	 * //Comparing start date and end date
	 * 
	 * SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	 * ///SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy"); //Date
	 * startDate = sdf.parse("2022-01-02"); //Date endDate =
	 * sdf.parse("2022-12-25");
	 * 
	 * System.out.println("startDate : " + sdf2.format(startDate)); //
	 * System.out.println("endDate : " + sdf2.format(endDate));
	 * 
	 * Date testDate = sdf.parse("2022-01-01"); System.out.println("testDate : " +
	 * sdf2.format(testDate));
	 * 
	 * // if (testDate.after(startDate) && testDate.before(endDate)) { //
	 * System.out.println("testDate is within the date range."); // } else { //
	 * System.out.println("testDate is NOT within the date range."); // }
	 * 
	 * }
	 * 
	 */

	
}
