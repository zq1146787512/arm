package com.school.test;

import java.io.IOException;

import com.school.utils.ImageHelper;

public class Test {
	// public void gethour() {
	// String name = "12-SS";
	//
	// System.out.println(name.substring(3, 5));
	// }
	//
	// public static void main(String[] args) {
	// for (int i = 10; i < 5; i++) {
	// System.out.println("ss");
	// }
	// }
	public static void main(String[] args) {
		try {
			ImageHelper.cutImage1("image/error1.jpg", 1,"f:/image/iamge");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
