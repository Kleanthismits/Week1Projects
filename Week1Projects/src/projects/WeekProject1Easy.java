package projects;


import java.util.Scanner;

public class WeekProject1Easy {

	public static void main(String[] args) {

		boolean choice = true;
		double inp1;
		double inp2;
		double sum = 0;
		double div;
		double rem = 0;
		boolean boo1;
		boolean boo2;

		do {
			boo1 = true;
			boo2 = true;
			System.out.println("Please enter two numbers: ");

			Scanner sc = new Scanner(System.in);
			if (!sc.hasNextDouble()) {
				boo1 = false;
			}
			try {
				inp1 = sc.nextDouble();

			}catch (java.util.InputMismatchException e) {   //If the input is something different than number
				inp1 = 0;                                   //we assign the value of '0'
			}

			Scanner sc2 = new Scanner(System.in);
			if (!sc2.hasNextDouble()) {
				boo2 = false;
			}
			try {
				inp2 = sc2.nextDouble();
			}catch (java.util.InputMismatchException e) {
				inp2 = 0;
			}


			//Testing the values
			//System.out.println(boo1 + " " + boo2 +" " + inp1 +" " + inp2);

			/*Case 1*/  if(!boo1 && !boo2) {
				sum = (inp1+inp2);
				System.out.println("The sum of the two inputs is: " + sum);
			}

			/*Case 2*/  if (boo1 && boo2) {
				System.out.println("Just Print a message :)");
			}

			/*Case 3*/  if (!boo1 || !boo2) {
				double sub = inp2 - inp1;
				System.out.println("Substraction: " + sub);
			}

			/*Case 4*/	if (!boo1 && inp1>20) {
				System.out.println("The product of the two numbers is: " + (inp1*inp2));			
			}else {
				try {
					div = inp1/inp2;
					rem = inp1%inp2;
					if (inp1==0 || inp2==0) {
						throw new ArithmeticException();
					}
				}catch (ArithmeticException ex) {
					System.out.println("One or two inputs are not numbers or are equal to zero. Cannot perform division");
				}
			}
			/*Case 5*/	if (boo2 && sum>44 && rem==0)  {
				System.out.println("I will now do whatever I want");
			}


			System.out.println("\n\n");
			System.out.println("Do you want to continue? (Y/N)");
			Scanner sc3 = new Scanner(System.in);

			if (sc3.nextLine().toUpperCase().contains("Y")) {
				choice = true;
			}else {
				choice = false;
			}

		}while (choice);

		System.out.println("....THE END....");

	}
}