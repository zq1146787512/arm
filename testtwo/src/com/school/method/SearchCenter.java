package com.school.method;


public class SearchCenter {
	private GetParam gp;

	public SearchCenter(GetParam gp) {
		this.gp = gp;
	}

	public void init() {
		// getParam gp = new getParam("XA-A1234", "2016-07-20", "T3", "1", "59",
		// "59", "2", "2","1");

		int hour_1 = Integer.parseInt(gp.getHour_1());
		int hour_2 = Integer.parseInt(gp.getHour_2());
		int min_1 = Integer.parseInt(gp.getMin_1());
		int min_2 = Integer.parseInt(gp.getMin_2());
		int sec_1 = Integer.parseInt(gp.getSec_1());
		int sec_2 = Integer.parseInt(gp.getSec_2());

		// Check c = new Check();
		//
		// c.search_image(gp.getRoot(), gp.getPaizhao(), gp.getData(),
		// gp.getSheXiangTou(), hour_1, min_1, sec_1, hour_2, min_2, sec_2);
		TestCheck c = new TestCheck();
		c.search_image(gp.getRoot(), gp.getPaizhao(), gp.getData(),
				gp.getSheXiangTou1(), gp.getSheXiangTou2(),
				gp.getSheXiangTou3(), gp.getSheXiangTou4(), hour_1, min_1,
				sec_1, hour_2, min_2, sec_2);

	}
}
