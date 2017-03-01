package com.school.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.school.method.ExportThread;
import com.school.method.GetParam;
import com.school.method.TestCheck;

public class Check_UI {
	private static JFrame jFrame;
	private static JButton jButton_determin;
	private JLabel jLabel_1;
	private JLabel jLabel_2;
	private JLabel jLabel_3;
	private JLabel jLabel_4;
	private JLabel jLabel_5;

	private JComboBox<Object> jComboBox_1_1;
	private JComboBox<Object> jComboBox_1_2;

	private JComboBox<Object> jComboBox_1;
	private JComboBox<Object> jComboBox_2;
	private JComboBox<Object> jComboBox_3;
	private JComboBox<Object> jComboBox_4;
	private JComboBox<Object> jComboBox_5;
	private JComboBox<Object> jComboBox_6;
	private JComboBox<Object> jComboBox_7;
	private JComboBox<Object> jComboBox_8;
	private JComboBox<Object> jComboBox_9;

	private JTextField jTextField;

	private JCheckBox jCheckBox_1;
	private JCheckBox jCheckBox_2;
	private JCheckBox jCheckBox_3;
	private JCheckBox jCheckBox_4;

	private JLabel jLabel;
	private JTextField jTextField2;
	private JButton jButton_choose;

	// private JButton jButton_determin;
	private JButton jButton_cancel;
	private JButton jb_start;

	private static String paiZhao = null;

	private static String riQi = null;
	private GetParam gp1;

