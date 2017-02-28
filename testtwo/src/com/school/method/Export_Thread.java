package com.school.method;

public class Export_Thread implements Runnable {
	private int i;
	private export_getParam export_gp;

	public Export_Thread(export_getParam export_gp, int i) {
		this.export_gp = export_gp;
		this.i = i;
	}

	@Override
	public void run() {

		new export_search_center(export_gp, i).init();

		// System.out.println("线程结束了");
	}

}
