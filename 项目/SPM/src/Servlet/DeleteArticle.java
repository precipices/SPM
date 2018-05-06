package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ArticleDao;

@WebServlet("/deleteArticle")
public class DeleteArticle extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		ArticleDao dao = new ArticleDao();
		boolean success = dao.deleteArticle(id);
		if (success) {
			response.sendRedirect("viewArticle");
		}
	}
}
