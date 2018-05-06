package test;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteFileServlet
 */
@WebServlet("/DeleteFileServlet")
public class DeleteFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		//�õ��ļ���
		String filename=request.getParameter("filename");
		filename=new String(filename.getBytes("iso8859-1"),"UTF-8");
		//�õ��ļ�����·��
		String	filePath=request.getParameter("filePath");
		filePath=new String(filePath.getBytes("iso8859-1"),"UTF-8");
		filePath=this.getServletContext().getRealPath("/WEB-INF/upload")+File.separator+filePath;
		
		System.out.println("filename="+filename+"\nfilePath="+filePath);
		//����ļ��Ƿ����
		File file=new File(filePath);
		if(!file.exists()) {
			request.setAttribute("message", "�Բ���,��Ҫ���ص��ļ������ڻ��ѱ�ɾ��!");
			request.getRequestDispatcher("jspForUpload/message.jsp").forward(request, response);
			return;
		}
		file.delete();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
