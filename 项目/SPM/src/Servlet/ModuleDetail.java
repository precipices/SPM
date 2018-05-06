package Servlet;

import java.io.IOException;
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

@WebServlet("/moduleDetail")
public class ModuleDetail extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		int module_id = Integer.parseInt(request.getParameter("module_id"));
		ModuleDao dao1 = new ModuleDao();
		String module = dao1.findModule(module_id);
		ArticleDao dao2 = new ArticleDao();
		ArrayList<Article> articleList = dao2.findArticleByModule(module_id);

		request.setAttribute("module", module);
		request.setAttribute("articleList", articleList);
		RequestDispatcher rd = request.getRequestDispatcher("moduleDetail.jsp");
		rd.forward(request, response);
	}
}
