package Data;

import java.sql.Timestamp;

public class Article {
	private int article_id;
	private String title;
	private int module_id;
	private Timestamp add_time;
	private String content;
	private String module;

	public Article() {
	}

	public Article(String title, int module_id, Timestamp add_time, String content) {
		this.title = title;
		this.module_id = module_id;
		this.add_time = add_time;
		this.content = content;
	}
	
	public int getArticle_id() {
		return article_id;
	}

	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getModule_id() {
		return module_id;
	}

	public void setModule_id(int module_id) {
		this.module_id = module_id;
	}

	public Timestamp getAdd_time() {
		return add_time;
	}

	public void setAdd_time(Timestamp add_time) {
		this.add_time = add_time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}
}
