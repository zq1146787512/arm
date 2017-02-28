package com.school.method;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.school.ui.Check_UI;
import com.school.ui.ShowFrame;
/**
 *播放程序定时器
 */
public class PlayPic extends TimerTask {

	/** 当前要画的图片 */
	private BufferedImage currentImage1 = null;
	private BufferedImage currentImage2 = null;
	private BufferedImage currentImage3 = null;
	private BufferedImage currentImage4 = null;
	private List<String> list1 = new ArrayList<String>();
	private List<String> list2 = new ArrayList<String>();
	private List<String> list3 = new ArrayList<String>();
	private List<String> list4 = new ArrayList<String>();

	/** 是否暂停 */
	private boolean stop = false;
	/** 循环的初始值 */
	private static int k;

	private boolean pre = false;
	private boolean next = false;

	public void run() {

		// System.out.println("playpic开始啦！");
		if (!stop) {
			if ((list1 != null && list1.size() > 0)
					|| (list2 != null && list2.size() > 0)
					|| (list3 != null && list3.size() > 0)
					|| (list4 != null && list4.size() > 0)) {
				if (k < list1.size() - 1) {
					k++;
				}
				// 判空且满足当前循环值小于当前list的大小时才能绘制图片
				if (list1 != null && list1.size() > 0 && k < list1.size()) {
					currentImage1 = listchangetoimage(list1.get(k));
					ShowFrame.getJp1b().setCurrentImage(currentImage1);
					ShowFrame.getJp1b().repaint();

					if (gettime(list1.get(k)) != null) {
						ShowFrame.getJtexttime().setText(gettime(list1.get(k)));
						ShowFrame.getJtexttime1()
								.setText(gettime(list1.get(k)));
						// System.out.println("C1:===" + getname(list1.get(k)));
					}
				}
				if (list2 != null && list2.size() > 0 && k < list2.size()) {
					currentImage2 = listchangetoimage(list2.get(k));
					ShowFrame.getJp2b().setCurrentImage(currentImage2);
					ShowFrame.getJp2b().repaint();

					if (gettime(list2.get(k)) != null) {
						ShowFrame.getJtexttime().setText(gettime(list2.get(k)));
						ShowFrame.getJtexttime2()
								.setText(gettime(list2.get(k)));
						// System.out.println("C2:===" + getname(list2.get(k)));
					}
				}
				if (list3 != null && list3.size() > 0 && k < list3.size()) {
					currentImage3 = listchangetoimage(list3.get(k));
					ShowFrame.getJp3b().setCurrentImage(currentImage3);
					ShowFrame.getJp3b().repaint();
					if (gettime(list3.get(k)) != null) {
						ShowFrame.getJtexttime().setText(gettime(list3.get(k)));
						ShowFrame.getJtexttime3()
								.setText(gettime(list3.get(k)));
						// System.out.println("c3:===" + getname(list3.get(k)));
					}
				}
				if (list4 != null && list4.size() > 0 && k < list4.size()) {
					currentImage4 = listchangetoimage(list4.get(k));
					ShowFrame.getJp4b().setCurrentImage(currentImage4);
					ShowFrame.getJp4b().repaint();
					if (gettime(list4.get(k)) != null) {
						ShowFrame.getJtexttime().setText(gettime(list4.get(k)));
						ShowFrame.getJtexttime4()
								.setText(gettime(list4.get(k)));
						// System.out.println("C4:===" + getname(list4.get(k)));
					}

				}

			}

		} else if (stop) {
			if (pre) {
				// System.out.println(k);
				if (k == 0) {
					pre = false;
				} else {
					k--;
					// 判空且满足当前循环值小于当前list的大小时才能绘制图片
					if (list1 != null && list1.size() > 0 && k < list1.size()) {
						currentImage1 = listchangetoimage(list1.get(k));
						ShowFrame.getJp1b().setCurrentImage(currentImage1);
						ShowFrame.getJp1b().repaint();
						if (gettime(list1.get(k)) != null) {
							ShowFrame.getJtexttime().setText(
									gettime(list1.get(k)));
							ShowFrame.getJtexttime1().setText(
									gettime(list1.get(k)));
							// System.out.println("C1:" + k);
						}
					}
					if (list2 != null && list2.size() > 0 && k < list2.size()) {
						currentImage2 = listchangetoimage(list2.get(k));
						ShowFrame.getJp2b().setCurrentImage(currentImage2);
						ShowFrame.getJp2b().repaint();
						if (gettime(list2.get(k)) != null) {
							ShowFrame.getJtexttime().setText(
									gettime(list2.get(k)));
							ShowFrame.getJtexttime2().setText(
									gettime(list2.get(k)));
							// System.out.println("C2:" + k);
						}
					}
					if (list3 != null && list3.size() > 0 && k < list3.size()) {
						currentImage3 = listchangetoimage(list3.get(k));
						ShowFrame.getJp3b().setCurrentImage(currentImage3);
						ShowFrame.getJp3b().repaint();
						if (gettime(list3.get(k)) != null) {
							ShowFrame.getJtexttime().setText(
									gettime(list3.get(k)));
							ShowFrame.getJtexttime3().setText(
									gettime(list3.get(k)));
							// System.out.println("C3:" + k);
						}
					}
					if (list4 != null && list4.size() > 0 && k < list4.size()) {
						currentImage4 = listchangetoimage(list4.get(k));
						ShowFrame.getJp4b().setCurrentImage(currentImage4);
						ShowFrame.getJp4b().repaint();
						if (gettime(list4.get(k)) != null) {
							ShowFrame.getJtexttime().setText(
									gettime(list4.get(k)));
							ShowFrame.getJtexttime4().setText(
									gettime(list4.get(k)));
							// System.out.println("C4:" + k);
						}
					}

					// System.out.println("pre语句中:" + k);

				}
				pre = false;
			} else if (next) {

				if (k >= list1.size() - 1) {
					next = false;
				} else {
					k++;
					// 判空且满足当前循环值小于当前list的大小时才能绘制图片
					if (list1 != null && list1.size() > 0 && k < list1.size()) {
						currentImage1 = listchangetoimage(list1.get(k));
						ShowFrame.getJp1b().setCurrentImage(currentImage1);
						ShowFrame.getJp1b().repaint();
						if (gettime(list1.get(k)) != null) {
							ShowFrame.getJtexttime().setText(
									gettime(list1.get(k)));
							ShowFrame.getJtexttime1().setText(
									gettime(list1.get(k)));
						}
					}
					if (list2 != null && list2.size() > 0 && k < list2.size()) {
						currentImage2 = listchangetoimage(list2.get(k));
						ShowFrame.getJp2b().setCurrentImage(currentImage2);
						ShowFrame.getJp2b().repaint();
						if (gettime(list2.get(k)) != null) {
							ShowFrame.getJtexttime().setText(
									gettime(list2.get(k)));
							ShowFrame.getJtexttime2().setText(
									gettime(list2.get(k)));
						}
					}
					if (list3 != null && list3.size() > 0 && k < list3.size()) {
						currentImage3 = listchangetoimage(list3.get(k));
						ShowFrame.getJp3b().setCurrentImage(currentImage3);
						ShowFrame.getJp3b().repaint();
						if (gettime(list3.get(k)) != null) {
							ShowFrame.getJtexttime().setText(
									gettime(list3.get(k)));
							ShowFrame.getJtexttime3().setText(
									gettime(list3.get(k)));
						}
					}
					if (list4 != null && list4.size() > 0 && k < list4.size()) {
						currentImage4 = listchangetoimage(list4.get(k));
						ShowFrame.getJp4b().setCurrentImage(currentImage4);
						ShowFrame.getJp4b().repaint();
						if (gettime(list4.get(k)) != null) {
							ShowFrame.getJtexttime().setText(
									gettime(list4.get(k)));
							ShowFrame.getJtexttime4().setText(
									gettime(list4.get(k)));
						}
					}

					// System.out.println("next语句中:" + k);
				}

				next = false;
			}

		}

	}

