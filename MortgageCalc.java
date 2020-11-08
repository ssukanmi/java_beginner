import java.text.NumberFormat;
import java.util.Scanner;

/**
 * MortgageCalc
 */
public class MortgageCalc {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		final byte MONTHS_IN_YEAR = 12;
		final byte PERCENT = 100;
		int userPrincipal;
		float interestRate;
		short duration;

		do {
			System.out.print("Principal ($1K - $1M): ");
			userPrincipal = scanner.nextInt();
			if (userPrincipal >= 1_000 && userPrincipal <= 1_000_000)
				break;
			System.out.println("Please enter a number between 1,000 and 1,000,000.");
		} while (true);

		do {
			System.out.print("Annual Interest Rate: ");
			interestRate = scanner.nextFloat() / PERCENT;
			if (interestRate > 0 && interestRate < 0.3)
				break;
			System.out.println("Please enter a value greater than 0 and less than or equal to 30.");
		} while (true);

		do {
			System.out.print("Period (Years): ");
			duration = (short) (scanner.nextByte() * MONTHS_IN_YEAR);
			if (duration >= 12 && duration <= 360)
				break;
			System.out.println("Please enter a value between 1 and 30");
		} while (true);

		scanner.close();
		double mortgage = userPrincipal
				* ((interestRate * Math.pow(1 + interestRate, duration)) / (Math.pow(1 + interestRate, duration) - 1));
		System.out.println("Mortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));
	}
}