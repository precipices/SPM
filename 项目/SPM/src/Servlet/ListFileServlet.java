package Servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Tool.FileTool;

@WebServlet("/ListFileServlet")
public class ListFileServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 一定要进行的修改: 1.需要从session得到用户类型
		 * 再将下面的userType改为"teacher","student"或"manager"
		 * 2.如果用户类型为老师,需要从session得到登陆老师的名字 再将下面的teacherName改为登陆老师的名字
		 * 3.如果你需要保证安全而使用post,请将doGet方法里的doPost注释掉或删除
		 * 这里会把userType和teacher放入到session中,
		 * 如果你觉得你的session里已有类似内容,而不希望session里多余这些内容,或你的命名与我的相冲突, 你只需要改动
		 * 1.在UploadServlet.java里使用了teacherName
		 * 2.在ShowTeacherFileServlet.java里使用了userType 其他地方均未使用这些内容,无需改动
		 */
		String user = request.getParameter("userType");
		// 得到upload目录
		File rootPath = new File(this.getServletContext().getRealPath("/WEB-INF/upload"));
		// 如果upload目录不存在,则创建
		if (!rootPath.exists()) {
			System.out.println("目录" + rootPath + "不存在,创建中...");
			rootPath.mkdirs();
		}
		if (user == null) {
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			String username;
			String userType;
			username = (String) session.getAttribute("username");
			userType = (String) session.getAttribute("userType");
			if ("教师".equals(userType)) {// 如果用户为老师
				// 得到老师已通过文件和未通过文件
				session.setAttribute("teacherName", username);
				List<String> checkedList = new ArrayList<String>();
				if (!FileTool.listChecked(rootPath, username, checkedList)) {
					System.out.println("没有已通过文件!");
				}
				request.setAttribute("checkedList", checkedList);

				List<String> uncheckedList = new ArrayList<String>();
				if (!FileTool.listUnchecked(rootPath, username, uncheckedList)) {
					System.out.println("没有待审核文件!");
				}
				request.setAttribute("uncheckedList", uncheckedList);
				// 得到老师的名字,并跳转到teacherShowFile.jsp显示该老师的文件
				request.setAttribute("teacherName", username);
				request.getRequestDispatcher("fileUpload/teacherShowFile.jsp").forward(request, response);
			} else {
				// 得到所有老师名字
				List teachers = FileTool.listTeacherName(rootPath);
				request.setAttribute("teachers", teachers);
				// 跳转到studentShowFile.jsp显示所有可下载的文件
				request.getRequestDispatcher("fileUpload/studentShowFile.jsp").forward(request, response);
			}
		} else {
			if (user.equals("admin")) {// 如果用户为管理员
				// 得到所有老师及其待审核文件的Map
				Map teacherUncheckedMap = FileTool.listAllUnchecked(rootPath);
				// 得到所有老师名字
				List teachers = FileTool.listTeacherName(rootPath);
				request.setAttribute("teachers", teachers);
				// 把teacherMap放入request
				request.setAttribute("teacherUncheckedMap", teacherUncheckedMap);
				// 跳转到uploadAgree.jsp进行文件的处理工作
				request.getRequestDispatcher("admin/adminShowFile.jsp").forward(request, response);
			}
		}
	}
}