	/**
	 * 将图片地址解读为bufferedimage
	 * 
	 * @param pathname
	 * @return
	 */
	public BufferedImage listchangetoimage(String pathname) {

		File file1 = new File(pathname); // 用file1取得图片地址
		BufferedImage input = null;
		try {
			input = ImageIO.read(file1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return input;
	}

	/**
	 * 图片名字
	 * 
	 * @param pathname
	 * @return
	 */
	public String getname(String pathname) {
		File file1 = new File(pathname); // 用file1取得图片名字
		String name = file1.getName();
		return name;
	}

	/**
	 * 图片名字
	 * 
	 * @param pathname
	 * @return
	 */
	public String gettime(String pathname) {
		File file1 = new File(pathname); // 用file1取得图片名字
		String name = file1.getName();
		int lastIndex1 = name.lastIndexOf("-") == -1 ? name.length() : name
				.lastIndexOf("-");
		String k1 = name.substring(0, lastIndex1);
		int lastIndex2 = name.lastIndexOf(".") == -1 ? name.length() : name
				.lastIndexOf(".");

		if (lastIndex1 >= name.length()) {
			return null;
		} else {
			String k2 = name.substring(lastIndex1 + 1, lastIndex2);
			k1 = k1.replaceAll("-", ":");
			return k1 + "-" + k2;
		}
	}

	/**
	 * 牌照时间
	 */
	public String pzsj() {
		String paizhao = Check_UI.getPaiZhao();
		paizhao = paizhao.replaceAll("-", "");
		String riqi = Check_UI.getRiQi();
		riqi = riqi.replaceAll("-", "");
		return paizhao + "-" + riqi + "-";

	}

	/**
	 * 图片导出1
	 */
	public void daochu1() {
		if (!list1.isEmpty() && list1.get(k) != null) {
			String shijian = getname(list1.get(k));
			// System.out.println(shijian);
			shijian = shijian.replaceFirst("-", "");
			shijian = shijian.replaceFirst("-", "");
			JFileChooser jFileChooser = new JFileChooser();
			jFileChooser.setMultiSelectionEnabled(true);
			jFileChooser.setFileSelectionMode(1);
			int i = jFileChooser.showOpenDialog(null);
			if (i == JFileChooser.APPROVE_OPTION) {
				// 添加选中的要复制对象的地址
				try {
					ImageIO.write(currentImage1, "jpg", new File(jFileChooser
							.getSelectedFile().getAbsolutePath()
							+ "\\"
							+ pzsj() + "T1-" + shijian));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			JOptionPane.showMessageDialog(ShowFrame.getJf().getContentPane(),
					"图片不存在", "提示信息", JOptionPane.ERROR_MESSAGE);
			return;
		}

	}

	/**
	 * 图片导出2
	 */
	public void daochu2() {
		if (!list2.isEmpty() && list2.get(k) != null) {
			String shijian = getname(list2.get(k));
			shijian = shijian.replaceFirst("-", "");
			shijian = shijian.replaceFirst("-", "");
			JFileChooser jFileChooser = new JFileChooser();
			jFileChooser.setMultiSelectionEnabled(true);
			jFileChooser.setFileSelectionMode(1);
			int i = jFileChooser.showOpenDialog(null);
			if (i == JFileChooser.APPROVE_OPTION) {
				// 添加选中的要复制对象的地址
				try {
					ImageIO.write(currentImage2, "jpg", new File(jFileChooser
							.getSelectedFile().getAbsolutePath()
							+ "\\"
							+ pzsj() + "T2-" + shijian));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			JOptionPane.showMessageDialog(ShowFrame.getJf().getContentPane(),
					"图片不存在", "提示信息", JOptionPane.ERROR_MESSAGE);
			return;
		}

	}

	/**
	 * 图片导出3
	 */
	public void daochu3() {
		if (!list3.isEmpty() && list3.get(k) != null) {
			String shijian = getname(list3.get(k));
			shijian = shijian.replaceFirst("-", "");
			shijian = shijian.replaceFirst("-", "");
			JFileChooser jFileChooser = new JFileChooser();
			jFileChooser.setMultiSelectionEnabled(true);
			jFileChooser.setFileSelectionMode(1);
			int i = jFileChooser.showOpenDialog(null);
			if (i == JFileChooser.APPROVE_OPTION) {
				// 添加选中的要复制对象的地址
				try {
					ImageIO.write(currentImage3, "jpg", new File(jFileChooser
							.getSelectedFile().getAbsolutePath()
							+ "\\"
							+ pzsj() + "T3-" + shijian));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			JOptionPane.showMessageDialog(ShowFrame.getJf().getContentPane(),
					"图片不存在", "提示信息", JOptionPane.ERROR_MESSAGE);
			return;
		}

	}

	/**
	 * 图片导出4
	 */
	public void daochu4() {
		if (!list4.isEmpty() && list4.get(k) != null) {
			String shijian = getname(list4.get(k));
			shijian = shijian.replaceFirst("-", "");
			shijian = shijian.replaceFirst("-", "");
			JFileChooser jFileChooser = new JFileChooser();
			jFileChooser.setMultiSelectionEnabled(true);
			jFileChooser.setFileSelectionMode(1);
			int i = jFileChooser.showOpenDialog(null);
			if (i == JFileChooser.APPROVE_OPTION) {
				// 添加选中的要复制对象的地址
				try {
					ImageIO.write(currentImage4, "jpg", new File(jFileChooser
							.getSelectedFile().getAbsolutePath()
							+ "\\"
							+ pzsj() + "T4-" + shijian));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			JOptionPane.showMessageDialog(ShowFrame.getJf().getContentPane(),
					"图片不存在", "提示信息", JOptionPane.ERROR_MESSAGE);
			return;
		}

	}

	/**
	 * 设置是否暂停
	 * 
	 * @param stop
	 *            ture 暂停，false 不暂停
	 */
	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public void setpre(boolean pre) {
		this.pre = pre;
	}

	public void setnext(boolean next) {
		this.next = next;
	}

	public BufferedImage getCurrentImage1() {
		return currentImage1;
	}

	public void setCurrentImage1(BufferedImage currentImage1) {
		this.currentImage1 = currentImage1;
	}

	public BufferedImage getCurrentImage2() {
		return currentImage2;
	}

	public void setCurrentImage2(BufferedImage currentImage2) {
		this.currentImage2 = currentImage2;
	}

	public BufferedImage getCurrentImage3() {
		return currentImage3;
	}

	public void setCurrentImage3(BufferedImage currentImage3) {
		this.currentImage3 = currentImage3;
	}

	public BufferedImage getCurrentImage4() {
		return currentImage4;
	}

	public void setCurrentImage4(BufferedImage currentImage4) {
		this.currentImage4 = currentImage4;
	}

	public List<String> getList1() {
		return list1;
	}

	public void setList1(List<String> list1) {
		this.list1 = list1;
	}

	public List<String> getList2() {
		return list2;
	}

	public void setList2(List<String> list2) {
		this.list2 = list2;
	}

	public List<String> getList3() {
		return list3;
	}

	public void setList3(List<String> list3) {
		this.list3 = list3;
	}

	public List<String> getList4() {
		return list4;
	}

	public void setList4(List<String> list4) {
		this.list4 = list4;
	}

	public static int getK() {
		return k;
	}

	public static void setK(int k) {
		PlayPic.k = k;
	}

}
