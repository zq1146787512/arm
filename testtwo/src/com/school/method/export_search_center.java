package com.school.method;

import java.io.FileNotFoundException;

public class export_search_center {
	private export_getParam export_gp;
	private int i;

	public export_search_center(export_getParam gp, int i) {
		this.export_gp = gp;
		this.i = i;
	}

	public void init() {
		// getParam gp = new getParam("XA-A1234", "2016-07-20", "T3", "1", "59",
		// "59", "2", "2","1");
		int hour_1 = Integer.parseInt(export_gp.getHour_1());// String 转换为
																// Integer
		int hour_2 = Integer.parseInt(export_gp.getHour_2());
		int min_1 = Integer.parseInt(export_gp.getMin_1());
		int min_2 = Integer.parseInt(export_gp.getMin_2());
		int sec_1 = Integer.parseInt(export_gp.getSec_1());
		int sec_2 = Integer.parseInt(export_gp.getSec_2());
		try {
			new export_check().search_image(export_gp.getFile(),
					export_gp.getPaizhao(), export_gp.getData(),
					export_gp.getSheXiangTou(), hour_1, min_1, sec_1, hour_2,
					min_2, sec_2, export_gp.getExport_root(), i);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

}
