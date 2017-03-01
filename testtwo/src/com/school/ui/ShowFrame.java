package com.school.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.school.method.MyMouseListener;
import com.school.method.PlayPic;
import com.school.method.TestCheck;

public class ShowFrame {
	private static JFrame jf;// 窗口

	private JPanel jpheader;// 第一层
	private JLabel jlheader;
	private static DisplayJPanel1 jp1b;
	private static DisplayJPanel2 jp2b;
	private static DisplayJPanel3 jp3b;
	private static DisplayJPanel4 jp4b;
	private static JPanel jpbody;// 第二层
	private static JPanel jpx;
	private static JPanel jpy;
	private JPanel jp1;
	private JPanel jp;
	private JPanel jp1a;
	private JPanel jp1c;
	private JLabel jl1;
	private JButton bt11;
	private JButton bt12;
	private JPanel jp2;
	private JPanel jp2a;
	private JPanel jp2c;
	private JLabel jl2;
	private static JLabel jl_chepai;
	private JLabel jl_riqi1;
	private static JLabel jl_riqi2;
	private JButton bt21;
	private JButton bt22;
	private JPanel jp3;
	private JPanel jp3a;
	private JPanel jp3c;
	private JLabel jl3;
	private JButton bt31;
	private JButton bt32;
	private JPanel jp4;
	private JPanel jp4a;
	private JPanel jp4c;
	private JLabel jl4;
	private JButton bt41;
	private JButton bt42;
	private JPanel jpbottom;
	private JButton bt1;
	private JButton bt2a;
	private JButton bt2b;
	private JButton bt3;
	private JButton bt1c;
	private JButton bt2c;
	private JButton bt3c;
	private JButton bt4c;
	private JLabel jLabel2;// 播放延时改变
	private JSpinner delaySpin;
	private JLabel jltime;
	private JLabel jltime1;
	private JLabel jltime2;
	private JLabel jltime3;
	private JLabel jltime4;
	private static JLabel jtexttime;
	private static JLabel jtexttime1;
	private static JLabel jtexttime2;
	private static JLabel jtexttime3;
	private static JLabel jtexttime4;

	private PlayPic pp;
	private int delay = 300;
	private static Timer timer = null;
	private static boolean flag1 = true;
	private static boolean flag2 = true;
	private static boolean flag3 = true;
	private static boolean flag4 = true;

	/**
	 * 初始化组件
	 */
	public void initcomponent() {
		jf = new JFrame("图片播放");
		jf.setLayout(new BorderLayout());
		pp = new PlayPic();
		PlayPic.setK(0);
		showframe();
		timer = new Timer();
		timer.schedule(pp, 1000, delay);

		jf.setSize(800, 500);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = jf.getSize();
		jf.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);
		jf.setResizable(true);
		jf.setVisible(true);

