import javax.swing.JOptionPane;

public class LottoGenerator {
	// MVP Version for a program to generate lucky numbers for Australian Lotto
	// This program will display randomly generated 10 sets of lucky numbers for the
	// user, six regular numbers and two supplementary numbers
	// [1]"Lotteries in Australia", En.wikipedia.org, 2020. [Online]. Available:
	// https://en.wikipedia.org/wiki/Lotteries_in_Australia. [Accessed: 15- Feb-
	// 2020]

	public LottoGenerator() {
		showMenu();
	}

	public void showMenu() {
		int menuChoice = Integer.parseInt(JOptionPane.showInputDialog(
				"Choice of Generator: \n1. Lucky numbers without text file output \n2. Lucky numbers with text file output"));
		if (menuChoice == 1) {
			withoutTxtPrintOut();
		} else if (menuChoice == 2) {
			withTxtPrintOut();
		} else {
			menuChoice = Integer.parseInt(JOptionPane.showInputDialog("Wong input! Please enter \"1\" or \"2\"."));
		}
	}

	public void withoutTxtPrintOut() {
		// Block for displaying generator without text file generated.
		int[] pool = new int[49];
		// Requirement C2 Object member variables (including arrays).
		String output = "";
		int[] luckyNum = new int[8];
		// Requirement C2 Object member variables (including arrays).
		int poolLimit;
		int random = 0;
		for (int j = 0; j < 10; j++) {
			output += "Lucky Numbers Set " + (j + 1) + ": ";
			poolLimit = pool.length - 1;
			for (int i = 0; i < pool.length; i++) {
				// Requirement C6 Conditional execution and repetition.
				pool[i] = (i + 1);
			}
			for (int i = 0; i < luckyNum.length; i++) {
				// Requirement C6 Conditional execution and repetition.
				random = (int) Math.floor(Math.random() * poolLimit);
				// Generate random variables
				// [2]"JavaScript Random", W3schools.com, 2020. [Online]. Available:
				// https://www.w3schools.com/js/js_random.asp. [Accessed: 15- Feb- 2020]
				luckyNum[i] = pool[random];
				pool[random] = pool[poolLimit];
				poolLimit--;
			}
			output += luckyNum[0] + " " + luckyNum[1] + " " + luckyNum[2] + " " + luckyNum[3] + " " + luckyNum[4] + " " + luckyNum[5]
					+ "\t\tSupplementary Numbers:" + luckyNum[6] + " " + luckyNum[7] + "\r\n";
		}
		System.out.println(output);
	}

	public void withTxtPrintOut() {
			System.out.println("Under construction!");
	}

	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null,
				"This simple program will show lucky numbers generated for the Australian Lotto.\n\nThere will be 10 sets with 6 regular numbers and 2 supplementary numbers in each set.\n\nGood luck!");
		LottoGenerator method;
		method = new LottoGenerator();
		// Requirement C3
		// Use of constructor method
	}
}
