package com.school.ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame {
	private static JFrame jf;

	private JButton jb_check;
	private JButton jb_copy;
	private JLabel jl;

	public MainFrame() {
		initcomponent();

	}

	/**
	 * 初始化组件
	 */
	public void initcomponent() {
		jf = new JFrame();

		// jf.setSize(400, 300);
		jf.setBounds(0, 0, 400, 300);
		jf.setLayout(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = jf.getSize();
		jf.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);
		jf.setResizable(false);
		jf.setVisible(true);

		jb_check = new JButton("检索");
		jb_check.setBounds(135, 75, 150, 40);
		jb_copy = new JButton("上传");
		jb_copy.setBounds(135, 150, 150, 40);
		jl = new JLabel("图片的上传及检索播放");
		jl.setBounds(135, 10, 150, 40);

		jf.add(jb_check);
		jf.add(jb_copy);
		jf.add(jl);

		jb_check.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// jf.setVisible(false);
				new Check_UI().init();

			}
		});
		jb_copy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// jf.setVisible(false);
				new export_check_UI().init();

			}
		});

		// // 该方法用来返回上一界面
		// jf.addWindowListener(new WindowAdapter() {
		// public void windowClosing(WindowEvent e) {
		// super.windowClosing(e);
		//
		// }
		// });
	}

	public static JFrame getJf() {
		return jf;
	}

	public static void setJf(JFrame jf) {
		MainFrame.jf = jf;
	}
	// public static void main(String[] args) {
	// new MainFrame();
	// }

}
