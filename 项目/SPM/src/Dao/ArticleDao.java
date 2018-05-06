package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Data.Article;

public class ArticleDao extends BaseDao {
	public boolean addArticle(Article article) {
		String sql = "insert into article(title,module_id,add_time,detail) values(?,?,?,?)";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, article.getTitle());
			stmt.setInt(2, article.getModule_id());
			stmt.setTimestamp(3, article.getAdd_time());
			stmt.setString(4, article.getContent());
			stmt.executeUpdate();
			stmt.close();
			con.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public Article findOneArticle(int id) {
		String sql = "select * from article where article_id=?";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			Article article = new Article();
			article.setArticle_id(rs.getInt("article_id"));
			article.setTitle(rs.getString("title"));
			article.setModule_id(rs.getInt("module_id"));
			article.setAdd_time(rs.getTimestamp("add_time"));
			article.setContent(rs.getString("detail"));
			stmt.close();
			con.close();
			return article;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Article> findArticleByModuleForIndex(int module_id) {
		ArrayList<Article> articleList = new ArrayList<Article>();
		String sql = "select top 5 * from article where module_id=? order by add_time";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, module_id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Article article = new Article();
				article.setArticle_id(rs.getInt("article_id"));
				article.setTitle(rs.getString("title"));
				article.setAdd_time(rs.getTimestamp("add_time"));
				articleList.add(article);
			}
			stmt.close();
			con.close();
			return articleList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Article> findArticleByModule(int module_id) {
		ArrayList<Article> articleList = new ArrayList<Article>();
		String sql = "select * from article where module_id=? order by add_time";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, module_id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Article article = new Article();
				article.setArticle_id(rs.getInt("article_id"));
				article.setTitle(rs.getString("title"));
				article.setAdd_time(rs.getTimestamp("add_time"));
				articleList.add(article);
			}
			stmt.close();
			con.close();
			return articleList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Article> findArticle(int module) {
		ArrayList<Article> articleList = new ArrayList<Article>();
		String sql = "select * from article where module_id=?";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, module);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Article article = new Article();
				article.setTitle(rs.getString("title"));
				article.setModule(getModule(rs.getInt("module_id")));
				article.setAdd_time(rs.getTimestamp("add_time"));
				article.setContent(rs.getString("detail"));
				articleList.add(article);
			}
			stmt.close();
			con.close();
			return articleList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Article> findAllArticle() {
		ArrayList<Article> articleList = new ArrayList<Article>();
		String sql = "select * from article";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Article article = new Article();
				article.setArticle_id(rs.getInt("article_id"));
				article.setTitle(rs.getString("title"));
				article.setModule(getModule(rs.getInt("module_id")));
				article.setAdd_time(rs.getTimestamp("add_time"));
				article.setContent(rs.getString("detail"));
				articleList.add(article);
			}
			stmt.close();
			con.close();
			return articleList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public boolean deleteArticle(int id) {
		String sql = "delete from article where article_id=?";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public boolean setArticle(Article article, int id) {
		String sql = "update article set title=?,module_id=?,add_time=?,detail=? where article_id=?";
		try {
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, article.getTitle());
			stmt.setInt(2, article.getModule_id());
			stmt.setTimestamp(3, article.getAdd_time());
			stmt.setString(4, article.getContent());
			stmt.setInt(5, id);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	private String getModule(int id) {
		// TODO Auto-generated method stub
		ModuleDao dao = new ModuleDao();
		return dao.findModule(id);
	}
}
