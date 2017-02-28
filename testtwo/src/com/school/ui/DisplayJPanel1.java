package com.school.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

/**
 * 
 * 循环播放图片
 * 
 * @author monitor Created on 2010-12-22, 16:38:02
 */
@SuppressWarnings("serial")
public class DisplayJPanel1 extends JPanel {
	/** 背景颜色 */
	private final Color B_COLOR = Color.LIGHT_GRAY;
	/** 当前要画的图片 */
	private BufferedImage currentImage = null;
	private int width = 100;
	private int height = 100;

	/**
	 * 构造一个最初没有图片显示的DisplayJPanel对象
	 */
	public DisplayJPanel1() {
	}

	@Override
	public void paintComponent(Graphics g) {
		// BufferedImage currentImage = null;
		// System.out.println("绘制1");
		width = ShowFrame.width1();
		height = ShowFrame.height1();
		g.setColor(B_COLOR);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		// System.out.println("绘制1:==" + currentImage);
		if (currentImage != null) {
			g.drawImage(currentImage, 0, 0, width, height, null);
		}
		// 释放资源
		// try {
		// finalize();
		// } catch (Throwable e) {
		// e.printStackTrace();
		// }
	}

	public BufferedImage getCurrentImage() {
		return currentImage;
	}

	public void setCurrentImage(BufferedImage currentImage) {
		this.currentImage = currentImage;
	}

}
