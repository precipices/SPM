package Servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ArticleDao;
import Dao.ModuleDao;
import Data.Article;
import Data.Module;

@WebServlet("/setArticle")
public class SetArticle extends HttpServlet {
	private static int id;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		id = Integer.parseInt(request.getParameter("id"));
		ArticleDao dao1 = new ArticleDao();
		Article article = dao1.findOneArticle(id);
		ModuleDao dao2 = new ModuleDao();
		ArrayList<Module> moduleList = dao2.findAllModule();

		request.setAttribute("title", article.getTitle());
		request.setAttribute("module_id", article.getModule_id());
		request.setAttribute("content", article.getContent());
		request.setAttribute("moduleList", moduleList);
		RequestDispatcher rd = request.getRequestDispatcher("admin/setArticle.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		int module_id = Integer.parseInt(request.getParameter("module"));
		Timestamp add_time = new Timestamp(System.currentTimeMillis());
		String content = request.getParameter("content");
		ArticleDao dao = new ArticleDao();
		Article article = new Article(title, module_id, add_time, content);
		boolean success = dao.setArticle(article, id);
		if (success) {
			response.sendRedirect("viewArticle");
		}
	}
}
