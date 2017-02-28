package com.school.method;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

public class export_check {
	public static int i1 = 0;
	public static int i2 = 0;
	public static int i3 = 0;
	public static int i4 = 0;

	// public static final File rootFile = new File("D:/image");
	// s1,s2,s3分别代表车牌号，日期，摄像头编号
	// a1,b1,c1代表开始时间，a2,b2,c2代表截至时间
	public void search_image(File f, String s1, String s2, String s3, int a1,
			int b1, int c1, int a2, int b2, int c2, String export_root, int i)
			throws FileNotFoundException {

		File f3 = search(s3, f);
		String export_absolute_root = null;
		if (f3 != null) {
			export_absolute_root = export_root + "//" + s1 + "//" + s2 + "//"
					+ s3;
			search_condition(a1, b1, c1, a2, b2, c2, f3, export_absolute_root,
					i);

		} else {
			JOptionPane.showMessageDialog(null, "不存在车牌号为" + s1 + "的" + s2
					+ "日期的" + "摄像头" + s3 + "的图像信息", "系统信息",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
	}

	// String export_absolute_root = null;
	// File root = new File(rootFile);
	// File f1 = search(s1, root);
	// if(f1 != null){
	// File f2 = search(s2, f1);
	// if(f2 != null){
	// File f3 = search(s3, f2);
	// if(f3 != null){
	// export_absolute_root = export_root+"//"+s1+"//"+s2+"//"+s3;
	// //System.out.println(export_absolute_root);
	// search_condition( a1, b1, c1, a2, b2, c2, f3, export_absolute_root,i);
	// }else{
	// JOptionPane.showMessageDialog(null,"不存在车"+s1+"的"+s2+"日期的"+"摄像头"+s3+"的图像信息",
	// "系统信息", JOptionPane.ERROR_MESSAGE);
	// return;
	// }
	// }else{
	// JOptionPane.showMessageDialog(null,"不存在车"+s1+"的"+s2+"日期的图像信息",
	// "系统信息", JOptionPane.ERROR_MESSAGE);
	// return;
	// }
	// }else{
	// JOptionPane.showMessageDialog(null,"不存在车"+s1+"的图像信息",
	// "系统信息", JOptionPane.ERROR_MESSAGE);
	// return;
	// }
	// }

	// 在文件file内搜索用户给定上、下区间所有图片
	public static void search_condition(int a1, int b1, int c1, int a2, int b2,
			int c2, File file, String export_absolute_root, int i)
			throws FileNotFoundException {
		if (a1 < a2) {
			if ((a2 - a1) == 1) {
				search_scope(a1, b1, c1, a1, 59, 59, file,
						export_absolute_root, i);
				search_scope(a2, 0, 0, a2, b2, c2, file, export_absolute_root,
						i);
			} else {
				search_scope(a1, b1, c1, a1, 59, 59, file,
						export_absolute_root, i);
				search_scope(a1 + 1, 0, 0, a2 - 1, 59, 59, file,
						export_absolute_root, i);
				search_scope(a2, 0, 0, a2, b2, c2, file, export_absolute_root,
						i);
			}
		} else if (a1 == a2) {
			if (b1 < b2) {
				if ((b2 - b1) == 1) {
					search_scope(a1, b1, c1, a2, b2 - 1, 59, file,
							export_absolute_root, i);
					search_scope(a1, b1 + 1, 0, a2, b2, c2, file,
							export_absolute_root, i);
				} else {
					search_scope(a1, b1, c1, a2, b1, 59, file,
							export_absolute_root, i);
					search_scope(a1, b1 + 1, 0, a2, b2 - 1, 59, file,
							export_absolute_root, i);
					search_scope(a1, b2, 0, a2, b2, c2, file,
							export_absolute_root, i);
				}
			} else if (b1 == b2) {
				if (c1 == c2) {
					search_scope(a1, b1, c1, a2, b2, c2, file,
							export_absolute_root, i);
				} else {// c1<c2
					search_scope(a1, b1, c1, a2, b2, c2, file,
							export_absolute_root, i);
				}
			}
		}
	}

	// if(a1>a2){
	// JOptionPane.showMessageDialog(null,"小时输入上下区间不符合要求",
	// "系统信息", JOptionPane.ERROR_MESSAGE);
	// return;
	// }else if(a1==a2){
	// if(b1>b2){
	// JOptionPane.showMessageDialog(null,"分钟输入上下区间不符合要求",
	// "系统信息", JOptionPane.ERROR_MESSAGE);
	// return;
	// }else if(b1==b2){
	// if(c1>c2){
	// JOptionPane.showMessageDialog(null,"秒钟输入上下区间不符合要求",
	// "系统信息", JOptionPane.ERROR_MESSAGE);
	// return;
	// }else if(c1==c2){
	// search_scope(a1, b1, c1, a2, b2, c2, file, export_absolute_root,i);
	// }else{//c1<c2
	// search_scope(a1, b1, c1, a2, b2, c2, file, export_absolute_root,i);
	// }
	// }else{//b1<b2
	// if((b2-b1)==1){
	// search_scope(a1, b1, c1, a2, b2-1, 59, file, export_absolute_root,i);
	// search_scope(a1, b1+1, 0, a2, b2, c2, file, export_absolute_root,i);
	// }else{
	// search_scope(a1, b1, c1, a2, b1, 59, file, export_absolute_root,i);
	// search_scope(a1, b1+1, 0, a2, b2-1, 59, file, export_absolute_root,i);
	// search_scope(a1, b2, 0, a2, b2, c2, file, export_absolute_root,i);
	// }
	// }
	// }else{//a1<a2
	// if((a2-a1)==1){
	// search_scope(a1, b1, c1, a1, 59, 59, file, export_absolute_root,i);
	// search_scope(a2, 0, 0, a2, b2, c2, file, export_absolute_root,i);
	// }else{
	// search_scope(a1, b1, c1, a1, 59, 59, file, export_absolute_root,i);
	// search_scope(a1+1, 0, 0, a2-1, 59, 59, file, export_absolute_root,i);
	// search_scope(a2, 0, 0, a2, b2, c2, file, export_absolute_root,i);
	// }
	// }

	// 跟实际情况按照给定上、下区间搜索相应图片
	public static void search_scope(int a_1, int b_1, int c_1, int a_2,
			int b_2, int c_2, File file, String export_absolute_root, int _i)
			throws FileNotFoundException {
		String s1 = null;
		String s2 = null;
		String s3 = null;
		String s = null;
		for (int m = a_1; m <= a_2; m++) {
			for (int n = b_1; n <= b_2; n++) {
				for (int k = c_1; k <= c_2; k++) {
					for (int i = 1; i <= 1; i++) {
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
						File image_file = search(s, file);

						if (image_file != null) {
							String image_AbsolutePath = image_file
									.getAbsolutePath();
							File root_file = new File(export_absolute_root);
							if (!root_file.exists()) {
								root_file.mkdirs();
							}
							// 可以加一个判断图片名称是否重复，然后是否覆盖
							FileInputStream fis = new FileInputStream(
									image_AbsolutePath);
							FileOutputStream fos = new FileOutputStream(
									export_absolute_root + "//"
											+ image_file.getName());
							byte[] b = new byte[1024];
							int num = -1;
							try {
								while ((num = fis.read(b)) != -1) {
									try {
										fos.write(b, 0, num);
									} catch (IOException e) {
										e.printStackTrace();
									}
								}
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							try {
								fis.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
							try {
								fos.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
							// System.out.println(getNewName(image_file));//
							// 这里可以换成播放图片的函数
						}

						switch (_i) {
						case 1:
							i1++;
							// System.out.println("i1shiduoshao" + i1);
							break;
						case 2:
							i2++;
							// System.out.println("i2shiduoshao" + i2);
							break;
						case 3:
							i3++;
							// System.out.println("i3shiduoshao" + i3);
							break;
						case 4:
							i4++;
							// System.out.println("i4shiduoshao" + i4);

						}
						if (realTime_preogressBar.isWork() == false) {
							break;
						}
					}
					if (realTime_preogressBar.isWork() == false) {
						break;
					}
				}
				if (realTime_preogressBar.isWork() == false) {
					break;
				}
			}
			if (realTime_preogressBar.isWork() == false) {
				break;
			}
		}
	}

	// 查找指定文件内是否还有文件名为 s 的文件
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

	// // 列出文件内的所有文件
	// public static void list(File file) {
	// File[] fileList = file.listFiles();
	// for (File f : fileList) {
	// System.out.println(getNewName(f));
	// }
	// }

}
