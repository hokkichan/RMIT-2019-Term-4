import javax.swing.JOptionPane;

public class CarRentalApp{
	private int maxNumCars;
	private Car[] carList;
	private int currentNumCars;

	public CarRentalApp (int maxNumCars) {
		this.maxNumCars = maxNumCars;
		this.carList = new Car[this.maxNumCars];
		this.currentNumCars = 0;
		showMenu();
	}
		
	public void showMenu() {
		String menu = "Car Rental App v1.0\n";
		menu += "[1] Add vehicles\n";
		menu += "[2] Remove vehicles\n";
		menu += "[3] Modify vehicles\n";
		String menuChoiceString = JOptionPane.showInputDialog(menu);
		while (menuChoiceString != null) {
			int menuChoiceInt = Integer.parseInt(menuChoiceString);
			if (menuChoiceInt == 1) {
				String title = JOptionPane.showInputDialog("Enter a new car title");
				String location = JOptionPane.showInputDialog("Enter car location for '" + title + "'");
				boolean CarAdded = AddCar(title, location);
				if (!CarAdded) {
					JOptionPane.showMessageDialog(null, "Oops! Looks like you have no more room for new cars");
				}
			} else if (menuChoiceInt == 2) {
				String targetTitle = JOptionPane.showInputDialog("Enter an exact car title to remove");
				boolean CarRemoved = RemoveCar(targetTitle);
				if (!CarRemoved) {
					JOptionPane.showMessageDialog(null, "Could not find any matches for " + targetTitle);
				}
			} else if (menuChoiceInt == 3) {
				String targetTitle = JOptionPane.showInputDialog("Enter a partial car title to search");
				String message = "Modify vehicle of " + (targetTitle);
				JOptionPane.showMessageDialog(null, message);
			} 
			else
				JOptionPane.showMessageDialog(null, "Wong input! Please enter \"1\", \"2\" or \"3\".");

			menuChoiceString = JOptionPane.showInputDialog(menu);
		}
	}

	public boolean AddCar(String title, String location) {
		boolean CarAdded = false;
		int foundIndex = GetCarIndexByTitle(title);
		if (foundIndex >= 0) {
			this.carList[foundIndex] = new Car(title, location);
			CarAdded = true;
		} else {
			if (this.currentNumCars >= this.maxNumCars) {
				int expandedSize = this.maxNumCars * 2;
				Car[] biggerCarList = new Car[expandedSize];

				int i = 0;
				while (i < this.currentNumCars) {
					biggerCarList[i] = this.carList[i];
					i += 1;
				}

				this.carList = biggerCarList;
				this.maxNumCars = expandedSize;
			}
			int i = currentNumCars;
			while (i > 0 && this.carList[i - 1].getCarTitle().compareTo(title) >= 0) {
				this.carList[i] = this.carList[i - 1];
				i -= 1;
			}
			this.carList[i] = new Car(title, location);
			this.currentNumCars += 1;
			CarAdded = true;
		}
		return CarAdded;
	}
	
	public int GetCarIndexByTitle(String targetTitle) {
		int i = 0;
		while (i < this.currentNumCars && !this.carList[i].getCarTitle().equalsIgnoreCase(targetTitle))
			i += 1;

		if (i >= this.currentNumCars)
			i = -1;
		return i;
	}
	
	public boolean SetCar(String targetTitle) {
		boolean carSet = false;
		int i = GetCarIndexByTitle(targetTitle);
		String comment = JOptionPane.showInputDialog("Enter comment for " + targetTitle);
		this.carList[i].setCarComment(comment);
	}

	public boolean RemoveCar(String targetTitle) {
		boolean CarRemoved = false;
		int i = GetCarIndexByTitle(targetTitle);
		if (i>=0) {
			while(i<this.currentNumCars) {
				this.carList[i]=this.carList[i+1];
				i+=1;
			}
			this.currentNumCars -=1;
			CarRemoved = true;
		}
		return CarRemoved;
	}
	
	public static void main(String[] args) {
		CarRentalApp md = new CarRentalApp(50);
	}
}
