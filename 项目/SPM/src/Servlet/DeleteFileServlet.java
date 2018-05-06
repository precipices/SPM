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
		// �õ��ļ���
		String filename = request.getParameter("filename");
		// �õ��ļ�����·��
		String filePath = request.getParameter("filePath");
		System.out.println(filePath);
		filePath = this.getServletContext().getRealPath("/WEB-INF/upload") + File.separator + filePath;

		System.out.println("filename=" + filename + "\nfilePath=" + filePath);
		// ����ļ��Ƿ����
		File file = new File(filePath);
		if (!file.exists()) {
			request.setAttribute("message", "�Բ�����Ҫ���ص��ļ������ڻ��ѱ�ɾ����");
			request.getRequestDispatcher("fileUpload/message.jsp").forward(request, response);
		}
		file.delete();
		request.setAttribute("message", "ɾ���ɹ���");
		request.getRequestDispatcher("fileUpload/message.jsp").forward(request, response);
	}
}
