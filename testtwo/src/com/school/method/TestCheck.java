package com.school.method;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.school.ui.Check_UI;

public class TestCheck {

	private static List<String> list1 = new ArrayList<String>();
	private static List<String> list2 = new ArrayList<String>();
	private static List<String> list3 = new ArrayList<String>();
	private static List<String> list4 = new ArrayList<String>();
	int ii = 0;
	private static int max = 0;// 最大list长度值
	private static boolean flag = false;// 用于在check_ui中判断是否提示错误信息的出现
	private static boolean flag1 = false;

	// s1,s2,s3分别代表车牌号，日期，摄像头编号
	// a1,b1,c1代表开始时间，a2,b2,c2代表截至时间
	public void search_image(String root, String s1, String s2, String s31,
			String s32, String s33, String s34, int a1, int b1, int c1, int a2,
			int b2, int c2) {
		// 查询的根目录
		File rootFile = new File(root);

		File f1 = search(s1, rootFile);
		if (f1 != null) {
			File f2 = search(s2, f1);
			if (f2 != null) {

				File file1 = search(s31, f2);
				File file2 = search(s32, f2);
				File file3 = search(s33, f2);
				File file4 = search(s34, f2);
				if (file1 != null || file2 != null || file3 != null
						|| file4 != null) {

					search_condition(a1, b1, c1, a2, b2, c2, file1, file2,
							file3, file4);
				}
				// ExportThread.setEnd(false);
				else {

					TestCheck.setFlag1(true);
					// ExportThread.setWork(false);
					Check_UI.getjButton_determin().setEnabled(true);
					return;
				}
			} else {

				TestCheck.setFlag1(true);
				// ExportThread.setWork(false);
				Check_UI.getjButton_determin().setEnabled(true);
				return;
			}
		} else {

			TestCheck.setFlag1(true);
			// ExportThread.setWork(false);
			Check_UI.getjButton_determin().setEnabled(true);
			return;
		}
	}

	// 在文件file内搜索用户给定上、下区间所有图片
	public void search_condition(int a1, int b1, int c1, int a2, int b2,
			int c2, File file1, File file2, File file3, File file4) {
		if (a1 == 0 && b1 == 0 && c1 == 0 && a2 == 0 && b2 == 0 && c2 == 0) {

			TestCheck.setFlag1(true);
			// ExportThread.setWork(false);
			Check_UI.getjButton_determin().setEnabled(true);
			return;
		}

		else {
			// System.out.println("KAISHI");
			if (a1 > a2) {

				TestCheck.setFlag1(true);
				// ExportThread.setWork(false);
				Check_UI.getjButton_determin().setEnabled(true);
				return;
			} else if (a1 == a2) {
				if (b1 > b2) {

					TestCheck.setFlag1(true);
					// ExportThread.setWork(false);
					Check_UI.getjButton_determin().setEnabled(true);
					return;
				} else if (b1 == b2) {
					if (c1 > c2) {

						TestCheck.setFlag1(true);
						// ExportThread.setWork(false);
						Check_UI.getjButton_determin().setEnabled(true);
						return;
					} else if (c1 == c2) {
						flag = true;
						search_scope(a1, b1, c1, a2, b2, c2, file1, file2,
								file3, file4);

					} else {// c1<c2
						flag = true;
						search_scope(a1, b1, c1, a2, b2, c2, file1, file2,
								file3, file4);
					}
				} else {// b1<b2
					flag = true;

					search_scope(a1, b1, c1, a2, b2 - 1, 59, file1, file2,
							file3, file4);
					search_scope(a1, b1 + 1, 0, a2, b2 - 1, 59, file1, file2,
							file3, file4);
					search_scope(a2, b2, 0, a2, b2, c2, file1, file2, file3,
							file4);

				}
			} else {// a1<a2
				flag = true;
				if ((a2 - a1) == 1) {
					search_scope(a1, b1, c1, a2, b1, 59, file1, file2, file3,
							file4);
					search_scope(a1, b1 + 1, 0, a1, 59, 59, file1, file2,
							file3, file4);
					search_scope(a2, 0, 0, a2, b2 - 1, 59, file1, file2, file3,
							file4);
					search_scope(a2, b2, 0, a2, b2, c2, file1, file2, file3,
							file4);

				} else {
					search_scope(a1, b1, c1, a1, b1, 59, file1, file2, file3,
							file4);
					search_scope(a1, b1 + 1, 0, a1, 59, 59, file1, file2,
							file3, file4);
					search_scope(a1 + 1, 0, 0, a2 - 1, 59, 59, file1, file2,
							file3, file4);
					search_scope(a2, 0, 0, a2, b2 - 1, 59, file1, file2, file3,
							file4);
					search_scope(a2, b2, 0, a2, b2, c2, file1, file2, file3,
							file4);

				}
			}
		}
	}

