package Data;

public class TeacherUser {
	private String teacher_id;
	private String password;
	private String teacher_name;

	public TeacherUser() {
	}

	public TeacherUser(String teacher_id, String password) {
		this.teacher_id = teacher_id;
		this.password = password;
	}

	public String getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
}
