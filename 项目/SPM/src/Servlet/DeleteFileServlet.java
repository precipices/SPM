package Servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteFileServlet")
public class DeleteFileServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 得到文件名
		String filename = request.getParameter("filename");
		// 得到文件绝对路径
		String filePath = request.getParameter("filePath");
		System.out.println(filePath);
		filePath = this.getServletContext().getRealPath("/WEB-INF/upload") + File.separator + filePath;

		System.out.println("filename=" + filename + "\nfilePath=" + filePath);
		// 检查文件是否存在
		File file = new File(filePath);
		if (!file.exists()) {
			request.setAttribute("message", "对不起，您要下载的文件不存在或已被删除！");
			request.getRequestDispatcher("fileUpload/message.jsp").forward(request, response);
		}
		file.delete();
		request.setAttribute("message", "删除成功！");
		request.getRequestDispatcher("fileUpload/message.jsp").forward(request, response);
	}
}
