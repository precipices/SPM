package Data;

public class StudentUser {
	private String student_id;
	private String password;

	public StudentUser() {
	}

	public StudentUser(String student_id, String password) {
		this.student_id = student_id;
		this.password = password;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
