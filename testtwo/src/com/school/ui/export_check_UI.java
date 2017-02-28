package com.school.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.school.method.Export_Thread;
import com.school.method.export_check;
import com.school.method.export_getParam;
import com.school.method.realTime_preogressBar;

public class export_check_UI {
	public static int i;
	public static int mark = 0;
	private static int mark1 = 0;
	private static int mark2 = 0;
	private static int mark3 = 0;
	private static int mark4 = 0;

	public static export_getParam export__gp;

	private JFrame jFrame;
	private JLabel jLabel_1;
	private JLabel jLabel_2;
	private JLabel jLabel_3;
	private JLabel jLabel_4;
	private JLabel jLabel_5;

	private JComboBox<Object> jComboBox_1_1;
	private JComboBox<Object> jComboBox_1_2;

	private JComboBox<String> jComboBox_1;
	private JComboBox<String> jComboBox_2;
	private JComboBox<String> jComboBox_3;
	private JComboBox<String> jComboBox_4;
	private JComboBox<String> jComboBox_5;
	private JComboBox<String> jComboBox_6;
	private JComboBox<String> jComboBox_7;
	private JComboBox<String> jComboBox_8;
	private JComboBox<String> jComboBox_9;

	private JTextField jTextField;

	private JCheckBox jCheckBox_1;
	private JCheckBox jCheckBox_2;
	private JCheckBox jCheckBox_3;
	private JCheckBox jCheckBox_4;

	private JLabel jLabel;
	private JTextField jTextField2;
	private JButton jButton_choose;

	private JButton jButton_determin;
	private JButton jButton_cancel;

	private JLabel jLabel2;
	private JTextField jTextField3;// 导出路径
	private JButton jButton_choose2;

