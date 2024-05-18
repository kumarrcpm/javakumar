import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Premium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Premium user = new Premium();
		// user.premiumCalculation();
		//user.premiumCalculation1();
		user.premiumCal();
		
	}

	private void premiumCal() {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Select Your Sum Insured Amount");
		Double sumInsuredAmount = sc.nextDouble();
		Double sumInsuredPercentage =0D; 
		Double sumInsuredAmountPer=0D; 
		if(sumInsuredAmount >10000)
		{
			sumInsuredPercentage = 10D;
			System.out.println("Your Sum Insured Percentage is 10%");
			sumInsuredAmountPer = (sumInsuredAmount * sumInsuredPercentage) / 100;
			System.out.println("Your Sum Insured Amount Percentage is "+sumInsuredAmountPer);
			String age= sc.next("dd/MM/yyyy");
			String vehicleAge= sdf.format(age);
		}
		else if(	sumInsuredAmount <100001 &&sumInsuredAmount >=20000)	{
			sumInsuredPercentage = 20D;
			System.out.println("Your Sum Insured Percentage is 20%");			
			sumInsuredAmountPer = (sumInsuredAmount * sumInsuredPercentage) / 100;
			System.out.println("Your Sum Insured Amount Percentage is "+sumInsuredAmountPer);

		}
		else if (sumInsuredAmount <=200001 &&sumInsuredAmount >=50000)
		{
			sumInsuredPercentage = 30D;
			System.out.println("Your Sum Insured Percentage is 30%");			
			sumInsuredAmountPer = (sumInsuredAmount * sumInsuredPercentage) / 100;
			System.out.println("Your Sum Insured Amount Percentage is "+sumInsuredAmountPer);

		}

	}

	private void premiumCalculation1() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Select Your Sum Insured Amount");
		System.out.println("1. 1 to 100000 // 2. 100001 to 200000 // 3. 200001 to 500000");
		int sumInsured = sc.nextInt();
		int sumInsuredPercentage = 0;
		int sumInsuredAmount = 0;
		int amount = 0;
		if (sumInsured == 1) {
			sumInsuredPercentage = 10;
			System.out.println("Your Sum Insured Percentage is 10%");
			System.out.println("Enter Your Amount");
			amount = sc.nextInt();
			sumInsuredAmount = (amount * sumInsuredPercentage) / 100;
			System.out.println("10% Amount is " + sumInsuredAmount);
			System.out.println("Enter Vehicle Age");
			System.out.println("1. 0 to 1 // 2. 2 to 5 // 3. 6 to 10");
			int vehicleAge = sc.nextInt();
			int vehiclePercentage = 0;
			if (vehicleAge == 1) {
				vehiclePercentage = 1;
				System.out.println("Your Vehicle Percentage is 1%");
				System.out.println("Enter Driver Age");
				System.out.println("1. 18 to 25 // 2. 26 to 40 ");
				int driverAge = sc.nextInt();
				double driverAgePercentage = 0;
				if (driverAge == 1) {
					driverAgePercentage = 10;
					System.out.println("Your Driver Age Percentage Percentage is 10%");
					System.out.println("Please Select Vehicle Body Type");
					System.out.println("1. Saloon // 2. Four Wheel // 3. Sports Type ");
					int vehicleType = sc.nextInt();
					double vehicleTypePercentage = 0;
					double dap = 0, vp = 0, sip = 0;
					Double totalPercentage = 0D;
					Double totalAmount = 0D;
					if (vehicleType == 1) {
						vehicleTypePercentage = 1.5;
						System.out.println("Your Vehicle Type Rate is 1.5");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else if (vehicleType == 2) {
						vehicleTypePercentage = 2;
						System.out.println("Your Vehicle Type Rate is 2");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else if (vehicleType == 3) {
						vehicleTypePercentage = 3;
						System.out.println("Your Vehicle Type Rate is 3");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else
						System.out.println("Please Enter Correct Vehicle Type");
				} else if (driverAge == 2) {
					driverAgePercentage = 5;
					System.out.println("Your Driver Age Percentage Percentage is 5%");
					System.out.println("Please Select Vehicle Body Type");
					System.out.println("1. Saloon // 2. Four Wheel // 3. Sports Type ");
					int vehicleType = sc.nextInt();
					double vehicleTypePercentage = 0;
					double dap = 0, vp = 0, sip = 0;
					Double totalPercentage = 0D;
					Double totalAmount = 0D;
					if (vehicleType == 1) {
						vehicleTypePercentage = 1.5;
						System.out.println("Your Vehicle Type Rate is 1.5");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else if (vehicleType == 2) {
						vehicleTypePercentage = 2;
						System.out.println("Your Vehicle Type Rate is 2");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else if (vehicleType == 3) {
						vehicleTypePercentage = 3;
						System.out.println("Your Vehicle Type Rate is 3");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else
						System.out.println("Please Enter Correct Vehicle Type");
				}

			} else if (vehicleAge == 2) {
				vehiclePercentage = 10;
				System.out.println("Your Vehicle Percentage is 10%");
				System.out.println("Enter Driver Age");
				System.out.println("1. 18 to 25 // 2. 26 to 40 ");
				int driverAge = sc.nextInt();
				double driverAgePercentage = 0;
				if (driverAge == 1) {
					driverAgePercentage = 10;
					System.out.println("Your Driver Age Percentage Percentage is 10%");
					System.out.println("Please Select Vehicle Body Type");
					System.out.println("1. Saloon // 2. Four Wheel // 3. Sports Type ");
					int vehicleType = sc.nextInt();
					double vehicleTypePercentage = 0;
					double dap = 0, vp = 0, sip = 0;
					Double totalPercentage = 0D;
					Double totalAmount = 0D;
					if (vehicleType == 1) {
						vehicleTypePercentage = 1.5;
						System.out.println("Your Vehicle Type Rate is 1.5");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else if (vehicleType == 2) {
						vehicleTypePercentage = 2;
						System.out.println("Your Vehicle Type Rate is 2");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else if (vehicleType == 3) {
						vehicleTypePercentage = 3;
						System.out.println("Your Vehicle Type Rate is 3");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else
						System.out.println("Please Enter Correct Vehicle Type");
				} else if (driverAge == 2) {
					driverAgePercentage = 5;
					System.out.println("Your Driver Age Percentage Percentage is 5%");
					System.out.println("Please Select Vehicle Body Type");
					System.out.println("1. Saloon // 2. Four Wheel // 3. Sports Type ");
					int vehicleType = sc.nextInt();
					double vehicleTypePercentage = 0;
					double dap = 0, vp = 0, sip = 0;
					Double totalPercentage = 0D;
					Double totalAmount = 0D;
					if (vehicleType == 1) {
						vehicleTypePercentage = 1.5;
						System.out.println("Your Vehicle Type Rate is 1.5");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else if (vehicleType == 2) {
						vehicleTypePercentage = 2;
						System.out.println("Your Vehicle Type Rate is 2");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else if (vehicleType == 3) {
						vehicleTypePercentage = 3;
						System.out.println("Your Vehicle Type Rate is 3");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else
						System.out.println("Please Enter Correct Vehicle Type");
				}

			} else if (vehicleAge == 3) {
				vehiclePercentage = 25;
				System.out.println("Your Vehicle Percentage is 25%");
				System.out.println("Enter Driver Age");
				System.out.println("1. 18 to 25 // 2. 26 to 40 ");
				int driverAge = sc.nextInt();
				double driverAgePercentage = 0;
				if (driverAge == 1) {
					driverAgePercentage = 10;
					System.out.println("Your Driver Age Percentage Percentage is 10%");
					System.out.println("Please Select Vehicle Body Type");
					System.out.println("1. Saloon // 2. Four Wheel // 3. Sports Type ");
					int vehicleType = sc.nextInt();
					double vehicleTypePercentage = 0;
					double dap = 0, vp = 0, sip = 0;
					Double totalPercentage = 0D;
					Double totalAmount = 0D;
					if (vehicleType == 1) {
						vehicleTypePercentage = 1.5;
						System.out.println("Your Vehicle Type Rate is 1.5");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else if (vehicleType == 2) {
						vehicleTypePercentage = 2;
						System.out.println("Your Vehicle Type Rate is 2");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else if (vehicleType == 3) {
						vehicleTypePercentage = 3;
						System.out.println("Your Vehicle Type Rate is 3");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else
						System.out.println("Please Enter Correct Vehicle Type");
				} else if (driverAge == 2) {
					driverAgePercentage = 5;
					System.out.println("Your Driver Age Percentage Percentage is 5%");
					System.out.println("Please Select Vehicle Body Type");
					System.out.println("1. Saloon // 2. Four Wheel // 3. Sports Type ");
					int vehicleType = sc.nextInt();
					double vehicleTypePercentage = 0;
					double dap = 0, vp = 0, sip = 0;
					Double totalPercentage = 0D;
					Double totalAmount = 0D;
					if (vehicleType == 1) {
						vehicleTypePercentage = 1.5;
						System.out.println("Your Vehicle Type Rate is 1.5");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else if (vehicleType == 2) {
						vehicleTypePercentage = 2;
						System.out.println("Your Vehicle Type Rate is 2");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else if (vehicleType == 3) {
						vehicleTypePercentage = 3;
						System.out.println("Your Vehicle Type Rate is 3");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else
						System.out.println("Please Enter Correct Vehicle Type");
				}

			}

		} else if (sumInsured == 2) {
			sumInsuredPercentage = 20;
			System.out.println("Your Sum Insured Percentage is 20%");
			System.out.println("Enter Your Amount");
			amount = sc.nextInt();
			sumInsuredAmount = (amount * sumInsuredPercentage) / 100;
			System.out.println("20% Amount is " + sumInsuredAmount);
			sumInsuredPercentage = 10;
			System.out.println("Your Sum Insured Percentage is 10%");
			System.out.println("Enter Your Amount");
			amount = sc.nextInt();
			sumInsuredAmount = (amount * sumInsuredPercentage) / 100;
			System.out.println("10% Amount is " + sumInsuredAmount);
			System.out.println("Enter Vehicle Age");
			System.out.println("1. 0 to 1 // 2. 2 to 5 // 3. 6 to 10");
			int vehicleAge = sc.nextInt();
			int vehiclePercentage = 0;
			if (vehicleAge == 1) {
				vehiclePercentage = 1;
				System.out.println("Your Vehicle Percentage is 1%");
				System.out.println("Enter Driver Age");
				System.out.println("1. 18 to 25 // 2. 26 to 40 ");
				int driverAge = sc.nextInt();
				double driverAgePercentage = 0;
				if (driverAge == 1) {
					driverAgePercentage = 10;
					System.out.println("Your Driver Age Percentage Percentage is 10%");
					System.out.println("Please Select Vehicle Body Type");
					System.out.println("1. Saloon // 2. Four Wheel // 3. Sports Type ");
					int vehicleType = sc.nextInt();
					double vehicleTypePercentage = 0;
					double dap = 0, vp = 0, sip = 0;
					Double totalPercentage = 0D;
					Double totalAmount = 0D;
					if (vehicleType == 1) {
						vehicleTypePercentage = 1.5;
						System.out.println("Your Vehicle Type Rate is 1.5");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else if (vehicleType == 2) {
						vehicleTypePercentage = 2;
						System.out.println("Your Vehicle Type Rate is 2");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else if (vehicleType == 3) {
						vehicleTypePercentage = 3;
						System.out.println("Your Vehicle Type Rate is 3");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else
						System.out.println("Please Enter Correct Vehicle Type");
				} else if (driverAge == 2) {
					driverAgePercentage = 5;
					System.out.println("Your Driver Age Percentage Percentage is 5%");
					System.out.println("Please Select Vehicle Body Type");
					System.out.println("1. Saloon // 2. Four Wheel // 3. Sports Type ");
					int vehicleType = sc.nextInt();
					double vehicleTypePercentage = 0;
					double dap = 0, vp = 0, sip = 0;
					Double totalPercentage = 0D;
					Double totalAmount = 0D;
					if (vehicleType == 1) {
						vehicleTypePercentage = 1.5;
						System.out.println("Your Vehicle Type Rate is 1.5");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else if (vehicleType == 2) {
						vehicleTypePercentage = 2;
						System.out.println("Your Vehicle Type Rate is 2");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else if (vehicleType == 3) {
						vehicleTypePercentage = 3;
						System.out.println("Your Vehicle Type Rate is 3");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else
						System.out.println("Please Enter Correct Vehicle Type");
				}

			} else if (vehicleAge == 2) {
				vehiclePercentage = 10;
				System.out.println("Your Vehicle Percentage is 10%");
				System.out.println("Enter Driver Age");
				System.out.println("1. 18 to 25 // 2. 26 to 40 ");
				int driverAge = sc.nextInt();
				double driverAgePercentage = 0;
				if (driverAge == 1) {
					driverAgePercentage = 10;
					System.out.println("Your Driver Age Percentage Percentage is 10%");
					System.out.println("Please Select Vehicle Body Type");
					System.out.println("1. Saloon // 2. Four Wheel // 3. Sports Type ");
					int vehicleType = sc.nextInt();
					double vehicleTypePercentage = 0;
					double dap = 0, vp = 0, sip = 0;
					Double totalPercentage = 0D;
					Double totalAmount = 0D;
					if (vehicleType == 1) {
						vehicleTypePercentage = 1.5;
						System.out.println("Your Vehicle Type Rate is 1.5");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else if (vehicleType == 2) {
						vehicleTypePercentage = 2;
						System.out.println("Your Vehicle Type Rate is 2");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else if (vehicleType == 3) {
						vehicleTypePercentage = 3;
						System.out.println("Your Vehicle Type Rate is 3");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else
						System.out.println("Please Enter Correct Vehicle Type");
				} else if (driverAge == 2) {
					driverAgePercentage = 5;
					System.out.println("Your Driver Age Percentage Percentage is 5%");
					System.out.println("Please Select Vehicle Body Type");
					System.out.println("1. Saloon // 2. Four Wheel // 3. Sports Type ");
					int vehicleType = sc.nextInt();
					double vehicleTypePercentage = 0;
					double dap = 0, vp = 0, sip = 0;
					Double totalPercentage = 0D;
					Double totalAmount = 0D;
					if (vehicleType == 1) {
						vehicleTypePercentage = 1.5;
						System.out.println("Your Vehicle Type Rate is 1.5");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else if (vehicleType == 2) {
						vehicleTypePercentage = 2;
						System.out.println("Your Vehicle Type Rate is 2");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else if (vehicleType == 3) {
						vehicleTypePercentage = 3;
						System.out.println("Your Vehicle Type Rate is 3");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else
						System.out.println("Please Enter Correct Vehicle Type");
				}

			} else if (vehicleAge == 3) {
				vehiclePercentage = 25;
				System.out.println("Your Vehicle Percentage is 25%");
				System.out.println("Enter Driver Age");
				System.out.println("1. 18 to 25 // 2. 26 to 40 ");
				int driverAge = sc.nextInt();
				double driverAgePercentage = 0;
				if (driverAge == 1) {
					driverAgePercentage = 10;
					System.out.println("Your Driver Age Percentage Percentage is 10%");
					System.out.println("Please Select Vehicle Body Type");
					System.out.println("1. Saloon // 2. Four Wheel // 3. Sports Type ");
					int vehicleType = sc.nextInt();
					double vehicleTypePercentage = 0;
					double dap = 0, vp = 0, sip = 0;
					Double totalPercentage = 0D;
					Double totalAmount = 0D;
					if (vehicleType == 1) {
						vehicleTypePercentage = 1.5;
						System.out.println("Your Vehicle Type Rate is 1.5");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else if (vehicleType == 2) {
						vehicleTypePercentage = 2;
						System.out.println("Your Vehicle Type Rate is 2");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else if (vehicleType == 3) {
						vehicleTypePercentage = 3;
						System.out.println("Your Vehicle Type Rate is 3");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else
						System.out.println("Please Enter Correct Vehicle Type");
				} else if (driverAge == 2) {
					driverAgePercentage = 5;
					System.out.println("Your Driver Age Percentage Percentage is 5%");
					System.out.println("Please Select Vehicle Body Type");
					System.out.println("1. Saloon // 2. Four Wheel // 3. Sports Type ");
					int vehicleType = sc.nextInt();
					double vehicleTypePercentage = 0;
					double dap = 0, vp = 0, sip = 0;
					Double totalPercentage = 0D;
					Double totalAmount = 0D;
					if (vehicleType == 1) {
						vehicleTypePercentage = 1.5;
						System.out.println("Your Vehicle Type Rate is 1.5");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else if (vehicleType == 2) {
						vehicleTypePercentage = 2;
						System.out.println("Your Vehicle Type Rate is 2");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else if (vehicleType == 3) {
						vehicleTypePercentage = 3;
						System.out.println("Your Vehicle Type Rate is 3");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else
						System.out.println("Please Enter Correct Vehicle Type");
				}

			}

		} else if (sumInsured == 3) {
			sumInsuredPercentage = 30;
			System.out.println("Your Sum Insured Percentage is 30%");
			System.out.println("Enter Your Amount");
			amount = sc.nextInt();
			sumInsuredAmount = (amount * sumInsuredPercentage) / 100;
			System.out.println("30% Amount is " + sumInsuredAmount);
			sumInsuredPercentage = 10;
			System.out.println("Your Sum Insured Percentage is 10%");
			System.out.println("Enter Your Amount");
			amount = sc.nextInt();
			sumInsuredAmount = (amount * sumInsuredPercentage) / 100;
			System.out.println("10% Amount is " + sumInsuredAmount);
			System.out.println("Enter Vehicle Age");
			System.out.println("1. 0 to 1 // 2. 2 to 5 // 3. 6 to 10");
			int vehicleAge = sc.nextInt();
			int vehiclePercentage = 0;
			if (vehicleAge == 1) {
				vehiclePercentage = 1;
				System.out.println("Your Vehicle Percentage is 1%");
				System.out.println("Enter Driver Age");
				System.out.println("1. 18 to 25 // 2. 26 to 40 ");
				int driverAge = sc.nextInt();
				double driverAgePercentage = 0;
				if (driverAge == 1) {
					driverAgePercentage = 10;
					System.out.println("Your Driver Age Percentage Percentage is 10%");
					System.out.println("Please Select Vehicle Body Type");
					System.out.println("1. Saloon // 2. Four Wheel // 3. Sports Type ");
					int vehicleType = sc.nextInt();
					double vehicleTypePercentage = 0;
					double dap = 0, vp = 0, sip = 0;
					Double totalPercentage = 0D;
					Double totalAmount = 0D;
					if (vehicleType == 1) {
						vehicleTypePercentage = 1.5;
						System.out.println("Your Vehicle Type Rate is 1.5");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else if (vehicleType == 2) {
						vehicleTypePercentage = 2;
						System.out.println("Your Vehicle Type Rate is 2");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else if (vehicleType == 3) {
						vehicleTypePercentage = 3;
						System.out.println("Your Vehicle Type Rate is 3");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else
						System.out.println("Please Enter Correct Vehicle Type");
				} else if (driverAge == 2) {
					driverAgePercentage = 5;
					System.out.println("Your Driver Age Percentage Percentage is 5%");
					System.out.println("Please Select Vehicle Body Type");
					System.out.println("1. Saloon // 2. Four Wheel // 3. Sports Type ");
					int vehicleType = sc.nextInt();
					double vehicleTypePercentage = 0;
					double dap = 0, vp = 0, sip = 0;
					Double totalPercentage = 0D;
					Double totalAmount = 0D;
					if (vehicleType == 1) {
						vehicleTypePercentage = 1.5;
						System.out.println("Your Vehicle Type Rate is 1.5");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else if (vehicleType == 2) {
						vehicleTypePercentage = 2;
						System.out.println("Your Vehicle Type Rate is 2");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else if (vehicleType == 3) {
						vehicleTypePercentage = 3;
						System.out.println("Your Vehicle Type Rate is 3");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else
						System.out.println("Please Enter Correct Vehicle Type");
				}

			} else if (vehicleAge == 2) {
				vehiclePercentage = 10;
				System.out.println("Your Vehicle Percentage is 10%");
				System.out.println("Enter Driver Age");
				System.out.println("1. 18 to 25 // 2. 26 to 40 ");
				int driverAge = sc.nextInt();
				double driverAgePercentage = 0;
				if (driverAge == 1) {
					driverAgePercentage = 10;
					System.out.println("Your Driver Age Percentage Percentage is 10%");
					System.out.println("Please Select Vehicle Body Type");
					System.out.println("1. Saloon // 2. Four Wheel // 3. Sports Type ");
					int vehicleType = sc.nextInt();
					double vehicleTypePercentage = 0;
					double dap = 0, vp = 0, sip = 0;
					Double totalPercentage = 0D;
					Double totalAmount = 0D;
					if (vehicleType == 1) {
						vehicleTypePercentage = 1.5;
						System.out.println("Your Vehicle Type Rate is 1.5");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else if (vehicleType == 2) {
						vehicleTypePercentage = 2;
						System.out.println("Your Vehicle Type Rate is 2");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else if (vehicleType == 3) {
						vehicleTypePercentage = 3;
						System.out.println("Your Vehicle Type Rate is 3");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else
						System.out.println("Please Enter Correct Vehicle Type");
				} else if (driverAge == 2) {
					driverAgePercentage = 5;
					System.out.println("Your Driver Age Percentage Percentage is 5%");
					System.out.println("Please Select Vehicle Body Type");
					System.out.println("1. Saloon // 2. Four Wheel // 3. Sports Type ");
					int vehicleType = sc.nextInt();
					double vehicleTypePercentage = 0;
					double dap = 0, vp = 0, sip = 0;
					Double totalPercentage = 0D;
					Double totalAmount = 0D;
					if (vehicleType == 1) {
						vehicleTypePercentage = 1.5;
						System.out.println("Your Vehicle Type Rate is 1.5");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else if (vehicleType == 2) {
						vehicleTypePercentage = 2;
						System.out.println("Your Vehicle Type Rate is 2");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else if (vehicleType == 3) {
						vehicleTypePercentage = 3;
						System.out.println("Your Vehicle Type Rate is 3");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else
						System.out.println("Please Enter Correct Vehicle Type");
				}

			} else if (vehicleAge == 3) {
				vehiclePercentage = 25;
				System.out.println("Your Vehicle Percentage is 25%");
				System.out.println("Enter Driver Age");
				System.out.println("1. 18 to 25 // 2. 26 to 40 ");
				int driverAge = sc.nextInt();
				double driverAgePercentage = 0;
				if (driverAge == 1) {
					driverAgePercentage = 10;
					System.out.println("Your Driver Age Percentage Percentage is 10%");
					System.out.println("Please Select Vehicle Body Type");
					System.out.println("1. Saloon // 2. Four Wheel // 3. Sports Type ");
					int vehicleType = sc.nextInt();
					double vehicleTypePercentage = 0;
					double dap = 0, vp = 0, sip = 0;
					Double totalPercentage = 0D;
					Double totalAmount = 0D;
					if (vehicleType == 1) {
						vehicleTypePercentage = 1.5;
						System.out.println("Your Vehicle Type Rate is 1.5");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else if (vehicleType == 2) {
						vehicleTypePercentage = 2;
						System.out.println("Your Vehicle Type Rate is 2");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else if (vehicleType == 3) {
						vehicleTypePercentage = 3;
						System.out.println("Your Vehicle Type Rate is 3");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else
						System.out.println("Please Enter Correct Vehicle Type");
				} else if (driverAge == 2) {
					driverAgePercentage = 5;
					System.out.println("Your Driver Age Percentage Percentage is 5%");
					System.out.println("Please Select Vehicle Body Type");
					System.out.println("1. Saloon // 2. Four Wheel // 3. Sports Type ");
					int vehicleType = sc.nextInt();
					double vehicleTypePercentage = 0;
					double dap = 0, vp = 0, sip = 0;
					Double totalPercentage = 0D;
					Double totalAmount = 0D;
					if (vehicleType == 1) {
						vehicleTypePercentage = 1.5;
						System.out.println("Your Vehicle Type Rate is 1.5");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else if (vehicleType == 2) {
						vehicleTypePercentage = 2;
						System.out.println("Your Vehicle Type Rate is 2");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else if (vehicleType == 3) {
						vehicleTypePercentage = 3;
						System.out.println("Your Vehicle Type Rate is 3");
						dap = (vehicleTypePercentage * driverAgePercentage) / 100;
						vp = (vehicleTypePercentage * vehiclePercentage) / 100;
						sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
						System.out.println("Driver Age Percentage Calculation is " + dap);
						System.out.println("Vehicle Percentage Calculation is " + vp);
						System.out.println("Sum Insured Percentage Calculation is " + sip);
						totalPercentage = vehicleTypePercentage + dap + vp + sip;
						System.out.println("Total Percentage Calculation is " + totalPercentage);
						totalAmount = totalPercentage * sumInsuredAmount;
						System.out.println("Total Insurance Policy Calculation is " + totalAmount);
					} else
						System.out.println("Please Enter Correct Vehicle Type");
				}

			}

		} else
			System.out.println("Please Enter Correct Sum Insured Policy");

	}

	private void premiumCalculation() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Select Your Sum Insured Amount");
		System.out.println("1. 1 to 100000 // 2. 100001 to 200000 // 3. 200001 to 500000");
		int sumInsured = sc.nextInt();
		int sumInsuredPercentage = 0;
		int sumInsuredAmount = 0;
		switch (sumInsured) {
		case 1:
			sumInsuredPercentage = 10;
			System.out.println("Your Sum Insured Percentage is 10%");
			System.out.println("Enter Your Amount");
			int amount = sc.nextInt();
			sumInsuredAmount = (amount * sumInsuredPercentage) / 100;
			System.out.println("10% Amount is " + sumInsuredAmount);
			break;

		case 2:
			sumInsuredPercentage = 20;
			System.out.println("Your Sum Insured Percentage is 20%");
			System.out.println("Enter Your Amount");
			amount = sc.nextInt();
			sumInsuredAmount = (amount * sumInsuredPercentage) / 100;
			System.out.println("20% Amount is " + sumInsuredAmount);
			break;

		case 3:
			sumInsuredPercentage = 30;
			System.out.println("Your Sum Insured Percentage is 30%");
			System.out.println("Enter Your Amount");
			amount = sc.nextInt();
			sumInsuredAmount = (amount * sumInsuredPercentage) / 100;
			System.out.println("30% Amount is " + sumInsuredAmount);
			break;
		default:
			System.out.println("Please Enter Correct Sum Insured Policy");

		}
		System.out.println("Enter Vehicle Age");
		System.out.println("1. 0 to 1 // 2. 2 to 5 // 3. 6 to 10");
		int vehicleAge = sc.nextInt();
		int vehiclePercentage = 0;

		switch (vehicleAge) {
		case 1:
			vehiclePercentage = 1;
			System.out.println("Your Vehicle Percentage is 1%");
			break;
		case 2:
			vehiclePercentage = 10;
			System.out.println("Your Vehicle Percentage is 10%");
			break;
		case 3:
			vehiclePercentage = 25;
			System.out.println("Your Vehicle Percentage is 25%");
			break;
		default:
			System.out.println("Please Enter Correct Vehicle Age");
		}
		System.out.println("Enter Driver Age");
		System.out.println("1. 18 to 25 // 2. 26 to 40 ");
		int driverAge = sc.nextInt();
		double driverAgePercentage = 0;
		switch (driverAge) {
		case 1:
			driverAgePercentage = 10;
			System.out.println("Your Driver Age Percentage Percentage is 10%");
			break;
		case 2:
			driverAgePercentage = 5;
			System.out.println("Your Driver Age Percentage Percentage is 5%");
			break;
		default:
			System.out.println("Please Enter Correct Vehicle Age");
		}
		System.out.println("Please Select Vehicle Body Type");
		System.out.println("1. Saloon // 2. Four Wheel // 3. Sports Type ");
		int vehicleType = sc.nextInt();
		switch (vehicleType) {
		case 1:
			double vehicleTypePercentage = 1.5;
			System.out.println("Your Vehicle Type Rate is 1.5");
			double dap = (vehicleTypePercentage * driverAgePercentage) / 100;
			double vp = (vehicleTypePercentage * vehiclePercentage) / 100;
			double sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
			System.out.println("Driver Age Percentage Calculation is " + dap);
			System.out.println("Vehicle Percentage Calculation is " + vp);
			System.out.println("Sum Insured Percentage Calculation is " + sip);
			Double totalPercentage = vehicleTypePercentage + dap + vp + sip;
			System.out.println("Total Percentage Calculation is " + totalPercentage);
			Double totalAmount = totalPercentage * sumInsuredAmount;
			System.out.println("Total Insurance Policy Calculation is " + totalAmount);
			break;
		case 2:
			vehicleTypePercentage = 2;
			System.out.println("Your Vehicle Type Rate is 2");
			dap = (vehicleTypePercentage * driverAgePercentage) / 100;
			vp = (vehicleTypePercentage * vehiclePercentage) / 100;
			sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
			System.out.println("Driver Age Percentage Calculation is " + dap);
			System.out.println("Vehicle Percentage Calculation is " + vp);
			System.out.println("Sum Insured Percentage Calculation is " + sip);
			totalPercentage = vehicleTypePercentage + dap + vp + sip;
			System.out.println("Total Percentage Calculation is " + totalPercentage);
			totalAmount = totalPercentage * sumInsuredAmount;
			System.out.println("Total Insurance Policy Calculation is " + totalAmount);
			break;
		case 3:
			vehicleTypePercentage = 3;
			System.out.println("Your Vehicle Type Rate is 3");
			dap = (vehicleTypePercentage * driverAgePercentage) / 100;
			vp = (vehicleTypePercentage * vehiclePercentage) / 100;
			sip = (vehicleTypePercentage * sumInsuredPercentage) / 100;
			System.out.println("Driver Age Percentage Calculation is " + dap);
			System.out.println("Vehicle Percentage Calculation is " + vp);
			System.out.println("Sum Insured Percentage Calculation is " + sip);
			totalPercentage = vehicleTypePercentage + dap + vp + sip;
			System.out.println("Total Percentage Calculation is " + totalPercentage);
			totalAmount = totalPercentage * sumInsuredAmount;
			System.out.println("Total Insurance Policy Calculation is " + totalAmount);
			break;
		default:
			System.out.println("Please Enter Correct Vehicle Type");
		}
	}

}