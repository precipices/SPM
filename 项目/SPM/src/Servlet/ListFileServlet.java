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
		 * һ��Ҫ���е��޸�: 1.��Ҫ��session�õ��û�����
		 * �ٽ������userType��Ϊ"teacher","student"��"manager"
		 * 2.����û�����Ϊ��ʦ,��Ҫ��session�õ���½��ʦ������ �ٽ������teacherName��Ϊ��½��ʦ������
		 * 3.�������Ҫ��֤��ȫ��ʹ��post,�뽫doGet�������doPostע�͵���ɾ��
		 * ������userType��teacher���뵽session��,
		 * �����������session��������������,����ϣ��session�������Щ����,������������ҵ����ͻ, ��ֻ��Ҫ�Ķ�
		 * 1.��UploadServlet.java��ʹ����teacherName
		 * 2.��ShowTeacherFileServlet.java��ʹ����userType �����ط���δʹ����Щ����,����Ķ�
		 */
		String user = request.getParameter("userType");
		// �õ�uploadĿ¼
		File rootPath = new File(this.getServletContext().getRealPath("/WEB-INF/upload"));
		// ���uploadĿ¼������,�򴴽�
		if (!rootPath.exists()) {
			System.out.println("Ŀ¼" + rootPath + "������,������...");
			rootPath.mkdirs();
		}
		if (user == null) {
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			String username;
			String userType;
			username = (String) session.getAttribute("username");
			userType = (String) session.getAttribute("userType");
			if ("��ʦ".equals(userType)) {// ����û�Ϊ��ʦ
				// �õ���ʦ��ͨ���ļ���δͨ���ļ�
				session.setAttribute("teacherName", username);
				List<String> checkedList = new ArrayList<String>();
				if (!FileTool.listChecked(rootPath, username, checkedList)) {
					System.out.println("û����ͨ���ļ�!");
				}
				request.setAttribute("checkedList", checkedList);

				List<String> uncheckedList = new ArrayList<String>();
				if (!FileTool.listUnchecked(rootPath, username, uncheckedList)) {
					System.out.println("û�д�����ļ�!");
				}
				request.setAttribute("uncheckedList", uncheckedList);
				// �õ���ʦ������,����ת��teacherShowFile.jsp��ʾ����ʦ���ļ�
				request.setAttribute("teacherName", username);
				request.getRequestDispatcher("fileUpload/teacherShowFile.jsp").forward(request, response);
			} else {
				// �õ�������ʦ����
				List teachers = FileTool.listTeacherName(rootPath);
				request.setAttribute("teachers", teachers);
				// ��ת��studentShowFile.jsp��ʾ���п����ص��ļ�
				request.getRequestDispatcher("fileUpload/studentShowFile.jsp").forward(request, response);
			}
		} else {
			if (user.equals("admin")) {// ����û�Ϊ����Ա
				// �õ�������ʦ���������ļ���Map
				Map teacherUncheckedMap = FileTool.listAllUnchecked(rootPath);
				// �õ�������ʦ����
				List teachers = FileTool.listTeacherName(rootPath);
				request.setAttribute("teachers", teachers);
				// ��teacherMap����request
				request.setAttribute("teacherUncheckedMap", teacherUncheckedMap);
				// ��ת��uploadAgree.jsp�����ļ��Ĵ�����
				request.getRequestDispatcher("admin/adminShowFile.jsp").forward(request, response);
			}
		}
	}
}