	// 跟实际情况按照给定上、下区间搜索相应图片
	public void search_scope(int a_1, int b_1, int c_1, int a_2, int b_2,
			int c_2, File file1, File file2, File file3, File file4) {
		String s1 = null;
		String s2 = null;
		String s3 = null;
		String s = null;

		for (int m = a_1; m <= a_2; m++) {
			// System.out.println("M:" + m);
			for (int n = b_1; n <= b_2; n++) {
				// System.out.println("N:" + n);
				for (int k = c_1; k <= c_2; k++) {
					// System.out.println("K:" + k);
					for (int i = 1; i <= 1; i++) {
						// System.out.println("I:" + i);
						if (m < 10) {
							s1 = "0" + m;
						} else {
							s1 = m + "";
						}
						if (n < 10) {
							s2 = "0" + n;
						} else {
							s2 = n + "";
						}
						if (k < 10) {
							s3 = "0" + k;
						} else {
							s3 = k + "";
						}

						s = s1 + "-" + s2 + "-" + s3 + "-" + i;
						System.out.println(s);
						File image_file1 = search(s, file1);
						File image_file2 = search(s, file2);
						File image_file3 = search(s, file3);
						File image_file4 = search(s, file4);
						if (image_file1 != null || image_file2 != null
								|| image_file3 != null || image_file4 != null) {
							if (image_file1 != null) {
								list1.add(image_file1.getAbsolutePath());

							} else {
								list1.add("image/blank.jpg");
							}

							if (image_file2 != null) {
								list2.add(image_file2.getAbsolutePath());

							} else {

								list2.add("image/blank.jpg");

							}

							if (image_file3 != null) {
								list3.add(image_file3.getAbsolutePath());

							} else {

								list3.add("image/blank.jpg");

							}

							if (image_file4 != null) {
								list4.add(image_file4.getAbsolutePath());

							} else {

								list4.add("image/blank.jpg");

							}
						}

						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {

							e.printStackTrace();
						}

						if (flag1) {
							// System.out.println("fdsds---" + flag1);
							break;
						}
					}
					if (flag1) {
						break;
					}
				}
				if (flag1) {
					break;
				}
			}
			if (flag1) {
				break;
			}
		}
		// ExportThread.setWork(false);
	}

	// 查找指定文件内是否还有文件名为 s 的文件
	public static File search(String s, File file) {
		if (file != null) {
			File[] fileList = file.listFiles();
			File file_search = null;
			for (File f : fileList) {
				if (f != null) {
					if (getNewName(f).equals(s)) {
						file_search = f;
						break;
					}
				} else {
					file_search = null;
				}
			}
			return file_search;
		} else {
			return null;
		}
	}

	public static String getNewName(File file) {
		String name = file.getName();
		int lastIndex = name.lastIndexOf(".") == -1 ? name.length() : name
				.lastIndexOf(".");
		return name.substring(0, lastIndex);
	}

	public static List<String> getList1() {
		return list1;
	}

	public static void setList1(List<String> list1) {
		TestCheck.list1 = list1;
	}

	public static List<String> getList2() {
		return list2;
	}

	public static void setList2(List<String> list2) {
		TestCheck.list2 = list2;
	}

	public static List<String> getList3() {
		return list3;
	}

	public static void setList3(List<String> list3) {
		TestCheck.list3 = list3;
	}

	public static List<String> getList4() {
		return list4;
	}

	public static void setList4(List<String> list4) {
		TestCheck.list4 = list4;
	}

	public static int getMax() {
		return max;
	}

	public static void setMax(int max) {
		TestCheck.max = max;
	}

	public static boolean isFlag() {
		return flag;
	}

	public static void setFlag(boolean flag) {
		TestCheck.flag = flag;
	}

	public static boolean isFlag1() {
		return flag1;
	}

	public static void setFlag1(boolean flag1) {
		TestCheck.flag1 = flag1;
	}

}
