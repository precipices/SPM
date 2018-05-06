package Data;

public class Room {
	private int id;
	private String room;

	public Room() {
	}

	public Room(int id, String room) {
		this.id = id;
		this.room = room;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

}
