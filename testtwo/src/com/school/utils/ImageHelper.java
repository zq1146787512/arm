package com.school.utils;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class ImageHelper {
	
	/*
	 * 图片剪裁部分test测试剪切图片
	 */
	 public static void cutImage(String src ,int k,String dest) throws IOException{ 
		 Iterator iterator = ImageIO.getImageReadersByFormatName("jpg"); 
         ImageReader reader = (ImageReader)iterator.next(); 
         InputStream in=new FileInputStream(src);
         ImageInputStream iis = ImageIO.createImageInputStream(in); 
         reader.setInput(iis, true); 
         ImageReadParam param = reader.getDefaultReadParam(); 
         int imageIndex = 0; 
         int width = reader.getWidth(imageIndex); 
         int height = reader.getHeight(imageIndex);
         Rectangle rect=null;
         switch (k) {
		case 1: rect = new Rectangle(0,  0,width/2, height/2);//左上
			break;
		case 2: rect = new Rectangle(width/2, 0,width/2, height/2);//右上
			break;
		case 3:rect = new Rectangle(0,  height/2,width/2, height);//左下
			break;
		case 4:rect = new Rectangle(width/2,  height/2,width, height);//右下
			break;
		default:
			break;
		} 
         param.setSourceRegion(rect); 
         BufferedImage bi = reader.read(0,param); 
         ImageIO.write(bi, "jpg", new File(dest));
//           return bi;
	 }
	 
	 /*
		 * 图片剪裁部分
		 */
		 public static BufferedImage cutImage1(String src ,int k) throws IOException{ 
			 Iterator iterator = ImageIO.getImageReadersByFormatName("jpg"); 
	         ImageReader reader = (ImageReader)iterator.next(); 
	         InputStream in=new FileInputStream(src);
	         ImageInputStream iis = ImageIO.createImageInputStream(in); 
	         reader.setInput(iis, true); 
	         ImageReadParam param = reader.getDefaultReadParam(); 
	         int imageIndex = 0; 
	         int width = reader.getWidth(imageIndex); 
	         int height = reader.getHeight(imageIndex);
	         Rectangle rect=null;
	         switch (k) {
			case 1: rect = new Rectangle(0,  0,width/2, height/2);//左上
				break;
			case 2: rect = new Rectangle(width/2, 0,width/2, height/2);//右上
				break;
			case 3:rect = new Rectangle(0,  height/2,width/2, height);//左下
				break;
			case 4:rect = new Rectangle(width/2,  height/2,width, height);//右下
				break;
			default:
				break;
			} 
	         param.setSourceRegion(rect); 
	         BufferedImage bi = reader.read(0,param); 
//	         ImageIO.write(bi, "jpg", new File(dest));
	           return bi;
		 }
	
   
	
}
