package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ArticleDao;
import Data.Article;

@WebServlet("/articleDetail")
public class ArticleDetail extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int article_id = Integer.parseInt(request.getParameter("article_id"));
		ArticleDao dao = new ArticleDao();
		Article article = dao.findOneArticle(article_id);

		request.setAttribute("article", article);
		RequestDispatcher rd = request.getRequestDispatcher("articleDetail.jsp");
		rd.forward(request, response);
	}
}