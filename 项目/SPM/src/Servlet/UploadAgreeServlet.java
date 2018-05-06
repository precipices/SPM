package Servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UploadAgreeServlet")
public class UploadAgreeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String filename = request.getParameter("filename");
		String teacherName = request.getParameter("teacherName");
		String teacherPath = this.getServletContext().getRealPath("/WEB-INF/upload") + File.separator + teacherName;
		String oldPath = teacherPath + File.separator + "待审核";
		String newPath = teacherPath + File.separator + "已通过";
		String oldFilePath = oldPath + File.separator + filename;
		File oldFile = new File(oldFilePath);
		if (!oldFile.exists()) {
			request.setAttribute("message", "对不起,待审核的文件不存在或已被删除!");
			System.out.println("待审核的文件[" + oldFile + "不存在或已被删除!]");
			request.getRequestDispatcher("jspForUpload/message.jsp").forward(request, response);
			return;
		}
		File newPathFile = new File(newPath);
		if (!newPathFile.exists()) {
			newPathFile.mkdirs();
			System.out.println("[" + newPath + "]目录不存在,正在创建...");
		}
		File newFile = new File(newPath + File.separator + filename);
		if (newFile.exists()) {
			newFile.delete();
		}
		oldFile.renameTo(newFile);
	}
}
