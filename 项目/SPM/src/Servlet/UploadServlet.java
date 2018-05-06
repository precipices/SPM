package Servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request.setCharacterEncoding("UTF-8");
		// response.setCharacterEncoding("UTF-8");
		/*
		 * 需要从session得到登陆老师的名字
		 */
		String teacherName = (String) request.getSession().getAttribute("username");
		// String teacherName="张";
		String savePath = this.getServletContext().getRealPath("/WEB-INF/upload") + File.separator + teacherName
				+ File.separator + "待审核";
		File savePathFile = new File(savePath);
		if (!savePathFile.exists()) {
			savePathFile.mkdirs();
			System.out.println("[" + savePath + "]目录不存在，正在创建...");
		}
		// 判断request的表单是上传表单还是普通表单
		if (!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("message", "该表单不是上传文件表单，不归UploadServlet处理！");
			request.getRequestDispatcher("fileUpload/message.jsp").forward(request, response);
		}
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();// 得到解析器工厂
			factory.setSizeThreshold(1024 * 1024);// 设置缓冲区大小为1M,不设置的话默认为10K
			// 设置临时文件保存路径,如果上传文件超过缓冲区大小,则产生临时文件
			File tempFile = new File(this.getServletContext().getRealPath("/WEB-INF/temp"));
			if (!tempFile.exists()) {
				tempFile.mkdirs();
			}
			factory.setRepository(tempFile);

			ServletFileUpload upload = new ServletFileUpload(factory);// 在工厂里创建文件上传解析器

			// upload.setFileSizeMax(1024*1024*5);//设置上传文件最大为

			upload.setHeaderEncoding("UTF-8");// 设置上传文件的编码

			// 得到表单
			List<FileItem> list = upload.parseRequest(request);
			// 得到表单的每个组件
			for (FileItem item : list) {
				// 判断是否是上传文件
				if (item.isFormField()) {
					String name = item.getFieldName();
					String value = item.getString("UTF-8");// 设置内容的编码
					// value=new String(value.getBytes("iso8859-1"),"UTF-8");
					System.out.println(name + "=" + value);
				} else {
					// 得到纯文件名
					String filename = item.getName().substring(item.getName().lastIndexOf("\\") + 1);
					if (filename == null || filename.trim().equals("")) {
						request.setAttribute("message", "文件为空，上传失败！");
						request.getRequestDispatcher("fileUpload/message.jsp").forward(request, response);
					}
					// 设置路径
					String position = savePath + "\\" + filename;
					System.out.println("正在上传文件：" + position);
					// 创建输入流和文件输出流
					InputStream in = item.getInputStream();
					FileOutputStream out = new FileOutputStream(position);
					// 设置每次读取的大小
					byte buffer[] = new byte[1024];
					// 实际读取的长度
					int len = 0;
					// 将输入流写入输出流
					while ((len = in.read(buffer)) != -1) {
						out.write(buffer, 0, len);
					}
					// 关闭输入流和文件输出流
					in.close();
					out.close();
					// 删除临时文件
					item.delete();
				}
			}
		}
		// catch(FileUploadBase.FileSizeLimitExceededException e) {
		// request.setAttribute("message", "文件大小超过限制!!");
		// System.out.println("文件大小超过限制!!");
		// request.getRequestDispatcher("fileUpload/message.jsp").forward(request,
		// response);
		// }
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// throw new RuntimeException(e);
		}
		request.setAttribute("message", "上传成功！");
		request.getRequestDispatcher("fileUpload/message.jsp").forward(request, response);
	}
}
