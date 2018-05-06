package Data;

public class Teacher {
	private String teacher_id;
	private String teacher_name;
	private String sex;
	private int age;

	public Teacher() {
	}

	public Teacher(String teacher_id, String teacher_name) {
		this.teacher_id = teacher_id;
		this.teacher_name = teacher_name;
	}

	public String getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
