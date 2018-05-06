package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.ArticleDao;
import Data.Article;

@WebServlet("/getArticleList")
public class GetArticleList extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		ArticleDao dao = new ArticleDao();
		ArrayList<Article> list1 = dao.findArticleByModuleForIndex(1);
		ArrayList<Article> list2 = dao.findArticleByModuleForIndex(2);
		ArrayList<Article> list3 = dao.findArticleByModuleForIndex(3);
		ArrayList<Article> list4 = dao.findArticleByModuleForIndex(4);

		request.setAttribute("session", session);
		request.setAttribute("list1", list1);
		request.setAttribute("list2", list2);
		request.setAttribute("list3", list3);
		request.setAttribute("list4", list4);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}
}
