package com.school.test;

import java.io.IOException;

import com.school.utils.ImageHelper;

public class Test {
	
	public static void main(String[] args) {
		try {
			ImageHelper.cutImage("image/error1.jpg", 1,"f:/image/iamge");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
