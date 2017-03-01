package com.school.utils;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class ImageHelper {
	
	/*
	 * 图片剪裁返回四个切割图片，只做一次IO处理
	 */
	 public static List<BufferedImage> cutImage(String src) throws IOException{ 
		 Iterator iterator = ImageIO.getImageReadersByFormatName("jpg"); 
         ImageReader reader = (ImageReader)iterator.next(); 
         InputStream in=new FileInputStream(src);
         ImageInputStream iis = ImageIO.createImageInputStream(in); 
         reader.setInput(iis, true); 
         ImageReadParam param = reader.getDefaultReadParam(); 
         int imageIndex = 0; 
         int width = reader.getWidth(imageIndex); 
         int height = reader.getHeight(imageIndex);
         
         Rectangle rect1 = new Rectangle(0,  0,width/2, height/2);//左上	
         Rectangle rect2 = new Rectangle(width/2, 0,width/2, height/2);//右上
         Rectangle rect3 = new Rectangle(0,  height/2,width/2, height);//左下		
         Rectangle rect4 = new Rectangle(width/2,  height/2,width, height);//右下
		
         param.setSourceRegion(rect1); 
         BufferedImage bi1 = reader.read(0,param);
         param.setSourceRegion(rect2);
         BufferedImage bi2 = reader.read(0,param);
         param.setSourceRegion(rect3);
         BufferedImage bi3 = reader.read(0,param);
         param.setSourceRegion(rect4);
         BufferedImage bi4 = reader.read(0,param);
         
         List<BufferedImage> list=new ArrayList<>();
         list.add(bi1);
         list.add(bi2);
         list.add(bi3);
         list.add(bi4);
//         for(int i=0;i<4;i++){
//         ImageIO.write(list.get(i), "jpg", new File(dest+i+1+".jpg"));}
           return list;
	 }
	 
	 /*
		 * 图片剪裁部分，返回单个图片，IO处理要求四次
		 */
		 public static BufferedImage cutImage(String src ,int k) throws IOException{ 
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
