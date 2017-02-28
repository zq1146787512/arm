package com.school.method;

import java.util.TimerTask;

import com.school.ui.Progressbar;
import com.school.ui.export_check_UI;

public class realTime_preogressBar extends TimerTask {
	private static boolean work = true;

	public static int count(int hour_1, int hour_2, int min_1, int min_2,
			int sec_1, int sec_2) {

		int count = 0;
		if (hour_2 - hour_1 == 0) {
			if (min_2 - min_1 == 0) {
				count = sec_2 - sec_1;
			} else if (min_2 - min_1 == 1) {
				count = 60 - sec_1 + sec_2 + 1;
			} else if (min_2 - min_1 > 1) {
				count = 60 - sec_1 + (min_2 - min_1 - 1) * 60 + sec_2 + 1;
			}
		} else if (hour_2 - hour_1 == 1) {
			count = (59 - min_1) * 60 + (60 - sec_1 + 1) + min_2 * 60 + sec_2;
		} else if (hour_2 - hour_1 > 1) {
			count = (59 - min_1) * 60 + (60 - sec_1 + 1) + min_2 * 60 + sec_2
					+ (hour_2 - hour_1 - 1) * 3600;
		}
		return count * 1;
	}

	public static void progressBar(export_getParam param, int mark) {
		// System.out.println(mark);
		// System.out.println("进度条中mark=" + mark);
		int some = 0;
		int sum = count(Integer.parseInt(param.getHour_1()),
				Integer.parseInt(param.getHour_2()),
				Integer.parseInt(param.getMin_1()),
				Integer.parseInt(param.getMin_2()),
				Integer.parseInt(param.getSec_1()),
				Integer.parseInt(param.getSec_2()));
		// System.out.println(sum * mark);
		// while (some < sum * mark) {
		// if (!work) {
		// break;
		// }

		some = export_check.i1 + export_check.i2 + export_check.i3
				+ export_check.i4;

		double value1 = (some * 100 / (sum * mark));
		int value = (int) value1;

		Progressbar.getjProgressBar().setValue(value);
		// try {
		// Thread.sleep(100);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// }
		// setWork(false);

	}

	@Override
	public void run() {
		// System.out.println("线程开始了");

		// while (work) {
		progressBar(export_check_UI.export__gp, export_check_UI.mark);
		// }
		// System.out.println("线程结束了");

	}

	public static boolean isWork() {
		return work;
	}

	public static void setWork(boolean work) {
		realTime_preogressBar.work = work;
	}

	// public static void main(String[] args) {
	// }

}