		if (Check_UI.getPaiZhao() != null) {
			jl_chepai.setText(Check_UI.getPaiZhao());
		}
		if (Check_UI.getRiQi() != null) {
			jl_riqi2.setText(Check_UI.getRiQi());
		}

	}

	/**
	 * 组件的事件监听器
	 */
	public void showframe() {

		// header
		jpheader = new JPanel();
		jf.add(jpheader, BorderLayout.NORTH);
		jlheader = new JLabel("车牌：");
		jl_chepai = new JLabel("xx-xxxx");
		jl_riqi1 = new JLabel("日期：");
		jl_riqi2 = new JLabel("0000-00-00");

		jpheader.add(jlheader);
		jpheader.add(jl_chepai);
		jpheader.add(jl_riqi1);
		jpheader.add(jl_riqi2);

		jltime = new JLabel("时间:");
		jpheader.add(jltime);

		jtexttime = new JLabel("--:--:--");
		jpheader.add(jtexttime);
		// body
		jpbody = new JPanel();
		jpbody.setLayout(new BoxLayout(jpbody, BoxLayout.Y_AXIS));
		jf.add(jpbody, BorderLayout.CENTER);
		// /
		jpx = new JPanel();
		jpx.setLayout(new BoxLayout(jpx, BoxLayout.X_AXIS));
		jpbody.add(jpx);

		jpy = new JPanel();
		jpy.setLayout(new BoxLayout(jpy, BoxLayout.X_AXIS));
		jpbody.add(jpy);
		/**
		 * jp1
		 */
		jp1 = new JPanel();
		jp1.setBackground(new Color(0));
		jp1.setLayout(new BorderLayout());
		jp1.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		// a
		jp1a = new JPanel();
		jl1 = new JLabel("C1");
		bt1c = new JButton("还原");
		jltime1 = new JLabel("时间:");
		jtexttime1 = new JLabel("--:--:--");
		jltime1.setVisible(false);
		jtexttime1.setVisible(false);
		bt1c.setVisible(false);
		jp1a.add(jl1);
		jp1a.add(bt1c);

		bt1c.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bt11.setVisible(true);
				bt1c.setVisible(false);
				jltime1.setVisible(false);
				jtexttime1.setVisible(false);
				jf.remove(jp1a);
				jf.add(jpheader, BorderLayout.NORTH);
				jpbody.remove(jp1b);
				jpbody.add(jpx);
				jp1.add(jp1a, BorderLayout.NORTH);
				jp1.add(jp1b, BorderLayout.CENTER);
				jpbody.add(jpy);
				jpbody.updateUI();
				jf.repaint();
			}
		});
		bt12 = new JButton("导出");
		bt12.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pp.daochu(1);// 调用导出方法；
			}
		});

		// b
		jp1b = new DisplayJPanel1();
		jp1.add(jp1b);
		// c
		jp1c = new JPanel();
		jp1.add(jp1a, BorderLayout.NORTH);
		jp1.add(jp1c, BorderLayout.SOUTH);
		bt11 = new JButton("放大");
		bt11.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bt11.setVisible(false);
				bt1c.setVisible(true);
				jltime1.setVisible(true);
				jtexttime1.setVisible(true);
				jf.remove(jpheader);
				jf.add(jp1a, BorderLayout.NORTH);
				jpbody.remove(jpx);
				jpbody.remove(jpy);
				jpbody.add(jp1b);
				jpbody.updateUI();
				jf.repaint();
			}
		});

		jp1a.add(bt11);
		jp1a.add(bt12);
		jp1a.add(jltime1);
		jp1a.add(jtexttime1);
		jpx.add(jp1);
		/**
		 * jp2
		 */
		jp2 = new JPanel();
		jp2.setBackground(new Color(0));
		jp2.setLayout(new BorderLayout());
		jp2.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));// 边距是多少
		// a
		jp2a = new JPanel();
		jp2.add(jp2a, BorderLayout.NORTH);
		jl2 = new JLabel("C2");
		bt2c = new JButton("还原");
		jltime2 = new JLabel("时间:");
		jtexttime2 = new JLabel("--:--:--");
		jltime2.setVisible(false);
		jtexttime2.setVisible(false);
		bt2c.setVisible(false);
		jp2a.add(jl2);
		jp2a.add(bt2c);
		bt2c.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bt21.setVisible(true);
				bt2c.setVisible(false);
				jltime2.setVisible(false);
				jtexttime2.setVisible(false);
				jf.remove(jp2a);
				jf.add(jpheader, BorderLayout.NORTH);
				jpbody.remove(jp2b);
				jpbody.add(jpx);
				jp2.add(jp2a, BorderLayout.NORTH);
				jp2.add(jp2b, BorderLayout.CENTER);
				jpbody.add(jpy);
				jpbody.updateUI();
				jf.repaint();
			}

		});
		jp2c = new JPanel();
		jp2.add(jp2c, BorderLayout.SOUTH);
		bt22 = new JButton("导出");
		bt22.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pp.daochu(2);// 调用导出方法；
			}
		});

		// b
		jp2b = new DisplayJPanel2();
		jp2.add(jp2b);
		// c
		bt21 = new JButton("放大");
		bt21.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bt21.setVisible(false);
				bt2c.setVisible(true);
				jltime2.setVisible(true);
				jtexttime2.setVisible(true);
				jf.remove(jpheader);
				jf.add(jp2a, BorderLayout.NORTH);
				jpbody.remove(jpx);
				jpbody.remove(jpy);
				jpbody.add(jp2b);
				jpbody.updateUI();
				jf.repaint();
			}
		});

		jp2a.add(bt21);
		jp2a.add(bt22);
		jp2a.add(jltime2);
		jp2a.add(jtexttime2);
		jpx.add(jp2);
		/**
		 * jp3
		 */
		jp3 = new JPanel();
		jp3.setBackground(new Color(0));
		jp3.setLayout(new BorderLayout());
		jp3.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		// a
		jp3a = new JPanel();
		jp3.add(jp3a, BorderLayout.NORTH);
		jl3 = new JLabel("C3");
		bt3c = new JButton("还原");
		jltime3 = new JLabel("时间:");
		jtexttime3 = new JLabel("--:--:--");
		jltime3.setVisible(false);
		jtexttime3.setVisible(false);
		bt3c.setVisible(false);
		jp3a.add(jl3);
		jp3a.add(bt3c);
		bt3c.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bt31.setVisible(true);
				bt3c.setVisible(false);
				jltime3.setVisible(false);
				jtexttime3.setVisible(false);
				jf.remove(jp3a);
				jf.add(jpheader, BorderLayout.NORTH);
				jpbody.remove(jp3b);
				jpbody.add(jpx);
				jp3.add(jp3a, BorderLayout.NORTH);
				jp3.add(jp3b, BorderLayout.CENTER);
				jpbody.add(jpy);
				jpbody.updateUI();
				jf.repaint();
			}
		});
		bt32 = new JButton("导出");
		bt32.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				pp.daochu(3);// 调用导出方法；
			}
		});

		// b
		jp3b = new DisplayJPanel3();
		jp3.add(jp3b);
		// c
		jp3c = new JPanel();
		jp3.add(jp3c, BorderLayout.SOUTH);
		bt31 = new JButton("放大");
		bt31.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bt31.setVisible(false);
				bt3c.setVisible(true);
				jltime3.setVisible(true);
				jtexttime3.setVisible(true);
				jf.remove(jpheader);
				jf.add(jp3a, BorderLayout.NORTH);
				jpbody.remove(jpx);
				jpbody.remove(jpy);
				jpbody.add(jp3b);
				jpbody.updateUI();
				jf.repaint();

			}
		});
		jp3a.add(bt31);
		jp3a.add(bt32);
		jp3a.add(jltime3);
		jp3a.add(jtexttime3);
		jpy.add(jp3);
		/**
		 * jp4
		 */
		jp4 = new JPanel();
		jp4.setBackground(new Color(0));
		jp4.setLayout(new BorderLayout());
		jp4.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		// a
		jp4a = new JPanel();
		jl4 = new JLabel("C4");
		jp4.add(jp4a, BorderLayout.NORTH);
		bt4c = new JButton("还原");
		jltime4 = new JLabel("时间:");
		jtexttime4 = new JLabel("--:--:--");
		jltime4.setVisible(false);
		jtexttime4.setVisible(false);
		bt4c.setVisible(false);
		jp4a.add(jl4);
		jp4a.add(bt4c);
		bt4c.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bt41.setVisible(true);
				bt4c.setVisible(false);
				jltime4.setVisible(false);
				jtexttime4.setVisible(false);
				jf.remove(jp4a);
				jf.add(jpheader, BorderLayout.NORTH);
				jpbody.remove(jp4b);
				jpbody.add(jpx);
				jp4.add(jp4a, BorderLayout.NORTH);
				jp4.add(jp4b, BorderLayout.CENTER);
				jpbody.add(jpy);
				jpbody.updateUI();
				jf.repaint();
			}
		});
		bt42 = new JButton("导出");
		bt42.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pp.daochu(4);// 调用displaypanel4中的导出方法；
			}
		});

		// b
		jp4b = new DisplayJPanel4();
		jp4.add(jp4b);
		// c
		jp4c = new JPanel();
		jp4.add(jp4c, BorderLayout.SOUTH);
		bt41 = new JButton("放大");
		bt41.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bt41.setVisible(false);
				bt4c.setVisible(true);
				jltime4.setVisible(true);
				jtexttime4.setVisible(true);
				jf.remove(jpheader);
				jf.add(jp4a, BorderLayout.NORTH);
				jpbody.remove(jpx);
				jpbody.remove(jpy);
				jpbody.add(jp4b);
				jpbody.updateUI();
				jf.repaint();
			}
		});

		jp4a.add(bt41);
		jp4a.add(bt42);
		jp4a.add(jltime4);
		jp4a.add(jtexttime4);
		jpy.add(jp4);

		/**
		 * bottom
		 */
		jpbottom = new JPanel();
		jpbottom.setLayout(new GridLayout(1, 2));
		jf.add(jpbottom, BorderLayout.PAGE_END);

		bt1 = new JButton("上一张");
		bt1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pp.setpre(true);

			}
		});

		bt2b = new JButton("播放");
		bt2a = new JButton("暂停");
		bt2a.setVisible(false);
		bt2a.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				bt2a.setVisible(false);
				bt2b.setVisible(true);
				pp.setStop(true);

			}
		});

		bt2b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bt2b.setVisible(false);
				bt2a.setVisible(true);
				pp.setList1(TestCheck.getList1());				
				pp.setStop(false);

			}
		});

		bt3 = new JButton("下一张");
		bt3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pp.setnext(true);
			}
		});
		jp = new JPanel();
		jLabel2 = new JLabel();
		jLabel2.setText("播放延时(ms)：");
		delaySpin = new JSpinner();
		delaySpin.setModel(new SpinnerNumberModel(Integer.valueOf(delay),
				Integer.valueOf(10), null, Integer.valueOf(1)));
		delaySpin.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				delaySpinStateChanged(e);
			}
		});
		jp.add(jLabel2);
		jp.add(delaySpin);
		jpbottom.add(jp);

		JPanel jpss = new JPanel();
		jpss.add(bt1);
		jpss.add(bt2b);
		jpss.add(bt2a);
		jpss.add(bt3);
		jpbottom.add(jpss);

		// 该方法用来返回上一界面
		jf.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				pp.setStop(true);
				PlayPic.setK(0);// 将Playpic.java中的K值置为初始值

				TestCheck.setFlag(false);
				TestCheck.setFlag1(true);// 返回上一界面时将list中的循环终止
				Check_UI.getjFrame().setVisible(true);
				Check_UI.getjButton_determin().setEnabled(true);

			}
		});
		jp1b.addMouseListener(new MyMouseListener() {

			public void mouseDoubleClicked(MouseEvent e) {
				if (flag1) {
					// System.out.println("aaaaa");
					bt11.setVisible(false);
					bt1c.setVisible(true);
					jltime1.setVisible(true);
					jtexttime1.setVisible(true);
					jf.remove(jpheader);
					jf.add(jp1a, BorderLayout.NORTH);
					jpbody.remove(jpx);
					jpbody.remove(jpy);
					jpbody.add(jp1b);
					jpbody.updateUI();
					jf.repaint();
					flag1 = false;
				} else {
					// System.out.println("ssss");
					bt11.setVisible(true);
					bt1c.setVisible(false);
					jltime1.setVisible(false);
					jtexttime1.setVisible(false);
					jf.remove(jp1a);
					jf.add(jpheader, BorderLayout.NORTH);
					jpbody.remove(jp1b);
					jpbody.add(jpx);
					jp1.add(jp1a, BorderLayout.NORTH);
					jp1.add(jp1b, BorderLayout.CENTER);
					jpbody.add(jpy);
					jpbody.updateUI();
					jf.repaint();
					flag1 = true;
				}
			}
		});

		jp2b.addMouseListener(new MyMouseListener() {
			public void mouseDoubleClicked(MouseEvent e) {
				if (flag2) {
					bt21.setVisible(false);
					bt2c.setVisible(true);
					jltime2.setVisible(true);
					jtexttime2.setVisible(true);
					jf.remove(jpheader);
					jf.add(jp2a, BorderLayout.NORTH);
					jpbody.remove(jpx);
					jpbody.remove(jpy);
					jpbody.add(jp2b);
					jpbody.updateUI();
					jf.repaint();
					flag2 = false;
				} else {
					bt21.setVisible(true);
					bt2c.setVisible(false);
					jltime2.setVisible(false);
					jtexttime2.setVisible(false);
					jf.remove(jp2a);
					jf.add(jpheader, BorderLayout.NORTH);
					jpbody.remove(jp2b);
					jpbody.add(jpx);
					jp2.add(jp2a, BorderLayout.NORTH);
					jp2.add(jp2b, BorderLayout.CENTER);
					jpbody.add(jpy);
					jpbody.updateUI();
					jf.repaint();
					flag2 = true;
				}
			}
		});

		jp3b.addMouseListener(new MyMouseListener() {
			public void mouseDoubleClicked(MouseEvent e) {
				if (flag3) {
					bt31.setVisible(false);
					bt3c.setVisible(true);
					jltime3.setVisible(true);
					jtexttime3.setVisible(true);
					jf.remove(jpheader);
					jf.add(jp3a, BorderLayout.NORTH);
					jpbody.remove(jpx);
					jpbody.remove(jpy);
					jpbody.add(jp3b);
					jpbody.updateUI();
					jf.repaint();
					flag3 = false;
				} else {
					bt31.setVisible(true);
					bt3c.setVisible(false);
					jltime3.setVisible(false);
					jtexttime3.setVisible(false);
					jf.remove(jp3a);
					jf.add(jpheader, BorderLayout.NORTH);
					jpbody.remove(jp3b);
					jpbody.add(jpx);
					jp3.add(jp3a, BorderLayout.NORTH);
					jp3.add(jp3b, BorderLayout.CENTER);
					jpbody.add(jpy);
					jpbody.updateUI();
					jf.repaint();
					flag3 = true;
				}
			}
		});

		jp4b.addMouseListener(new MyMouseListener() {
			public void mouseDoubleClicked(MouseEvent e) {
				if (flag4) {
					bt41.setVisible(false);
					bt4c.setVisible(true);
					jltime4.setVisible(true);
					jtexttime4.setVisible(true);
					jf.remove(jpheader);
					jf.add(jp4a, BorderLayout.NORTH);
					jpbody.remove(jpx);
					jpbody.remove(jpy);
					jpbody.add(jp4b);
					jpbody.updateUI();
					jf.repaint();
					flag4 = false;
				} else {
					bt41.setVisible(true);
					bt4c.setVisible(false);
					jltime4.setVisible(false);
					jtexttime4.setVisible(false);
					jf.remove(jp4a);
					jf.add(jpheader, BorderLayout.NORTH);
					jpbody.remove(jp4b);
					jpbody.add(jpx);
					jp4.add(jp4a, BorderLayout.NORTH);
					jp4.add(jp4b, BorderLayout.CENTER);
					jpbody.add(jpy);
					jpbody.updateUI();
					jf.repaint();
					flag4 = true;
				}
			}
		});

	}

	/**
	 * 修改帧延时
	 * 
	 * @param evt
	 */
	public void delaySpinStateChanged(ChangeEvent e) {
		int delay1 = (Integer) delaySpin.getValue();

		if (delay1 >= 100) {
			delay = delay1;
			pp.cancel();
			timer.purge();
			timer.cancel();
			timer = new Timer();
			pp = new PlayPic();
			PlayPic.setK(PlayPic.getK());
			timer.schedule(pp, 1000, delay);

		} else {
			JOptionPane.showMessageDialog(jf.getContentPane(), "请输入大于100的值",
					"系统信息", JOptionPane.ERROR_MESSAGE);
			return;
		}
	}

	/**
	 * 第一个的返回jp1b的宽高
	 * 
	 * @return
	 */
	public static int height1() {
		return jp1b.getHeight();
	}

	public static int width1() {
		return jp1b.getWidth();
	}

	/**
	 * 第2个的返回jp2b的宽高
	 * 
	 * @return
	 */
	public static int height2() {
		return jp2b.getHeight();
	}

	public static int width2() {
		return jp2b.getWidth();
	}

	/**
	 * 第3个的返回jp3b的宽高
	 * 
	 * @return
	 */
	public static int height3() {
		return jp3b.getHeight();
	}

	public static int width3() {
		return jp3b.getWidth();
	}

	/**
	 * 第4个的返回jp4b的宽高
	 * 
	 * @return
	 */
	public static int height4() {
		return jp4b.getHeight();
	}

	public static int width4() {
		return jp4b.getWidth();
	}

	public static DisplayJPanel1 getJp1b() {
		return jp1b;
	}

	public static void setJp1b(DisplayJPanel1 jp1b) {
		ShowFrame.jp1b = jp1b;
	}

	public static DisplayJPanel2 getJp2b() {
		return jp2b;
	}

	public static void setJp2b(DisplayJPanel2 jp2b) {
		ShowFrame.jp2b = jp2b;
	}

	public static DisplayJPanel3 getJp3b() {
		return jp3b;
	}

	public static void setJp3b(DisplayJPanel3 jp3b) {
		ShowFrame.jp3b = jp3b;
	}

	public static DisplayJPanel4 getJp4b() {
		return jp4b;
	}

	public static void setJp4b(DisplayJPanel4 jp4b) {
		ShowFrame.jp4b = jp4b;
	}

	public static JLabel getJtexttime() {
		return jtexttime;
	}

	public static void setJtexttime(JLabel jtexttime) {
		ShowFrame.jtexttime = jtexttime;
	}

	public static JFrame getJf() {
		return jf;
	}

	public static void setJf(JFrame jf) {
		ShowFrame.jf = jf;
	}

	public static JLabel getJl_chepai() {
		return jl_chepai;
	}

	public static void setJl_chepai(JLabel jl_chepai) {
		ShowFrame.jl_chepai = jl_chepai;
	}

	public static JLabel getJl_riqi2() {
		return jl_riqi2;
	}

	public static void setJl_riqi2(JLabel jl_riqi2) {
		ShowFrame.jl_riqi2 = jl_riqi2;
	}

	public static JLabel getJtexttime1() {
		return jtexttime1;
	}

	public static void setJtexttime1(JLabel jtexttime1) {
		ShowFrame.jtexttime1 = jtexttime1;
	}

	public static JLabel getJtexttime2() {
		return jtexttime2;
	}

	public static void setJtexttime2(JLabel jtexttime2) {
		ShowFrame.jtexttime2 = jtexttime2;
	}

	public static JLabel getJtexttime3() {
		return jtexttime3;
	}

	public static void setJtexttime3(JLabel jtexttime3) {
		ShowFrame.jtexttime3 = jtexttime3;
	}

	public static JLabel getJtexttime4() {
		return jtexttime4;
	}

	public static void setJtexttime4(JLabel jtexttime4) {
		ShowFrame.jtexttime4 = jtexttime4;
	}

//	 public static void main(String[] args) {
//	 new ShowFrame().initcomponent();
//	 }

}
