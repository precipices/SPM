package Data;

public class Course {
	private int course_id;
	private String course_name;
	private String teacher_id;
	private int building_id;
	private int room_id;
	private int day_id;
	private int time_id;
	private String teacher;
	private String building;
	private String room;
	private String day;
	private String time;

	public Course() {
	}

	public Course(String course_name, String teacher_id, int building_id, int room_id, int day_id, int time_id) {
		this.course_name = course_name;
		this.teacher_id = teacher_id;
		this.building_id = building_id;
		this.room_id = room_id;
		this.day_id = day_id;
		this.time_id = time_id;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}

	public int getBuilding_id() {
		return building_id;
	}

	public void setBuilding_id(int building_id) {
		this.building_id = building_id;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public int getDay_id() {
		return day_id;
	}

	public void setDay_id(int day_id) {
		this.day_id = day_id;
	}

	public int getTime_id() {
		return time_id;
	}

	public void setTime_id(int time_id) {
		this.time_id = time_id;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