	// public static ShowFrame sf;
	public Check_UI() {

	}

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
		jComboBox_1 = new JComboBox<Object>(s1);
		jComboBox_1.setBounds(170, 200, 70, 40);
		String[] s2 = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"11", "12" };
		jComboBox_2 = new JComboBox<Object>(s2);
		jComboBox_2.setBounds(250, 200, 50, 40);
		String[] s3 = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
				"21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
				"31" };
		jComboBox_3 = new JComboBox<Object>(s3);
		jComboBox_3.setBounds(310, 200, 50, 40);

		jLabel_5 = new JLabel("请选择时间段:");
		jLabel_5.setBounds(60, 250, 100, 40);

		String[] s4 = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
				"21", "22", "23" };
		jComboBox_4 = new JComboBox<Object>(s4);
		jComboBox_4.setBounds(170, 250, 50, 40);
		String[] s5 = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
				"21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
				"31", "32", "33", "34", "35", "36", "37", "38", "39", "40",
				"41", "42", "43", "44", "45", "46", "47", "48", "49", "50",
				"51", "52", "53", "54", "55", "56", "57", "58", "59" };
		jComboBox_5 = new JComboBox<Object>(s5);
		jComboBox_5.setBounds(230, 250, 50, 40);
		jComboBox_6 = new JComboBox<Object>(s5);
		jComboBox_6.setBounds(290, 250, 50, 40);

		jLabel_4 = new JLabel("至");
		jLabel_4.setBounds(350, 250, 30, 40);

		jComboBox_7 = new JComboBox<Object>(s4);
		jComboBox_7.setBounds(370, 250, 50, 40);
		jComboBox_8 = new JComboBox<Object>(s5);
		jComboBox_8.setBounds(430, 250, 50, 40);
		jComboBox_9 = new JComboBox<Object>(s5);
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
		jb_start = new JButton("开始");
		jb_start.setBounds(260, 370, 100, 50);

		jFrame.add(jb_start);
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

		jb_start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (TestCheck.isFlag() == false
				// || ExportThread.isWork() == false
				) {
					JOptionPane.showMessageDialog(jFrame.getContentPane(),
							"请点击确定正确信息", "提示信息", JOptionPane.ERROR_MESSAGE);
					return;
				} else if (TestCheck.isFlag() == true
				// && ExportThread.isWork() == true
				) {
					// PlayPic.setWork(true);
					new ShowFrame().initcomponent();

					jFrame.setVisible(false);
				}
			}
		});

		jButton_determin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 程序开始之前将以前的list中的数据清理干净
				// Check.getList1().clear();
				// Check.getList2().clear();
				// Check.getList3().clear();
				// Check.getList4().clear();
				// // 将list中的循环置为可循环状态，当flag1是false时循环才能继续，只针对再次开启状态
				// Check.setFlag1(false);
				TestCheck.getList1().clear();
				TestCheck.getList2().clear();
				TestCheck.getList3().clear();
				TestCheck.getList4().clear();
				// 将list中的循环置为可循环状态，当flag1是false时循环才能继续，只针对再次开启状态
				TestCheck.setFlag1(false);

				// 根路径
				String root = null;
				if ((jTextField2.getText()).length() != 0) {
					root = jTextField2.getText();
				} else {
					JOptionPane.showMessageDialog(jFrame.getContentPane(),
							"查找目录输入信息不正确", "系统信息", JOptionPane.ERROR_MESSAGE);
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
				// PaiZhaoArea paz = new PaiZhaoArea();
				// 牌照
				// String paiZhao1 = paz.getValue((String) jComboBox_1_1
				// .getSelectedItem())
				// + (String) jComboBox_1_2.getSelectedItem() + pz;
				paiZhao = (String) jComboBox_1_1.getSelectedItem()
						+ (String) jComboBox_1_2.getSelectedItem() + pz;
				// System.out.println(paiZhao1);
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

				File rootFile = new File(root);
				File f1 = TestCheck.search(paiZhao, rootFile);
				File f2 = null;
				if (f1 != null) {
					f2 = TestCheck.search(riQi, f1);
					if (f2 == null) {
						JOptionPane.showMessageDialog(null, "不存在车牌号为" + paiZhao
								+ "的" + riQi + "日期的图像信息", "系统信息",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
				} else {
					JOptionPane.showMessageDialog(null, "不存在车牌号为" + paiZhao
							+ "的图像信息", "系统信息", JOptionPane.ERROR_MESSAGE);
					return;
				}
				int a1 = 0;
				int b1 = 0;
				int c1 = 0;
				// int a1 = Integer.parseInt((String) jComboBox_4
				// .getSelectedItem());
				// int b1 = Integer.parseInt((String) jComboBox_5
				// .getSelectedItem());
				// int c1 = Integer.parseInt((String) jComboBox_6
				// .getSelectedItem());

				String s1 = null;
				String s2 = null;
				String s3 = null;
				String s4 = null;
				if (jCheckBox_1.isSelected()) {
					s1 = jCheckBox_1.getText();
				}
				if (jCheckBox_2.isSelected()) {
					s2 = jCheckBox_2.getText();
				}
				if (jCheckBox_3.isSelected()) {
					s3 = jCheckBox_3.getText();
				}
				if (jCheckBox_4.isSelected()) {
					s4 = jCheckBox_4.getText();

				}
				File f3 = searchtime(f2);
				File f4 = searchtime(f3);
				// System.out.println(gethour(f4));
				// System.out.println(getmin(f4));
				// System.out.println(getsec(f4));
				if (Integer.parseInt(gethour(f4)) < Integer
						.parseInt((String) jComboBox_4.getSelectedItem())) {
					a1 = Integer.parseInt((String) jComboBox_4
							.getSelectedItem());
					b1 = Integer.parseInt((String) jComboBox_5
							.getSelectedItem());
					c1 = Integer.parseInt((String) jComboBox_6
							.getSelectedItem());
					gp1 = new GetParam(root, paiZhao, riQi, s1, s2, s3, s4,
							(String) jComboBox_4.getSelectedItem(),
							(String) jComboBox_5.getSelectedItem(),
							(String) jComboBox_6.getSelectedItem(),
							(String) jComboBox_7.getSelectedItem(),
							(String) jComboBox_8.getSelectedItem(),
							(String) jComboBox_9.getSelectedItem());

				} else if (Integer.parseInt(gethour(f4)) > Integer
						.parseInt((String) jComboBox_4.getSelectedItem())) {
					a1 = Integer.parseInt(gethour(f4));
					b1 = Integer.parseInt(getmin(f4));
					c1 = Integer.parseInt(getsec(f4));
					gp1 = new GetParam(root, paiZhao, riQi, s1, s2, s3, s4,
							gethour(f4), getmin(f4), getsec(f4),
							(String) jComboBox_7.getSelectedItem(),
							(String) jComboBox_8.getSelectedItem(),
							(String) jComboBox_9.getSelectedItem());
				} else {
					if (Integer.parseInt(getmin(f4)) < Integer
							.parseInt((String) jComboBox_5.getSelectedItem())) {
						a1 = Integer.parseInt((String) jComboBox_4
								.getSelectedItem());
						b1 = Integer.parseInt((String) jComboBox_5
								.getSelectedItem());
						c1 = Integer.parseInt((String) jComboBox_6
								.getSelectedItem());
						gp1 = new GetParam(root, paiZhao, riQi, s1, s2, s3, s4,
								(String) jComboBox_4.getSelectedItem(),
								(String) jComboBox_5.getSelectedItem(),
								(String) jComboBox_6.getSelectedItem(),
								(String) jComboBox_7.getSelectedItem(),
								(String) jComboBox_8.getSelectedItem(),
								(String) jComboBox_9.getSelectedItem());
					} else if (Integer.parseInt(getmin(f4)) > Integer
							.parseInt((String) jComboBox_5.getSelectedItem())) {
						a1 = Integer.parseInt(gethour(f4));
						b1 = Integer.parseInt(getmin(f4));
						c1 = Integer.parseInt(getsec(f4));
						gp1 = new GetParam(root, paiZhao, riQi, s1, s2, s3, s4,
								gethour(f4), getmin(f4), getsec(f4),
								(String) jComboBox_7.getSelectedItem(),
								(String) jComboBox_8.getSelectedItem(),
								(String) jComboBox_9.getSelectedItem());

					} else {
						if (Integer.parseInt(getsec(f4)) <= Integer
								.parseInt((String) jComboBox_6
										.getSelectedItem())) {
							a1 = Integer.parseInt((String) jComboBox_4
									.getSelectedItem());
							b1 = Integer.parseInt((String) jComboBox_5
									.getSelectedItem());
							c1 = Integer.parseInt((String) jComboBox_6
									.getSelectedItem());
							gp1 = new GetParam(root, paiZhao, riQi, s1, s2, s3,
									s4, (String) jComboBox_4.getSelectedItem(),
									(String) jComboBox_5.getSelectedItem(),
									(String) jComboBox_6.getSelectedItem(),
									(String) jComboBox_7.getSelectedItem(),
									(String) jComboBox_8.getSelectedItem(),
									(String) jComboBox_9.getSelectedItem());

						} else if (Integer.parseInt(getsec(f4)) > Integer
								.parseInt((String) jComboBox_6
										.getSelectedItem())) {
							a1 = Integer.parseInt(gethour(f4));
							b1 = Integer.parseInt(getmin(f4));
							c1 = Integer.parseInt(getsec(f4));
							gp1 = new GetParam(root, paiZhao, riQi, s1, s2, s3,
									s4, gethour(f4), getmin(f4), getsec(f4),
									(String) jComboBox_7.getSelectedItem(),
									(String) jComboBox_8.getSelectedItem(),
									(String) jComboBox_9.getSelectedItem());
						}
					}

				}

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

				jButton_determin.setEnabled(false);

				
				ExportThread et_1 = new ExportThread(gp1);
				Thread t1 = new Thread(et_1);
				t1.start();

				// System.out.println("jButton_determin不能用了");

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

			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				jFrame.dispose();
				TestCheck.setFlag(false);
				TestCheck.setFlag1(true);// 返回上一界面时将list中循环终止
				if (MainFrame.getJf() != null) {
					MainFrame.getJf().setVisible(true);
				}
			}
		});
		jFrame.setVisible(true);
	}

	public static JFrame getjFrame() {
		return jFrame;
	}

	public static void setjFrame(JFrame jFrame) {
		Check_UI.jFrame = jFrame;
	}

	public static JButton getjButton_determin() {
		return jButton_determin;
	}

	public static void setjButton_determin(JButton jButton_determin) {
		Check_UI.jButton_determin = jButton_determin;
	}

	public static String getRiQi() {
		return riQi;
	}

	public static void setRiQi(String riQi) {
		Check_UI.riQi = riQi;
	}

	public static String getPaiZhao() {
		return paiZhao;
	}

	public static void setPaiZhao(String paiZhao) {
		Check_UI.paiZhao = paiZhao;
	}

	/**
	 * 
	 * @param s
	 * @param file
	 * @return
	 */
	public File searchtime(File file) {
		if (file != null) {
			File[] fileList = file.listFiles();
			File file_search = null;
			for (File f : fileList) {
				if (f != null) {
					file_search = f;
					break;
				}

			}
			return file_search;
		} else {
			return null;
		}
	}

	public String gethour(File file) {
		String name = file.getName();

		return name.substring(0, 2);
	}

	public String getmin(File file) {
		String name = file.getName();

		return name.substring(3, 5);
	}

	public String getsec(File file) {
		String name = file.getName();

		return name.substring(6, 8);
	}

	// 测试
	// public static void main(String[] args) {
	//
	// new Check_UI().init();
	// }

}
