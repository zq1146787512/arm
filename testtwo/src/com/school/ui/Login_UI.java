package com.school.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.school.utils.SystemConfig;

public class Login_UI {
	public static JFrame f;
	private JLabel jl_1;
	private JLabel jl_2;
	private JTextField jTextField;
	private JPasswordField jPassWord;
	private JButton jButton_1;
	private JButton jButton_2;

	public void init() {
		f = new JFrame("搜索回放图像处理软件");
		jl_1 = new JLabel("账 号");
		jl_1.setBounds(110, 100, 40, 30);
		jTextField = new JTextField();
		jTextField.setBounds(160, 100, 120, 30);

		jl_2 = new JLabel("密 码");
		jl_2.setBounds(110, 140, 40, 30);
		jPassWord = new JPasswordField();
		jPassWord.setBounds(160, 140, 120, 30);

		jButton_1 = new JButton("登陆");
		jButton_1.setBounds(120, 180, 60, 30);

		jButton_2 = new JButton("取消");
		jButton_2.setBounds(200, 180, 60, 30);

		jButton_1.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				if ((jTextField.getText()).equals(SystemConfig.p
						.getProperty("username"))
						&& (jPassWord.getText()).equals(SystemConfig.p
								.getProperty("password"))) {
					// System.out.println(jTextField.getText() + "==="
					// + jPassWord.getText());
					f.hide();
					new MainFrame();
				} else {
					JOptionPane.showMessageDialog(f.getContentPane(),
							"你输入的用户密码错误！", "系统信息", JOptionPane.ERROR_MESSAGE);
					return;
				}

			}
		});

		jButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				f.dispose();
			}
		});

		f.add(jl_1);
		f.add(jl_2);
		f.add(jButton_1);
		f.add(jButton_2);
		f.add(jPassWord);
		f.add(jTextField);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(null);// 布局：绝对定位
		f.setBounds(0, 0, 400, 350);
		f.setResizable(false);// 窗口大小不能改变
		f.setLocationRelativeTo(null);// 居中显示
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new Login_UI().init();
	}
}
