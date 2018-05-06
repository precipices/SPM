package Data;

public class Building {
	private int id;
	private String building;

	public Building() {
	}

	public Building(int id, String building) {
		this.id = id;
		this.building = building;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

}
