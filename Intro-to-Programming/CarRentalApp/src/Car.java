
public class Car {
	private String carLocation;
	private String carTitle;
	private String carComment;

	public Car(String title, String location) {
		this.carTitle = title;
		this.carLocation = location;
		this.carComment = null;

	}

	public String getCarLocation() {
		return this.carLocation;
	}

	public String getCarTitle() {
		return this.carTitle;
	}

	public String setCarComment() {
		return this.carComment;
	}

}
