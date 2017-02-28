package com.school.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class chooseFile_UI {
	private JFrame jFrame;
	private JLabel jLabel;
	private JTextField jTextField;
	private JButton jButton_choose;
	private JButton jButton_determin;
	private JButton jButton_cancel;

	public void init() {
		jFrame = new JFrame("上传图片");
		jFrame.setLayout(null);
		jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jFrame.setResizable(false);
		jFrame.setBounds(0, 0, 400, 300);
		jFrame.setLocationRelativeTo(null);

		jLabel = new JLabel("请输入文件路径：");
		jLabel.setBounds(50, 90, 105, 30);

		jTextField = new JTextField();
		jTextField.setBounds(50, 120, 250, 30);
		jButton_choose = new JButton("选择...");
		jButton_choose.setBounds(305, 120, 70, 30);

		jButton_determin = new JButton("确定");
		jButton_determin.setBounds(240, 155, 60, 30);

		jButton_cancel = new JButton("取消");
		jButton_cancel.setBounds(305, 155, 60, 30);

		jFrame.add(jLabel);
		jFrame.add(jTextField);
		jFrame.add(jButton_choose);
		jFrame.add(jButton_determin);
		jFrame.add(jButton_cancel);

		jFrame.setVisible(true);

		jButton_choose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser jFileChooser = new JFileChooser();
				jFileChooser.setMultiSelectionEnabled(true);
				jFileChooser.setFileSelectionMode(1);
				int i = jFileChooser.showOpenDialog(jFrame);
				if (i == JFileChooser.APPROVE_OPTION) {
					jTextField.setText(jFileChooser.getSelectedFile()
							.getAbsolutePath());
				}

			}
		});

		jButton_cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jFrame.dispose();
			}
		});
		// 该方法用来返回上一界面
		jFrame.addWindowListener(new WindowAdapter() {

			@SuppressWarnings("deprecation")
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				MainFrame.getJf().show();
			}
		});
	}
	// public static void main(String[] args) {
	//
	// new chooseFile_UI().init();
	// }
}
