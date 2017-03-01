package com.school.method;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.school.ui.Check_UI;
import com.school.ui.ShowFrame;
import com.school.utils.ImageHelper;
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
	

	/** 是否暂停 */
	private boolean stop = false;
	/** 循环的初始值 */
	private static int k;

	private boolean pre = false;
	private boolean next = false;

	public void run() {

		// System.out.println("playpic开始啦！");
		if (!stop) {
			if ((list1 != null && list1.size() > 0)) {
				if (k < list1.size() - 1) {
					k++;
				}
				// 判空且满足当前循环值小于当前list的大小时才能绘制图片
				if (list1 != null && list1.size() > 0 && k < list1.size()) {
					try {
//						currentImage1 = ImageHelper.cutImage1(list1.get(k), 1);//调用四次切割函数，消耗CPU资源过多
//						currentImage2 = ImageHelper.cutImage1(list1.get(k), 2);
//						currentImage3 = ImageHelper.cutImage1(list1.get(k), 3);
//						currentImage4 = ImageHelper.cutImage1(list1.get(k), 4);
						List<BufferedImage> list=ImageHelper.cutImage(list1.get(k));//调用一次切割函数，减少CPU处理
						currentImage1 = list.get(0);
						currentImage2 = list.get(1);
						currentImage3 = list.get(2);
						currentImage4 = list.get(3);
					} catch (IOException e) {
						
						e.printStackTrace();
					}
					ShowFrame.getJp1b().setCurrentImage(currentImage1);
					ShowFrame.getJp1b().repaint();
					ShowFrame.getJp2b().setCurrentImage(currentImage2);
					ShowFrame.getJp2b().repaint();
					ShowFrame.getJp3b().setCurrentImage(currentImage3);
					ShowFrame.getJp3b().repaint();
					ShowFrame.getJp4b().setCurrentImage(currentImage4);
					ShowFrame.getJp4b().repaint();

					if (gettime(list1.get(k)) != null) {
						ShowFrame.getJtexttime().setText(gettime(list1.get(k)));
						ShowFrame.getJtexttime1()
								.setText(gettime(list1.get(k)));
						// System.out.println("C1:===" + getname(list1.get(k)));
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
						try {
							List<BufferedImage> list=ImageHelper.cutImage(list1.get(k));
							currentImage1 = list.get(0);
							currentImage2 = list.get(1);
							currentImage3 = list.get(2);
							currentImage4 = list.get(3);
						} catch (IOException e) {	
							e.printStackTrace();
						}
						
						ShowFrame.getJp1b().setCurrentImage(currentImage1);
						ShowFrame.getJp1b().repaint();
						ShowFrame.getJp2b().setCurrentImage(currentImage2);
						ShowFrame.getJp2b().repaint();
						ShowFrame.getJp3b().setCurrentImage(currentImage3);
						ShowFrame.getJp3b().repaint();
						ShowFrame.getJp4b().setCurrentImage(currentImage4);
						ShowFrame.getJp4b().repaint();
						
						if (gettime(list1.get(k)) != null) {
							ShowFrame.getJtexttime().setText(
									gettime(list1.get(k)));
							ShowFrame.getJtexttime1().setText(
									gettime(list1.get(k)));
							// System.out.println("C1:" + k);
						}
					}
				}		
				pre = false;
			} else if (next) {

				if (k >= list1.size() - 1) {
					next = false;
				} else {
					k++;
					// 判空且满足当前循环值小于当前list的大小时才能绘制图片
					if (list1 != null && list1.size() > 0 && k < list1.size()) {
						try {
							List<BufferedImage> list=ImageHelper.cutImage(list1.get(k));
							currentImage1 = list.get(0);
							currentImage2 = list.get(1);
							currentImage3 = list.get(2);
							currentImage4 = list.get(3);
						} catch (IOException e) {	
							e.printStackTrace();
						}
						
						ShowFrame.getJp1b().setCurrentImage(currentImage1);
						ShowFrame.getJp1b().repaint();
						ShowFrame.getJp2b().setCurrentImage(currentImage2);
						ShowFrame.getJp2b().repaint();
						ShowFrame.getJp3b().setCurrentImage(currentImage3);
						ShowFrame.getJp3b().repaint();
						ShowFrame.getJp4b().setCurrentImage(currentImage4);
						ShowFrame.getJp4b().repaint();
						
						if (gettime(list1.get(k)) != null) {
							ShowFrame.getJtexttime().setText(
									gettime(list1.get(k)));
							ShowFrame.getJtexttime1().setText(
									gettime(list1.get(k)));
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
	 * 图片导出
	 */
	public void daochu(int t) {
		if (!list1.isEmpty() && list1.get(k) != null) {
			String shijian = getname(list1.get(k));
			// System.out.println(shijian);
			shijian = shijian.replaceFirst("-", "");
			shijian = shijian.replaceFirst("-", "");
			JFileChooser jFileChooser = new JFileChooser();
			jFileChooser.setMultiSelectionEnabled(true);
			jFileChooser.setFileSelectionMode(1);
			BufferedImage currentImage=null;
			switch (t) {
			case 1:currentImage=currentImage1;
				break;
			case 2:currentImage=currentImage2;
				break;
			case 3:currentImage=currentImage3;
				break;
			case 4:currentImage=currentImage4;
				break;
			default:
				break;
			}
			int i = jFileChooser.showOpenDialog(null);
			if (i == JFileChooser.APPROVE_OPTION) {
				// 添加选中的要复制对象的地址
				try {
					ImageIO.write(currentImage, "jpg", new File(jFileChooser
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

	

	public static int getK() {
		return k;
	}

	public static void setK(int k) {
		PlayPic.k = k;
	}

}
