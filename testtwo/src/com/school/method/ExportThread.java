package com.school.method;

public class ExportThread implements Runnable {
	// private static boolean work = true;
	// private static boolean end = true;

	private GetParam gp;

	public ExportThread(GetParam gp) {
		this.gp = gp;
	}

	@Override
	public void run() {

		new SearchCenter(gp).init();

	}

	// public static boolean isWork() {
	// return work;
	// }
	//
	// public static void setWork(boolean work) {
	// ExportThread.work = work;
	// }

	// public static boolean isEnd() {
	// return end;
	// }
	//
	// public static void setEnd(boolean end) {
	// ExportThread.end = end;
	// }

}
