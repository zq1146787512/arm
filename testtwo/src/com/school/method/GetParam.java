package com.school.method;

public class GetParam {
	private String paiZhao;
	private String data;
	private String sheXiangTou1;
	private String sheXiangTou2;
	private String sheXiangTou3;
	private String sheXiangTou4;
	private String hour_1;
	private String min_1;
	private String sec_1;
	private String hour_2;
	private String min_2;
	private String sec_2;
	private String root;

	public GetParam(String root, String paiZhao, String data, String SXTou1,
			String SXTou2, String SXTou3, String SXTou4, String hour_1,
			String min_1, String sec_1, String hour_2, String min_2,
			String sec_2) {
		this.root = root;
		this.paiZhao = paiZhao;
		this.data = data;
		this.sheXiangTou1 = SXTou1;
		this.sheXiangTou2 = SXTou2;
		this.sheXiangTou3 = SXTou3;
		this.sheXiangTou4 = SXTou4;
		this.hour_1 = hour_1;
		this.hour_2 = hour_2;
		this.min_1 = min_1;
		this.min_2 = min_2;
		this.sec_1 = sec_1;
		this.sec_2 = sec_2;
	}

	public String getRoot() {
		return root;
	}

	public String getPaizhao() {
		return paiZhao;
	}

	public String getData() {
		return data;
	}

	public String getSheXiangTou1() {
		return sheXiangTou1;
	}

	public String getSheXiangTou2() {
		return sheXiangTou2;
	}

	public String getSheXiangTou3() {
		return sheXiangTou3;
	}

	public String getSheXiangTou4() {
		return sheXiangTou4;
	}

	public String getHour_1() {
		return hour_1;
	}

	public String getHour_2() {
		return hour_2;
	}

	public String getMin_1() {
		return min_1;
	}

	public String getMin_2() {
		return min_2;
	}

	public String getSec_1() {
		return sec_1;
	}

	public String getSec_2() {
		return sec_2;
	}
}
