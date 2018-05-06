package Tool;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 文件结构介绍: 
 * 1.上传的文件储存在WEB-INF/upload 
 * 2.每个老师有一个以老师名字命名的文件夹
 * 3.老师名字文件夹下有两个目录:[已通过]和[待审核]
 * 4.[已通过]和[待审核]两个文件夹下储存着老师的文件,文件以上传时的原文件名命名
 */
public class FileTool {
	// 从rootPath(即WEB-INF/upload下的所有文件)取出所有文件放入到teacherMap里
	// public static boolean listFile(File rootPath, Map teacherMap) {
	// // 得到老师名字文件夹列表
	// File[] teacherDirectoryList = rootPath.listFiles();
	// // 遍历每个老师名字文件夹
	// for (File teacherDirectory : teacherDirectoryList) {
	// // 创建并添加teacherMap的key,value值
	// String teacherName = teacherDirectory.getName();// 得到老师名字
	// List isCheckedDirectoryList = new ArrayList();// 创建储存[已通过]和[待审核]的list
	// teacherMap.put(teacherName, isCheckedDirectoryList);
	// List checkedFileList = new ArrayList();// 创建储存所有已通过文件名的list
	// List unCheckedFileList = new ArrayList();// 创建储存所有待审核文件名的list
	// isCheckedDirectoryList.add(checkedFileList);
	// isCheckedDirectoryList.add(unCheckedFileList);
	//
	// // 得到老师名字文件夹下的[已通过]和[待审核]文件夹
	// File[] isCheckedDirectory = teacherDirectory.listFiles();
	// // 遍历[已通过]和[待审核]以外的文件夹
	// for (File isChecked : isCheckedDirectory) {
	// if (isChecked.getName().equals("已通过")) {
	// // 得到所有已通过的文件
	// File[] checkedFiles = isChecked.listFiles();
	// // 遍历所有已通过的文件
	// for (File checkedFile : checkedFiles) {
	// // 将文件名放入checkedFileList
	// checkedFileList.add(checkedFile.getName());
	// // System.out.println(checkedFile.getName());
	// }
	// } else if (isChecked.getName().equals("待审核")) {
	// // 得到所有待审核的文件
	// File[] unCheckedFiles = isChecked.listFiles();
	// // 遍历所有待审核的文件
	// for (File unCheckedFile : unCheckedFiles) {
	// // 将文件名放入unCheckedFileList
	// unCheckedFileList.add(unCheckedFile.getName());
	// // System.out.println(unCheckedFile.getName());
	// }
	// } else {
	// return false;
	// }
	// }
	// }
	// return true;
	// }

	// 得到名字为teacherName的老师的所有已通过文件的文件名
	public static boolean listChecked(File rootPath, String teacherName, List<String> checkedList) {
		File checked = new File(rootPath.getPath() + File.separator + teacherName + File.separator + "已通过");
		System.out.println("目录:" + checked);
		if (checked.exists()) {
			checkedList.addAll(Arrays.asList(checked.list()));
			// checkedList = Arrays.asList(checked.list());
			if (checkedList.size() == 0)
				return false;
			return true;
		} else {
			return false;
		}
	}

	// 得到名字为teacherName的老师的所有待审核文件的文件名
	public static boolean listUnchecked(File rootPath, String teacherName, List<String> uncheckedList) {
		File unchecked = new File(rootPath.getPath() + File.separator + teacherName + File.separator + "待审核");
		if (unchecked.exists()) {
			uncheckedList.addAll(Arrays.asList(unchecked.list()));
			if (uncheckedList.size() == 0)
				return false;
			return true;
		} else {
			return false;
		}
	}

	// 得到所有上传过文件的老师名字
	public static List<String> listTeacherName(File rootPath) {
		return Arrays.asList(rootPath.list());
	}

	// 得到所有老师及其所有已通过文件的文件名的Map
	public static Map listAllChecked(File rootPath) {
		List<String> teachers = listTeacherName(rootPath);
		Map teacherMap = new HashMap();
		List<String> checkedList;
		for (int i = 0; i < teachers.size(); i++) {
			checkedList = new ArrayList<String>();
			if (listChecked(rootPath, teachers.get(i), checkedList)) {
				teacherMap.put(teachers.get(i), checkedList);
			}
		}
		return teacherMap;
	}

	// 得到所有老师及其所有待审核文件的文件名的Map
	public static Map listAllUnchecked(File rootPath) {
		List<String> teachers = listTeacherName(rootPath);
		Map teacherMap = new HashMap();
		List<String> uncheckedList;
		for (int i = 0; i < teachers.size(); i++) {
			uncheckedList = new ArrayList<String>();
			if (listUnchecked(rootPath, teachers.get(i), uncheckedList)) {
				teacherMap.put(teachers.get(i), uncheckedList);
			}
		}
		return teacherMap;
	}
}
