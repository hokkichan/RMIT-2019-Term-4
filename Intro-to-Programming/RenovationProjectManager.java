import javax.swing.JOptionPane;

public class RenovationProjectManager {
	double wallArea = 0, cost, height, length, costPerSqm;
	String tempInput, wallNames;

	public void Wall() {
		// First method for calculating the cost of painting a wall
		costPerSqm = Double.parseDouble(JOptionPane.showInputDialog("Enter cost per sq.m ($)"));
		tempInput = JOptionPane.showInputDialog("Enter a wall name");
		height = Double.parseDouble(JOptionPane.showInputDialog("Enter " + tempInput + " wall height (m)"));
		length = Double.parseDouble(JOptionPane.showInputDialog("Enter " + tempInput + " wall length (m)"));
		wallArea = height * length;
		cost = wallArea * costPerSqm;
		JOptionPane.showMessageDialog(null,
				"Cost to paint " + tempInput + " wall of " + wallArea + " sq.m. is $" + cost);
	}

	public void Project() {
		// Second method for calculating the cost of a painting project
		costPerSqm = Double.parseDouble(JOptionPane.showInputDialog("Enter cost per sq.m ($)"));
		wallNames = "";
		wallArea = 0;
		cost = 0;
		tempInput = JOptionPane.showInputDialog("Enter a wall name (cancel to finish)");
		while (tempInput != null) {
			height = Double.parseDouble(JOptionPane.showInputDialog("Enter " + tempInput + " wall height (m)"));
			length = Double.parseDouble(JOptionPane.showInputDialog("Enter " + tempInput + " wall length (m)"));
			wallArea += height * length;
			wallNames += tempInput + ", ";
			tempInput = JOptionPane.showInputDialog("Enter a wall name (cancel to finish)");
		}
		cost = wallArea * costPerSqm;
		JOptionPane.showMessageDialog(null,
				"Cost to paint " + wallNames + "wall(s) of " + wallArea + " sq.m. is $" + cost);
	}

	public static void main(String[] args) {
		RenovationProjectManager method;
		method = new RenovationProjectManager();
		int selection;
		String choosemenu;
		// Define a new string of "choosemenu"
		String menu = "Menu:\n";
		menu += "1. Calculate paint required for a wall\n";
		menu += "2. Calculate paint required for project";
		choosemenu = JOptionPane.showInputDialog(menu);
		while (choosemenu != null) {
			selection = Integer.parseInt(choosemenu);
			// Use of if/else statements to choose between first or second method
			if (selection == 1) {
				method.Wall();
			} else if (selection == 2) {
				method.Project();
			} else {
				JOptionPane.showMessageDialog(null, "Invalid choice!");
			}
			choosemenu = JOptionPane.showInputDialog(menu);
		}
	}
}