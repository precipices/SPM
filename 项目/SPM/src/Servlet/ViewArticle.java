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
import Data.Module;

@WebServlet("/viewArticle")
public class ViewArticle extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String module = request.getParameter("module");
		int module_id;
		try {
			module_id = Integer.parseInt(module);
		} catch (NumberFormatException e) {
			module_id = 0;
		}
		ArticleDao dao = new ArticleDao();
		ArrayList<Article> articleList;
		if (module_id == 0) {
			articleList = dao.findAllArticle();
		} else {
			articleList = dao.findArticle(module_id);
		}

		String p = request.getParameter("page");
		int page;
		try {
			page = Integer.parseInt(p);
		} catch (NumberFormatException e) {
			page = 1;
		}
		int totalArticle = articleList.size();
		int articlePerPage = 10;
		int totalPage;
		if (totalArticle % articlePerPage == 0) {
			totalPage = totalArticle / articlePerPage;
		} else {
			totalPage = totalArticle / articlePerPage + 1;
		}
		int start = (page - 1) * articlePerPage;
		int end = start + articlePerPage;
		if (end > totalArticle) {
			end = totalArticle;
		}

		ArrayList<Module> moduleList = getModuleList();

		request.setAttribute("module_id", module_id);
		request.setAttribute("page", page);
		request.setAttribute("totalArticle", totalArticle);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("start", start);
		request.setAttribute("end", end);
		request.setAttribute("articleList", articleList);
		request.setAttribute("moduleList", moduleList);
		RequestDispatcher rd = request.getRequestDispatcher("admin/viewArticle.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

	private ArrayList<Module> getModuleList() {
		// TODO Auto-generated method stub
		ModuleDao dao = new ModuleDao();
		return dao.findAllModule();
	}
}
