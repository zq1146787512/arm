package com.school.method;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.school.ui.Check_UI;

public class Check {
	private static List<String> list = new ArrayList<String>();
//	private static List<String> list2 = new ArrayList<String>();
//	private static List<String> list3 = new ArrayList<String>();
//	private static List<String> list4 = new ArrayList<String>();
	int ii = 0;
	private static int max = 0;// 最大list长度值
	private static boolean flag = false;// 用于在check_ui中判断是否提示错误信息的出现
	private static boolean flag1 = false;

	// s1,s2,s3分别代表车牌号，日期，摄像头编号
	// a1,b1,c1代表开始时间，a2,b2,c2代表截至时间
	public void search_image(String root, String s1, String s2, String s3,
			int a1, int b1, int c1, int a2, int b2, int c2) {
		// 查询的根目录
		File rootFile = new File(root);
		File f1 = search(s1, rootFile);
		if (f1 != null) {
			File f2 = search(s2, f1);
			if (f2 != null) {
				File f3 = search(s3, f2);
//				if (f3 != null) {
//					if (s3.equals("T1")) {
//						list = list1;
//					} else if (s3.equals("T2")) {
//						list = list2;
//					} else if (s3.equals("T3")) {
//						list = list3;
//					} else {
//						list = list4;
//					}
					search_condition(a1, b1, c1, a2, b2, c2, f3, list);
					// ExportThread.setEnd(false);
//				} else {
//					JOptionPane.showMessageDialog(null, "不存在车" + s1 + "的" + s2
//							+ "日期的" + "摄像头" + s3 + "的图像信息", "系统信息",
//							JOptionPane.ERROR_MESSAGE);
//					Check.setFlag1(true);
//					// ExportThread.setWork(false);
//					Check_UI.getjButton_determin().setEnabled(true);
//					return;
//				}
			} else {
				JOptionPane.showMessageDialog(null, "不存在车" + s1 + "的" + s2
						+ "日期的图像信息", "系统信息", JOptionPane.ERROR_MESSAGE);
				Check.setFlag1(true);
				// ExportThread.setWork(false);
				Check_UI.getjButton_determin().setEnabled(true);
				return;
			}
		} else {
			JOptionPane.showMessageDialog(null, "不存在车" + s1 + "的图像信息", "系统信息",
					JOptionPane.ERROR_MESSAGE);
			Check.setFlag1(true);
			// ExportThread.setWork(false);
			Check_UI.getjButton_determin().setEnabled(true);
			return;
		}
	}

	// 在文件file内搜索用户给定上、下区间所有图片
	public void search_condition(int a1, int b1, int c1, int a2, int b2,
			int c2, File file, List<String> list) {
		if (a1 == 0 && b1 == 0 && c1 == 0 && a2 == 0 && b2 == 0 && c2 == 0) {
			JOptionPane.showMessageDialog(null, "选择上下区间不能同时为0", "系统信息",
					JOptionPane.ERROR_MESSAGE);
			Check.setFlag1(true);
			// ExportThread.setWork(false);
			Check_UI.getjButton_determin().setEnabled(true);
			return;
		}

		else {
			// System.out.println("KAISHI");
			if (a1 > a2) {
				JOptionPane.showMessageDialog(null, "小时输入上下区间不符合要求", "系统信息",
						JOptionPane.ERROR_MESSAGE);
				Check.setFlag1(true);
				// ExportThread.setWork(false);
				Check_UI.getjButton_determin().setEnabled(true);
				return;
			} else if (a1 == a2) {
				if (b1 > b2) {
					JOptionPane.showMessageDialog(null, "分钟输入上下区间不符合要求",
							"系统信息", JOptionPane.ERROR_MESSAGE);
					Check.setFlag1(true);
					// ExportThread.setWork(false);
					Check_UI.getjButton_determin().setEnabled(true);
					return;
				} else if (b1 == b2) {
					if (c1 > c2) {
						JOptionPane.showMessageDialog(null, "秒钟输入上下区间不符合要求",
								"系统信息", JOptionPane.ERROR_MESSAGE);
						Check.setFlag1(true);
						// ExportThread.setWork(false);
						Check_UI.getjButton_determin().setEnabled(true);
						return;
					} else if (c1 == c2) {
						flag = true;
						search_scope(a1, b1, c1, a2, b2, c2, file, list);

					} else {// c1<c2
						flag = true;
						search_scope(a1, b1, c1, a2, b2, c2, file, list);
					}
				} else {// b1<b2
					flag = true;
					if ((b2 - b1) == 1) {
						search_scope(a1, b1, c1, a2, b2 - 1, 59, file, list);
						search_scope(a1, b1 + 1, 0, a2, b2, c2, file, list);

					} else {
						search_scope(a1, b1, c1, a2, b1, 59, file, list);
						search_scope(a1, b1 + 1, 0, a2, b2 - 1, 59, file, list);
						search_scope(a1, b2, 0, a2, b2, c2, file, list);

					}
				}
			} else {// a1<a2
				flag = true;
				if ((a2 - a1) == 1) {
					search_scope(a1, b1, c1, a1, 59, 59, file, list);
					search_scope(a2, 0, 0, a2, b2, c2, file, list);

				} else {
					search_scope(a1, b1, c1, a1, 59, 59, file, list);
					search_scope(a1 + 1, 0, 0, a2 - 1, 59, 59, file, list);
					search_scope(a2, 0, 0, a2, b2, c2, file, list);

				}
			}
		}
	}

	// 跟实际情况按照给定上、下区间搜索相应图片
	public void search_scope(int a_1, int b_1, int c_1, int a_2, int b_2,
			int c_2, File file, List<String> list) {
		String s1 = null;
		String s2 = null;
		String s3 = null;
		String s = null;
		int ii = 0;
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
						File image_file = search(s, file);
						if (image_file != null) {
							// System.out.println(ii++);
							list.add(image_file.getAbsolutePath());
							ii = ii + 1;
							// System.out.println(image_file.getAbsolutePath());

						} else if (list != null && list.size() > 0) {
							// System.out.println("sss:" + ii);
							if ((list.size() >= ii + 1 && list.get(ii)
									.endsWith(s + ".jpg")))
									 {
								System.out.println(list.size());
								list.add("image/blank.jpg");//
								ii = ii + 1;
								// 添加一张错误提示图片，表示该时间图片缺失
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

	/**
	 * 查找指定文件内是否还有文件名为 s 的文件
	 */
	public static File search(String s, File file) {
		File[] fileList = file.listFiles();
		File file_search = null;
		for (File f : fileList) {
			if (s.equals(getNewName(f))) {
				file_search = f;
				break;
			} else {
				file_search = null;
			}
		}
		return file_search;
	}

	public static String getNewName(File file) {
		String name = file.getName();
		int lastIndex = name.lastIndexOf(".") == -1 ? name.length() : name
				.lastIndexOf(".");
		return name.substring(0, lastIndex);
	}

	public static List<String> getList() {
		return list;
	}

	public static void setList(List<String> list) {
		Check.list = list;
	}

	

	public static int getMax() {
		return max;
	}

	public static void setMax(int max) {
		Check.max = max;
	}

	public static boolean isFlag() {
		return flag;
	}

	public static void setFlag(boolean flag) {
		Check.flag = flag;
	}

	public static boolean isFlag1() {
		return flag1;
	}

	public static void setFlag1(boolean flag1) {
		Check.flag1 = flag1;
	}

}
