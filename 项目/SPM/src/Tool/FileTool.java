package Tool;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * �ļ��ṹ����: 
 * 1.�ϴ����ļ�������WEB-INF/upload 
 * 2.ÿ����ʦ��һ������ʦ�����������ļ���
 * 3.��ʦ�����ļ�����������Ŀ¼:[��ͨ��]��[�����]
 * 4.[��ͨ��]��[�����]�����ļ����´�������ʦ���ļ�,�ļ����ϴ�ʱ��ԭ�ļ�������
 */
public class FileTool {
	// ��rootPath(��WEB-INF/upload�µ������ļ�)ȡ�������ļ����뵽teacherMap��
	// public static boolean listFile(File rootPath, Map teacherMap) {
	// // �õ���ʦ�����ļ����б�
	// File[] teacherDirectoryList = rootPath.listFiles();
	// // ����ÿ����ʦ�����ļ���
	// for (File teacherDirectory : teacherDirectoryList) {
	// // ���������teacherMap��key,valueֵ
	// String teacherName = teacherDirectory.getName();// �õ���ʦ����
	// List isCheckedDirectoryList = new ArrayList();// ��������[��ͨ��]��[�����]��list
	// teacherMap.put(teacherName, isCheckedDirectoryList);
	// List checkedFileList = new ArrayList();// ��������������ͨ���ļ�����list
	// List unCheckedFileList = new ArrayList();// �����������д�����ļ�����list
	// isCheckedDirectoryList.add(checkedFileList);
	// isCheckedDirectoryList.add(unCheckedFileList);
	//
	// // �õ���ʦ�����ļ����µ�[��ͨ��]��[�����]�ļ���
	// File[] isCheckedDirectory = teacherDirectory.listFiles();
	// // ����[��ͨ��]��[�����]������ļ���
	// for (File isChecked : isCheckedDirectory) {
	// if (isChecked.getName().equals("��ͨ��")) {
	// // �õ�������ͨ�����ļ�
	// File[] checkedFiles = isChecked.listFiles();
	// // ����������ͨ�����ļ�
	// for (File checkedFile : checkedFiles) {
	// // ���ļ�������checkedFileList
	// checkedFileList.add(checkedFile.getName());
	// // System.out.println(checkedFile.getName());
	// }
	// } else if (isChecked.getName().equals("�����")) {
	// // �õ����д���˵��ļ�
	// File[] unCheckedFiles = isChecked.listFiles();
	// // �������д���˵��ļ�
	// for (File unCheckedFile : unCheckedFiles) {
	// // ���ļ�������unCheckedFileList
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

	// �õ�����ΪteacherName����ʦ��������ͨ���ļ����ļ���
	public static boolean listChecked(File rootPath, String teacherName, List<String> checkedList) {
		File checked = new File(rootPath.getPath() + File.separator + teacherName + File.separator + "��ͨ��");
		System.out.println("Ŀ¼:" + checked);
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

	// �õ�����ΪteacherName����ʦ�����д�����ļ����ļ���
	public static boolean listUnchecked(File rootPath, String teacherName, List<String> uncheckedList) {
		File unchecked = new File(rootPath.getPath() + File.separator + teacherName + File.separator + "�����");
		if (unchecked.exists()) {
			uncheckedList.addAll(Arrays.asList(unchecked.list()));
			if (uncheckedList.size() == 0)
				return false;
			return true;
		} else {
			return false;
		}
	}

	// �õ������ϴ����ļ�����ʦ����
	public static List<String> listTeacherName(File rootPath) {
		return Arrays.asList(rootPath.list());
	}

	// �õ�������ʦ����������ͨ���ļ����ļ�����Map
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

	// �õ�������ʦ�������д�����ļ����ļ�����Map
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
