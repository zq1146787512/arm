package com.school.method;

import java.util.TimerTask;

public class CheckTask extends TimerTask {
	private GetParam gp;

	public CheckTask(GetParam gp) {
		this.gp = gp;
	}

	@Override
	public void run() {
		// while (work) {

		// if (end) {
		// System.out.println("export线程进行中啦！");
		new SearchCenter(gp).init();
		// }

		// }

		// System.out.println("export线程结束啦！");

	}

}
