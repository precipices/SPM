package Data;

public class Module {
	private int id;
	private String module;

	public Module() {
	}

	public Module(int id, String module) {
		this.id = id;
		this.module = module;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

}
