package com.school.ui;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

import com.school.method.realTime_preogressBar;

public class Progressbar {
	private static JFrame jFrame;
	private static JProgressBar jProgressBar;

	// private static JLabel jl;

	public void init() {
		jFrame = new JFrame("导出进度");
		jProgressBar = new JProgressBar();
		jProgressBar.setStringPainted(true);

		jFrame.add(jProgressBar, BorderLayout.NORTH);
		// jl = new JLabel("0%");
		//
		// jFrame.add(jl);
		jFrame.setVisible(true);
		jFrame.setLocationRelativeTo(null);
		jFrame.setSize(300, 160);
		jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// 该方法用来返回上一界面
		jFrame.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				jFrame.dispose();
				realTime_preogressBar.setWork(false);
			}
		});
	}

	public static JProgressBar getjProgressBar() {
		return jProgressBar;
	}

	public static void setjProgressBar(JProgressBar jProgressBar) {
		Progressbar.jProgressBar = jProgressBar;
	}

	// public static JLabel getJl() {
	// return jl;
	// }
	//
	// public static void setJl(JLabel jl) {
	// Progressbar.jl = jl;
	// }

	// public static void main(String[] args) {
	// new Progressbar().init();
	// }

}
