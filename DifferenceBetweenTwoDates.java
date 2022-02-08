package differenceBetweenTwoDates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DifferenceBetweenTwoDates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
LocalDate nowDate = LocalDate.now();
LocalDate pastDate=LocalDate.of(1947,8,15);
System.out.println("Years "+ChronoUnit.YEARS.between(pastDate, nowDate));
System.out.println("Months "+ChronoUnit.MONTHS.between(pastDate, nowDate));
System.out.println("Days "+ChronoUnit.DAYS.between(pastDate, nowDate));
LocalDateTime nowDateTime = LocalDateTime.now();
LocalDateTime pastDateTime = LocalDateTime.of(1947, 8, 15, 12, 0, 0);
System.out.println("Years "+ChronoUnit.YEARS.between(pastDateTime, nowDateTime));
System.out.println("Months "+ChronoUnit.MONTHS.between(pastDateTime, nowDateTime));
System.out.println("Days "+ChronoUnit.DAYS.between(pastDateTime, nowDateTime));
System.out.println("Hours "+ChronoUnit.HOURS.between(pastDateTime, nowDateTime));
System.out.println("Minutes "+ChronoUnit.MINUTES.between(pastDateTime, nowDateTime));
System.out.println("Seconds "+ChronoUnit.SECONDS.between(pastDateTime, nowDateTime));

	}

}