	public void init() {

		// gp = new getParam(root, paiZhao, data, sheXiangTou, hour_1, min_1,
		// sec_1, hour_2, min_2, sec_2)

		jFrame = new JFrame("检索图片");
		jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jFrame.setResizable(false);
		jFrame.setBounds(0, 0, 600, 500);
		jFrame.setLocationRelativeTo(null);
		jFrame.setLayout(null);

		jLabel = new JLabel("请输入文件路径：");
		jLabel.setBounds(55, 70, 105, 30);
		jTextField2 = new JTextField();
		jTextField2.setBounds(170, 70, 250, 30);
		jButton_choose = new JButton("选择...");
		jButton_choose.setBounds(430, 70, 70, 30);

		jLabel_1 = new JLabel("请输入车牌号：");
		jLabel_1.setBounds(60, 130, 100, 40);
		String[] s1_1 = { "沪" };
		jComboBox_1_1 = new JComboBox<Object>(s1_1);
		jComboBox_1_1.setBounds(170, 130, 80, 40);
		String[] s1_2 = { "A", "B", "C", "D", "E", "F", "H" };
		jComboBox_1_2 = new JComboBox<Object>(s1_2);
		jComboBox_1_2.setBounds(260, 130, 80, 40);
		jTextField = new JTextField();
		jTextField.setBounds(350, 130, 100, 40);

		jLabel_2 = new JLabel("请选择日期：");
		jLabel_2.setBounds(60, 200, 100, 40);
		String[] s1 = { "2016", "2017", "2018", "2019", "2020", "2021", "2022",
				"2023" };
		jComboBox_1 = new JComboBox<String>(s1);
		jComboBox_1.setBounds(170, 200, 70, 40);
		String[] s2 = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"11", "12" };
		jComboBox_2 = new JComboBox<String>(s2);
		jComboBox_2.setBounds(250, 200, 50, 40);
		String[] s3 = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
				"21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
				"31" };
		jComboBox_3 = new JComboBox<String>(s3);
		jComboBox_3.setBounds(310, 200, 50, 40);

		jLabel_5 = new JLabel("请选择时间段:");
		jLabel_5.setBounds(60, 250, 100, 40);

		String[] s4 = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
				"21", "22", "23" };
		jComboBox_4 = new JComboBox<String>(s4);
		jComboBox_4.setBounds(170, 250, 50, 40);
		String[] s5 = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
				"21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
				"31", "32", "33", "34", "35", "36", "37", "38", "39", "40",
				"41", "42", "43", "44", "45", "46", "47", "48", "49", "50",
				"51", "52", "53", "54", "55", "56", "57", "58", "59" };
		jComboBox_5 = new JComboBox<String>(s5);
		jComboBox_5.setBounds(230, 250, 50, 40);
		jComboBox_6 = new JComboBox<String>(s5);
		jComboBox_6.setBounds(290, 250, 50, 40);

		jLabel_4 = new JLabel("至");
		jLabel_4.setBounds(350, 250, 30, 40);

		jComboBox_7 = new JComboBox<String>(s4);
		jComboBox_7.setBounds(370, 250, 50, 40);
		jComboBox_8 = new JComboBox<String>(s5);
		jComboBox_8.setBounds(430, 250, 50, 40);
		jComboBox_9 = new JComboBox<String>(s5);
		jComboBox_9.setBounds(490, 250, 50, 40);

		jLabel_3 = new JLabel("请选择摄像头：");
		jLabel_3.setBounds(60, 310, 100, 40);
		jCheckBox_1 = new JCheckBox("T1");
		jCheckBox_1.setBounds(170, 310, 40, 40);
		jCheckBox_2 = new JCheckBox("T2");
		jCheckBox_2.setBounds(215, 310, 40, 40);
		jCheckBox_3 = new JCheckBox("T3");
		jCheckBox_3.setBounds(260, 310, 40, 40);
		jCheckBox_4 = new JCheckBox("T4");
		jCheckBox_4.setBounds(305, 310, 40, 40);

		jButton_determin = new JButton("确定");
		jButton_determin.setBounds(380, 315, 60, 30);
		jButton_cancel = new JButton("取消");
		jButton_cancel.setBounds(460, 315, 60, 30);

		jLabel2 = new JLabel("导出路径：");
		jLabel2.setBounds(60, 365, 105, 30);
		jTextField3 = new JTextField();
		jTextField3.setBounds(170, 365, 250, 30);
		jButton_choose2 = new JButton("选择...");
		jButton_choose2.setBounds(430, 365, 70, 30);

		jFrame.add(jLabel_1);
		jFrame.add(jLabel_2);
		jFrame.add(jLabel_3);
		jFrame.add(jComboBox_1_1);
		jFrame.add(jComboBox_1_2);
		jFrame.add(jTextField);
		jFrame.add(jLabel_5);
		jFrame.add(jLabel_4);
		jFrame.add(jCheckBox_1);
		jFrame.add(jCheckBox_2);
		jFrame.add(jCheckBox_3);
		jFrame.add(jCheckBox_4);
		jFrame.add(jLabel);
		jFrame.add(jTextField2);
		jFrame.add(jButton_choose);
		jFrame.add(jButton_determin);
		jFrame.add(jButton_cancel);
		jFrame.add(jComboBox_1);
		jFrame.add(jComboBox_2);
		jFrame.add(jComboBox_3);
		jFrame.add(jComboBox_4);
		jFrame.add(jComboBox_5);
		jFrame.add(jComboBox_6);
		jFrame.add(jComboBox_7);
		jFrame.add(jComboBox_8);
		jFrame.add(jComboBox_9);
		jFrame.add(jLabel2);
		jFrame.add(jTextField3);
		jFrame.add(jButton_choose2);

		jButton_choose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser jFileChooser = new JFileChooser();
				jFileChooser.setMultiSelectionEnabled(true);
				jFileChooser.setFileSelectionMode(1);
				int i = jFileChooser.showOpenDialog(jFrame);
				if (i == JFileChooser.APPROVE_OPTION) {
					jTextField2.setText(jFileChooser.getSelectedFile()
							.getAbsolutePath());
				}

			}
		});

		jButton_determin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// PaiZhaoArea pza = new PaiZhaoArea();
				// 根路径

				String root = null;
				if ((jTextField2.getText()).length() != 0) {
					root = jTextField2.getText();
				} else {
					JOptionPane.showMessageDialog(jFrame.getContentPane(),
							"未输入查找文件路径", "检索目录信息", JOptionPane.ERROR_MESSAGE);
					return;
				}
				String pz = null;
				if (jTextField.getText().length() == 5) {
					pz = (String) jTextField.getText();
				} else {
					JOptionPane.showMessageDialog(jFrame.getContentPane(),
							"车牌号输入信息不正确", "系统信息", JOptionPane.ERROR_MESSAGE);
					return;
				}
				// 牌照
				// String paiZhao = pza.getValue((String) jComboBox_1_1
				// .getSelectedItem())
				// + (String) jComboBox_1_2.getSelectedItem() + "-" + pz;
				String paiZhao1 = (String) jComboBox_1_1.getSelectedItem()
						+ (String) jComboBox_1_2.getSelectedItem() + pz;
				String riQi = null;
				if (Integer.parseInt((String) jComboBox_2.getSelectedItem()) < 10
						&& Integer.parseInt((String) jComboBox_3
								.getSelectedItem()) < 10) {
					riQi = jComboBox_1.getSelectedItem() + "-" + "0"
							+ jComboBox_2.getSelectedItem() + "-" + "0"
							+ jComboBox_3.getSelectedItem();
				} else if (Integer.parseInt((String) jComboBox_2
						.getSelectedItem()) < 10) {
					riQi = jComboBox_1.getSelectedItem() + "-" + "0"
							+ jComboBox_2.getSelectedItem() + "-"
							+ jComboBox_3.getSelectedItem();
				} else if (Integer.parseInt((String) jComboBox_3
						.getSelectedItem()) < 10) {
					riQi = jComboBox_1.getSelectedItem() + "-"
							+ jComboBox_2.getSelectedItem() + "-" + "0"
							+ jComboBox_3.getSelectedItem();
				} else {
					riQi = jComboBox_1.getSelectedItem() + "-"
							+ jComboBox_2.getSelectedItem() + "-"
							+ jComboBox_3.getSelectedItem();
				}

				if (!jCheckBox_1.isSelected() && !jCheckBox_2.isSelected()
						&& !jCheckBox_3.isSelected()
						&& !jCheckBox_4.isSelected()) {
					JOptionPane.showMessageDialog(jFrame.getContentPane(),
							"未选择摄像头编号", "系统信息", JOptionPane.ERROR_MESSAGE);
					return;
				}

				String export_root = null;
				if (jTextField3.getText().length() != 0) {
					export_root = jTextField3.getText();
				} else {
					JOptionPane.showMessageDialog(jFrame.getContentPane(),
							"未输入导出文件路径", "系统信息", JOptionPane.ERROR_MESSAGE);
					return;
				}

				File rootFile = new File(root);
				File f1 = export_check.search(paiZhao1, rootFile);
				File f2 = null;
				if (f1 != null) {
					f2 = export_check.search(riQi, f1);
					if (f2 == null) {
						JOptionPane.showMessageDialog(null, "不存在车牌号为"
								+ paiZhao1 + "的" + riQi + "日期的图像信息", "系统信息",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
				} else {
					JOptionPane.showMessageDialog(null, "不存在车牌号为" + paiZhao1
							+ "的图像信息", "系统信息", JOptionPane.ERROR_MESSAGE);
					return;
				}

				int a1 = Integer.parseInt((String) jComboBox_4
						.getSelectedItem());
				int b1 = Integer.parseInt((String) jComboBox_5
						.getSelectedItem());
				int c1 = Integer.parseInt((String) jComboBox_6
						.getSelectedItem());
				int a2 = Integer.parseInt((String) jComboBox_7
						.getSelectedItem());
				int b2 = Integer.parseInt((String) jComboBox_8
						.getSelectedItem());
				int c2 = Integer.parseInt((String) jComboBox_9
						.getSelectedItem());

				if (a1 == 0 && a2 == 0 && b1 == 0 && b2 == 0 && c1 == 0
						&& c2 == 0) {
					JOptionPane.showMessageDialog(null, "选择上下区间不能同时为0", "系统信息",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (a1 > a2) {
					JOptionPane.showMessageDialog(null, "小时输入上下区间不符合要求",
							"系统信息", JOptionPane.ERROR_MESSAGE);
					return;
				} else if (a1 == a2) {
					if (b1 > b2) {
						JOptionPane.showMessageDialog(null, "分钟输入上下区间不符合要求",
								"系统信息", JOptionPane.ERROR_MESSAGE);
						return;
					} else if (b1 == b2) {
						if (c1 > c2) {
							JOptionPane.showMessageDialog(null,
									"秒钟输入上下区间不符合要求", "系统信息",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
				}

				// 时间上下区间不能同时为0
				// if(jComboBox_4.getSelectedItem().equals("0")&&
				// jComboBox_5.getSelectedItem().equals("0")&&
				// jComboBox_6.getSelectedItem().equals("0")&&
				// jComboBox_7.getSelectedItem().equals("0")&&
				// jComboBox_8.getSelectedItem().equals("0")&&
				// jComboBox_9.getSelectedItem().equals("0")){
				// JOptionPane.showMessageDialog(null,"选择上下区间不能同时为0",
				// "系统信息", JOptionPane.ERROR_MESSAGE);
				// return;
				// }

				if (jCheckBox_1.isSelected()) {
					// System.out.println("1");
					mark1 = 1;
					i = 1;
					export_getParam export_gp = new export_getParam(f2,
							paiZhao1, riQi, jCheckBox_1.getText(),
							(String) jComboBox_4.getSelectedItem(),
							(String) jComboBox_5.getSelectedItem(),
							(String) jComboBox_6.getSelectedItem(),
							(String) jComboBox_7.getSelectedItem(),
							(String) jComboBox_8.getSelectedItem(),
							(String) jComboBox_9.getSelectedItem(), export_root);

					Export_Thread et_1 = new Export_Thread(export_gp, i);
					Thread t1 = new Thread(et_1);
					t1.start();

				}

				if (jCheckBox_2.isSelected()) {
					// System.out.println("2");
					mark2 = 1;
					i = 2;
					export_getParam export_gp = new export_getParam(f2,
							paiZhao1, riQi, jCheckBox_2.getText(),
							(String) jComboBox_4.getSelectedItem(),
							(String) jComboBox_5.getSelectedItem(),
							(String) jComboBox_6.getSelectedItem(),
							(String) jComboBox_7.getSelectedItem(),
							(String) jComboBox_8.getSelectedItem(),
							(String) jComboBox_9.getSelectedItem(), export_root);
					Export_Thread et_2 = new Export_Thread(export_gp, i);
					Thread t2 = new Thread(et_2);
					t2.start();

				}

				if (jCheckBox_3.isSelected()) {
					// System.out.println("3");
					mark3 = 1;
					i = 3;
					export_getParam export_gp = new export_getParam(f2,
							paiZhao1, riQi, jCheckBox_3.getText(),
							(String) jComboBox_4.getSelectedItem(),
							(String) jComboBox_5.getSelectedItem(),
							(String) jComboBox_6.getSelectedItem(),
							(String) jComboBox_7.getSelectedItem(),
							(String) jComboBox_8.getSelectedItem(),
							(String) jComboBox_9.getSelectedItem(), export_root);

					Export_Thread et_3 = new Export_Thread(export_gp,
							export_check_UI.i);
					Thread t3 = new Thread(et_3);
					t3.start();

				}

				if (jCheckBox_4.isSelected()) {
					// System.out.println("4");
					mark4 = 1;
					i = 4;
					export_getParam export_gp = new export_getParam(f2,
							paiZhao1, riQi, jCheckBox_4.getText(),
							(String) jComboBox_4.getSelectedItem(),
							(String) jComboBox_5.getSelectedItem(),
							(String) jComboBox_6.getSelectedItem(),
							(String) jComboBox_7.getSelectedItem(),
							(String) jComboBox_8.getSelectedItem(),
							(String) jComboBox_9.getSelectedItem(), export_root);

					Export_Thread et_4 = new Export_Thread(export_gp, i);
					Thread t4 = new Thread(et_4);
					t4.start();
				}

				export__gp = new export_getParam(f2, paiZhao1, riQi,
						jCheckBox_1.getText(), (String) jComboBox_4
								.getSelectedItem(), (String) jComboBox_5
								.getSelectedItem(), (String) jComboBox_6
								.getSelectedItem(), (String) jComboBox_7
								.getSelectedItem(), (String) jComboBox_8
								.getSelectedItem(), (String) jComboBox_9
								.getSelectedItem(), export_root);

				mark = mark1 + mark2 + mark3 + mark4;
				// System.out.println(mark);
				// System.out.println("number=" + mark);
				if (mark != 0) {

					jFrame.setVisible(false);
					new Progressbar().init();
					realTime_preogressBar real = new realTime_preogressBar();
					Timer timerbar = new Timer();
					timerbar.schedule(real, 100, 500);
				}

			}
		});

		jButton_cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jFrame.dispose();
			}
		});

		jButton_choose2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser jFileChooser = new JFileChooser();
				jFileChooser.setMultiSelectionEnabled(true);
				jFileChooser.setFileSelectionMode(1);
				int i = jFileChooser.showOpenDialog(jFrame);
				if (i == JFileChooser.APPROVE_OPTION) {
					jTextField3.setText(jFileChooser.getSelectedFile()
							.getAbsolutePath());
				}
			}
		});

		jFrame.setVisible(true);
	}
	// public static void main(String[] args) {
	// new export_check_UI().init();
	// }

}
