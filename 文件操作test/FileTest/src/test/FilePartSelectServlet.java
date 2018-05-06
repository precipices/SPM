package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FilePartSelectServlet")
public class FilePartSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FilePartSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		/*
		 * 需要进行的修改
		 * 1.需要从session得到用户类型		 再将下面的userType改为"teacher","student"或"manager"
		 */
		String userType = "student";//用户类型
		
		//根据设置用户类型跳转到相应界面
		if("teacher".equals(userType)) {
			//如果用户为老师,跳转到teacherUpload.jsp进行上传文件操作
			request.getRequestDispatcher("jspForUpload/teacherUpload.jsp").forward(request, response);
			return;
		}else if("student".equals(userType)) {
			//如果用户为学生,跳转到ListFileServlet.java取出文件
			request.getRequestDispatcher("/ListFileServlet.java").forward(request, response);
			return;
		}else if("manager".equals(userType)) {
			//如果用户为管理员,跳转到ListFileServlet.java取出文件
			request.getRequestDispatcher(request.getContextPath()+"/ListFileServlet").forward(request, response);
			return;
		}else {
			String message="不应该出现的错误:teacher,student,manager以外的用户类型!!";
			request.setAttribute("message", message);
			request.getRequestDispatcher("jspForUpload/message.jsp").forward(request, response);
			return;
		}

//		String message="暂未编写!!";
//		request.setAttribute("message", message);
//		request.getRequestDispatcher("jspForUpload/message.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
