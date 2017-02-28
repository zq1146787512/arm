package com.school.method;

import java.io.File;

public class export_getParam {
	private String paiZhao;
	private String data;
	private String sheXiangTou;
	private String hour_1;
	private String min_1;
	private String sec_1;
	private String hour_2;
	private String min_2;
	private String sec_2;
	private File file;
	private String export_root;

	public export_getParam(File file, String paiZhao, String data,
			String sheXiangTou, String hour_1, String min_1, String sec_1,
			String hour_2, String min_2, String sec_2, String export_root) {
		this.file = file;
		this.paiZhao = paiZhao;
		this.data = data;
		this.sheXiangTou = sheXiangTou;
		this.hour_1 = hour_1;
		this.hour_2 = hour_2;
		this.min_1 = min_1;
		this.min_2 = min_2;
		this.sec_1 = sec_1;
		this.sec_2 = sec_2;
		this.export_root = export_root;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getExport_root() {
		return export_root;
	}

	public void setExport_root(String export_root) {
		this.export_root = export_root;
	}

	public String getPaizhao() {
		return paiZhao;
	}

	public String getData() {
		return data;
	}

	public String getSheXiangTou() {
		return sheXiangTou;
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
